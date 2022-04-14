package com.thgroup.fms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thgroup.fms.entity.Furniture;
import com.thgroup.fms.repository.FurnitureRepository;
import com.thgroup.fms.service.FurnitureService;

@Service
public class FurnitureServiceImpl implements FurnitureService {
	@Autowired
	private FurnitureRepository furnitureRepo;
	
	/*public FurnitureServiceImpl(FurnitureRepository furnitureRepo) {
		super();
		this.furnitureRepo = furnitureRepo;
	}*/

	@Override
	public List<Furniture> getAllFurnitures() {
		return this.furnitureRepo.findAll();
	}

}
