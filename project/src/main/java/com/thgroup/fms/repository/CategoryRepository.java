package com.thgroup.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thgroup.fms.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
