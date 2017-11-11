package com.chemyoo.bean;

import java.math.BigDecimal;

/**
 * CheckOut entity. @author MyEclipse Persistence Tools
 */

public class CheckOut implements java.io.Serializable {

	// Fields

	private String pkOut;
	private AreaStore areaStore;
	private Stores stores;
	private String codes;
	private String names;
	private BigDecimal proAttribute;
	private String proAddress;
	private String instoreDate;
	private String outstoreDate;
	private BigDecimal status;
	private Double checkoutNum;
	private String ts;
	private BigDecimal dr;
	private String qrCode;

	// Constructors

	/** default constructor */
	public CheckOut() {
	}

	/** minimal constructor */
	public CheckOut(String pkOut) {
		this.pkOut = pkOut;
	}

	/** full constructor */
	public CheckOut(String pkOut, AreaStore areaStore, Stores stores,
			String codes, String names, BigDecimal proAttribute,
			String proAddress, String instoreDate, String outstoreDate,
			BigDecimal status, Double checkoutNum, String ts, BigDecimal dr,
			String qrCode) {
		this.pkOut = pkOut;
		this.areaStore = areaStore;
		this.stores = stores;
		this.codes = codes;
		this.names = names;
		this.proAttribute = proAttribute;
		this.proAddress = proAddress;
		this.instoreDate = instoreDate;
		this.outstoreDate = outstoreDate;
		this.status = status;
		this.checkoutNum = checkoutNum;
		this.ts = ts;
		this.dr = dr;
		this.qrCode = qrCode;
	}

	// Property accessors

	public String getPkOut() {
		return this.pkOut;
	}

	public void setPkOut(String pkOut) {
		this.pkOut = pkOut;
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

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public Double getCheckoutNum() {
		return this.checkoutNum;
	}

	public void setCheckoutNum(Double checkoutNum) {
		this.checkoutNum = checkoutNum;
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

	public String getQrCode() {
		return this.qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

}