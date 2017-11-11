package com.chemyoo.opration;

import java.util.List;

import com.chemyoo.action.BaseAction;
import com.chemyoo.bean.AreaStore;
import com.chemyoo.bean.Stores;
import com.chemyoo.bean.SysUser;
import com.chemyoo.dao.AreaDao;
import com.chemyoo.dao.StoreDao;
import com.chemyoo.dao.SysUserDao;
import com.chemyoo.enumclass.UserRole;

public class AddProductgetData extends BaseAction{
	private AreaDao dao=new AreaDao();
	private List<AreaStore> arealist;
	private StoreDao storesdao=new StoreDao();
	private List<Stores> storelist;
	public String message="数据异常！";
	
	
	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
//		String user=(String) session.get("user");
//		SysUserDao sysdao=new SysUserDao();
//		SysUser u=sysdao.findByUser(user);
//		if(u.getUserrole()!=UserRole.Administrator.toIntValue())
//		{
//			message="权限不足！";
//			return "message";
//		}
		arealist=dao.findAll();
		storelist=storesdao.findAll();
		if(arealist!=null&&storelist!=null)
			return "success";
		else
			return "message";
	}
	
	/**
	 * @return arealist
	 */
	public List<AreaStore> getArealist() {
		return arealist;
	}

	/**
	 * @param arealist 要设置的 arealist
	 */
	public void setArealist(List<AreaStore> arealist) {
		this.arealist = arealist;
	}

	/**
	 * @return storelist
	 */
	public List<Stores> getStorelist() {
		return storelist;
	}

	/**
	 * @param storelist 要设置的 storelist
	 */
	public void setStorelist(List<Stores> storelist) {
		this.storelist = storelist;
	}


}
