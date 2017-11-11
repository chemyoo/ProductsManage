package com.chemyoo.action.listaction;

import java.util.List;

import com.chemyoo.action.BaseAction;
import com.chemyoo.bean.SysUser;
import com.chemyoo.dao.SysUserDao;
import com.chemyoo.enumclass.UserRole;

public class SysUserListAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SysUserDao sysuserdao=new SysUserDao();
	
	private List<SysUser> sysuserlist;
	
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
		currentPage=page;
		sysuserlist=sysuserdao.findByPage(page-1);
		total=dao.getTotalrow();
		totalPage=dao.getToalpages();
		if(sysuserlist!=null)
			return "success";
		else
			return "fail";
	}

	/**
	 * @return sysuserlist
	 */
	public List<SysUser> getSysuserlist() {
		return sysuserlist;
	}

	/**
	 * @param sysuserlist 要设置的 sysuserlist
	 */
	public void setSysuserlist(List<SysUser> sysuserlist) {
		this.sysuserlist = sysuserlist;
	}
}
