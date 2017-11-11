package com.chemyoo.bean;

import java.math.BigDecimal;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private String pkUserid;
	private String userAccount;
	private String passward;
	private BigDecimal status;
	private String ts;
	private BigDecimal dr;
	private BigDecimal userrole;
	private String question1;
	private String question2;
	private String question3;
	private String answer1;
	private String answer2;
	private String answer3;

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** minimal constructor */
	public SysUser(String pkUserid) {
		this.pkUserid = pkUserid;
	}

	/** full constructor */
	public SysUser(String pkUserid, String userAccount, String passward,
			BigDecimal status, String ts, BigDecimal dr, BigDecimal userrole,
			String question1, String question2, String question3,
			String answer1, String answer2, String answer3) {
		this.pkUserid = pkUserid;
		this.userAccount = userAccount;
		this.passward = passward;
		this.status = status;
		this.ts = ts;
		this.dr = dr;
		this.userrole = userrole;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
	}

	// Property accessors

	public String getPkUserid() {
		return this.pkUserid;
	}

	public void setPkUserid(String pkUserid) {
		this.pkUserid = pkUserid;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPassward() {
		return this.passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
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

	public BigDecimal getUserrole() {
		return this.userrole;
	}

	public void setUserrole(BigDecimal userrole) {
		this.userrole = userrole;
	}

	public String getQuestion1() {
		return this.question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return this.question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return this.question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getAnswer1() {
		return this.answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return this.answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return this.answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

}