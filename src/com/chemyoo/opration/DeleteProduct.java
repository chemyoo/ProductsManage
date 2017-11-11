package com.chemyoo.opration;

import java.math.BigDecimal;

import com.chemyoo.action.BaseAction;
import com.chemyoo.action.SaveAction;
import com.chemyoo.action.UpdateAction;
import com.chemyoo.bean.ProductInfo;
import com.chemyoo.bean.SysLog;
import com.chemyoo.dao.ProductDao;
import com.chemyoo.defException.BusinessException;
import com.chemyoo.enumclass.OprationStatus;
import com.chemyoo.function.GetPkTool;

@SuppressWarnings("serial")
public class DeleteProduct extends BaseAction {

	private ProductDao dao=new ProductDao();
	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		String pk_id=request.getParameter("pk_id");
		String []pk=pk_id.split(",");
		ProductInfo[] pro=new ProductInfo[pk.length];	
		SysLog []log=new SysLog[pk.length];
		for(int i=0;i<pk.length;i++)
		{
			pro[i]=dao.findById(pk[i]);
			pro[i].setDr(BigDecimal.ONE);
			log[i]=new SysLog();
			log[i].setPkLogid(GetPkTool.getpk());
			log[i].setLoginer((String) session.get("user"));
			log[i].setDelfrom("商品管理");
			log[i].setDeletepk(pk[i]);
			log[i].setFullclassname(pro[i].getClass().getName());
			log[i].setTablename(pro[i].getClass().getSimpleName());
			log[i].setOprationstatus(OprationStatus.Delete.toIntValue());
			log[i].setOperationContent("商品"+pro[i].getNames()+"被删除!");
		}
		
		try 
		{
			UpdateAction.doUpdate(pro);
			SaveAction.doSave(log);
		} catch (BusinessException e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}

}
