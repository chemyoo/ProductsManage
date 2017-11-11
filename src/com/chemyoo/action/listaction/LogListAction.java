package com.chemyoo.action.listaction;

import java.util.List;

import com.chemyoo.action.BaseAction;
import com.chemyoo.bean.SysLog;
import com.chemyoo.dao.LogDao;

public class LogListAction extends BaseAction {
	private LogDao dao= new LogDao();
	
	private List<SysLog> loglist;
	public String message="数据异常！";
	
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
		currentPage=page;
		loglist=dao.findByPage(page-1);
		total=dao.getTotalrow();
		totalPage=dao.getToalpages();
		if(total==0)
			currentPage=0;
		if(loglist!=null)
			return "success";
		else
			return "message";
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
