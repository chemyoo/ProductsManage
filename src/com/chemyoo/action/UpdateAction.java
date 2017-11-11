package com.chemyoo.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.chemyoo.bean.SysUser;
import com.chemyoo.dao.BaseDao;

public class UpdateAction extends BaseDao {
	
	public static void doUpdate(Object obj)
	{
		Session session=openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		session.update(obj);
		tx.commit();
		session.flush();
		session.close();
	}
	public static void doUpdate(Object[] obj)
	{
		Session session=openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		for(int i=0;i<obj.length;i++)
			session.merge(obj[i]);
		tx.commit();
		session.flush();
		session.close();
	}

}
