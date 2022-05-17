package com.thgroup.fms.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.thgroup.fms.entity.Category;
import com.thgroup.fms.entity.Furniture;

public interface FurnitureService {
	List<Furniture> getAllFurnitures();
	Furniture saveFurniture(Furniture furniture);
	void removeFurniture(int idNoiThat);
	Furniture getFurnitureById(int idNoiThat);
	String getMaxId();
	List<Furniture> searchid_loai(@Param("id_loai") int idloai);
	List<Furniture> findbyTenNT(String tenNT);
}
