package com.thgroup.fms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thgroup.fms.entity.Furniture;
import com.thgroup.fms.entity.Promotion;
import com.thgroup.fms.entity.Type;
import com.thgroup.fms.service.FurnitureService;

@Controller
public class FurnitureController {
	@Autowired
	private FurnitureService furnitureService;

	
	
	public FurnitureController(FurnitureService furnitureService) {
		super();
		this.furnitureService = furnitureService;
	}
	
	    // display list of employees
	@GetMapping("/")
	    public String viewHomePage(Model model) {
	        return findPaginated(1, "maNoiThat", "asc", model);
	 	
	}
	    
	@GetMapping("/showNewFurnitureForm")
	  public String showNewEmployeeForm(Model model) {
	    //create model attribute to bind from data
	    Furniture furniture = new Furniture();
	    List<Type> types = this.furnitureService.getAllType();
	    List<Promotion> promotions = this.furnitureService.getAllPromotion();

	    model.addAttribute("listPro",promotions);
	    model.addAttribute("listType",types);
	    model.addAttribute("furniture",furniture);
	    return "new_furniture";
	 }
	    
	    @PostMapping("/saveFurniture")
	    public String saveEmployee(@ModelAttribute("employee") Furniture furniture) {
	    	//save employee to database
	    	furnitureService.saveFurnitures(furniture);
	    	return "redirect:/";
	    }
	    
	    @GetMapping("/showFormForUpdate/{idNoiThat}")
	    public String showFormForUpdate(@PathVariable (value="idNoiThat")int idNoiThat,Model model) {
	    	// get employee from the service
			
	    	Furniture furniture = furnitureService.getFurnitureById(idNoiThat);
	    	 List<Type> types = this.furnitureService.getAllType();
	 	    List<Promotion> promotions = this.furnitureService.getAllPromotion();

	 	    model.addAttribute("listPro",promotions);
	 	    model.addAttribute("listType",types);
	    	model.addAttribute("furniture",furniture);
	    	
	    	return "update_furniture";
	    	
	    }
	    
	    @GetMapping("/showFormForDelete/{idNoiThat}")
	    public String showFormForDelete(@PathVariable (value="idNoiThat")int idNoiThat,Model model) {
	    	// get employee from the service
			
	    	this.furnitureService.deleteFurniture(idNoiThat);
			return "redirect:/";
	    	
	    }
	    // /page/1?sortField=name&sortDir=asc
	    @GetMapping("/page/{pageNo}")
	    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
	        @RequestParam("sortField") String sortField,
	        @RequestParam("sortDir") String sortDir,
	        Model model) {
	        int pageSize = 5;

	        Page <Furniture> page = furnitureService.findPaginated(pageNo, pageSize, sortField, sortDir);
	        List <Furniture> listFurniture = page.getContent();

	        model.addAttribute("currentPage", pageNo);
	        model.addAttribute("totalPages", page.getTotalPages());
	        model.addAttribute("totalItems", page.getTotalElements());

	        model.addAttribute("sortField", sortField);
	        model.addAttribute("sortDir", sortDir);
	        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

	        model.addAttribute("listFurniture", listFurniture);
	        return "index";
	    }
}
