package com.thgroup.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.thgroup.fms.entity.ProductPhotos;

public interface ProductPhotosRepository extends JpaRepository<ProductPhotos, Integer> {
	@Transactional
	@Modifying
	@Query(value = "Delete from hinhanh where id_noi_that= :#{#id}", nativeQuery = true)
	void deleteByid(@Param("id") int id);

}
