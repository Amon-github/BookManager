package com.amon.Dao;

import com.amon.model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年3月29日 下午11:06:46
* 图书DAO
 */
public class BookDao {
	
	
	/**
	 * 添加图书方法
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
