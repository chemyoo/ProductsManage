package com.chemyoo.test;


import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;

import com.chemyoo.action.DeleteAction;
import com.chemyoo.action.SaveAction;
import com.chemyoo.action.UpdateAction;
import com.chemyoo.bean.AreaStore;
import com.chemyoo.bean.SysUser;
import com.chemyoo.dao.BaseDao;
import com.chemyoo.dao.LogDao;
import com.chemyoo.defException.BusinessException;
import com.chemyoo.enumclass.UserRole;
import com.chemyoo.function.GetPkTool;
import com.chemyoo.opration.QueryLike;

public class TestHiberbate  extends BaseDao{

	/**
	 * @param args
	 */
	@Test
	public void tst1()
	{
		BigDecimal u=UserRole.Normal.toIntValue();
		long start = new Date().getTime();
		AreaStore [] store=new AreaStore[10];
		for(int i=0;i<store.length;i++)
		{
			store[i]=new AreaStore();
			store[i].setAreaid(GetPkTool.getpk());
			store[i].setAreaname(i+"区");
		}
		try 
		{
			SaveAction.doSave(store);
			UpdateAction.doUpdate(store);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		System.out.println("耗时："+(new Date().getTime()-start)+"ms");
	}
	@Test
	public void tst2()
	{
		long start = new Date().getTime();
		AreaStore store=new AreaStore();
		store.setAreaid("20160310145711Q79B");
		DeleteAction.doDel(store);
	}
	@Test
	public void tst3()
	{
		long start = new Date().getTime();
		SysUser sysuser=new SysUser();
		for(int i=0;i<10;i++)
		{
			sysuser.setPkUserid(GetPkTool.getpk());
			sysuser.setUserAccount("System"+(i+1));
			sysuser.setPassward("1");
			//sysuser.setStatus(1);
			try {
				SaveAction.doSave(sysuser);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Test
	public void tst4()
	{
		System.out.println(BigDecimal.ONE.add(BigDecimal.TEN));
	}
	
	public void createSysUser()
	{
		Session session = openSession();
		String sql="Insert into SYS_USER (PK_USERID,USER_ACCOUNT,PASSWARD,STATUS,TS,DR,USERROLE,QUESTION1," +
				"QUESTION2,QUESTION3,ANSWER1,ANSWER2,ANSWER3) values ('20160312121332Y46S','system','1',1," +
				"'2016-03-12 12:13:32',0,0,null,null,null,null,null,null)";
		session.createSQLQuery(sql);
		session.close();
	}
}
