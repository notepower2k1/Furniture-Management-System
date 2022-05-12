package com.thgroup.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thgroup.fms.entity.Furniture;

public interface FurnitureRepository extends JpaRepository<Furniture, Integer> {
	@Query(value="Select ma_noi_that From noithat Order By ma_noi_that Desc Limit 1", nativeQuery = true)
	String findFirstMaNoiThat();
}

