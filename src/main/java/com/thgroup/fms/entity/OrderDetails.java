package com.thgroup.fms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chitietddh")
@IdClass(ODPrimaryKey.class)
public class OrderDetails {
	@Id
	@ManyToOne
	@JoinColumn(name = "IDDonHang", insertable = true, updatable = true)
	private Order donDatHang;
	@Id
	@ManyToOne
	@JoinColumn(name = "IDNoiThat", insertable = true, updatable = true)
	private Furniture noiThat;
	@Column(name = "SoLuong", nullable = false)
	private int soLuong;
	@Column(name = "GiaMua", nullable = false)
	private float giaMua;
	
	public OrderDetails() {
		super();
	}

	public OrderDetails(Order donDatHang, Furniture noiThat, int soLuong) {
		super();
		this.donDatHang = donDatHang;
		this.noiThat = noiThat;
		this.soLuong = soLuong;
	}

	public Order getDonDatHang() {
		return donDatHang;
	}

	public void setDonDatHang(Order donDatHang) {
		this.donDatHang = donDatHang;
	}

	public Furniture getNoiThat() {
		return noiThat;
	}

	public void setNoiThat(Furniture noiThat) {
		this.noiThat = noiThat;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getGiaMua() {
		return giaMua;
	}

	public void setGiaMua(float giaMua) {
		this.giaMua = giaMua;
	}
	
}

class ODPrimaryKey implements Serializable {
	
	private int donDatHang;
    private int noiThat;
    
}
