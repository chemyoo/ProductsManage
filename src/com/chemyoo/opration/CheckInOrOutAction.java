package com.chemyoo.opration;


import java.math.BigDecimal;
import java.util.List;

import com.chemyoo.action.BaseAction;
import com.chemyoo.action.SaveAction;
import com.chemyoo.action.UpdateAction;
import com.chemyoo.bean.CheckIn;
import com.chemyoo.bean.CheckOut;
import com.chemyoo.bean.ProductInfo;
import com.chemyoo.dao.CheckinDao;
import com.chemyoo.dao.CheckoutDao;
import com.chemyoo.dao.ProductDao;
import com.chemyoo.defException.BusinessException;
import com.chemyoo.enumclass.ProductStatus;
import com.chemyoo.function.GetPkTool;

@SuppressWarnings("serial")
public class CheckInOrOutAction extends BaseAction{

	private ProductDao dao =new ProductDao();
	public String message="";
	
	public List<CheckOut> outlist;
	public List<CheckIn> inlist;
	
	private int page = 1;
	public long total=0;
	public long totalPage=0;  //总页数
	public long currentPage=0;  //当前页

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public String AddCheckIn()
	{
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		else
			return "success";
	}
	public String Exit()
	{
		session.clear();
		return "success";
	}
	public String AddCheckOut()
	{
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		else
			return "success";
	}

	
	public String saveCheckin() throws Exception {
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		else
		{
			String pk=request.getParameter("pk");
//			String proname=request.getParameter("proname");
//			String procode=request.getParameter("procode");
//			String procode=request.getParameter("procode");
//			String procode=request.getParameter("procode");
//			String procode=request.getParameter("procode");
			String intodate=request.getParameter("intodate");
			String num=request.getParameter("num");
			
			ProductInfo pro=dao.findById(pk);
			CheckIn check=new CheckIn();
			check.setPkCheck(GetPkTool.getpk());
			check.setCodes(pro.getCodes());
			check.setNames(pro.getNames());
			check.setAreaStore(pro.getAreaStore());
			check.setCheckinNum(Double.parseDouble(num));
			check.setStores(pro.getStores());
			check.setInstoreDate(intodate);
			check.setStatus(ProductStatus.NoOut.toIntValue());
			check.setProAttribute(pro.getProAttribute());
			check.setProAddress(pro.getProAddress());
			try {
				SaveAction.doSave(check);
			} catch (BusinessException e) {
				message=e.getMessage();
				e.printStackTrace();
				return "message";
			}
			return "success";
		}
	}
	
	public String saveCheckout()
	{
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		else
		{
			String pk=request.getParameter("pk");
//			String proname=request.getParameter("proname");
//			String procode=request.getParameter("procode");
//			String procode=request.getParameter("procode");
//			String procode=request.getParameter("procode");
//			String procode=request.getParameter("procode");
			String intodate=request.getParameter("intodate");
			String num=request.getParameter("num");
			
			ProductInfo pro=dao.findById(pk);
			CheckOut check=new CheckOut();
			check.setPkOut(GetPkTool.getpk());
			check.setCodes(pro.getCodes());
			check.setNames(pro.getNames());
			check.setAreaStore(pro.getAreaStore());
			check.setCheckoutNum(Double.parseDouble(num));
			check.setStores(pro.getStores());
			check.setOutstoreDate(intodate);
			check.setStatus(ProductStatus.NoOut.toIntValue());
			check.setProAttribute(pro.getProAttribute());
			check.setProAddress(pro.getProAddress());
			try {
				SaveAction.doSave(check);
			} catch (BusinessException e) {
				message=e.getMessage();
				e.printStackTrace();
				return "message";
			}
			return "success";
		}
	}
	public String checkinSure()
	{
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		try
		{
			String pk=request.getParameter("pk");
			
			CheckinDao indao=new CheckinDao();
			CheckIn check=indao.findById(pk);
			ProductInfo pro=dao.findByCode(check.getCodes());
			pro.setTotalnum(pro.getTotalnum()+check.getCheckinNum());
			pro.setInstoreDate(check.getInstoreDate());
			
			check.setDr(BigDecimal.ONE);
	//		check.setStatus(ProductStatus.NoOut)
			UpdateAction.doUpdate(pro);
			UpdateAction.doUpdate(check);
		}catch(Exception e)
		{
			message=e.getMessage();
			return "message";
		}
		return "success";
		
	}
	public String checkoutSure()
	{
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		try
		{
			String pk=request.getParameter("pk");
			CheckoutDao outdao=new CheckoutDao();
			CheckOut check=outdao.findById(pk);
			ProductInfo pro=dao.findByCode(check.getCodes());
			pro.setTotalnum(pro.getTotalnum()-check.getCheckoutNum());
			pro.setOutstoreDate(check.getInstoreDate());
			
			check.setDr(BigDecimal.ONE);
	//		check.setStatus(ProductStatus.NoOut)
			UpdateAction.doUpdate(pro);
			UpdateAction.doUpdate(check);
		}catch(Exception e)
		{
			message=e.getMessage();
			return "message";
		}
		return "success";
		
	}
	public String outHistory()
	{
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		CheckoutDao outdao=new CheckoutDao();
		outlist=outdao.findHistory(page-1);
		currentPage=page;
		total=dao.getTotalrow();
		totalPage=dao.getToalpages();
		if(outlist!=null)
			return "success";
		else
		{	
			message="操作异常！";
			return "message";
		}
		
	}
	public String inHistory()
	{
		if(session.isEmpty())
		{
			session.clear();
			return "fail";
		}
		CheckinDao indao=new CheckinDao();
		inlist=indao.findHistory(page-1);
		currentPage=page;
		total=dao.getTotalrow();
		totalPage=dao.getToalpages();
		if(inlist!=null)
			return "success";
		else
		{	
			message="操作异常！";
			return "message";
		}
		
	}

}
