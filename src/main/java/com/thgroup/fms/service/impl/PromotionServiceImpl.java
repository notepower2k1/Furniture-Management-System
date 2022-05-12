package com.thgroup.fms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thgroup.fms.entity.Promotion;
import com.thgroup.fms.repository.PromotionRepository;
import com.thgroup.fms.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {
	
	@Autowired
	private PromotionRepository proRepo;
	
	@Override
	public List<Promotion> getAllPromotions() {
		return this.proRepo.findAll();
	}
	@Override
	public Promotion getPromotionById(int id) {
		Optional<Promotion> optional = this.proRepo.findById(id);
		Promotion promotion = null;
		if(optional.isPresent()) {
			promotion = optional.get();
		} else {
			throw new RuntimeException("Employee not found	for id::" + id);
		}
		return promotion;
	}
}
