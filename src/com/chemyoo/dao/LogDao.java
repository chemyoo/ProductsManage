package com.chemyoo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.chemyoo.bean.SysLog;
import com.chemyoo.interfaces.PageDao;

public class LogDao extends BaseDao implements PageDao{
	
	@SuppressWarnings("unused")
	private static long toalpages=0;
	public final static int length=16;
	private static long totalrow=0;
	
	public long getTotalrow() {
		return totalrow;
	}
	public void setTotalrow(long totalrow) {
		LogDao.totalrow = totalrow;
	}
	public long getToalpages() {
		if(totalrow%length==0)
			return totalrow/length;
		return totalrow/length+1;
	}
	public static void setToalpages(long toalpages) {
		LogDao.toalpages = toalpages;
	}
	@Override
	public long getAllRowCount(String hql) {
		Session session = openSession();
		long size=(Long) session.createQuery("select count(*) "+ hql).list().get(0);
		session.close();
		return size;
	}
	public List<SysLog> findAll()
	{
		Session session = openSession();
		Query query=session.createQuery("FROM SysLog");
		List<SysLog> Loglist = query.list();
		session.close();
		return Loglist;
	}
	public List<SysLog> findByPage(final int offset)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM SysLog");
		totalrow=this.getAllRowCount("FROM SysLog");
		query.setFirstResult(offset*length);
		query.setMaxResults(length);
		List<SysLog> Loglist = query.list();
		session.close();
		return Loglist;
	}
	public List<SysLog> findAllDel(final int offset)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM SysLog where oprationstatus=2");
		totalrow=this.getAllRowCount("FROM SysLog where oprationstatus=2");
		query.setFirstResult(offset*length);
		query.setMaxResults(length);
		List<SysLog> Loglist = query.list();
		session.close();
		return Loglist;
	}
	public static SysLog findById (String pk)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM SysLog where pkLogid='"+pk+"'");
		List<SysLog> Loglist = query.list();
		session.close();
			return Loglist.get(0);
	}
	public static SysLog findByIdDel (String pk)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM SysLog where oprationstatus=2 and pkLogid='"+pk+"'");
		List<SysLog> Loglist = query.list();
		session.close();
			return Loglist.get(0);
	}

}
