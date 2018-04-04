package com.amon.manager.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.amon.manager.Dao.BookDao;
import com.amon.manager.Dao.BookTypeDao;
import com.amon.model.Book;
import com.amon.model.BookType;
import com.amon.util.DbUtil;
import com.amon.util.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年3月30日 上午11:20:14
* 图书类型维护界面
*/
public class TypeManagerIntFrm extends JInternalFrame {
	private JTextField bTypeNameTxt;
	private JTable table;
	DbUtil dbUtil=new DbUtil();
	Connection con=null;
	private JTextField idTxt;
	private JTextArea descTxt;
	private JTextField bookTypeNameTxt;
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
		setTitle("\u7C7B\u522B\u7BA1\u7406");
		setBounds(100, 100, 530, 617);
		
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(92)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bTypeNameTxt, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(searchBookType))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))))
					.addContainerGap(78, Short.MAX_VALUE))
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
					.addGap(51)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(85, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		 descTxt = new JTextArea();
		descTxt.setText("4374");
		
		JButton btnUpdate = new JButton("\u4FEE  \u6539");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateActionPerformed(e);
			}
		});
		
		JButton btnDelete = new JButton("\u5220  \u9664");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeDeleteActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(94, Short.MAX_VALUE)
					.addComponent(btnUpdate)
					.addGap(29)
					.addComponent(btnDelete)
					.addGap(82))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(descTxt, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(descTxt, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate)
						.addComponent(btnDelete))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeTableMousePressed(e);
			}
		});
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
	 * 修改按钮监听事件	
	 * @param e
	 */
	private void updateActionPerformed(ActionEvent e) {
		try {
			if (StringUtil.isEmpty(bookTypeNameTxt.getText())) {
				JOptionPane.showMessageDialog(null, "图书类型名称不能为空");
				return;
			}else if (StringUtil.isEmpty(descTxt.getText())) {
				JOptionPane.showMessageDialog(null, "图书类型描述不能为空");
				return;
			}
			con=dbUtil.getConn();
			BookType bookType=new BookType();
			bookType.setId(Integer.valueOf(idTxt.getText()));
			bookType.setTypeName(bookTypeNameTxt.getText());
			bookType.setTypeDesc(descTxt.getText());
			BookTypeDao dao=new BookTypeDao();
			int result=dao.update(con, bookType);
			if (result==1) {
				JOptionPane.showMessageDialog(null, "操作成功");
				this.fillTable(new BookType());	
				idTxt.setText("");
				bookTypeNameTxt.setText("");
				descTxt.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "修改失敗！");
				this.fillTable(new BookType());	
				idTxt.setText("");
				bookTypeNameTxt.setText("");
				descTxt.setText("");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	/**
	 * 删除按钮监听事件
	 * @param e
	 */
	private void typeDeleteActionPerformed(ActionEvent e) {
		if (beforDelete()==1) {
			JOptionPane.showMessageDialog(null, "该类别下含有图书，不能删除哦！");
			return;
		}
		try {
			con=dbUtil.getConn();
			int id=Integer.valueOf(idTxt.getText());
			BookTypeDao bookTypeDao=new BookTypeDao();
			int result=bookTypeDao.delete(con, id);
			if (result==1) {
				this.fillTable(new BookType());	
				idTxt.setText("");
				bookTypeNameTxt.setText("");
				descTxt.setText("");
				JOptionPane.showMessageDialog(null, "删除成功！");
			}else {
				JOptionPane.showMessageDialog(null, "删除失敗呢！");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 删除图书类型前判断该类中有没有图书
	 */
	private int  beforDelete() {
		int returnNum=0;
		try {
			con=dbUtil.getConn();
			int id=Integer.valueOf(idTxt.getText());
			Book book=new Book(id);
			BookDao bookDao=new BookDao();
			ResultSet result=bookDao.selectBook(con, book);
			if (result.next()) {
				returnNum=1;
				System.out.println("给类别下有图书，ID为：");
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
		
		
		
		
		return returnNum;
	}
	
	

	/**
	 * 表单点击选项，显示在表单操作中
	 * @param e
	 */
	private void bookTypeTableMousePressed(MouseEvent e) {
		int selectRow=table.getSelectedRow();
		int id=(int) table.getValueAt(selectRow, 0);	//获取所选行第1列的内容，返回的事object对象，强转为int
		String bookTypeName=(String) table.getValueAt(selectRow, 1);//获取所选行第2列的内容
		String bookTypeDesc=(String) table.getValueAt(selectRow, 2);//获取所选行第3列的内容
		idTxt.setText(id+"");
		bookTypeNameTxt.setText(bookTypeName);
		descTxt.setText(bookTypeDesc);
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
			BookTypeDao bookTypeDao=new BookTypeDao();	
			 con=dbUtil.getConn();
			ResultSet rSet=bookTypeDao.list(con, bookType);	
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
