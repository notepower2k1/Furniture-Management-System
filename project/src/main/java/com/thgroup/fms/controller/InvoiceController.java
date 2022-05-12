package com.thgroup.fms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thgroup.fms.entity.Order;
import com.thgroup.fms.entity.OrderDetails;
import com.thgroup.fms.service.OrderDetailsService;
import com.thgroup.fms.service.OrderService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class InvoiceController {
	
	@Autowired
	private OrderDetailsService orderDetailService;
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/pdf/{idDonHang}")
	public String generatePdf(@PathVariable(value="idDonHang") int idDonHang,
			RedirectAttributes redirectAttrs) {
		String path = "src/main/resources/";
		Order orderPrinted = this.orderService.getOrderById(idDonHang);
		List<OrderDetails> orderDPrinted = this.orderDetailService.getByOrderId(idDonHang);
		float total = 0;
		for (int i = 0; i < orderDPrinted.size(); i++) {
			total += orderDPrinted.get(i).getGiaMua()*orderDPrinted.get(i).getSoLuong();
		}
		JRBeanCollectionDataSource beanCollectionDataSource = 
				new JRBeanCollectionDataSource(orderDPrinted);
		try {
			File file = new File(path + "invoice");
			file.mkdirs();
			JasperReport compileReport = JasperCompileManager
					.compileReport(new FileInputStream(path + "invoice.jrxml"));
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("order", orderPrinted);
			parameters.put("total", total);
			JasperPrint jasperPrint = JasperFillManager
					.fillReport(compileReport, parameters, beanCollectionDataSource);
			String fileName = "hoadon-"+ orderPrinted.getMaDH() + ".pdf";
			JasperExportManager.exportReportToPdfFile(jasperPrint, file.getAbsolutePath() 
					+ "/" + fileName);
			return "redirect:/show-pdf/" + fileName;
		} catch (FileNotFoundException | JRException e) {
			e.printStackTrace();
			return null;
		}

	}
	@GetMapping("/show-pdf/{pdfName}")
	public ResponseEntity<InputStreamResource> showPDF(@PathVariable(value="pdfName") String pdfName) {

        String filePath = "src/main/resources/invoice/";
        String fileName = pdfName;
        File file = new File(filePath + fileName);
        HttpHeaders headers = new HttpHeaders();      
        headers.add("content-disposition", "inline;filename=" + fileName);
        
        InputStreamResource resource;
		try {
			resource = new InputStreamResource(new FileInputStream(file));
			return ResponseEntity.ok()
	                .headers(headers)
	                .contentLength(file.length())
	                .contentType(MediaType.parseMediaType("application/pdf"))
	                .body(resource);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
        
    }
}
