package com.thgroup.fms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thgroup.fms.entity.Category;
import com.thgroup.fms.entity.Furniture;
import com.thgroup.fms.repository.FurnitureRepository;

import com.thgroup.fms.service.FurnitureService;

@Service
public class FurnitureServiceImpl implements FurnitureService {
	@Autowired
	private FurnitureRepository furnitureRepo;

	public FurnitureServiceImpl(FurnitureRepository furnitureRepo) {
		super();
		this.furnitureRepo = furnitureRepo;
	}

	@Override
	public List<Furniture> getAllFurnitures() {
		return this.furnitureRepo.findAll();
	}

	public Furniture saveFurniture(Furniture furniture) {
		return this.furnitureRepo.save(furniture);
	}

	@Override
	public void removeFurniture(int idNoiThat) {
		this.furnitureRepo.deleteById(idNoiThat);
	}

	@Override
	public Furniture getFurnitureById(int idNoiThat) {
		Optional<Furniture> optional = this.furnitureRepo.findById(idNoiThat);
		Furniture furniture = null;
		if(optional.isPresent()) {
			furniture = optional.get();
		} else {
			throw new RuntimeException("Employee not found	for id::" + idNoiThat);
		}
		return furniture;
	}

	@Override
	public String getMaxId() {
		return this.furnitureRepo.findFirstMaNoiThat();
	}

	@Override
	public List<Furniture> searchid_loai(int idloai) {
		// TODO Auto-generated method stub
		return this.furnitureRepo.searchid_loai(idloai);
	}

	@Override
	public List<Furniture> findbyTenNT(String tenNT) {
		// TODO Auto-generated method stub
		return this.furnitureRepo.findbyTenNT(tenNT);
	}

	
	

	


}
