package com.thgroup.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hinhanh")
public class ProductPhotos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDHinhAnh", nullable = false)
	private int idHinhAnh;
	@ManyToOne
	@JoinColumn(name = "idNoiThat", insertable = true, updatable = true)
	private Furniture noiThat;
	@Column(name = "TenAnh", nullable = false)
	private String tenAnh;
	public ProductPhotos() {
		super();
	}
	public ProductPhotos(Furniture noiThat, String tenAnh) {
		super();
		this.noiThat = noiThat;
		this.tenAnh = tenAnh;
	}
	public Furniture getNoiThat() {
		return noiThat;
	}
	public void setNoiThat(Furniture noiThat) {
		this.noiThat = noiThat;
	}
	public String getTenAnh() {
		return tenAnh;
	}
	public void setTenAnh(String tenAnh) {
		this.tenAnh = tenAnh;
	}
	
}