package com.chemyoo.opration;

import com.chemyoo.action.BaseAction;
import com.chemyoo.action.DeleteAction;
import com.chemyoo.bean.SysLog;
import com.chemyoo.dao.LogDao;

@SuppressWarnings("serial")
public class Undodel extends BaseAction {

	private LogDao dao=new LogDao();
	private RecoverData recover= new RecoverData();
	/* （非 Javadoc）
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		String pk_id=request.getParameter("pk_id");
		String []pk=pk_id.split(",");
		SysLog []log=new SysLog[pk.length];
		boolean flag;
		int num=0;
		for(int i=0;i<pk.length;i++)
		{
			log[i]=dao.findByIdDel(pk[i]);
			flag=recover.recoverData(log[i].getDeletepk(), log[i].getTablename(), log[i].getFullclassname(),1);
			if(flag)
			{
				DeleteAction.doDel(log[i]);
				num++;
			}
		}
		if(num<pk.length)
		{
			System.out.println((pk.length-num)+"条还原失败");
			return "fail";
		}
		return "success";
	}

}
