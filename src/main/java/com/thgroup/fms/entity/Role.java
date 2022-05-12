package com.thgroup.fms.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDVaiTro", nullable = false)
    private int idVaiTro;
	@Column(name = "TenVT", nullable = false)
    private String tenVT;
    @OneToMany(mappedBy = "dsVT")
    private Set<Account> dsTK;
    
	public Role() {
		super();
	}
	
	public Role(int idVaiTro, String tenVT) {
		super();
		this.idVaiTro = idVaiTro;
		this.tenVT = tenVT;
	}
	public int getIdVaiTro() {
		return idVaiTro;
	}
	public void setIdVaiTro(int idVaiTro) {
		this.idVaiTro = idVaiTro;
	}
	public String getTenVT() {
		return tenVT;
	}
	public void setTenVT(String tenVT) {
		this.tenVT = tenVT;
	}
    
}
