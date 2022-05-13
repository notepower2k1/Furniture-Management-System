package com.thgroup.fms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thgroup.fms.entity.ProductPhotos;
import com.thgroup.fms.repository.ProductPhotosRepository;
import com.thgroup.fms.service.ProductPhotosService;

@Service
public class ProductPhotosServiceImpl implements ProductPhotosService{

	@Autowired
	private ProductPhotosRepository productRepo;
	
	@Override
	public List<ProductPhotos> getAllFiles() {
		// TODO Auto-generated method stub
		return this.productRepo.findAll();
	}

	@Override
	public void saveAllFilesList(List<ProductPhotos> fileList) {
		// TODO Auto-generated method stub
		for (ProductPhotos fileModal : fileList)
			productRepo.save(fileModal);
	}

	@Override
	public void deleteByid(int id) {
		this.productRepo.deleteByid(id);
		
	}

	
}
