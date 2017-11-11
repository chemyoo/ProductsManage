package com.chemyoo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.chemyoo.bean.Stores;
import com.chemyoo.interfaces.PageDao;

public class StoreDao extends BaseDao  implements PageDao{
	
	@SuppressWarnings("unused")
	private static long toalpages=0;
	public final static int length=16;
	private static long totalrow=0;
	
	private static Stores s;
	private static boolean flag;
	
	public long getTotalrow() {
		return totalrow;
	}
	public void setTotalrow(long totalrow) {
		StoreDao.totalrow = totalrow;
	}
	public long getToalpages() {
		if(totalrow%length==0)
			return totalrow/length;
		return totalrow/length+1;
	}
	public static void setToalpages(long toalpages) {
		StoreDao.toalpages = toalpages;
	}
	@Override
	public long getAllRowCount(String hql) {
		Session session = openSession();
		long size=(Long) session.createQuery("select count(*) "+ hql).list().get(0);
		session.close();
		return size;
	}

	
	public List<Stores> findByPage(final int offset)
	{
		Session session=openSession();
		Query query=session.createQuery("FROM Stores where nvl(dr,0)=0");
		totalrow=this.getAllRowCount("FROM Stores where nvl(dr,0)=0");
		query.setFirstResult(offset*length);
		query.setMaxResults(length);
		
		List<Stores> storeslist=query.list();
		session.close();
		return storeslist;
	}
	public List<Stores> findAll()
	{
		Session session=openSession();
		Query query=session.createQuery("FROM Stores where nvl(dr,0)=0");
		List<Stores> storeslist=query.list();
		session.close();
		return storeslist;
	}
	public static Stores findById(String pk)
	{
		Session session=openSession();
		Query query=session.createQuery("FROM Stores where nvl(dr,0)=0 and pkStore='"+pk+"'");
		List<Stores> storeslist=query.list();
		s=storeslist.get(0);
		flag=s.getCheckIns().isEmpty()&&s.getCheckOuts().isEmpty()&&s.getProductInfos().isEmpty();
		session.close();
		return s;
	}
	public static boolean getIsUsed()
	{
		return flag;
	}

}
