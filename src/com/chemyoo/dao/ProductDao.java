package com.chemyoo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.chemyoo.bean.ProductInfo;
import com.chemyoo.bean.SysUser;
import com.chemyoo.interfaces.PageDao;

public class ProductDao extends BaseDao implements PageDao{
	
	@SuppressWarnings("unused")
	private static long toalpages=0;
	public final static int length=16;
	private static long totalrow=0;
	
	public long getTotalrow() {
		return totalrow;
	}
	public void setTotalrow(long totalrow) {
		ProductDao.totalrow = totalrow;
	}
	public long getToalpages() {
		if(totalrow%length==0)
			return totalrow/length;
		return totalrow/length+1;
	}
	public static void setToalpages(long toalpages) {
		ProductDao.toalpages = toalpages;
	}
	@Override
	public long getAllRowCount(String hql) {
		Session session = openSession();
		long size=(Long) session.createQuery("select count(*) "+ hql).list().get(0);
		session.close();
		return size;
	}
	public List<ProductInfo> findByPage(final int offset)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM ProductInfo where nvl(dr,0)=0");
		totalrow=this.getAllRowCount("FROM ProductInfo where nvl(dr,0)=0");
		query.setFirstResult(offset*length);
		query.setMaxResults(length);
		List<ProductInfo> productlist=query.list();
		session.close();
		return productlist;
	}
	public List<ProductInfo> findAll()
	{
		Session session = openSession();
		Query query=session.createQuery("FROM ProductInfo where nvl(dr,0)=0");
		List<ProductInfo> productlist=query.list();
		session.close();
		return productlist;
	}
	
	public static ProductInfo findById(String pk)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM ProductInfo where nvl(dr,0)=0 and pk_pro='"+pk+"' ");
		List<ProductInfo> product=query.list();
		session.close();
		return product.get(0);
	}
	public static ProductInfo findByCode(String code)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM ProductInfo where nvl(dr,0)=0 and codes='"+code+"' ");
		List<ProductInfo> product=query.list();
		session.close();
		return product.get(0);
	}
	public static List<ProductInfo> queryLike(String name)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM ProductInfo where nvl(dr,0)=0 and (names like '%"+name+"%' or codes like '%"+name+"%' or " +
				"instore_date like '%"+name+"%' )");
		List<ProductInfo> productlist=query.list();
		session.close();
		return productlist;
	}

}
