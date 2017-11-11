package com.chemyoo.action.listaction;

import java.util.List;

import com.chemyoo.action.BaseAction;
import com.chemyoo.bean.CheckOut;
import com.chemyoo.dao.CheckoutDao;

public class CheckoutListAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -648784253473760805L;
	private CheckoutDao dao =new CheckoutDao();
	private List<CheckOut> checkoutlist;
	
	
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
		checkoutlist=dao.findByPage(page-1);
		total=dao.getTotalrow();
		totalPage=dao.getToalpages();
		if(checkoutlist!=null)
			return "success";
		else
			return "message";
	}


	public List<CheckOut> getCheckoutlist() {
		return checkoutlist;
	}


	public void setCheckoutlist(List<CheckOut> checkoutlist) {
		this.checkoutlist = checkoutlist;
	}
	

}
