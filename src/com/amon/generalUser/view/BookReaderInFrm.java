package com.amon.generalUser.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.amon.Dao.BookDao;
import com.amon.model.Book;
import com.amon.util.DbUtil;
import com.amon.util.FileUtil;

import javax.swing.JTextArea;
import java.awt.TextArea;
import java.sql.Connection;
import java.sql.ResultSet;

/**
* @author "Amon"
* @version 创建时间：2018年4月17日 下午7:37:42
* 图书内容阅读
*/
public class BookReaderInFrm extends JInternalFrame {
	int bookid;
	Connection con;
	JLabel bookNameTxt;
	JTextArea bookContext;

	/**
	 * Create the frame.
	 */
	public BookReaderInFrm(int bookid) {
		setClosable(true);
		this.bookid=bookid;
		setMaximizable(true);
		setTitle("\u56FE\u4E66\u9605\u8BFB");
		setBounds(100, 100, 450, 377);
		
		bookNameTxt = new JLabel("\u56FE\u4E66\u540D\u79F0");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(190)
					.addComponent(bookNameTxt)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(bookNameTxt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		bookContext = new JTextArea();
		bookContext.setText("\u6587\u4EF6\u52A0\u8F7D\u5931\u8D25\u6216\u6570\u636E\u4E22\u5931\uFF0C\u8BF7\u8054\u7CFB\u7BA1\u7406\u5458\uFF01");
		bookContext.setEditable(false);
		bookContext.setLineWrap(true);        //激活自动换行功能 
		bookContext.setWrapStyleWord(true);	 // 激活断行不断字功能
		scrollPane.setViewportView(bookContext);
		getContentPane().setLayout(groupLayout);
		getInfo();
	}
	
	
	void getInfo(){
		try {
			BookDao bookDao=new BookDao();
			con=DbUtil.getConn();
			ResultSet rs=bookDao.selectBookByID(con, bookid);
			String bookName = null;
			String context;
			while (rs.next()) {
				bookName=rs.getString("bookName");
				
			}
			bookNameTxt.setText(bookName);
			String bookCon=FileUtil.getContext(bookName);
			if ("-1".equals(bookCon)) {
				bookContext.setText("文件加载失败或数据丢失，请联系管理员！");
				JOptionPane.showMessageDialog(null, "文件加载失败！");
				return;
			}else if ("-2".equals(bookCon)) {
				bookContext.setText("");
				return;
			}
			bookContext.setText(bookCon);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
	
}
