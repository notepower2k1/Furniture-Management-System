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
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "taikhoan")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDTaiKhoan", nullable = false)
	private int idTaiKhoan;
	//@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Tên tài khoản không nên bắt đầu bằng ký tự số")
	@Column(name = "TenTaiKhoan", nullable = false)
	private String tenTaiKhoan;
	//@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "Mật khẩu chứa ít nhất 1 ký tự hoa, thường và số")
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
	@OneToOne(mappedBy = "taiKhoan")
    private Customer khachHang;
	public Customer getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(Customer khachHang) {
		this.khachHang = khachHang;
	}
	public Account() {
		super();
	}
	public Account(int idTaiKhoan, String tenTaiKhoan, String matKhau, Set<Role> dsVT) {
		super();
		this.idTaiKhoan = idTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.dsVT = dsVT;
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
	
	/*public void addRole(Role role) {
        this.dsVT.add(role);
       role.getDsTK().add(this);
    }*/
  
    public void removeRole(Role role) {
        this.dsVT.remove(role);
        role.getDsTK().remove(this);
    }
}
