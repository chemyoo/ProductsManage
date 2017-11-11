package com.chemyoo.action.listaction;

import java.util.List;

import com.chemyoo.action.BaseAction;
import com.chemyoo.bean.CheckIn;
import com.chemyoo.dao.CheckinDao;

public class CheckinListAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CheckinDao dao=new CheckinDao();
	private List<CheckIn> checklist;
	
	public String message="数据操作异常";
	
	/**
	 * @return checklist
	 */
	public List<CheckIn> getChecklist() {
		return checklist;
	}
	/**
	 * @param checklist 要设置的 checklist
	 */
	public void setChecklist(List<CheckIn> checklist) {
		this.checklist = checklist;
	}
	@Override
	public String execute() throws Exception {
		
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		currentPage=page;
		checklist=dao.findByPage(page-1);
		total=dao.getTotalrow();
		totalPage=dao.getToalpages();
		if(checklist!=null)
			return "success";
		else
			return "message";
	}
}
