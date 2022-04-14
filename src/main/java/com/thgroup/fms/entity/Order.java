package com.thgroup.fms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dondathang")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDDonHang", nullable = false)
	private int idDonHang;
	@Column(name = "MaDH", nullable = false)
	private String maDH;
	@Column(name = "NgayLap", nullable = false)
	private Date ngayLap;
	@Column(name = "TinhTrang", nullable = false)
	private boolean tinhTrang;
	@Column(name = "DiaChiNhanHang", nullable = false)
	private String diaChiNhanHang;
	@Column(name = "IDKhachHang", nullable = false)
	private int idKhachHang;
	@Column(name = "IDNhanVien", nullable = false)
	private int idNhanVien;
	@Column(name = "GhiChu", nullable = true)
	private String ghiChu;
	
	public Order() {
		super();
	}

	public Order(int idDonHang, String maDH, Date ngayLap, boolean tinhTrang, String diaChiNhanHang, int idKhachHang,
			int idNhanVien, String ghiChu) {
		super();
		this.idDonHang = idDonHang;
		this.maDH = maDH;
		this.ngayLap = ngayLap;
		this.tinhTrang = tinhTrang;
		this.diaChiNhanHang = diaChiNhanHang;
		this.idKhachHang = idKhachHang;
		this.idNhanVien = idNhanVien;
		this.ghiChu = ghiChu;
	}

	public int getIdDonHang() {
		return idDonHang;
	}

	public void setIdDonHang(int idDonHang) {
		this.idDonHang = idDonHang;
	}

	public String getMaDH() {
		return maDH;
	}

	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public int getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public int getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
