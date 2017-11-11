package com.chemyoo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.chemyoo.bean.CheckOut;
import com.chemyoo.interfaces.PageDao;

public class CheckoutDao extends BaseDao  implements PageDao{
	
	@SuppressWarnings("unused")
	private static long toalpages=0;
	public final static int length=16;
	private static long totalrow=0;
	
	public long getTotalrow() {
		return totalrow;
	}
	public void setTotalrow(long totalrow) {
		CheckoutDao.totalrow = totalrow;
	}
	public long getToalpages() {
		if(totalrow%length==0)
			return totalrow/length;
		return totalrow/length+1;
	}
	public static void setToalpages(long toalpages) {
		CheckoutDao.toalpages = toalpages;
	}
	@SuppressWarnings("unchecked")
	public List<CheckOut> findAll()
	{
		Session session = openSession();
		Query query=session.createQuery("FROM CheckOut where nvl(dr,0)=0");
		List<CheckOut> outlist=query.list();
		session.close();
		return outlist;
	}
	@SuppressWarnings("unchecked")
	public List<CheckOut> findByPage(final int offset)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM CheckOut where nvl(dr,0)=0");
		totalrow=this.getAllRowCount("FROM CheckOut where nvl(dr,0)=0");
		query.setFirstResult(offset*length);
		query.setMaxResults(length);
		List<CheckOut> outlist=query.list();
		session.close();
		return outlist;
	}
	@SuppressWarnings("unchecked")
	public List<CheckOut> findHistory(final int offset)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM CheckOut where nvl(dr,0)<>0");
		totalrow=this.getAllRowCount("FROM CheckOut where nvl(dr,0)<>0");
		query.setFirstResult(offset*length);
		query.setMaxResults(length);
		List<CheckOut> intlist=query.list();
		session.close();
		return intlist;
	}
	
	@SuppressWarnings("unchecked")
	public static CheckOut findById(String pk)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM CheckOut where nvl(dr,0)=0 and pkOut='"+pk+"'");
		List<CheckOut> out=query.list();
		session.close();
		return out.get(0);
	}
	@Override
	public long getAllRowCount(String hql) {
		Session session = openSession();
		long size=(Long) session.createQuery("select count(*) "+ hql).list().get(0);
		session.close();
		return size;
	}

}
