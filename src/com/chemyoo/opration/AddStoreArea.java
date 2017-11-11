package com.chemyoo.opration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chemyoo.action.BaseAction;
import com.chemyoo.action.SaveAction;
import com.chemyoo.bean.AreaStore;
import com.chemyoo.bean.SysLog;
import com.chemyoo.dao.AreaDao;
import com.chemyoo.defException.BusinessException;
import com.chemyoo.enumclass.OprationStatus;
import com.chemyoo.function.GetPkTool;

public class AddStoreArea extends BaseAction{

	private AreaDao dao=new AreaDao();
	String NAME[]={"A区","B区","C区","D区","E区","F区","G区","H区","I区","J区","K区","L区","M区","N区","O区","P区","Q区","R区","S区","T区","U区","V区","W区","X区","Y区","Z区"};
	public String message="分区已达上限，无法再进行增加分区";
	@Override
	public String execute() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		List<AreaStore>  arealist=dao.findAllIncludeDel();
		List<String> listname=new ArrayList<String>();
		List<String> listcode=new ArrayList<String>();
		if(arealist!=null||arealist.size()!=0)
		{
			for(int i=0;i<arealist.size();i++)
			{
				listcode.add(arealist.get(i).getAreacode());
				listname.add(arealist.get(i).getAreaname());
			}
			AreaStore area= new AreaStore();
			area.setAreaid(GetPkTool.getpk());
			int j=-1;
			while(true)
			{
				j++;
				if(j>=NAME.length)
				{
					return "message";
				}
				if(!listname.contains(NAME[j]))
				{
					Date d=new Date();
					String pk;
					while(true)
					{
						SimpleDateFormat format= new SimpleDateFormat("ddHHmmss");
						pk=format.format(d);
						if(!listcode.contains(pk))
						{
							break;
						}
					}
					area.setAreacode(pk);
					area.setAreaname(NAME[j]);
					
					break;
				}
				
				
			}
			try {
				SaveAction.doSave(area);
				SysLog log=new SysLog();
				log.setPkLogid(GetPkTool.getpk());
				log.setOprationstatus(OprationStatus.Insert.toIntValue());
				log.setLoginer("sys");
				log.setOperationContent("新增仓库分区："+area.getAreaname());
			} catch (BusinessException e) {
				e.printStackTrace();
				return "fail";
			}
			return "success";
		}
		return "fail";
	}

}
