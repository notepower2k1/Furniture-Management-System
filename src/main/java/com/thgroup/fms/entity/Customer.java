package com.thgroup.fms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
	private String hoTen;
	@Column(name = "SDT", nullable = false)
	private String sdt;
	@Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$", message = "Email không hợp lệ")
	@Column(name = "Email", nullable = false)
	private String email;
	@Column(name = "DiaChi", nullable = false)
	private String diaChi;
	@OneToOne
	@JoinColumn(name = "idTaiKhoan", insertable = true, updatable = true)
	private Account taiKhoan;
	public Customer() {
		super();
	}

	public Customer(int idKhachHang, String maKH, String hoTen, String sdt, String email, String diaChi,
			Account taiKhoan) {
		super();
		this.idKhachHang = idKhachHang;
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.email = email;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
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

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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


	public Account getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(Account taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	
	
	
}
