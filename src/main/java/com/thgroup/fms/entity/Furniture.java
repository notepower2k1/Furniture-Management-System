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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "noithat")
public class Furniture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDNoiThat", nullable = false)
	private int idNoiThat;
	@Column(name = "MaNoiThat", nullable = false)
	private String maNoiThat;
	@NotEmpty(message = "Không để trống tên sản phẩm")
	@Column(name = "TenNT", nullable = false)
	private String tenNT;
	@Min(0)
	@NotEmpty(message = "Không để trống đơn giá của sản phẩm")
	@Column(name = "DonGia", nullable = false)
	private float donGia;
	@NotBlank(message = "Không để trống kích thước")
	@Column(name = "KichThuoc", nullable = true)
	private String kichThuoc;
	@Min(0)
	@NotEmpty(message = "Không để trống thời gian bảo hành")
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
	
	public List<OrderDetails> getDsCTDH() {
		return dsCTDH;
	}
	public void setDsCTDH(List<OrderDetails> dsCTDH) {
		this.dsCTDH = dsCTDH;
	}
	public List<ProductPhotos> getDsHA() {
		return dsHA;
	}
	public void setDsHA(List<ProductPhotos> dsHA) {
		this.dsHA = dsHA;
	}
	
	public Furniture(int idNoiThat, String maNoiThat, String tenNT, float donGia, String kichThuoc, int baoHanh,
			String hinhAnh, String chatLieu, String donViTinh, String moTa, Category loai, Promotion khuyenMai,
			List<OrderDetails> dsCTDH, List<ProductPhotos> dsHA) {
		super();
		this.idNoiThat = idNoiThat;
		this.maNoiThat = maNoiThat;
		this.tenNT = tenNT;
		this.donGia = donGia;
		this.kichThuoc = kichThuoc;
		this.baoHanh = baoHanh;
		this.hinhAnh = hinhAnh;
		this.chatLieu = chatLieu;
		this.donViTinh = donViTinh;
		this.moTa = moTa;
		this.loai = loai;
		this.khuyenMai = khuyenMai;
		this.dsCTDH = dsCTDH;
		this.dsHA = dsHA;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public Furniture() {
		super();
		// TODO Auto-generated constructor stub
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
