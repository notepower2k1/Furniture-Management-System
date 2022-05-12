package com.thgroup.fms.service;

import java.util.List;

import com.thgroup.fms.entity.Category;

public interface CategoryService {
	List<Category> getAllCategories();
	Category getCategoryById(int id);
}
