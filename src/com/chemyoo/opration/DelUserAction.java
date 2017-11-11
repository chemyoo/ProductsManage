package com.chemyoo.opration;

import java.math.BigDecimal;

import com.chemyoo.action.BaseAction;
import com.chemyoo.action.SaveAction;
import com.chemyoo.action.UpdateAction;
import com.chemyoo.bean.SysLog;
import com.chemyoo.bean.SysUser;
import com.chemyoo.dao.SysUserDao;
import com.chemyoo.defException.BusinessException;
import com.chemyoo.enumclass.OprationStatus;
import com.chemyoo.enumclass.UserRole;
import com.chemyoo.function.GetPkTool;

public class DelUserAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SysUser[] sys;
	private SysLog syslog[];
	private SysUserDao dao=new SysUserDao();
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
		String pks=request.getParameter("pk_id");
		String[] id=pks.split(",");
		if(id.length==0)
			return "fail";
		sys=new SysUser[id.length];
		syslog=new SysLog[id.length];
		for(int i=0;i<id.length;i++)
		{
			sys[i]=dao.findById(id[i]);
			sys[i].setDr(BigDecimal.ONE);
			syslog[i]=new SysLog();
			syslog[i].setOperationContent("删除用户<-"+sys[i].getUserAccount()+"->");
			syslog[i].setDeletepk(id[i]);
			syslog[i].setDelfrom("用户管理");
			syslog[i].setFullclassname(sys[i].getClass().getName());
			syslog[i].setTablename(sys[i].getClass().getSimpleName());
			syslog[i].setPkLogid(GetPkTool.getpk());
			syslog[i].setLoginer(session.get("user").toString());
			syslog[i].setOprationstatus(OprationStatus.Delete.toIntValue());
		}
		try 
		{
			UpdateAction.doUpdate(sys);
			SaveAction.doSave(syslog);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
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
