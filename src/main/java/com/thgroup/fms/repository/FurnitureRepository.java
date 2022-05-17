package com.thgroup.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thgroup.fms.entity.Account;
import com.thgroup.fms.entity.Category;
import com.thgroup.fms.entity.Employee;
import com.thgroup.fms.entity.Furniture;

public interface FurnitureRepository extends JpaRepository<Furniture, Integer> {
	@Query(value="Select ma_noi_that From noithat Order By ma_noi_that Desc Limit 1", nativeQuery = true)
	String findFirstMaNoiThat();
	
	@Query(value="Select * From noithat where id_loai = :#{#id_loai}", nativeQuery = true)
	List<Furniture> searchid_loai(@Param("id_loai") int idloai);

	@Query(value="SELECT * FROM noithat WHERE tennt like %:tenNT%", nativeQuery = true)
	List<Furniture> findbyTenNT(@Param("tenNT") String tenNT);

	
}

