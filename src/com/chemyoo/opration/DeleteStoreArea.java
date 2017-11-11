package com.chemyoo.opration;

import java.math.BigDecimal;

import com.chemyoo.action.BaseAction;
import com.chemyoo.action.SaveAction;
import com.chemyoo.action.UpdateAction;
import com.chemyoo.bean.AreaStore;
import com.chemyoo.bean.SysLog;
import com.chemyoo.dao.AreaDao;
import com.chemyoo.defException.BusinessException;
import com.chemyoo.enumclass.OprationStatus;
import com.chemyoo.function.GetPkTool;

public class DeleteStoreArea extends BaseAction {
	
	private AreaDao dao=new AreaDao();
	
	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		String pk_id=request.getParameter("pk_id");
		String []pk=pk_id.split(",");
		AreaStore []area=new AreaStore[pk.length];
		SysLog []log=new SysLog[pk.length];
		for(int i=0;i<pk.length;i++)
		{
			area[i]=dao.findById(pk[i]);
			area[i].setDr(BigDecimal.ONE);
			log[i]=new SysLog();
			log[i].setPkLogid(GetPkTool.getpk());
			log[i].setDeletepk(pk[i]);
			log[i].setDelfrom("仓库分区管理");
			log[i].setLoginer(session.get("user").toString());
			log[i].setTablename(area[i].getClass().getSimpleName());
			log[i].setOperationContent("删除仓库分区:<-"+area[i].getAreaname()+"->的数据");
			log[i].setFullclassname(area[i].getClass().getName());
			log[i].setOprationstatus(OprationStatus.Delete.toIntValue());
		}
		try 
		{
			UpdateAction.doUpdate(area);
			SaveAction.doSave(log);
			return "success";
		} catch (BusinessException e) {
			e.printStackTrace();
			return "fail";
		}
		
	}

}
