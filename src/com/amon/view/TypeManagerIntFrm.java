package com.amon.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.amon.Dao.BookTypeDao;
import com.amon.model.BookType;
import com.amon.util.DbUtil;
import com.mysql.jdbc.RowDataCursor;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年3月30日 上午11:20:14
* 类说明
*/
public class TypeManagerIntFrm extends JInternalFrame {
	private JTextField bTypeNameTxt;
	private JTable table;
	DbUtil dbUtil=new DbUtil();
	Connection con=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TypeManagerIntFrm frame = new TypeManagerIntFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TypeManagerIntFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setBounds(100, 100, 451, 389);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0:");
		
		bTypeNameTxt = new JTextField();
		bTypeNameTxt.setColumns(10);
		
		JButton searchBookType = new JButton("\u67E5\u8BE2");
		searchBookType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBookTypeAction(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(74)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bTypeNameTxt, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(searchBookType))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchBookType))
					.addGap(44)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(146, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(94);
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new BookType());		//一开始将数据库的图书类型信息填充到表格中
	}
	
	
	
	
	/**
	 * 查询图书类型信息按钮的监听事件
	 * @param e
	 */
	private void searchBookTypeAction(ActionEvent e) {
			String bTypeName=bTypeNameTxt.getText();
			BookType bookType=new BookType(bTypeName);
			fillTable(bookType);
	}

	/**
	 * 填充表格显示数据的方法
	 * 
	 * 如果是空的BookType对象，调用BookTypeDao类里面的list方法时，返回的是数据表t_booktype的全部数据
	 * 如果不是空的则得到的数据是该BookType对象
	 * @param bookType
	 */
	private void fillTable(BookType bookType){
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);		//每次填充数据前，将表格的内容清空
		try {
			BookTypeDao boolTypeDao=new BookTypeDao();	
			 con=dbUtil.getConn();
			ResultSet rSet=boolTypeDao.list(con, bookType);	
			while (rSet.next()) {
				Vector vector=new Vector();
				vector.add(rSet.getInt("id"));
				vector.add(rSet.getString("bookTypeName"));
				vector.add(rSet.getString("bookTypeDesc"));
				dtm.addRow(vector);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}
	
	
}
