package com.chemyoo.enumclass;

import java.math.BigDecimal;

public enum ProductStatus {
	
	/** 出库态 */
	Out(1),
	/** 未出库态 */
	NoOut(0);
	private  int ps;
	private ProductStatus(int ps)
	{
		this.ps=ps;
	}
	public BigDecimal toIntValue()
	{
		return BigDecimal.valueOf(this.ps);
	}

	@Override
	public String toString() {
		return String.valueOf(this.ps);
	}

}
