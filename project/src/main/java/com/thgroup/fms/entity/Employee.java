package com.thgroup.fms.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
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
	@OneToMany(mappedBy = "nhanVien")
    private List<Order> dsDH = new ArrayList<>();
	@OneToOne
	@JoinColumn(name = "idTaiKhoan", insertable = true, updatable = true)
	private Account taiKhoan;
	public Employee() {
		super();
	}
	public Employee(int idNhanVien, String maNV, String hoTenNV, String sdt, String email, String diaChi,
			List<Order> dsDH, Account taiKhoan) {
		super();
		this.idNhanVien = idNhanVien;
		this.maNV = maNV;
		this.hoTenNV = hoTenNV;
		this.sdt = sdt;
		this.email = email;
		this.diaChi = diaChi;
		this.dsDH = dsDH;
		this.taiKhoan = taiKhoan;
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
	public List<Order> getDsDH() {
		return dsDH;
	}
	public void setDsDH(List<Order> dsDH) {
		this.dsDH = dsDH;
	}
	public Account getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(Account taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	
	
	
}
