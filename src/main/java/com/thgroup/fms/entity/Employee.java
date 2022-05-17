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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
	@NotBlank(message = "Tên nhân viên không để trống")
	@Column(name = "HoTenNV", nullable = false)
	private String hoTen;
	@Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$", message = "Số điện thoại không hợp lệ")
	@Column(name = "SDT", nullable = false)
	private String sdt;
	@Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$", message = "Email không hợp lệ")
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
	public Employee(int idNhanVien, String maNV, String hoTen, String sdt, String email, String diaChi,
			List<Order> dsDH, Account taiKhoan) {
		super();
		this.idNhanVien = idNhanVien;
		this.maNV = maNV;
		this.hoTen = hoTen;
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
