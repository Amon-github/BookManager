package com.amon.manager.Dao;

import com.amon.model.Book;
import com.amon.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Amon E-mail:248779716@qq.com
 * @version 创建时间：2018年3月29日 下午11:06:46 “图书”的数据库连接类
 */
public class BookDao {

	/**
	 * 添加图书方法
	 * 
	 * @throws SQLException
	 * 
	 */
	public int addBook(Connection con, Book book) throws SQLException {
		String sql = "insert into t_book values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, book.getId());
		pstm.setString(2, book.getName());
		pstm.setString(3, book.getAuthor());
		pstm.setString(4, book.getAuthorSex());
		pstm.setInt(5, book.getPrice());
		pstm.setString(6, book.getKeeproom());
		pstm.setInt(7, book.getCount());
		pstm.setInt(8, book.getStocks());
		pstm.setInt(9, book.getBookTypeId());
		pstm.setString(10, book.getBookDesc());
		int result = pstm.executeUpdate();
		return result;
	}

	/**
	 * 查找图书
	 * 
	 * @param con
	 * @param 0
	 * @return
	 * @throws SQLException
	 */
	public ResultSet selectBook(Connection con, Book book) throws SQLException {
		StringBuffer sBuffer = new StringBuffer("select * from t_book b,t_booktype bt where b.bookTypeId=bt.id ");
		if (StringUtil.isNotEmpty(book.getName())) {
			sBuffer.append(" and b.bookName LIKE '%" + book.getName() + "%'");
		}
		if (StringUtil.isNotEmpty(book.getAuthor())) {
			sBuffer.append(" and b.author LIKE '%" + book.getAuthor() + "%'");
		}
		if (book.getBookTypeId() != null && book.getBookTypeId() != -1) {
			sBuffer.append(" and b.bookTypeId=" + book.getBookTypeId());
		}
		String sql = sBuffer.toString();
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet resultSet = pstm.executeQuery(); // 获得查询到的结果集
		return resultSet;
	}

	/**
	 * 用图书ID 查询图书信息
	 * 
	 * @param con
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public ResultSet selectBookByID(Connection con, int id) throws SQLException {
		String sql = "select * from t_book where id=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		return rs;
	}

	/**
	 * 图书信息更新
	 * 
	 * @param con
	 * @param 0
	 * @return
	 * @throws SQLException
	 */
	public int updateBook(Connection con, Book book) throws SQLException {
		String sql = "update t_book set bookName=?,author=?,sex=?,price=?,keeproom=?,count=?,Stocks=?,bookTypeId=?,bookDesc=? where id=? ";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, book.getName());
		pstm.setString(2, book.getAuthor());
		pstm.setString(3, book.getAuthorSex());
		pstm.setInt(4, book.getPrice());
		pstm.setString(5, book.getKeeproom());
		pstm.setInt(6, book.getCount());
		pstm.setInt(7, book.getStocks());
		pstm.setInt(8, book.getBookTypeId());
		pstm.setString(9, book.getBookDesc());
		pstm.setInt(10, book.getId());

		int result = pstm.executeUpdate();
		return result;
	}

	/**
	 * 修改图书库存
	 * 
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int updateBookStocks(Connection con, Book book) {
		int result=0;
		try {
			String sql = "update  t_book set Stocks=? where id=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, book.getStocks());
			pstm.setInt(2, book.getId());
			result=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 删除图书信息
	 * 
	 * @param con
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int deleteBook(Connection con, int id) throws SQLException {
		String sql = "delete from t_book where id=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, id);
		int result = pstm.executeUpdate();
		return result;
	}

}
