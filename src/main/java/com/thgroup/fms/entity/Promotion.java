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
@Table(name = "khuyenmai")
public class Promotion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDKhuyenMai", nullable = false)
	private int idKhuyenMai;
	@Column(name = "MaKM", nullable = false)
	private String maKM;
	@Column(name = "TenKM", nullable = false)
	private String tenKM;
	@Column(name = "GiaTri", nullable = false)
	private float giaTri;
	@OneToMany(mappedBy = "khuyenMai")
    private List<Furniture> dsNT = new ArrayList<>();
	
	public Promotion() {
		super();
	}
	
	public Promotion(int idKhuyenMai, String maKM, String tenKM) {
		super();
		this.idKhuyenMai = idKhuyenMai;
		this.maKM = maKM;
		this.tenKM = tenKM;
	}

	public float getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(float giaTri) {
		this.giaTri = giaTri;
	}

	public int getIdKhuyenMai() {
		return idKhuyenMai;
	}

	public void setIdKhuyenMai(int idKhuyenMai) {
		this.idKhuyenMai = idKhuyenMai;
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
