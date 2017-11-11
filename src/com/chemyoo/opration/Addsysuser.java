package com.chemyoo.opration;

import com.chemyoo.action.BaseAction;
import com.chemyoo.action.SaveAction;
import com.chemyoo.ajax.servlet.AjaxServlet;
import com.chemyoo.bean.SysUser;
import com.chemyoo.dao.SysUserDao;
import com.chemyoo.defException.BusinessException;
import com.chemyoo.enumclass.UserRole;
import com.chemyoo.function.GetPkTool;

public class Addsysuser extends BaseAction{

	public String message="";
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
		String [] answer=request.getParameterValues("answer");
		String [] question=request.getParameterValues("question");
		String useraccount=request.getParameter("username");
		SysUser sysuser=new SysUser();
		sysuser.setUserAccount(useraccount);
		sysuser.setPkUserid(GetPkTool.getpk());
		sysuser.setPassward("000000");
		sysuser.setQuestion1(question[0]);
		sysuser.setQuestion2(question[1]);
		sysuser.setQuestion3(question[2]);
		sysuser.setAnswer1(answer[0]);
		sysuser.setAnswer2(answer[1]);
		sysuser.setAnswer3(answer[2]);
		request.setAttribute("pass", "000000");
		request.setAttribute("name", useraccount);
		try {
			SaveAction.doSave(sysuser);
			AjaxServlet.setList();
			return "success";
		} catch (BusinessException e) {
			return "fail";
		}
	}
	
	

}
