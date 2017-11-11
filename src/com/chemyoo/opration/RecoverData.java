package com.chemyoo.opration;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.chemyoo.action.DeleteAction;
import com.chemyoo.action.UpdateAction;
import com.chemyoo.bean.AreaStore;
import com.chemyoo.bean.CheckIn;
import com.chemyoo.bean.CheckOut;
import com.chemyoo.bean.ProductInfo;
import com.chemyoo.bean.Stores;
import com.chemyoo.bean.SysUser;
import com.chemyoo.dao.BaseDao;
import com.chemyoo.interfaces.RecoverDataFromRecycleBin;

public class RecoverData extends BaseDao implements RecoverDataFromRecycleBin {

	private AreaStore area=new AreaStore();
	private CheckIn checkin=new CheckIn();
	private CheckOut checkout=new CheckOut();
	private ProductInfo product=new ProductInfo();
	private Stores store=new Stores();
	private SysUser sysuser=new SysUser();
	@Override
	public Boolean recoverData(String pk, String tablename,String fullclassname,int recoverflag){
		Session session= openSession();
		Query query;
		String hql="FROM "+tablename+" where nvl(dr,0)<>0 and ";
		//Query query=session.createQuery("FROM "+tablename+" where nvl(dr,0)<>0 and "+"pk='"+pk+"'");
		
		if(fullclassname.equals(area.getClass().getName()))
		{
			query=session.createQuery(hql+"areaid='"+pk+"'");
			List<AreaStore> list=query.list();
			
			if(list!=null&&list.size()!=0)
			{
				area=list.get(0);
				boolean size=area.getProductInfos().isEmpty()&&area.getCheckIns().isEmpty()&&area.getCheckOuts().isEmpty();
				session.close();
				if(recoverflag==1)
				{
					area.setDr(BigDecimal.ZERO);
					UpdateAction.doUpdate(area);
				}
				else
				{
					if(size)
					{
						DeleteAction.doDel(area);
					}
					else 
						return false;
				}
				return true;
			}
		}
		else if(fullclassname.equals(checkin.getClass().getName()))
		{
			query=session.createQuery(hql+"pk_check='"+pk+"'");
			List<CheckIn> list=query.list();

			if(list!=null&&list.size()!=0)
			{
				checkin=list.get(0);
				session.close();
				if(recoverflag==1)
				{
					checkin.setDr(BigDecimal.ZERO);
					UpdateAction.doUpdate(checkin);
				}
				else
					DeleteAction.doDel(checkin);
				return true;
			}
		}
		else if(fullclassname.equals(checkout.getClass().getName()))
		{
			query=session.createQuery(hql+"pk_out='"+pk+"'");
			List<CheckOut> list=query.list();
			
			if(list!=null&&list.size()!=0)
			{
				checkout=list.get(0);
				session.close();
				if(recoverflag==1)
				{
					checkout.setDr(BigDecimal.ZERO);
					UpdateAction.doUpdate(checkout);
				}
				else
				{
					DeleteAction.doDel(checkout);
				}
				return true;
			}
		}
		else if(fullclassname.equals(product.getClass().getName()))
		{
			query=session.createQuery(hql+"pk_pro='"+pk+"'");
			List<ProductInfo> list=query.list();
			
			if(list!=null&&list.size()!=0)
			{
				product=list.get(0);
				session.close();
				if(recoverflag==1)
				{
					product.setDr(BigDecimal.ZERO);
					UpdateAction.doUpdate(product);
				}
				else
					DeleteAction.doDel(product);
				return true;
			}
		}
		else if(fullclassname.equals(store.getClass().getName()))
		{
			query=session.createQuery(hql+"pk_store='"+pk+"'");
			List<Stores> list=query.list();
			
			
			if(list!=null&&list.size()!=0)
			{
				store=list.get(0);
				boolean size=store.getProductInfos().isEmpty()&&store.getCheckIns().isEmpty()&&store.getCheckOuts().isEmpty();
				session.close();
				if(recoverflag==1)
				{
					store.setDr(BigDecimal.ZERO);
					UpdateAction.doUpdate(store);
				}
				else 
				{
					if(size)
						DeleteAction.doDel(store);
					else 
						return false;
				}
				return true;
			}
		}
		else if(fullclassname.equals(sysuser.getClass().getName()))
		{
			query=session.createQuery(hql+"pk_userid='"+pk+"'");
			List<SysUser> list=query.list();
			if(list!=null&&list.size()!=0)
			{
				sysuser=list.get(0);
				session.close();
				if(recoverflag==1)
				{
					sysuser.setDr(BigDecimal.ZERO);
					UpdateAction.doUpdate(sysuser);
				}
				else
					DeleteAction.doDel(sysuser);
				return true;
			}
		}
		session.close();
		return false;
	}

}
