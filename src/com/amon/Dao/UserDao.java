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
 * @version ����ʱ�䣺2018��3��28�� ����6:15:30 �û�DAO
 */
public class UserDao {

	/**
	 * ��¼��֤
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
		pres.setString(1, userName); // ����һ������ֵ
		pres.setString(2, passWord); // ���ڶ�������ֵ
		ResultSet rs = pres.executeQuery(); // ��ѯ���ݿ⣬��÷���ֵ
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
	 * ��ID�����û�
	 * 
	 * @param con
	 * @param userName
	 * @param passWord
	 * @return
	 * @throws SQLException
	 */
	public String selectUserByID(Connection con, User user) throws SQLException {
		User resultUser = null;
		String pwd = "��ȡ�û�ID����";
		String sql = "select * from t_user where id=?";
		PreparedStatement pres = con.prepareStatement(sql);
		pres.setInt(1, user.getId()); // ����һ������ֵ
		ResultSet rs = pres.executeQuery(); // ��ѯ���ݿ⣬��÷���ֵ
		while (rs.next()) {
			pwd = rs.getString("password");
		}
		return pwd;
	}
	/**
	 * ��ID�����û�2
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
		pres.setInt(1, user.getId()); // ����һ������ֵ
		ResultSet rs = pres.executeQuery(); // ��ѯ���ݿ⣬��÷���ֵ
		return rs;
	}

	/**
	 * ���û��������û�
	 * 
	 * @param con
	 * @param userName
	 * @param passWord
	 * @return
	 * @throws SQLException
	 */
	public String selectUserByName(Connection con, User user) throws SQLException {
		User resultUser = null;
		String pwd = "��ȡ�û����ֳ���";
		String sql = "select * from t_user where userName=?";
		PreparedStatement pres = con.prepareStatement(sql);
		pres.setString(1, user.getUserName());
		; // ����һ������ֵ
		ResultSet rs = pres.executeQuery(); // ��ѯ���ݿ⣬��÷���ֵ
		while (rs.next()) {
			pwd = rs.getString("password");
		}
		return pwd;
	}

	/**
	 * ���û����Ͳ����û�
	 * 
	 * @param con
	 * @param userName
	 * @param passWord
	 * @return
	 * @throws SQLException
	 */
	public String selectUserByType(Connection con, User user) throws SQLException {
		User resultUser = null;
		String pwd = "��ȡ�û����ͳ���";
		String sql = "select * from t_user where usertype=?";
		PreparedStatement pres = con.prepareStatement(sql);
		pres.setInt(1, user.getUserType());
		; // ����һ������ֵ
		ResultSet rs = pres.executeQuery(); // ��ѯ���ݿ⣬��÷���ֵ
		while (rs.next()) {
			pwd = rs.getString("password");
		}
		return pwd;
	}

	/**
	 * ���������û�
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
		String sql = sBuffer.toString().replaceFirst("and", "where"); // ����һ����and���滻Ϊ��where��
		PreparedStatement pres = con.prepareStatement(sql);
		ResultSet rs = pres.executeQuery(); // ��ѯ���ݿ⣬��÷���ֵ
		return rs;
	}

	/**
	 * ����û�
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
	 * �޸��û�����
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
	 * ɾ���û�
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
