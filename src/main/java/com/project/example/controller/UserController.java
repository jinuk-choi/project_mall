package com.project.example.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.example.config.JwtUtils;
import com.project.example.domain.Product;
import com.project.example.service.BoardService;
import com.project.example.service.CategoryService;
import com.project.example.service.OrderService;
import com.project.example.service.ProductService;
import com.project.example.service.UserService;
import com.project.example.domain.Board;
import com.project.example.domain.Pagination;
import com.project.example.domain.Search;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

//사용자 화면, 일반 홈페이지이므로 경로를 /으로 사용함.
@RequestMapping("/api")
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/product")
	public ResponseEntity<?> productUpdate(@Validated @RequestBody Product product){
		List<Product> product_one = productService.readProduct(product);
		return new ResponseEntity<>(product_one, HttpStatus.OK);
	}
	
	
	@GetMapping("/imageByRank")
	public ResponseEntity<?> imageByRank(){
		List<Product> imageByRank = productService.imageByRank();
		return new ResponseEntity<>(imageByRank, HttpStatus.OK);
	}
	
	@GetMapping("/imageTop")
	public ResponseEntity<?> imageTop(){
		List<Product> imageTop = productService.imageTop();
		return new ResponseEntity<>(imageTop, HttpStatus.OK);
	}
	
	
	@GetMapping("/imagePants")
	public ResponseEntity<?> imagePants(){
		List<Product> imagePants = productService.imagePants();
		return new ResponseEntity<>(imagePants, HttpStatus.OK);
	}
	
	@GetMapping({"/board","/board/{pageOpt}","/board/{pageOpt}/{typeOpt}/{keywordOpt}"})
	public ResponseEntity<?>  userAccess(@PathVariable Optional<Integer> pageOpt
										,@PathVariable Optional<Integer> typeOpt 
										,@PathVariable Optional<String> keywordOpt ) {
		Search search = null;
		int count = 0;
		int page = pageOpt.isPresent() ? pageOpt.get() : 1;
		int type = typeOpt.isPresent() ? typeOpt.get() : 0;
		String keyword = keywordOpt.isPresent() ? keywordOpt.get() : null ;
		
		if(keyword != null ) {
			search = new Search(type, keyword);
		}
		
		Pagination<Board> pagination = new Pagination<Board>();
		List<Board> boardList = null;
		
		count = boardService.countBoard(search);
		pagination = new Pagination<Board>(page,count,search);
		boardList = boardService.selectBoardList(pagination);
		pagination.setList(boardList);
		
		return new ResponseEntity<>(pagination, HttpStatus.OK);
	}
	
	@GetMapping("/boardDetail")
	public ResponseEntity<?>  boardDetail(@RequestParam int aIdx, Board board) {
		boardService.count(board);
		logger.info("///"+aIdx);
		
		board = boardService.selectBoardDetail(aIdx);
		
		return new ResponseEntity<>(board, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/boardDelete/{aIdx}")
	public ResponseEntity<?>  boardDelete(@PathVariable(value = "aIdx") int aIdx) {
		boardService.deleteBoard(aIdx);
		logger.info("delete"+aIdx);
		
		return new ResponseEntity<>(aIdx, HttpStatus.OK);
	}
	
	@PostMapping("/boardWrite")
	public ResponseEntity<?>  boardWrite(@RequestBody Board board) {
		boardService.insertBoard(board);
		logger.info("Write"+board);
		
		return new ResponseEntity<>(board, HttpStatus.OK);
		
	}
	
	@PostMapping("/boardEdit")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  boardEdit(@RequestBody Board board) {
		boardService.editBoard(board);
		logger.info("Edit"+board);
		
		return new ResponseEntity<>(board, HttpStatus.OK);
		
	}
	
	
	
}
