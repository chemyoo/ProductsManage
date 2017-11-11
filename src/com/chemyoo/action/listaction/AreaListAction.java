package com.chemyoo.action.listaction;

import java.util.List;

import com.chemyoo.action.BaseAction;
import com.chemyoo.bean.AreaStore;
import com.chemyoo.dao.AreaDao;

public class AreaListAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AreaDao dao=new AreaDao();
	private List<AreaStore> arealist;

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
		arealist=dao.findByPage(page-1);
		total=dao.getTotalrow();
		if(total==0)
			currentPage=0;
		totalPage=dao.getToalpages();
		if(arealist!=null)
			return "success";
		else
			return "fail";
	}

	/**
	 * @return arealist
	 */
	public List<AreaStore> getArealist() {
		return arealist;
	}

	/**
	 * @param arealist 要设置的 arealist
	 */
	public void setArealist(List<AreaStore> arealist) {
		this.arealist = arealist;
	}
}
