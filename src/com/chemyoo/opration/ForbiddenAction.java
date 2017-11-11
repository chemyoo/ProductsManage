package com.chemyoo.opration;

import com.chemyoo.action.BaseAction;
import com.chemyoo.action.UpdateAction;
import com.chemyoo.bean.SysUser;
import com.chemyoo.dao.SysUserDao;
import com.chemyoo.enumclass.UserStatus;

public class ForbiddenAction extends BaseAction {

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
			session.clear();
			return "fail";
		}
		String pks=request.getParameter("pk_id");
		if(pks==null)
		{
			message="错误的请求！";
			return message;
		}
		String[] id=pks.split(",");
		if(id.length==0)
			return "fail";
		sys=new SysUser[id.length];
		for(int i=0;i<id.length;i++)
		{
			sys[i]= SysUserDao.findById(id[i]);
			sys[i].setPkUserid(id[i]);
			sys[i].setStatus(UserStatus.Forbidden.toIntValue());
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
