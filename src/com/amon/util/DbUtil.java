package com.amon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
* @author Amon E-mail:248779716@qq.com
* @version ����ʱ�䣺2018��3��28�� ����9:25:46
* ���ݿ����ӹ�����
*/
public class DbUtil {
	private static String dbUrl="jdbc:mysql://localhost:3306/db_book";
	private static String userName="root";
	private static String passWord="root";
	private static String jdbcName="com.mysql.jdbc.Driver";
	
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */
	public static Connection getConn() throws Exception  {
		//���ز���ָ�����࣬���ҳ�ʼ������
		Class.forName(jdbcName);
		System.out.println("DbUtil-----���������ɹ�");
		Connection connection=DriverManager.getConnection(dbUrl,userName,passWord);
		System.out.println("DbUtil-----��ȡ���ݿ����ӳɹ�");
		return connection;
		
	}
	
	/**
	 * �ر����ݿ�����
	 * @param con
	 * @throws SQLException
	 */
	public void closeCon(Connection con) throws SQLException{
		if (con!=null) {
			con.close();
		}
		
	}
	
}
