package com.chemyoo.opration;

import com.chemyoo.action.BaseAction;
import com.chemyoo.action.UpdateAction;
import com.chemyoo.bean.SysUser;
import com.chemyoo.dao.SysUserDao;
import com.chemyoo.enumclass.UserRole;

public class Editsysusersuccess extends BaseAction {

	private SysUserDao sysuserdao=new SysUserDao();
	private SysUser sys;
	public String message;
	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		String user=(String) session.get("user");
		SysUserDao dao=new SysUserDao();
		SysUser u=dao.findByUser(user);
		if(u.getUserrole()!=UserRole.Administrator.toIntValue())
		{
			message="权限不足！";
			return "message";
		}
		String pk=request.getParameter("pk");
		String pass=request.getParameter("new_passwd");
		if(pk!=null||!"".equals(pk)||pass!=null||!"".equals(pass))
		{
			sys=sysuserdao.findById(pk);
			sys.setPassward(pass);
			UpdateAction.doUpdate(sys);
			return "success";
		}
		else
			return "fail";
	}
	
	

}
