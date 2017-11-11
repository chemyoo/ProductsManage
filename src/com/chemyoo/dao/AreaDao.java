package com.chemyoo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chemyoo.bean.AreaStore;
import com.chemyoo.interfaces.PageDao;

public class AreaDao extends BaseDao implements PageDao{
	
	@SuppressWarnings("unused")
	private static long toalpages=0;
	public final static int length=16;
	private static long totalrow=0;
	
	public long getTotalrow() {
		return totalrow;
	}
	public void setTotalrow(long totalrow) {
		AreaDao.totalrow = totalrow;
	}
	public long getToalpages() {
		if(totalrow%length==0)
			return totalrow/length;
		return totalrow/length+1;
	}
	public static void setToalpages(long toalpages) {
		AreaDao.toalpages = toalpages;
	}
	public List<AreaStore> findByPage(final int offset)
	{
		Session session = openSession();
		String hql="from AreaStore where nvl(dr,0)=0";
		Query query=session.createQuery(hql);
		totalrow=this.getAllRowCount(hql);
		query.setFirstResult(offset*length);
		query.setMaxResults(length);

		List<AreaStore> arealist=query.list();
		session.close();
		return arealist;
	}
	public List<AreaStore> findAll()
	{
		Session session = openSession();
		String hql="from AreaStore where nvl(dr,0)=0";
		Query query=session.createQuery(hql);

		List<AreaStore> arealist=query.list();
		session.close();
		return arealist;
	}
	public List<AreaStore> findAllIncludeDel()
	{
		Session session = openSession();
		Query query=session.createQuery("from AreaStore order by areaname");
		List<AreaStore> arealist=query.list();
		session.close();
		return arealist;
	}
	public static AreaStore findById (String pk)
	{
		Session session = openSession();
		Query query=session.createQuery("from AreaStore where nvl(dr,0)=0 and areaid='"+pk+"'");
//		query.setFirstResult(offset);
//		query.setMaxResults(length);
		List<AreaStore> area=query.list();
		session.close();
		return area.get(0);
	}
	@Override
	public long getAllRowCount(String hql) {
		Session session = openSession();
		long size=(Long) session.createQuery("select count(*) "+ hql).list().get(0);
		session.close();
		return size;
	}

}
