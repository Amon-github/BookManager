package com.amon.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.amon.model.BookType;
import com.amon.util.StringUtil;

/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年3月29日 下午7:32:30
* 图书类别 连接数据库的封装方法 DAO
*/
public class BookTypeDao {
	
	/**
	 * 添加图书类型
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,BookType bookType) throws Exception{
		String sql="insert into t_booktype values (?,?,?)";
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setInt(1, bookType.getId());
		pstm.setString(2, bookType.getTypeName());
		pstm.setString(3, bookType.getTypeDesc());
		int result=pstm.executeUpdate();

		return result;
	}
	
	/**
	 * 查询图书类别集合
	 * 	当参数booktype为空时，返回的是所有数据！  即需要将所有数据显示时，可以传入一个空的bookType对象
	 * @param con
	 * @param bookType
	 * @return	返回查询到的数据集合
	 * @throws Exception
	 */
	public ResultSet list(Connection con,BookType bookType) throws Exception{
		StringBuffer sBuffer=new StringBuffer("select * from t_booktype");
		
		if (StringUtil.isNotEmpty(bookType.getTypeName())) {
			sBuffer.append(" and bookTypeName LIKE '%"+bookType.getTypeName()+"%'");
		}
		String sql=sBuffer.toString().replaceFirst("and", "where");	//将第一个“and”替换为“where”
		PreparedStatement pstm=con.prepareStatement(sql);
		ResultSet resultSet=pstm.executeQuery();	//获得查询到的结果集
		return resultSet;
	}
	
	/**
	 * 刪除图书类别
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,int id) throws Exception{
		String sql="delete from t_booktype where id=?";
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setInt(1, id);
		int result=pstm.executeUpdate();
		return result;
	}
	
	
	/**
	 * 更新图书类型
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,BookType bookType) throws Exception{
		String sql="update t_booktype set bookTypeName=?,booktypedesc=? where id=?";
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1, bookType.getTypeName());
		pstm.setString(2, bookType.getTypeDesc());
		pstm.setInt(3, bookType.getId());
		int result=pstm.executeUpdate();
		return result;
	}
	
	

}
