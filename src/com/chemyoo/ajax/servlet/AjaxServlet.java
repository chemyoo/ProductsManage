package com.chemyoo.ajax.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chemyoo.bean.Stores;
import com.chemyoo.bean.SysUser;
import com.chemyoo.dao.StoreDao;
import com.chemyoo.dao.SysUserDao;

public class AjaxServlet 
{

	private String name;
	private String code;
	private String username;
	
	public String checkresult;
    public static Map<Integer,String> storecode =new HashMap<Integer,String>();
    public static Map<Integer,String> storename =new HashMap<Integer,String>();
    public static List<String> useraccount =new ArrayList <String>();
    
    static 
    {
    	setMap();
    	setList();
    }
    /**
     * 初始化
     * 如果仓库被添加且被保存，就调用此方法，重置map;
     */
    public static void setMap()
    {
    	storecode.clear();
    	storename.clear();
    	StoreDao dao=new StoreDao();
    	List<Stores> storelist;
    	storelist=dao.findAll();
    	if(storelist!=null&&storelist.size()!=0)
    	{
	    	for(int i=0;i<storelist.size();i++)
	    	{
	    		storename.put(i, storelist.get(i).getStorename().toLowerCase());
	    		storecode.put(i, storelist.get(i).getStoreid().toLowerCase());
	    	}
    	}
    }
    public static void setList()
    {
    	useraccount.clear();
    	SysUserDao dao=new SysUserDao();
    	List<SysUser> sysuser=dao.findAll();
    	if(sysuser!=null&&sysuser.size()!=0)
    	{
    		for (int i = 0; i < sysuser.size(); i++) 
    		{
    			useraccount.add(sysuser.get(i).getUserAccount().toLowerCase());
			}
    	}
    }
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
    public String getcheckresult() {/*名字要一致，用于返回数据*/
        return this.checkresult;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
    
    public String checkName(){
        /*userservice的具体方法根据自己的项目设置定义，这已经与ajax无关了*/ 
    	if(storename.containsValue(name.toLowerCase()))
        {
    		this.checkresult = "err";/*最终要返回的值，浏览器自动获取*/
        }
        else 
        {
            this.checkresult = "ok";
        }
    
        return "success";
    }
    public String checkCode(){
        /*userservice的具体方法根据自己的项目设置定义，这已经与ajax无关了*/ 
    	if(storecode.containsValue(code.toLowerCase()))
        {
    		this.checkresult = "err";/*最终要返回的值，浏览器自动获取*/
        }
        else 
        {
            this.checkresult = "ok";
        }
    
        return "success";
    }
    public String checkAccount(){
        /*userservice的具体方法根据自己的项目设置定义，这已经与ajax无关了*/ 
    	
    	if(!username.matches("^[0-9a-zA-Z]*$"))
    		this.checkresult = "errinput";
    	else if(useraccount.contains(username.toLowerCase()))
        {
    		this.checkresult = "err";/*最终要返回的值，浏览器自动获取*/
        }
        else 
        {
            this.checkresult = "ok";
        }
    
        return "success";
    }
}
