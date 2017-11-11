package com.chemyoo.opration;

import com.chemyoo.action.BaseAction;
import com.chemyoo.bean.SysUser;
import com.chemyoo.dao.SysUserDao;
import com.chemyoo.enumclass.UserRole;

public class Editsysuser extends BaseAction

{
	private SysUserDao sysuserdao=new SysUserDao();
	private SysUser sys;
	public String message="";

	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		
		String pk=request.getParameter("pk");
		if(pk==null)
		{
			message="错误的请求！";
			return "message";
		}
		String user=(String) session.get("user");
		SysUserDao dao=new SysUserDao();
		SysUser u=dao.findByUser(user);
		if(u.getUserrole()!=UserRole.Administrator.toIntValue())
		{
			message="权限不足！";
			return "message";
		}
		sys=sysuserdao.findById(pk);
		if(sys==null)
		{
			message="界面数据异常,请刷新界面！";
			return "message";
		}
		return "success";
	}

	/**
	 * @return sys
	 */
	public SysUser getSys() {
		return sys;
	}

	/**
	 * @param sys 要设置的 sys
	 */
	public void setSys(SysUser sys) {
		this.sys = sys;
	}
	

}
