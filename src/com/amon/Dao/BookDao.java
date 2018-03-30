package com.amon.Dao;

import com.amon.model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	private int add(Connection con,Book book) throws SQLException {
		String sql="insert into t_book values (?,?,?,?)";
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1, book.getName());
		pstm.setString(1, book.getAuthor());
		pstm.setString(1, book.getAuthorSex());
		pstm.setInt(1, book.getPrice());
		int result=pstm.executeUpdate();
		
		return result;
	}
	
	
}
