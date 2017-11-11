package com.chemyoo.action.listaction;

import java.util.List;
import com.chemyoo.action.BaseAction;
import com.chemyoo.bean.ProductInfo;
import com.chemyoo.dao.ProductDao;

public class ProductListAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProductDao productdao=new ProductDao();
	
	private List<ProductInfo> productlist;
	
	
	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		productlist=productdao.findByPage(page-1);
		currentPage=page;
		total=productdao.getTotalrow();
		totalPage=productdao.getToalpages();
		if(productlist!=null)
			return "success";
		else
			return "fail";
	}

	/**
	 * @return productlist
	 */
	public List<ProductInfo> getProductlist() {
		return productlist;
	}

	/**
	 * @param productlist 要设置的 productlist
	 */
	public void setProductlist(List<ProductInfo> productlist) {
		this.productlist = productlist;
	}

}
