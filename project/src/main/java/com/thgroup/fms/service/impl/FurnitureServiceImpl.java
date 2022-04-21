package com.thgroup.fms.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.thgroup.fms.entity.Furniture;
import com.thgroup.fms.entity.Promotion;
import com.thgroup.fms.entity.Type;
import com.thgroup.fms.repository.FurnitureRepository;
import com.thgroup.fms.repository.PromotionsRepository;
import com.thgroup.fms.repository.TypeRepository;
import com.thgroup.fms.service.FurnitureService;

@Service
public class FurnitureServiceImpl implements FurnitureService {
	@Autowired
	private FurnitureRepository furnitureRepo;
	
	@Autowired
	private TypeRepository typeRepo;
	
	@Autowired
	private PromotionsRepository proRepo;
	
	/*public FurnitureServiceImpl(FurnitureRepository furnitureRepo) {
		super();
		this.furnitureRepo = furnitureRepo;
	}*/

	@Override
	public List<Furniture> getAllFurnitures() {
		return this.furnitureRepo.findAll();
	}

	public void saveFurnitures(Furniture furniture) {
		// TODO Auto-generated method stub
		this.furnitureRepo.save(furniture);
	}

	@Override
	public void deleteFurniture(int idNoiThat) {
		// TODO Auto-generated method stub
		this.furnitureRepo.deleteById(idNoiThat);
	}

	@Override
	public Page<Furniture> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? 
				Sort.by(sortField).ascending():
				Sort.by(sortField).descending();
			Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);
			return this.furnitureRepo.findAll(pageable);
	}

	@Override
	public Furniture getFurnitureById(int idNoiThat) {
		// TODO Auto-generated method stub
		Optional<Furniture> optional = furnitureRepo.findById(idNoiThat);
		Furniture furniture = null;
		if(optional.isPresent()) {
			furniture = optional.get();
		}
		else {
			throw new RuntimeException("Employee not found	for id::"+idNoiThat);
		}
		return furniture;
	}

	@Override
	public List<Type> getAllType() {
		// TODO Auto-generated method stub
		return this.typeRepo.findAll();

	}

	@Override
	public List<Promotion> getAllPromotion() {
		// TODO Auto-generated method stub
		return this.proRepo.findAll();
	}

	
}
