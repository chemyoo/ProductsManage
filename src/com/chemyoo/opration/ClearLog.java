package com.chemyoo.opration;

import com.chemyoo.action.BaseAction;
import com.chemyoo.action.DeleteAction;
import com.chemyoo.bean.SysLog;
import com.chemyoo.dao.LogDao;

@SuppressWarnings("serial")
public class ClearLog extends BaseAction {

	private LogDao dao=new LogDao();
	private RecoverData recover= new RecoverData();
	public String message;
	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
			
		try
		{
			String pk_id=request.getParameter("pk_id");
			String []pk=pk_id.split(",");
			SysLog []log=new SysLog[pk.length];
			for(int i=0;i<pk.length;i++)
			{
				log[i]=dao.findByIdDel(pk[i]);
				recover.recoverData(log[i].getDeletepk(), log[i].getTablename(), log[i].getFullclassname(),2);
				
				DeleteAction.doDel(log[i]);
				
			}
		}
		catch(Exception e)
		{
			message=e.getMessage();
		}
		return "success";
	}

}
