package com.amon.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amon.model.User;
import com.amon.util.DbUtil;
import com.amon.util.StringUtil;

/**
 * @author Amon E-mail:248779716@qq.com
 * @version 创建时间：2018年3月28日 下午6:15:30 用户DAO
 */
public class UserDao {

	/**
	 * 登录验证
	 * 
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User login(Connection con, String userName, String passWord,int type) throws SQLException {
		User resultUser = null;
		String sql = "select * from t_user where userName=? and passWord =?";
		PreparedStatement pres = con.prepareStatement(sql);
		pres.setString(1, userName); // 给第一个？赋值
		pres.setString(2, passWord); // 给第二个？赋值
		ResultSet rs = pres.executeQuery(); // 查询数据库，获得返回值
		if (rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassWord(rs.getString("password"));
			resultUser.setUserType(rs.getInt("usertype"));
		}
		return resultUser;
	}

	/**
	 * 用ID查找用户
	 * 
	 * @param con
	 * @param userName
	 * @param passWord
	 * @return
	 * @throws SQLException
	 */
	public String selectUserByID(Connection con, User user) throws SQLException {
		User resultUser = null;
		String pwd = "获取用户ID出错";
		String sql = "select * from t_user where id=?";
		PreparedStatement pres = con.prepareStatement(sql);
		pres.setInt(1, user.getId()); // 给第一个？赋值
		ResultSet rs = pres.executeQuery(); // 查询数据库，获得返回值
		while (rs.next()) {
			pwd = rs.getString("password");
		}
		return pwd;
	}
	/**
	 * 用ID查找用户2
	 * 
	 * @param con
	 * @param userName
	 * @param passWord
	 * @return
	 * @throws SQLException
	 */
	public ResultSet selectUserByID2(Connection con, User user) throws SQLException {
		String sql = "select * from t_user where id=?";
		PreparedStatement pres = con.prepareStatement(sql);
		pres.setInt(1, user.getId()); // 给第一个？赋值
		ResultSet rs = pres.executeQuery(); // 查询数据库，获得返回值
		return rs;
	}

	/**
	 * 用用户名查找用户
	 * 
	 * @param con
	 * @param userName
	 * @param passWord
	 * @return
	 * @throws SQLException
	 */
	public String selectUserByName(Connection con, User user) throws SQLException {
		User resultUser = null;
		String pwd = "获取用户名字出错";
		String sql = "select * from t_user where userName=?";
		PreparedStatement pres = con.prepareStatement(sql);
		pres.setString(1, user.getUserName());
		; // 给第一个？赋值
		ResultSet rs = pres.executeQuery(); // 查询数据库，获得返回值
		while (rs.next()) {
			pwd = rs.getString("password");
		}
		return pwd;
	}

	/**
	 * 用用户类型查找用户
	 * 
	 * @param con
	 * @param userName
	 * @param passWord
	 * @return
	 * @throws SQLException
	 */
	public String selectUserByType(Connection con, User user) throws SQLException {
		User resultUser = null;
		String pwd = "获取用户类型出错";
		String sql = "select * from t_user where usertype=?";
		PreparedStatement pres = con.prepareStatement(sql);
		pres.setInt(1, user.getUserType());
		; // 给第一个？赋值
		ResultSet rs = pres.executeQuery(); // 查询数据库，获得返回值
		while (rs.next()) {
			pwd = rs.getString("password");
		}
		return pwd;
	}

	/**
	 * 查找所有用户
	 * 
	 * @param con
	 * @param userName
	 * @param passWord
	 * @return
	 * @throws SQLException
	 */
	public ResultSet selectUser(Connection con, User user) throws SQLException {
//		User resultUser = null;
		StringBuffer sBuffer = new StringBuffer("select * from t_user");
		if (StringUtil.isNotEmpty(user.getUserName())) {
			sBuffer.append(" and userName LIKE '%" + user.getUserName() + "%'");
		}
		String sql = sBuffer.toString().replaceFirst("and", "where"); // 将第一个“and”替换为“where”
		PreparedStatement pres = con.prepareStatement(sql);
		ResultSet rs = pres.executeQuery(); // 查询数据库，获得返回值
		return rs;
	}

	/**
	 * 添加用户
	 * 
	 * @param con
	 * @param user
	 * @return
	 */
	public int addUser(Connection con, User user) {
		int result = -1;
		try {
			String sql = "insert into t_user values (?,?,?,?)";
			PreparedStatement pres = con.prepareStatement(sql);
			pres.setInt(1, user.getId());
			pres.setString(2, user.getUserName());
			pres.setString(3, user.getPassWord());
			pres.setInt(4, user.getUserType());
			result = pres.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 修改用户资料
	 * 
	 * @param con
	 * @param user
	 * @return
	 */
	public int updateUser(Connection con, User user) {
		int result = -1;
		try {
			String sql = "update t_user set  userName=? , passWord =? where id=?";
			PreparedStatement ptsm = con.prepareStatement(sql);
			ptsm.setString(1, user.getUserName());
			ptsm.setString(2, user.getPassWord());
			ptsm.setInt(3, user.getId());
			result = ptsm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 删除用户
	 * 
	 * @param con
	 * @param id
	 * @return
	 */
	public int deleteUser(Connection con, User user) {
		int result = -1;
		try {
			String sql = "delete from t_user where id=?";
			PreparedStatement ptsm;
			ptsm = con.prepareStatement(sql);
			ptsm.setInt(1, user.getId());
			result = ptsm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
