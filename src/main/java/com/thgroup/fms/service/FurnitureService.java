package com.thgroup.fms.service;

import java.util.List;

import com.thgroup.fms.entity.Furniture;

public interface FurnitureService {
	List<Furniture> getAllFurnitures();
	Furniture saveFurniture(Furniture furniture);
	void removeFurniture(int idNoiThat);
	Furniture getFurnitureById(int idNoiThat);
	String getMaxId();
}
