package com.chemyoo.opration;

import java.util.List;

import com.chemyoo.action.BaseAction;
import com.chemyoo.bean.SysLog;
import com.chemyoo.dao.LogDao;

public class RecycalbinPage extends BaseAction {
	private LogDao dao= new LogDao();
	
	private List<SysLog> loglist;
	

	/* （非 Javadoc）
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		loglist=dao.findAllDel(page-1);
		currentPage=page;
		total=dao.getTotalrow();
		totalPage=dao.getToalpages();
		if(loglist!=null)
			return "success";
		else
			return "fail";
	}

	/**
	 * @return loglist
	 */
	public List<SysLog> getLoglist() {
		return loglist;
	}

	/**
	 * @param loglist 要设置的 loglist
	 */
	public void setLoglist(List<SysLog> loglist) {
		this.loglist = loglist;
	}

}


