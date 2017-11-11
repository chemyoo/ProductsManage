package com.chemyoo.bean;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * AreaStore entity. @author MyEclipse Persistence Tools
 */

public class AreaStore implements java.io.Serializable {

	// Fields

	private String areaid;
	private String areaname;
	private String ts;
	private BigDecimal dr;
	private String areacode;
	private Set checkIns = new HashSet(0);
	private Set productInfos = new HashSet(0);
	private Set checkOuts = new HashSet(0);

	// Constructors

	/** default constructor */
	public AreaStore() {
	}

	/** minimal constructor */
	public AreaStore(String areaid) {
		this.areaid = areaid;
	}

	/** full constructor */
	public AreaStore(String areaid, String areaname, String ts, BigDecimal dr,
			String areacode, Set checkIns, Set productInfos, Set checkOuts) {
		this.areaid = areaid;
		this.areaname = areaname;
		this.ts = ts;
		this.dr = dr;
		this.areacode = areacode;
		this.checkIns = checkIns;
		this.productInfos = productInfos;
		this.checkOuts = checkOuts;
	}

	// Property accessors

	public String getAreaid() {
		return this.areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getAreaname() {
		return this.areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
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

	public String getAreacode() {
		return this.areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public Set getCheckIns() {
		return this.checkIns;
	}

	public void setCheckIns(Set checkIns) {
		this.checkIns = checkIns;
	}

	public Set getProductInfos() {
		return this.productInfos;
	}

	public void setProductInfos(Set productInfos) {
		this.productInfos = productInfos;
	}

	public Set getCheckOuts() {
		return this.checkOuts;
	}

	public void setCheckOuts(Set checkOuts) {
		this.checkOuts = checkOuts;
	}

}