package com.chemyoo.opration;

import java.util.ArrayList;
import java.util.List;

import com.chemyoo.action.BaseAction;
import com.chemyoo.action.SaveAction;
import com.chemyoo.bean.AreaStore;
import com.chemyoo.bean.ProductInfo;
import com.chemyoo.bean.Stores;
import com.chemyoo.dao.AreaDao;
import com.chemyoo.dao.ProductDao;
import com.chemyoo.dao.StoreDao;
import com.chemyoo.defException.BusinessException;
import com.chemyoo.enumclass.ProductProerty;
import com.chemyoo.function.GetPkTool;

@SuppressWarnings("serial")
public class AddProductSave extends BaseAction {

	private static ProductDao dao=new ProductDao();
	private static List<String> listcode=new ArrayList<String>();
	public String message="该商品已存在,无需重新添加！";
    
	static 
	{
		setList();
	}
	public static void setList()
	{
		listcode.clear();
		List<ProductInfo> p=dao.findAll();
		for (int i = 0; i < p.size(); i++) {
			listcode.add(p.get(i).getCodes());
		}
	}
	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		String code=request.getParameter("code");
		String name=request.getParameter("name");
		String select=request.getParameter("select");
		String address=request.getParameter("address");
		String store=request.getParameter("store");
		String num=request.getParameter("num");
		String area=request.getParameter("area");
		String intodate=request.getParameter("intodate").trim();
		if(listcode.contains(code))
		{
			return "message";
		}
		ProductInfo pro=new ProductInfo();
		pro.setPkPro(GetPkTool.getpk());
		pro.setCodes(code);
		pro.setProAddress(address);
		pro.setInstoreDate(intodate);
		pro.setNames(name);
		pro.setProAttribute(ProductProerty.ProductProerty(select));
		pro.setTotalnum(Double.parseDouble(num));
		@SuppressWarnings("static-access")
		AreaStore areastore=new AreaDao().findById(area);
		@SuppressWarnings("static-access")
		Stores stores=new StoreDao().findById(store);
		pro.setAreaStore(areastore);
		pro.setStores(stores);
		try {
			SaveAction.doSave(pro);
			setList();
		} catch (BusinessException e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}

}
