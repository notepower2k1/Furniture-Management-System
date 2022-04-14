package com.thgroup.fms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "chitietddh")
@IdClass(CompositeKey.class)
public class OrderDetails {
	@Id
	@Column(name = "IDDonHang", nullable = false)
	private int idDonHang;
	@Id
	@Column(name = "IDNoiThat", nullable = false)
	private int idNoiThat;
	@Column(name = "DonGiaMua", nullable = false)
	private int donGiaMua;
	@Column(name = "SoLuong", nullable = false)
	private int soLuong;
	
	public OrderDetails() {
		super();
	}

	public OrderDetails(int idDonHang, int idNoiThat, int donGiaMua, int soLuong) {
		super();
		this.idDonHang = idDonHang;
		this.idNoiThat = idNoiThat;
		this.donGiaMua = donGiaMua;
		this.soLuong = soLuong;
	}

	public int getidDonHang() {
		return idDonHang;
	}

	public void setidDonHang(int idDonHang) {
		this.idDonHang = idDonHang;
	}

	public int getIdNoiThat() {
		return idNoiThat;
	}

	public void setIdNoiThat(int idNoiThat) {
		this.idNoiThat = idNoiThat;
	}

	public int getDonGiaMua() {
		return donGiaMua;
	}

	public void setDonGiaMua(int donGiaMua) {
		this.donGiaMua = donGiaMua;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
}

class CompositeKey implements Serializable {
    private int idDonHang;
    private int idNoiThat;
}
