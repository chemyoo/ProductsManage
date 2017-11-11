package com.chemyoo.action;

import java.util.List;

import com.chemyoo.bean.SysUser;
import com.chemyoo.dao.SysUserDao;

public class LoginAction extends BaseAction {
	
	public String message="";
	@Override
	public String execute() throws Exception {
		String useraccount=request.getParameter("account");
		String pass=request.getParameter("passwd");
		if(useraccount==null||pass==null)
		{
			session.clear();
			return "fail";
		}
		if(!session.isEmpty()&&!session.containsKey(useraccount))
			session.clear();
		else if(!session.isEmpty())
		{
//			session.clear();
			return "success";
		}
		if(!"".equals(useraccount)&&!"".equals(pass))
		{
			session.put(useraccount, pass);
			session.put("user", useraccount);
			return "success";
		}
		return "fail";
//		List<SysUser>syslist=sysdao.doLogin(useraccount);
		/*if(syslist!=null&&syslist.size()!=0)
		{
			if(pass.equals(syslist.get(0).getPassward()))
			{
				session.put(useraccount, pass);
				return "success";
			}
			else
			{
				message="帐号或密码错误";
				return "fail";
			}
		}
		else
		{
			message="帐号或密码错误";
			return "fail";
		}*/
	}
}
