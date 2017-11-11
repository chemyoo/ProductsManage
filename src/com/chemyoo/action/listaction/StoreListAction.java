package com.chemyoo.action.listaction;

import java.util.List;

import com.chemyoo.action.BaseAction;
import com.chemyoo.bean.Stores;
import com.chemyoo.dao.StoreDao;

public class StoreListAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StoreDao storesdao=new StoreDao();
	private List<Stores> storelist;
	

	/**
	 * @return storelist
	 */
	public List<Stores> getStorelist() {
		return storelist;
	}

	/**
	 * @param storelist 要设置的 storelist
	 */
	public void setStorelist(List<Stores> storelist) {
		this.storelist = storelist;
	}

	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		storelist=storesdao.findByPage(page-1);
		currentPage=page;
		total=storesdao.getTotalrow();
		totalPage=storesdao.getToalpages();
		if(storelist!=null)
			return "success";
		else
			return "fail";
	}

}
