package com.chemyoo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.chemyoo.bean.CheckIn;
import com.chemyoo.interfaces.PageDao;

public class CheckinDao extends BaseDao implements PageDao{
	@SuppressWarnings("unused")
	private static long toalpages=0;
	public final static int length=16;
	private static long totalrow=0;
	
	public long getTotalrow() {
		return totalrow;
	}
	public void setTotalrow(long totalrow) {
		CheckinDao.totalrow = totalrow;
	}
	public long getToalpages() {
		if(totalrow%length==0)
			return totalrow/length;
		return totalrow/length+1;
	}
	public static void setToalpages(long toalpages) {
		CheckinDao.toalpages = toalpages;
	}

	public List<CheckIn> findAll()
	{
		Session session = openSession();
		Query query=session.createQuery("FROM CheckIn where nvl(dr,0)=0");
		List<CheckIn> intlist=query.list();
		session.close();
		return intlist;
		
	}
	public List<CheckIn> findByPage(final int offset)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM CheckIn where nvl(dr,0)=0");
		totalrow=this.getAllRowCount("FROM CheckIn where nvl(dr,0)=0");
		query.setFirstResult(offset*length);
		query.setMaxResults(length);
		List<CheckIn> intlist=query.list();
		session.close();
		return intlist;
		
	}
	
	public List<CheckIn> findHistory(final int offset)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM CheckIn where nvl(dr,0)<>0");
		totalrow=this.getAllRowCount("FROM CheckIn where nvl(dr,0)=0");
		query.setFirstResult(offset*length);
		query.setMaxResults(length);
		List<CheckIn> intlist=query.list();
		session.close();
		return intlist;
	}
	
	public static CheckIn findById(String pk)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM CheckIn where nvl(dr,0)=0 and PK_CHECK='"+pk+"'");
		List<CheckIn> intlist=query.list();
		session.close();
		return intlist.get(0);
	}
	@Override
	public long getAllRowCount(String hql) {
		Session session = openSession();
		long size=(Long) session.createQuery("select count(*) "+ hql).list().get(0);
		session.close();
		return size;
	}
}
