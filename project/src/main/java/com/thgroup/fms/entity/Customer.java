package com.thgroup.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khachhang")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDKhachHang", nullable = false)
	private int idKhachHang;
	@Column(name = "MaKH", nullable = false)
	private String maKH;
	@Column(name = "HoTenKH", nullable = false)
	private String hoTenKH;
	@Column(name = "SDT", nullable = false)
	private String sdt;
	@Column(name = "Email", nullable = false)
	private String email;
	@Column(name = "DiaChi", nullable = false)
	private String diaChi;
	
	public Customer() {
		super();
	}

	public Customer(int idKhachHang, String maKH, String hoTenKH, String sdt, String email, String diaChi) {
		super();
		this.idKhachHang = idKhachHang;
		this.maKH = maKH;
		this.hoTenKH = hoTenKH;
		this.sdt = sdt;
		this.email = email;
		this.diaChi = diaChi;
	}

	public int getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getHoTenKH() {
		return hoTenKH;
	}

	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	
	
}
