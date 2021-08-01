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
import com.project.example.domain.Board;
import com.project.example.domain.Comment;
import com.project.example.domain.ListVo;
import com.project.example.domain.Pagination;
import com.project.example.domain.Product;
import com.project.example.domain.Search;
import com.project.example.service.BoardService;
import com.project.example.service.CategoryService;
import com.project.example.service.CommentService;
import com.project.example.service.OrderService;
import com.project.example.service.ProductService;
import com.project.example.service.UserService;

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
	
	@Autowired
	CommentService commentService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//상품정보
	@PostMapping("/product")
	public ResponseEntity<?> productUpdate(@Validated @RequestBody Product product){
		List<Product> product_one = productService.readProduct(product);
		return new ResponseEntity<>(product_one, HttpStatus.OK);
	}
	
	//랭크별 이미지
	@GetMapping("/imageByRank")
	public ResponseEntity<?> imageByRank(){
		List<Product> imageByRank = productService.imageByRank();
		return new ResponseEntity<>(imageByRank, HttpStatus.OK);
	}
	
	//상의 이미지
	@GetMapping("/imageTop")
	public ResponseEntity<?> imageTop(){
		List<Product> imageTop = productService.imageTop();
		return new ResponseEntity<>(imageTop, HttpStatus.OK);
	}
	
	//반팔 이미지
	@GetMapping("/imageShortTop")
	public ResponseEntity<?> imageShortTop(){
		List<Product> imageShortTop = productService.imageShortTop();
		return new ResponseEntity<>(imageShortTop, HttpStatus.OK);
	}
	
	//긴팔 이미지
	@GetMapping("/imageLongTop")
	public ResponseEntity<?> imageLongTop(){
		List<Product> imageLongTop = productService.imageLongTop();
		return new ResponseEntity<>(imageLongTop, HttpStatus.OK);
	}
	
	//하의 이미지
	@GetMapping("/imagePants")
	public ResponseEntity<?> imagePants(){
		List<Product> imagePants = productService.imagePants();
		return new ResponseEntity<>(imagePants, HttpStatus.OK);
	}
	
	//긴바지 이미지
	@GetMapping("/imageLongPants")
	public ResponseEntity<?> imageLongPants(){
		List<Product> imageLongPants = productService.imageLongPants();
		return new ResponseEntity<>(imageLongPants, HttpStatus.OK);
	}
	
	//반바지 이미지
	@GetMapping("/imageShortPants")
	public ResponseEntity<?> imageShortPants(){
		List<Product> imageShortPants = productService.imageShortPants();
		return new ResponseEntity<>(imageShortPants, HttpStatus.OK);
	}
	
	//Q&A게시판 리스트
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
	
	//Q&A게시판 상세보기
	@GetMapping("/boardDetail")
	public ResponseEntity<?>  boardDetail(@RequestParam int aIdx, Board board) {
		boardService.count(board);
		logger.info("///"+aIdx);
		
		board = boardService.selectBoardDetail(aIdx);
		
		return new ResponseEntity<>(board, HttpStatus.OK);
		
	}
	
	//Q&A게시판 삭제
	@DeleteMapping("/boardDelete/{aIdx}")
	public ResponseEntity<?>  boardDelete(@PathVariable(value = "aIdx") int aIdx) {
		boardService.deleteBoard(aIdx);
		logger.info("delete"+aIdx);
		
		return new ResponseEntity<>(aIdx, HttpStatus.OK);
	}
	
	//Q&A게시판 글쓰기
	@PostMapping("/boardWrite")
	public ResponseEntity<?>  boardWrite(@RequestBody Board board) {
		boardService.insertBoard(board);
		logger.info("Write"+board);
		
		return new ResponseEntity<>(board, HttpStatus.OK);
		
	}
	
	//Q&A게시판 수정하기
	@PostMapping("/boardEdit")
	public ResponseEntity<?>  boardEdit(@RequestBody Board board) {
		boardService.editBoard(board);
		logger.info("Edit"+board);
		
		return new ResponseEntity<>(board, HttpStatus.OK);
		
	}
	
	//상품후기 리스트
	@GetMapping({"/commentList","/commentList/{pageOpt}"})
	public ResponseEntity<?>  commentList(@PathVariable Optional<Integer> pageOpt
									     ,@RequestParam int id 
									     ,Product product) {
		
		int count = 0;
		int page = pageOpt.isPresent() ? pageOpt.get() : 1;
		int pageNum = 0;
		
		Pagination<Comment> pagination = null;
		List<Comment> commentList = null;
		ListVo listvo = null;
		
		count = commentService.commentCount(product);
		pagination = new Pagination<Comment>(page,count);
		
		pageNum = pagination.getPageNum();
		listvo = new ListVo(id,pageNum);
		commentList = commentService.selectCommentList(listvo);
		pagination.setList(commentList);
		
		return new ResponseEntity<>(pagination, HttpStatus.OK);
	}
	
	//상품후기 삭제하기
	@DeleteMapping("/commentDelete/{cId}")
	public ResponseEntity<?>  commentDelete(@PathVariable(value = "cId") int cId,
											@RequestParam int id,
											Product product) {
		commentService.commentDelete(cId);
		
		int count = 0;
		int page = 1;
		int pageNum = 0;
		
		Pagination<Comment> pagination = null;
		List<Comment> commentList = null;
		ListVo listvo = null;
		
		count = commentService.commentCount(product);
		pagination = new Pagination<Comment>(page,count);
		pageNum = pagination.getPageNum();
		listvo = new ListVo(id,pageNum);
		commentList = commentService.selectCommentList(listvo);
		pagination.setList(commentList);
		
		
		return new ResponseEntity<>(pagination, HttpStatus.OK);
	}
	
	//상품후기 작성하기
	@PostMapping("/commentWrite")
	public ResponseEntity<?>  commentWrite(@RequestBody Comment comment,
										   @RequestParam int id,
										   Product product) {
		
		commentService.insertComment(comment);
		
		int count = 0;
		int page = 1;
		int pageNum = 0;
		
		Pagination<Comment> pagination = null;
		List<Comment> commentList = null;
		ListVo listvo = null;
		
		count = commentService.commentCount(product);
		pagination = new Pagination<Comment>(page,count);
		pageNum = pagination.getPageNum();
		listvo = new ListVo(id,pageNum);
		commentList = commentService.selectCommentList(listvo);
		pagination.setList(commentList);
		
		
		return new ResponseEntity<>(pagination, HttpStatus.OK);
	}
	
	//상품후기 수정하기
	@PostMapping("/commentEdit")
	public ResponseEntity<?>  commentEdit(@RequestBody Comment comment,
										  @RequestParam int id,
										  Product product) {
		
		commentService.editComment(comment);
		
		int count = 0;
		int page = 1;
		int pageNum = 0;
		
		Pagination<Comment> pagination = null;
		List<Comment> commentList = null;
		ListVo listvo = null;
		
		count = commentService.commentCount(product);
		pagination = new Pagination<Comment>(page,count);
		pageNum = pagination.getPageNum();
		listvo = new ListVo(id,pageNum);
		commentList = commentService.selectCommentList(listvo);
		pagination.setList(commentList);
		
		
		return new ResponseEntity<>(pagination, HttpStatus.OK);
	}
	
	
	
}
