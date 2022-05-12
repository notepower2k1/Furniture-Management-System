package com.thgroup.fms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thgroup.fms.entity.Category;
import com.thgroup.fms.repository.CategoryRepository;
import com.thgroup.fms.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public List<Category> getAllCategories() {
		return this.categoryRepo.findAll();
	}

	@Override
	public Category getCategoryById(int id) {
		Optional<Category> optional = this.categoryRepo.findById(id);
		Category category = null;
		if(optional.isPresent()) {
			category = optional.get();
		} else {
			throw new RuntimeException("Employee not found	for id::" + id);
		}
		return category;
	}

}
