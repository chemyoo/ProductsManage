package com.chemyoo.opration;

import java.util.List;

import com.chemyoo.action.BaseAction;
import com.chemyoo.bean.AreaStore;
import com.chemyoo.bean.ProductInfo;
import com.chemyoo.bean.Stores;
import com.chemyoo.dao.AreaDao;
import com.chemyoo.dao.ProductDao;
import com.chemyoo.dao.StoreDao;

@SuppressWarnings("serial")
public class EditProduct extends BaseAction {

	private ProductDao dao=new ProductDao();
	private ProductInfo product;
	private AreaDao areadao=new AreaDao();
	private List<AreaStore> arealist;
	private StoreDao storesdao=new StoreDao();
	private List<Stores> storelist;
	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		String pk=request.getParameter("pk");
		product=dao.findById(pk);
		arealist=areadao.findAll();
		storelist=storesdao.findAll();
		if(product!=null&&arealist!=null&&storelist!=null)
			return "success";
		else
			return "fail";
	}
	public ProductInfo getProduct() {
		return product;
	}
	public void setProduct(ProductInfo product) {
		this.product = product;
	}
	public List<AreaStore> getArealist() {
		return arealist;
	}
	public void setArealist(List<AreaStore> arealist) {
		this.arealist = arealist;
	}
	public List<Stores> getStorelist() {
		return storelist;
	}
	public void setStorelist(List<Stores> storelist) {
		this.storelist = storelist;
	}

}
