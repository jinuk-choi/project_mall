package com.project.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.example.domain.Category;
import com.project.example.mapper.CategoryMapper;


@Service("CategoryServiceImpl")
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryMapper categorymapper;
	
	@Override
	public List<Category> readCategory() {
		return categorymapper.readCategory();
	};

	@Override
	public List<Category> readCategory_name(){
		return categorymapper.readCategory_name();
	};
	
	@Override
	public int findCg_id(String name){
		return categorymapper.findCg_id(name);
	};
	
	@Override
	public void categoryUpdate(Category category) {
		categorymapper.categoryUpdate(category);
	};

	
	@Override
	public int nextCategory(Category category) {
//		int next = categorymapper.nextCategory(category); �̷������� ¥�� ��.
//		category.setCg_id(next);
		return categorymapper.nextCategory(category);
	};
	
	@Override
	public void categoryAdd(Category category) {
		//mapper 2���� ����Ѵ�. 
		//1���� �ִ밪�� +1�� �ؼ� ��ȯ�ϴ� mapper�̰�,
		//1���� ���ο� �з���� ��ȯ�� ���� �����ؼ� ���ڵ�� ����� mapper�̴�. �̶� ������ 0���� ���ֵ��� �Ѵ�.
		int next = categorymapper.nextCategory(category); 
		category.setCg_id(next);
		categorymapper.categoryAdd(category);
	};
	
	/*���񽺿� mapper 2���� ���� ������ ������� �����ǿ��� ���� �ϳ��� ������ �����ϱ� ���ؼ� 2���� mapper�� �ʿ��ϴٸ�
	mapper 2���� �ְ�, 2���� mapper �߿� 1���� ������ ���� rollback�� ����� �Ѵ�. 
	�̷��� ����� Ʈ������̶�� �θ���. 
	���� ����Ʈ ���ñ���ؼ��� ~�� ��µ� ����Ʈ �������� ������ ����. �׷��� �� �߿� 1���� ������ ���� ������ rollback�� ����� �Ѵ�.
	�̰��� Ʈ������̸� �̷��� ����� ���ؼ� Ʈ������� ����ϴ� ���̴�. 
	 */ 
	
	
	
}
