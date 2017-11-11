package com.chemyoo.loginfilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chemyoo.bean.SysUser;
 
 
public class LoginFilter implements Filter {
 

	    public LoginFilter() {
	     
	
	     }
	 
		public void destroy() {
		 
		}
 

		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
		{
		 
			HttpServletRequest req=(HttpServletRequest) request;
			 
			HttpServletResponse res=(HttpServletResponse) response;
			 
			//获得请求的URL
			 
			String url=req.getRequestURL().toString();
		
		
			//获得session中的对象
			 
			HttpSession session= req.getSession();
			 
			SysUser user=(SysUser) session.getAttribute("user");
		 
			//使用endsWith()判断url结尾的字符串
			 
			
			if(user!=null||url.endsWith("ProductsManage/")||url.endsWith(".jsp")|| 
					url.endsWith(".css") || url.endsWith(".js")|| url.endsWith(".gif")|| 
					url.endsWith(".png")|| url.endsWith(".jpg")|| url.endsWith(".ico"))
			{
//				//满足条件就继续执行
//				if(url.endsWith("/Addsys_user.htm")||url.contains("/edituser.action?pk="))
//				{
//					if(user.getUserrole()==BigDecimal.ZERO)
//						chain.doFilter(request, response);
//					else
//						;//无权访问
//				}
//				else 
					chain.doFilter(request, response);
			 
			}
			else
			{
		 
				//不满足条件就跳转到其他页面
				 
//				PrintWriter out=res.getWriter();
//				 
//				out.print("<script language>top.location.href='/ProductsManage'</script>");
				 //
				 res.sendRedirect("/ProductsManage/"); 
			}
		 
		
		}
		 
		
		/**
		 
		* @see Filter#init(FilterConfig)
		 
		*/
		 
		public void init(FilterConfig fConfig) throws ServletException {
		 
		 
		}

}
 