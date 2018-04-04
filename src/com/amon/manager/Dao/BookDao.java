package com.amon.manager.Dao;

import com.amon.model.Book;
import com.amon.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
* @author Amon E-mail:248779716@qq.com
* @version ����ʱ�䣺2018��3��29�� ����11:06:46
* ͼ��DAO
 */
public class BookDao {
	
	
	/**
	 * ���ͼ�鷽��
	 * @throws SQLException 
	 * 
	 */
	public int addBook(Connection con,Book book) throws SQLException {
		String sql="insert into t_book values (?,?,?,?,?,?,?)";
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setInt(1, book.getId());
		pstm.setString(2, book.getName());
		pstm.setString(3, book.getAuthor());
		pstm.setString(4, book.getAuthorSex());
		pstm.setInt(5, book.getPrice());
		pstm.setInt(6, book.getBookTypeId());
		pstm.setString(7, book.getBookDesc());
		int result=pstm.executeUpdate();
		return result;
	}
	
	/**
	 * ����ͼ��
	 * @param con
	 * @param 0
	 * @return
	 * @throws SQLException
	 */
	public ResultSet selectBook(Connection con,Book book) throws SQLException {
		StringBuffer sBuffer=new StringBuffer("select * from t_book b,t_booktype bt where b.bookTypeId=bt.id ");
		if (StringUtil.isNotEmpty(book.getName())) {
			sBuffer.append(" and b.bookName LIKE '%"+book.getName()+"%'");
		}
		if (StringUtil.isNotEmpty(book.getAuthor())) {
			sBuffer.append(" and b.author LIKE '%"+book.getAuthor()+"%'");
		}
		if (book.getBookTypeId()!=null && book.getBookTypeId()!=-1) {
			sBuffer.append(" and b.bookTypeId="+book.getBookTypeId());
		}
		String sql=sBuffer.toString();	
		PreparedStatement pstm=con.prepareStatement(sql);
		ResultSet resultSet=pstm.executeQuery();	//��ò�ѯ���Ľ����
		return resultSet;
	}
	
	
	
	
	
	/**
	 * ͼ����Ϣ����
	 * @param con
	 * @param 0
	 * @return
	 * @throws SQLException
	 */
	public int updateBook(Connection con,Book book) throws SQLException {
		String sql="update t_book set bookName=?,author=?,sex=?,price=?,bookTypeId=?,bookDesc=? where id=? ";
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1, book.getName());
		pstm.setString(2, book.getAuthor());
		pstm.setString(3, book.getAuthorSex());
		pstm.setInt(4, book.getPrice());
		pstm.setInt(5, book.getBookTypeId());
		pstm.setString(6, book.getBookDesc());
		pstm.setInt(7, book.getId());
		System.out.println("bookdao------"+sql);
		int result=pstm.executeUpdate();
		return result;
	}
	
	
	
	/**
	 * ɾ��ͼ����Ϣ
	 * @param con
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int deleteBook(Connection con,int id) throws SQLException {
		String sql="delete from t_book where id=?";
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setInt(1, id);
		int result=pstm.executeUpdate();
		return result;
	}
	
	
	
	
}
