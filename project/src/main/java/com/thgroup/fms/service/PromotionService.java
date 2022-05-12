package com.thgroup.fms.service;

import java.util.List;

import com.thgroup.fms.entity.Promotion;

public interface PromotionService {
	List<Promotion> getAllPromotions();
	Promotion getPromotionById(int id);
}
