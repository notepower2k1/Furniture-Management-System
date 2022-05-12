package com.thgroup.fms.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "taikhoan")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDTaiKhoan", nullable = false)
	private int idTaiKhoan;
	@Column(name = "TenTaiKhoan", nullable = false)
	private String tenTaiKhoan;
	@Column(name = "MatKhau", nullable = false)
	private String matKhau;
	@ManyToMany
	@JoinTable(
            name = "tk_vt",
            joinColumns = @JoinColumn(name = "IDTaiKhoan"),
            inverseJoinColumns = @JoinColumn(name = "IDVaiTro")
    )
    private Set<Role> dsVT;
	@OneToOne(mappedBy = "taiKhoan")
    private Employee nhanVien;
	public Account() {
		super();
	}
	public Account(int idTaiKhoan, String tenTaiKhoan, String matKhau, Set<Role> dsVT, Employee nhanVien) {
		super();
		this.idTaiKhoan = idTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.dsVT = dsVT;
		this.nhanVien = nhanVien;
	}
	public int getIdTaiKhoan() {
		return idTaiKhoan;
	}
	public void setIdTaiKhoan(int idTaiKhoan) {
		this.idTaiKhoan = idTaiKhoan;
	}
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public Set<Role> getDsVT() {
		return dsVT;
	}
	public void setDsVT(Set<Role> dsVT) {
		this.dsVT = dsVT;
	}
	public Employee getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(Employee nhanVien) {
		this.nhanVien = nhanVien;
	}
	
}
