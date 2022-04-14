package com.thgroup.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDNhanVien", nullable = false)
	private int idNhanVien;
	@Column(name = "MaNV", nullable = false)
	private String maNV;
	@Column(name = "HoTenNV", nullable = false)
	private String hoTenNV;
	@Column(name = "SDT", nullable = false)
	private String sdt;
	@Column(name = "Email", nullable = false)
	private String email;
	@Column(name = "DiaChi", nullable = false)
	private String diaChi;
	@Column(name = "TaiKhoan", nullable = false)
	private String taiKhoan;
	@Column(name = "MatKhau", nullable = false)
	private String matKhau;
	@Column(name = "MaLoaiQuyen ", nullable = false)
	private String maLoaiQuyen;
	
	public Employee() {
		super();
	}

	public Employee(int idNhanVien, String maNV, String hoTenNV, String sdt, String email, String diaChi,
			String taiKhoan, String matKhau, String maLoaiQuyen) {
		super();
		this.idNhanVien = idNhanVien;
		this.maNV = maNV;
		this.hoTenNV = hoTenNV;
		this.sdt = sdt;
		this.email = email;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.maLoaiQuyen = maLoaiQuyen;
	}

	public int getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoTenNV() {
		return hoTenNV;
	}

	public void setHoTenNV(String hoTenNV) {
		this.hoTenNV = hoTenNV;
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

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getMaLoaiQuyen() {
		return maLoaiQuyen;
	}

	public void setMaLoaiQuyen(String maLoaiQuyen) {
		this.maLoaiQuyen = maLoaiQuyen;
	}
	
	
	
	
}
