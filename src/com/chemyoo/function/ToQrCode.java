package com.chemyoo.function;



import com.chemyoo.action.BaseAction;
import com.chemyoo.action.UpdateAction;
import com.chemyoo.bean.ProductInfo;
import com.chemyoo.dao.ProductDao;
import com.chemyoo.enumclass.ProductProerty;
import com.chemyoo.qrcode.tools.QrTool;

@SuppressWarnings("serial")
public class ToQrCode extends BaseAction{
	
	private ProductDao dao=new ProductDao();
	
	String message="商品不存在,请刷新界面！";

	@SuppressWarnings("deprecation")
	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		String pk=request.getParameter("pk");
		//String ctx = request.getContextPath();
		String realpath = request.getRealPath("");
		String text="";
		ProductInfo proinfo=dao.findById(pk);
		if(proinfo!=null)
		{
			text+="商品编码:"+proinfo.getCodes();
			text+="\n商品名称:"+proinfo.getNames();
			text+="\n商品属性:"+ProductProerty.getProertyName(proinfo.getProAttribute().toString());
			text+="\n生成地址:"+proinfo.getProAddress();
			text+="\n仓库:"+proinfo.getStores().getStorename();
			text+="\n仓库区域:"+proinfo.getAreaStore().getAreaname();
			text+="\n库存量:"+proinfo.getTotalnum();
			text+="\n入库日期:"+proinfo.getInstoreDate().trim();
			String dir=QrTool.transToQrcode(text, pk, realpath);
			proinfo.setQrCode(dir.replace(realpath+"\\", ""));
			UpdateAction.doUpdate(proinfo);
			return super.execute();
		}
		
		return "message";
	}
	


}
