package com.chemyoo.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.chemyoo.dao.BaseDao;
import com.chemyoo.defException.BusinessException;

public class SaveAction extends BaseDao {
	
	public static void doSave(Object obj) throws BusinessException
	{
		Session session=openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		session.save(obj);
		tx.commit();
		session.flush();
		session.close();
	}
	public static void doSave(Object[] obj) throws BusinessException
	{
		Session session=openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		try
		{
			for(int i=0;i<obj.length;i++)
			{
				session.save(obj[i]);
			}
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			throw new BusinessException("保存数据时业务异常 ————  "+e.getMessage(),e.getCause());
		}
		
		finally
		{
			session.flush();
			session.close();
		}
	}

}
