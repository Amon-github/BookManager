package com.amon.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amon.model.User;

/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年3月28日 下午6:15:30
* 用户DAO
*/
public class UserDao {

	/**
	 * 登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User login(Connection con,String userName,String passWord) throws SQLException{
		User resultUser=null;
		String sql="select * from t_user where userName=? and passWord =?";
		PreparedStatement pres=con.prepareStatement(sql);
		pres.setString(1,userName);	//给第一个？赋值
		pres.setString(2,passWord);	//给第二个？赋值
		ResultSet rs=pres.executeQuery();	//查询数据库，获得返回值
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
