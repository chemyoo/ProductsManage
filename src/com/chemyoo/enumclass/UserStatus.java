package com.chemyoo.enumclass;

import java.math.BigDecimal;

public enum UserStatus {
	/** 禁用 */
	Forbidden(0),
	/** 启用 */
	Available(1);
	private int status;
	private UserStatus(int status)
	{
		this.status=status;
	}
	public BigDecimal toIntValue()
	{
		return BigDecimal.valueOf(this.status);
	}

	@Override
	public String toString() {
		return String.valueOf(this.status);
	}
}
