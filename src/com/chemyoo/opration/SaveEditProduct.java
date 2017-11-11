package com.chemyoo.opration;

import com.chemyoo.action.BaseAction;
import com.chemyoo.action.SaveAction;
import com.chemyoo.action.UpdateAction;
import com.chemyoo.bean.AreaStore;
import com.chemyoo.bean.ProductInfo;
import com.chemyoo.bean.Stores;
import com.chemyoo.dao.AreaDao;
import com.chemyoo.dao.ProductDao;
import com.chemyoo.dao.StoreDao;
import com.chemyoo.defException.BusinessException;
import com.chemyoo.enumclass.ProductProerty;

public class SaveEditProduct extends BaseAction {
	private ProductDao dao=new ProductDao();

	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		String pk=request.getParameter("pk");
//		String code=request.getParameter("code");
		String name=request.getParameter("name");
		String Attribute=request.getParameter("Attribute");
		String Address=request.getParameter("Address");
		String store=request.getParameter("store");
		String totalnum=request.getParameter("totalnum");
		String area=request.getParameter("area");
		String intodate=request.getParameter("intodate");
		ProductInfo info =dao.findById(pk);
//		info.setCodes(code);
		info.setNames(name);
//		String num="".equals(totalnum)?"0":totalnum;
		info.setProAttribute(ProductProerty.ProductProerty(Attribute));
		
		info.setTotalnum(Double.parseDouble("".equals(totalnum)?"0":totalnum));
		info.setInstoreDate(intodate);
		@SuppressWarnings("static-access")
		AreaStore areastore=new AreaDao().findById(area);
		@SuppressWarnings("static-access")
		Stores stores=new StoreDao().findById(store);
		info.setAreaStore(areastore);
		info.setStores(stores);
		UpdateAction.doUpdate(info);
		
		return "success";
	}
	
}
