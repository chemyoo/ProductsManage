package com.chemyoo.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * SysLog entity. @author MyEclipse Persistence Tools
 */

public class SysLog implements java.io.Serializable {

	// Fields

	private String pkLogid;
	private String loginer;
	private String operationContent;
	private String ts = new Date().toLocaleString();
	private BigDecimal dr;
	private String deletepk;
	private String tablename;
	private String delfrom;
	private String fullclassname;
	private BigDecimal oprationstatus;

	// Constructors

	/**
	 * @return oprationstatus
	 */
	public BigDecimal getOprationstatus() {
		return oprationstatus;
	}

	/**
	 * @param oprationstatus 要设置的 oprationstatus
	 */
	public void setOprationstatus(BigDecimal oprationstatus) {
		this.oprationstatus = oprationstatus;
	}

	/** default constructor */
	public SysLog() {
	}

	/** minimal constructor */
	public SysLog(String pkLogid, String loginer, String deletepk,
			String tablename, String delfrom) {
		this.pkLogid = pkLogid;
		this.loginer = loginer;
		this.deletepk = deletepk;
		this.tablename = tablename;
		this.delfrom = delfrom;
	}

	/** full constructor */
	public SysLog(String pkLogid, String loginer, String operationContent,
			String ts, BigDecimal dr, String deletepk, String tablename,
			String delfrom, String fullclassname) {
		this.pkLogid = pkLogid;
		this.loginer = loginer;
		this.operationContent = operationContent;
		this.ts = ts;
		this.dr = dr;
		this.deletepk = deletepk;
		this.tablename = tablename;
		this.delfrom = delfrom;
		this.fullclassname = fullclassname;
	}

	// Property accessors

	public String getPkLogid() {
		return this.pkLogid;
	}

	public void setPkLogid(String pkLogid) {
		this.pkLogid = pkLogid;
	}

	public String getLoginer() {
		return this.loginer;
	}

	public void setLoginer(String loginer) {
		this.loginer = loginer;
	}

	public String getOperationContent() {
		return this.operationContent;
	}

	public void setOperationContent(String operationContent) {
		this.operationContent = operationContent;
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

	public String getDeletepk() {
		return this.deletepk;
	}

	public void setDeletepk(String deletepk) {
		this.deletepk = deletepk;
	}

	public String getTablename() {
		return this.tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getDelfrom() {
		return this.delfrom;
	}

	public void setDelfrom(String delfrom) {
		this.delfrom = delfrom;
	}

	public String getFullclassname() {
		return this.fullclassname;
	}

	public void setFullclassname(String fullclassname) {
		this.fullclassname = fullclassname;
	}

}