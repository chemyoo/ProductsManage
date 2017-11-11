package com.chemyoo.function;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.chemyoo.dao.BaseDao;

/**
 * 获取由日期生成的主键
 * @author Administrator
 *
 */
public class GetPkTool extends BaseDao{
	
	private static String letter[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V",
		"W","X","Y","Z"};
	public static synchronized String getpk()
	{
//		Session session =GetPkTool.openSession();
//		String hql="select to_char(sysdate,'YYYYMMDDHH24MISS') from Dual";
//		Query query = session.createQuery(hql);
//		String pk= query.list().get(0).toString();
//		session.flush();
//		session.close();
		String finalpk=null;
		try 
		{
			Date date=new Date();
			SimpleDateFormat format= new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String pk=format.format(date);
			if((int) (Math.random()*100)%4==0)
				finalpk= pk+letter[(int)(Math.random()*26)]+(int) (Math.random()*10)
						+letter[(int)(Math.random()*26)]+(int) (Math.random()*10);
			else if((int) (Math.random()*10)%3==1||(int) (Math.random()*10)%3==2)
				finalpk= pk+letter[(int)(Math.random()*26)]+letter[(int)(Math.random()*26)]
						+((int)(Math.random()*90)+10);
			else
				finalpk= pk+letter[(int)(Math.random()*26)]+(int) (Math.random()*10)
						+(int) (Math.random()*10)+letter[(int)(Math.random()*26)];
				Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return finalpk;
	}
}
