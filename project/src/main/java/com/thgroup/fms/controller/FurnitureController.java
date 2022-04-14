package com.thgroup.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thgroup.fms.service.FurnitureService;

@Controller
public class FurnitureController {
	@Autowired
	private FurnitureService furnitureService;

	public FurnitureController(FurnitureService furnitureService) {
		super();
		this.furnitureService = furnitureService;
	}
	@GetMapping(value = "/")
	public String viewHomePage(Model model) {
		model.addAttribute("furnitures", this.furnitureService.getAllFurnitures());
		return "index";
	}
}
