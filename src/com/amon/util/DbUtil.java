package com.amon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年3月28日 上午9:25:46
* 数据库连接工具类
*/
public class DbUtil {
	private static String dbUrl="jdbc:mysql://localhost:3306/db_book";
	private static String userName="root";
	private static String passWord="root";
	private static String jdbcName="com.mysql.jdbc.Driver";
	
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */
	public static Connection getConn() throws Exception  {
		//加载参数指定的类，并且初始化它。
		Class.forName(jdbcName);
		System.out.println("DbUtil-----加载驱动成功");
		Connection connection=DriverManager.getConnection(dbUrl,userName,passWord);
		System.out.println("DbUtil-----获取数据库连接成功");
		return connection;
		
	}
	
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws SQLException
	 */
	public void closeCon(Connection con) throws SQLException{
		if (con!=null) {
			con.close();
		}
		
	}
	
}
