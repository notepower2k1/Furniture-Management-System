package com.thgroup.fms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "noithat")
public class Furniture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDNoiThat", nullable = false)
	private int idNoiThat;
	@Column(name = "MaNoiThat", nullable = false)
	private String maNoiThat;
	@Column(name = "TenNT", nullable = false)
	private String tenNT;
	@Column(name = "DonGia", nullable = false)
	private float donGia;
	@Column(name = "KichThuoc", nullable = true)
	private String kichThuoc;
	@Column(name = "TGBaoHanh", nullable = false)
	private int baoHanh;
	@Column(name = "HinhAnh", nullable = false)
	private String hinhAnh;
	@Column(name = "ChatLieu", nullable = false)
	private String chatLieu;
	@Column(name = "DonViTinh", nullable = false)
	private String donViTinh;
	@Column(name = "MoTa", nullable = false)
	private String moTa;
	@ManyToOne
	@JoinColumn(name = "idLoai", insertable = true, updatable = true)
	private Category loai;
	@ManyToOne
	@JoinColumn(name = "idKM", insertable = true, updatable = true)
	private Promotion khuyenMai;
	@OneToMany(mappedBy = "noiThat")
    private List<OrderDetails> dsCTDH = new ArrayList<>();
	@OneToMany(mappedBy = "noiThat")
    private List<ProductPhotos> dsHA = new ArrayList<>();
	
	public Furniture(int idNoiThat, String maNoiThat, String tenNT, int donGia, String kichThuoc, int baoHanh,
			String hinhAnh, String chatLieu, String moTa, Category loai, Promotion khuyenMai, String donViTinh) {
		super();
		this.idNoiThat = idNoiThat;
		this.maNoiThat = maNoiThat;
		this.tenNT = tenNT;
		this.donGia = donGia;
		this.kichThuoc = kichThuoc;
		this.baoHanh = baoHanh;
		this.hinhAnh = hinhAnh;
		this.chatLieu = chatLieu;
		this.moTa = moTa;
		this.loai = loai;
		this.khuyenMai = khuyenMai;
		this.donViTinh = donViTinh;
	}
	public Furniture() {
		super();
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public int getIdNoiThat() {
		return idNoiThat;
	}
	public void setIdNoiThat(int idNoiThat) {
		this.idNoiThat = idNoiThat;
	}
	public String getMaNoiThat() {
		return maNoiThat;
	}
	public void setMaNoiThat(String maNoiThat) {
		this.maNoiThat = maNoiThat;
	}
	public String getTenNT() {
		return tenNT;
	}
	public void setTenNT(String tenNT) {
		this.tenNT = tenNT;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public String getKichThuoc() {
		return kichThuoc;
	}
	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}
	public int getBaoHanh() {
		return baoHanh;
	}
	public void setBaoHanh(int baoHanh) {
		this.baoHanh = baoHanh;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getChatLieu() {
		return chatLieu;
	}
	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public Category getLoai() {
		return loai;
	}
	public void setLoai(Category loai) {
		this.loai = loai;
	}
	public Promotion getKhuyenMai() {
		return khuyenMai;
	}
	public void setKhuyenMai(Promotion khuyenMai) {
		this.khuyenMai = khuyenMai;
	}
	
	
}
