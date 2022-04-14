package com.thgroup.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khuyenmai")
public class Promotion {
	@Id
	@Column(name = "MaKM", nullable = false)
	private String maKM;
	@Column(name = "TenKM", nullable = false)
	private String tenKM;
	
	public Promotion() {
		super();
	}

	public Promotion(String maKM, String tenKM) {
		super();
		this.maKM = maKM;
		this.tenKM = tenKM;
	}

	public String getMaKM() {
		return maKM;
	}

	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}

	public String getTenKM() {
		return tenKM;
	}

	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}
	
	
}
