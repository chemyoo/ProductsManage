package com.chemyoo.ajax.servlet;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.chemyoo.bean.SysUser;
import com.chemyoo.dao.SysUserDao;
import com.chemyoo.enumclass.UserStatus;

public class LoginCheck {
	private SysUserDao sysdao=new SysUserDao();
	private String account,passwd;
	public String checkresult;
	private String message="";
	
	private int available=1;
	
	
	
	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@SuppressWarnings("static-access")
	private boolean lookupUser(String user,String pass)
	{
		try
		{
			List<SysUser> userlist=sysdao.doLogin(user);
			if(userlist!=null&&userlist.size()!=0)
			{
				if(pass.equals(userlist.get(0).getPassward()))
				{
					if(userlist.get(0).getStatus()==null)
					{
						available=1;
						return false;
					}
					if(UserStatus.Forbidden.toIntValue()==userlist.get(0).getStatus())
					{
						available=0;
						return false;
					}
					return true;
				}
				else
				{
					return false;
				}
			}
			else if("system".equals(user))
			{
				sysdao.createSysUser();
				if("1".equals(passwd))
					return true;
				else 
					return false;
			}
		}
		catch(Exception e)
		{
			GregorianCalendar gc=new GregorianCalendar();
//			Calendar.getInstance().getTime();
			System.out.println(gc.getTime());
			e.printStackTrace();
			message=e.getMessage();
		}
		return false;
	}
	
	public String checkLogin()
	{
		available=-1;
		if(lookupUser(account,passwd))
		{
			this.checkresult = "ok"; 
		}
		else if(available==0)
		{
			this.checkresult = "forbidden";
		}
		else if(available==1)
		{
			this.checkresult = "notavailbe";
		}
		else if(!"".equals(message))
		{
			this.checkresult = "fail";
		}
		else
			this.checkresult = "err";
		
		return "success";
	}
}
