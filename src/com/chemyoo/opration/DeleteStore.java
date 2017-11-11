package com.chemyoo.opration;

import java.math.BigDecimal;

import com.chemyoo.action.BaseAction;
import com.chemyoo.action.SaveAction;
import com.chemyoo.action.UpdateAction;
import com.chemyoo.bean.Stores;
import com.chemyoo.bean.SysLog;
import com.chemyoo.dao.StoreDao;
import com.chemyoo.defException.BusinessException;
import com.chemyoo.enumclass.OprationStatus;
import com.chemyoo.function.GetPkTool;

public class DeleteStore extends BaseAction {

	private StoreDao dao=new StoreDao();
	private String message="";
	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		String pk_id=request.getParameter("pk_id");
		String []pk=pk_id.split(",");
		Stores []store=new Stores[pk.length];
		SysLog []log=new SysLog[pk.length];
		for(int i=0;i<pk.length;i++)
		{
			store[i]=dao.findById(pk[i]);
			if(!dao.getIsUsed())
			{
				message+="<tr><td>仓库编码："+store[i].getStoreid()+"</td><td>仓库名称："+store[i].getStorename()+"</td></tr>";
			}
			else
			{
				store[i].setDr(BigDecimal.ONE);
				log[i]=new SysLog();
				log[i].setPkLogid(GetPkTool.getpk());
				log[i].setDeletepk(pk[i]);
				log[i].setDelfrom("仓库管理");
				log[i].setLoginer(session.get("user").toString());
				log[i].setTablename(store[i].getClass().getSimpleName());
				log[i].setOperationContent("删除仓库名为<-"+store[i].getStorename()+"->的数据");
				log[i].setFullclassname(store[i].getClass().getName());
				log[i].setOprationstatus(OprationStatus.Delete.toIntValue());
				try 
				{
					UpdateAction.doUpdate(store[i]);
					SaveAction.doSave(log[i]);
				} catch (BusinessException e) {
					e.printStackTrace();
					return "fail";
				}
			}
			
		}
		if(!"".equals(message))
		{
			this.message="<table>"+message+"<tr><td colspan='2'>数据已被引用，无法删除已被引用的数据！</td></tr></table>";
			return "message";
		}
		return "success";
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
