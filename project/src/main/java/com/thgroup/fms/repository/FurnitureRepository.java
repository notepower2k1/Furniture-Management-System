package com.thgroup.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thgroup.fms.entity.Furniture;

public interface FurnitureRepository extends JpaRepository<Furniture, Integer> {

}
