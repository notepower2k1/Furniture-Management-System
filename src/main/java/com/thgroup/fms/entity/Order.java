package com.thgroup.fms.entity;

import java.sql.Date;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dondathang")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDDonHang", nullable = false)
	private int idDonHang;
	@Column(name = "MaDH", nullable = false)
	private String maDH;
	@NotNull(message = "Nhập ngày lập đơn")
	@Column(name = "NgayLap", nullable = false)
	private Date ngayLap;
	@NotNull(message = "Chọn tình trạng của đơn mua")
	@Column(name = "TinhTrang", nullable = false)
	private int tinhTrang;
	@Column(name = "DiaChiNhanHang", nullable = false)
	private String diaChiNhanHang;
	@ManyToOne
	@JoinColumn(name = "id_tai_khoan", insertable = true, updatable = true)
	private Account account;
	
	@Column(name = "GhiChu", nullable = true)
	private String ghiChu;
	@OneToMany(mappedBy = "donDatHang")
    private List<OrderDetails> dsCTDH = new ArrayList<>();


	

	public Order(int idDonHang, String maDH, @NotNull(message = "Nhập ngày lập đơn") Date ngayLap,
			@NotNull(message = "Chọn tình trạng của đơn mua") int tinhTrang, String diaChiNhanHang, Account account,
			String ghiChu, List<OrderDetails> dsCTDH) {
		super();
		this.idDonHang = idDonHang;
		this.maDH = maDH;
		this.ngayLap = ngayLap;
		this.tinhTrang = tinhTrang;
		this.diaChiNhanHang = diaChiNhanHang;
		this.account = account;
		this.ghiChu = ghiChu;
		this.dsCTDH = dsCTDH;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}



	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public List<OrderDetails> getDsCTDH() {
		return dsCTDH;
	}

	public void setDsCTDH(List<OrderDetails> dsCTDH) {
		this.dsCTDH = dsCTDH;
	}

}
