package com.chemyoo.opration;

import com.chemyoo.action.BaseAction;
import com.chemyoo.action.UpdateAction;
import com.chemyoo.bean.SysUser;
import com.chemyoo.dao.SysUserDao;
import com.chemyoo.enumclass.UserStatus;

public class AvailableAction extends BaseAction {

	/**
	 * 
	 */
private static final long serialVersionUID = 1L;
	
	private SysUser[] sys;
	public String message;
	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			return "fail";
		}
		String pks=request.getParameter("pk_id");
		if(pks==null)
		{
			message="请求错误，从前台传来一个空的参数";
			return "message";
		}
		else if("".equals(pks))
		{
			message="请求错误，从前台传来一个空的参数";
			return "message";
		}
		String[] id=pks.split(",");
		sys=new SysUser[id.length];
		for(int i=0;i<id.length;i++)
		{
			sys[i]= SysUserDao.findById(id[i]);
			sys[i].setPkUserid(id[i]);
			sys[i].setStatus(UserStatus.Available.toIntValue());
		}
		UpdateAction.doUpdate(sys);
		return "success";
		
	}
	/**
	 * @return sys
	 */
	public SysUser[] getSys() {
		return sys;
	}
	/**
	 * @param sys 要设置的 sys
	 */
	public void setSys(SysUser[] sys) {
		this.sys = sys;
	}


}
