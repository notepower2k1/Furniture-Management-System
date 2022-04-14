package com.thgroup.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phanquyen")
public class Permission {
	@Id
	@Column(name = "MaLoaiQuyen", nullable = false)
	private String maLoaiQuyen;
	@Column(name = "TenQuyen", nullable = false)
	private String tenQuyen;
	
	public Permission() {
		super();
	}

	public Permission(String maLoaiQuyen, String tenQuyen) {
		super();
		this.maLoaiQuyen = maLoaiQuyen;
		this.tenQuyen = tenQuyen;
	}

	public String getMaLoaiQuyen() {
		return maLoaiQuyen;
	}

	public void setMaLoaiQuyen(String maLoaiQuyen) {
		this.maLoaiQuyen = maLoaiQuyen;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}
	
	
}
