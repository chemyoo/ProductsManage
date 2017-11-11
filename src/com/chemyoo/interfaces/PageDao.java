package com.chemyoo.interfaces;

public interface PageDao {
	/**
	 * 查询所有的记录数
	 * @param hql 查询条件
	 * @return 总记录数
	 */
	public long getAllRowCount(String hql);

}
