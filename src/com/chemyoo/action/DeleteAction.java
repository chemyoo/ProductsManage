package com.chemyoo.action;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.chemyoo.dao.BaseDao;

public class DeleteAction extends BaseDao {
	
	public static void doDel(Object obj)
	{
		Session session=openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		session.delete(obj);
		tx.commit();
		session.flush();
		session.close();
	}
	public static void doDel(Object[] obj) 
	{
		Session session=openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		for(int i=0;i<obj.length;i++)
			session.delete(obj[i]);
		tx.commit();
		session.flush();
		session.close();
	}
}
