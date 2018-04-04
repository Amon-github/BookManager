package com.amon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.amon.manager.view.LogOnFrm;

/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年4月3日 下午3:41:36
* 类说明
*/
public class BookManagerMain {

	public static void main(String[] args) {
		new DbUtil().buildUpDb();	//创建数据库和数据表
		//打开登录界面
		LogOnFrm logOnFrm=new LogOnFrm();
		logOnFrm.setVisible(true);

	}
}
