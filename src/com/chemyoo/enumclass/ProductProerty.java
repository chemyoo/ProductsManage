package com.chemyoo.enumclass;

import java.math.BigDecimal;

public enum ProductProerty {
	/** 易潮湿 */
	Damp(0),
	/** 贵重品 */
	Precious(1),
	/** 易碎品 */
	Breakable(2),
	/** 易燃品 */
	Flammable(3),
	/** 危险品 */
	Dangerous(4),
	/** 易爆炸 */
	Explosive(5),
	/** 毒性物品 */
	Poisonous(6)
	;
	private int proerty;
	private ProductProerty(int proerty)
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
	public static String getProertyName(String proerty)
	{
		String proertyName="";
		if("0".equals(proerty))
			proertyName="易潮湿";
		else if("1".equals(proerty))
			proertyName="贵重品";
		else if("2".equals(proerty))
			proertyName="易碎品";
		else if("3".equals(proerty))
			proertyName="易燃品";
		else if("4".equals(proerty))
			proertyName="危险品";
		else if("5".equals(proerty))
			proertyName="易爆炸";
		else if("6".equals(proerty))
			proertyName="毒性物品";
		else
			proertyName="~";
		return proertyName;
		
	}

}
