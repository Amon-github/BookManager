package com.amon.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import com.amon.model.BorrowInfo;
import com.amon.util.StringUtil;

/**
 * @author "Amon"
 * @version 创建时间：2018年4月13日 上午8:22:27 “图书借售信息”的数据库连接类
 */
public class BorrowDao {

	/**
	 * 添加一条图书借售信息
	 * 
	 * @param con
	 * @param binfo
	 * @return
	 * @throws Exception
	 */
	public int addBorrowInfo(Connection con, BorrowInfo binfo) throws Exception {
		String sql = "insert into t_lend values (?,?,?,?,?,?,?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, binfo.getId());
		pstm.setInt(2, binfo.getBookid());
		pstm.setString(3, binfo.getCardid());
		pstm.setString(4, binfo.getBorrowdate());
		pstm.setInt(5, binfo.getLendcount());
		pstm.setInt(6, binfo.getManagerid());
		pstm.setString(7, binfo.getReturndate());
		int result = pstm.executeUpdate();
		return result;
	}
	
	/**
	 * 更新图书借售信息
	 * @param con
	 * @param binfo
	 * @return
	 * @throws Exception
	 */
	public int updateBorrowInfo(Connection con, BorrowInfo binfo) throws Exception {
		String sql="update t_lend set bookid=?,cardid=?,borrowdate=?,lendcount=?,managerid=?,returndate=? where id=?";
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setInt(1, binfo.getBookid());
		pstm.setString(2, binfo.getCardid());
		pstm.setString(3, binfo.getBorrowdate());
		pstm.setInt(4, binfo.getLendcount());
		pstm.setInt(5, binfo.getManagerid());
		pstm.setString(6, binfo.getReturndate());
		pstm.setInt(7, binfo.getId());
		int result=pstm.executeUpdate();
		return result;
	}
	
	
	

	/**
	 * 删除一条图书借售信息
	 * @param con
	 * @param bInfo
	 * @return  删除失败返回-1
	 * @throws Exception
	 */
	public int deleteBorrowInfo(Connection con, BorrowInfo bInfo) throws Exception {
		String sql = "delete from t_lend where id=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, bInfo.getId());
		int result = pstm.executeUpdate();
		return result;
	}

	/**
	 * 查询出借信息
	 * @param con
	 * @param bInfo
	 * @return
	 */
	public ResultSet selectBorrowInfo(Connection con, BorrowInfo bInfo) {
		ResultSet resultSet = null;
		try {
			StringBuffer sBuffer = new StringBuffer("select * from t_lend");
			if (StringUtil.isNotEmpty(bInfo.getCardid())) {
				sBuffer.append(" and cardid LIKE '%" + bInfo.getCardid() + "%'");
			}
			String sql = sBuffer.toString().replaceFirst("and", "where"); // 将第一个“and”替换为“where”
			PreparedStatement pstm;
			pstm = con.prepareStatement(sql);
			resultSet = pstm.executeQuery(); // 获得查询到的结果集
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;

	}

}
