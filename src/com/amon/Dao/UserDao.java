package com.amon.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amon.model.User;

/**
* @author Amon E-mail:248779716@qq.com
* @version ����ʱ�䣺2018��3��28�� ����6:15:30
* �û�DAO
*/
public class UserDao {

	/**
	 * ��¼��֤
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User login(Connection con,String userName,String passWord) throws SQLException{
		User resultUser=null;
		String sql="select * from t_user where userName=? and passWord =?";
		PreparedStatement pres=con.prepareStatement(sql);
		pres.setString(1,userName);	//����һ������ֵ
		pres.setString(2,passWord);	//���ڶ�������ֵ
		ResultSet rs=pres.executeQuery();	//��ѯ���ݿ⣬��÷���ֵ
		if (rs.next()) {
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassWord(rs.getString("password"));
			resultUser.setUserType(rs.getInt("usertype"));
		}
		return resultUser;
		
		
	}
}
