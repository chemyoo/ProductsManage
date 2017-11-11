package com.chemyoo.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.chemyoo.bean.SysUser;
import com.chemyoo.interfaces.PageDao;

public class SysUserDao extends BaseDao  implements PageDao{
	
	@SuppressWarnings("unused")
	private static long toalpages=0;
	public final static int length=16;
	private static long totalrow=0;
	
	public long getTotalrow() {
		return totalrow;
	}
	public void setTotalrow(long totalrow) {
		SysUserDao.totalrow = totalrow;
	}
	public long getToalpages() {
		if(totalrow%length==0)
			return totalrow/length;
		return totalrow/length+1;
	}
	public static void setToalpages(long toalpages) {
		SysUserDao.toalpages = toalpages;
	}

	public List<SysUser> findAll()
	{
		Session session = openSession();
		Query query=session.createQuery("FROM SysUser where nvl(dr,0)=0");
		List<SysUser> userlist=query.list();
		session.close();
		return userlist;
	}
	public List<SysUser> findByPage(final int offset)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM SysUser where nvl(dr,0)=0");
		totalrow=this.getAllRowCount("FROM SysUser where nvl(dr,0)=0");
		query.setFirstResult(offset*length);
		query.setMaxResults(length);
		List<SysUser> userlist=query.list();
		
		session.close();
		return userlist;
	}
	public static SysUser findById (String pk)
	{
		//String table=obj.getClass().getSimpleName();
		Session session = openSession();
		Query query=session.createQuery("FROM SysUser where nvl(dr,0)=0 and pk_userid='"+pk+"' ");
		List<SysUser> userlist=query.list();
		session.close();
		return userlist.get(0);
	}
	public static SysUser findByUser (String useraccount)
	{
		//String table=obj.getClass().getSimpleName();
		Session session = openSession();
		Query query=session.createQuery("FROM SysUser where nvl(dr,0)=0 and USER_ACCOUNT='"+useraccount+"' ");
		List<SysUser> userlist=query.list();
		session.close();
		return userlist.get(0);
	}
	public static List<SysUser> doLogin(String user)
	{
		Session session = openSession();
		Query query=session.createQuery("FROM SysUser where nvl(dr,0)=0 and userAccount='"+user+"' ");
		List<SysUser> userlist=query.list();
		session.close();
		return userlist;
	}
	@Override
	public long getAllRowCount(String hql) {
		Session session = openSession();
		long size=(Long) session.createQuery("select count(*) "+ hql).list().get(0);
		session.close();
		return size;
	}
	
	public void createSysUser()
	{
		Logger log = Logger.getRootLogger();
		Session session = openSession();
		String sql="Insert into SYS_USER (PK_USERID,USER_ACCOUNT,PASSWARD,STATUS,TS,DR,USERROLE,QUESTION1," +
				"QUESTION2,QUESTION3,ANSWER1,ANSWER2,ANSWER3) values ('20160312121332Y46S','system','1',1," +
				"'2016-03-12 12:13:32',0,0,null,null,null,null,null,null)";
		SQLQuery create=session.createSQLQuery(sql);
		int row=create.executeUpdate();
		session.beginTransaction().commit();
		log.debug("执行结果影响行数："+row);
		session.close();
	}

}
