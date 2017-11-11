package com.chemyoo.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
/**
 * 自动从JavaBean的映射文件生成数据库表
 * @author Administrator
 * @time 2015-12-08
 */
public class ExportDB {

	public static void main(String[] args) {
		
		//读取hibernate.cfg.xml文件
		Configuration cfg = new Configuration().configure();
		//读取hibernate.cfg.xml文件中的<mapping resource="*/*/..." />
		SchemaExport export = new SchemaExport(cfg);
		//开始创建表，先删除后创建
		export.create(true, true);
	}
}
