package com.thgroup.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loainoithat")
public class Type {
	@Id
	@Column(name = "MaLoai", nullable = false)
	private String maLoai;
	@Column(name = "TenLoai", nullable = false)
	private String tenLoai;
	
	public Type() {
		super();
	}
	public Type(String maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	
}
