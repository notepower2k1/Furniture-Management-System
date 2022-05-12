package com.thgroup.fms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "loainoithat")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDLoai", nullable = false)
	private int idLoai;
	@Column(name = "MaLoai", nullable = false)
	private String maLoai;
	@Column(name = "TenLoai", nullable = false)
	private String tenLoai;
	@OneToMany(mappedBy = "loai")
    private List<Furniture> dsNT = new ArrayList<>();
	public Category() {
		super();
	}
	public Category(int idLoai, String maLoai, String tenLoai) {
		super();
		this.idLoai = idLoai;
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}
	
	public int getIdLoai() {
		return idLoai;
	}
	public void setIdLoai(int idLoai) {
		this.idLoai = idLoai;
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
