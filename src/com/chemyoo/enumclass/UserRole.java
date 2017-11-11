package com.chemyoo.enumclass;

import java.math.BigDecimal;

public enum UserRole {
		/**
		 * 普通用户
		 */
		Normal(1),
		/**
		 * 预置用户
		 */
		Administrator(0);
		private int r;
		private UserRole(int r)
		{
			this.r=r;
		}
		public BigDecimal toIntValue()
		{
			return BigDecimal.valueOf(this.r);
		}
		@Override
		public String toString() {
			return String.valueOf(this.r);
		}
		
}
