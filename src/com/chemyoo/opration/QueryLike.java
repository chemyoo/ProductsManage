package com.chemyoo.opration;

import java.util.List;

import com.chemyoo.bean.ProductInfo;
import com.chemyoo.dao.ProductDao;
import com.chemyoo.enumclass.ProductProerty;

public class QueryLike {
	
	private String name;
	
	
	public String checkresult;
	
	
	
	
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	private ProductDao dao=new ProductDao();
	
	public String returnData ()
	{
		checkresult="";
		List<ProductInfo> list=dao.queryLike(name);
		if(list!=null&&list.size()!=0)
		{
			for(int i=0;i<list.size();i++)
			{
				ProductInfo pro=list.get(i);
				checkresult+=pro.getCodes()+","+pro.getNames()+","+ProductProerty.getProertyName(pro.getProAttribute()+"")+","+
						pro.getProAddress()+","+pro.getStores().getStorename()+","+pro.getAreaStore().getAreaname()+
						","+pro.getPkPro()+","+pro.getTotalnum()+";";//返回查询结果
			}
		}
		else 
			checkresult="ZERO";
		
		return "success";
	}
	

}
