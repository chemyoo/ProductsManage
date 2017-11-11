package com.chemyoo.opration;

import com.chemyoo.action.BaseAction;
import com.chemyoo.action.SaveAction;
import com.chemyoo.ajax.servlet.AjaxServlet;
import com.chemyoo.bean.Stores;
import com.chemyoo.defException.BusinessException;
import com.chemyoo.function.GetPkTool;

public class AddStore extends BaseAction {

	public String message="";
	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		if(name==null||code==null)
		{
			message="操作失败";
			return "message";
		}
		if(!"".equals(name)&&!"".equals(name))
		{
			Stores s=new Stores();
			s.setPkStore(GetPkTool.getpk());
			s.setStorename(name);
			s.setStoreid(code);
			try {
				SaveAction.doSave(s);
				AjaxServlet.setMap();
				return super.execute();
			} catch (BusinessException e) {
				e.printStackTrace();
				message=e.getMessage();
				return "message";
			}
		}
		else
		{
			message="数据异常";
			return "message";
		}
	}

}
