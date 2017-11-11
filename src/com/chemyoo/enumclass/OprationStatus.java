package com.chemyoo.enumclass;

import java.math.BigDecimal;

public enum OprationStatus {
	
	/** 插入 */
	Insert(0),
	/** 修改 */
	Update(1),
	/** 删除 */
	Delete(2);
	private int proerty;
	private OprationStatus(int proerty)
	{
		this.proerty=proerty;
	}
	public BigDecimal toIntValue()
	{
		return BigDecimal.valueOf(this.proerty);
	}
	public static BigDecimal ProductProerty(String proerty)
	{
		return BigDecimal.valueOf(Integer.parseInt(proerty));
	}
	@Override
	public String toString() {
		return String.valueOf(this.proerty);
	}

}
