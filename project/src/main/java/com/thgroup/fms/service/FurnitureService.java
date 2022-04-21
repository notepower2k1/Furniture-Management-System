package com.thgroup.fms.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.thgroup.fms.entity.Furniture;
import com.thgroup.fms.entity.Promotion;
import com.thgroup.fms.entity.Type;

public interface FurnitureService {
	List<Furniture> getAllFurnitures();
	void saveFurnitures(Furniture furniture);
	void deleteFurniture(int idNoiThat);
	Page<Furniture> findPaginated(int pageNo, int pageSize,String sortField,String sortDirection);
	Furniture getFurnitureById(int idNoiThat);

	List<Type> getAllType();
	List<Promotion> getAllPromotion();
}
