package com.chemyoo.bean;

import java.math.BigDecimal;

/**
 * ProductInfo entity. @author MyEclipse Persistence Tools
 */

public class ProductInfo implements java.io.Serializable {

	// Fields

	private String pkPro;
	private AreaStore areaStore;
	private Stores stores;
	private String codes;
	private String names;
	private BigDecimal proAttribute;
	private String proAddress;
	private String ts;
	private BigDecimal dr;
	private Double totalnum;
	private Double def1;
	private Double def2;
	private String instoreDate;
	private String outstoreDate;
	private String qrCode;

	// Constructors

	/** default constructor */
	public ProductInfo() {
	}

	/** minimal constructor */
	public ProductInfo(String pkPro) {
		this.pkPro = pkPro;
	}

	/** full constructor */
	public ProductInfo(String pkPro, AreaStore areaStore, Stores stores,
			String codes, String names, BigDecimal proAttribute,
			String proAddress, String ts, BigDecimal dr, Double totalnum,
			Double def1, Double def2, String instoreDate, String outstoreDate,
			String qrCode) {
		this.pkPro = pkPro;
		this.areaStore = areaStore;
		this.stores = stores;
		this.codes = codes;
		this.names = names;
		this.proAttribute = proAttribute;
		this.proAddress = proAddress;
		this.ts = ts;
		this.dr = dr;
		this.totalnum = totalnum;
		this.def1 = def1;
		this.def2 = def2;
		this.instoreDate = instoreDate;
		this.outstoreDate = outstoreDate;
		this.qrCode = qrCode;
	}

	// Property accessors

	public String getPkPro() {
		return this.pkPro;
	}

	public void setPkPro(String pkPro) {
		this.pkPro = pkPro;
	}

	public AreaStore getAreaStore() {
		return this.areaStore;
	}

	public void setAreaStore(AreaStore areaStore) {
		this.areaStore = areaStore;
	}

	public Stores getStores() {
		return this.stores;
	}

	public void setStores(Stores stores) {
		this.stores = stores;
	}

	public String getCodes() {
		return this.codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
	}

	public String getNames() {
		return this.names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public BigDecimal getProAttribute() {
		return this.proAttribute;
	}

	public void setProAttribute(BigDecimal proAttribute) {
		this.proAttribute = proAttribute;
	}

	public String getProAddress() {
		return this.proAddress;
	}

	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public BigDecimal getDr() {
		return this.dr;
	}

	public void setDr(BigDecimal dr) {
		this.dr = dr;
	}

	public Double getTotalnum() {
		return this.totalnum;
	}

	public void setTotalnum(Double totalnum) {
		this.totalnum = totalnum;
	}

	public Double getDef1() {
		return this.def1;
	}

	public void setDef1(Double def1) {
		this.def1 = def1;
	}

	public Double getDef2() {
		return this.def2;
	}

	public void setDef2(Double def2) {
		this.def2 = def2;
	}

	public String getInstoreDate() {
		return this.instoreDate;
	}

	public void setInstoreDate(String instoreDate) {
		this.instoreDate = instoreDate;
	}

	public String getOutstoreDate() {
		return this.outstoreDate;
	}

	public void setOutstoreDate(String outstoreDate) {
		this.outstoreDate = outstoreDate;
	}

	public String getQrCode() {
		return this.qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

}