package com.amon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.amon.manager.Dao.UserDao;
import com.amon.model.User;

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
	 * 创建数据库和数据表
	 * @return
	 */
	public static Connection buildUpDb(){
		 Connection conn=null;
		 try {
				Class.forName("com.mysql.jdbc.Driver");

			    //一开始必须填一个已经存在的数据库 
			    String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";   
			    conn = DriverManager.getConnection(url, "root", "root"); 
			    Statement stat = conn.createStatement(); 
			      
			    //创建数据库db_book
			    stat.executeUpdate("create database if not exists db_book"); 
			      
			    //打开创建的数据库 
			    stat.close(); 
			    conn.close(); 
			    url = "jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf-8"; 
			    conn = DriverManager.getConnection(url, "root", "root"); 
			    stat = conn.createStatement(); 
			      
			    //创建表
			    stat.executeUpdate("CREATE TABLE if not exists `t_book` (`id` int(11) NOT NULL AUTO_INCREMENT,`bookName` varchar(255) DEFAULT NULL,`author` varchar(255) DEFAULT NULL,`sex` varchar(255) DEFAULT NULL,`price` decimal(10,0) DEFAULT NULL,`bookTypeId` int(11) DEFAULT NULL,`bookDesc` varchar(255) DEFAULT NULL,PRIMARY KEY (`id`),KEY `bookTypeid` (`bookTypeId`)) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8"); 
			    stat.executeUpdate("CREATE TABLE if not exists `t_booktype` (`id` int(11) NOT NULL AUTO_INCREMENT,`bookTypeName` varchar(255) DEFAULT NULL,`bookTypeDesc` varchar(255) DEFAULT NULL,PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8");
			    stat.executeUpdate("CREATE TABLE if not exists `t_user` (`id` int(11) NOT NULL AUTO_INCREMENT,`userName` varchar(25) DEFAULT NULL,`password` varchar(25) DEFAULT NULL,`usertype` int(11) DEFAULT '2',PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8");
			    stat.executeUpdate("CREATE TABLE if not exists `t_lend` (  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '该条数据id',  `bookid` int(11) DEFAULT NULL COMMENT '图书id',  `cardid` varchar(11) DEFAULT NULL COMMENT '借书卡账号',  `borrowdate` varchar(255) DEFAULT NULL COMMENT '借书日期',  `lendcount` int(11) DEFAULT NULL,  `managerid` int(11) DEFAULT NULL COMMENT '处理者账号(管理员账号)',  `returndate` varchar(255) DEFAULT NULL COMMENT '还书日期',  PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8");
			    
			    UserDao userDao=new UserDao();
			    User user=new User(1);
			    String result=userDao.selectUserByID(conn, user);
			    if ("获取用户ID出错".equals(result)) {
			    	 stat.executeUpdate("INSERT INTO `t_user` VALUES ('1', 'admin', 'admin', '1')");
				}
			   } catch (Exception e) {
					System.out.println("创建数据库异常");
					e.printStackTrace();
				}finally {
					try {
						new DbUtil().closeCon(conn);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
		return null;
	}
	
	
	
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
	public static void closeCon(Connection con) throws SQLException{
		if (con!=null) {
			con.close();
		}
		
	}
	
}
