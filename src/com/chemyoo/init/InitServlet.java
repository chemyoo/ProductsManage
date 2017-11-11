package com.chemyoo.init;

import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4795379257932429768L;
	private Logger logger = Logger.getLogger(this.getClass());

    public InitServlet(){}

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        String webAppRootKey = context.getInitParameter("webAppRootKey");
        String webRoot = context.getRealPath("/");
        System.setProperty(webAppRootKey,webRoot);
        logger.info("参数初始化，将项目路径设置到系统变量中！");
        logger.info("设置-->"+webAppRootKey+" = "+webRoot);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

  
}
