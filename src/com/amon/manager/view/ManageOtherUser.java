package com.amon.manager.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.amon.Dao.BookDao;
import com.amon.Dao.UserDao;
import com.amon.model.Book;
import com.amon.model.User;
import com.amon.util.DbUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年4月2日 下午7:00:02
* 管理其他用户
*/
public class ManageOtherUser extends JInternalFrame {
	private JTextField userNameTxt;
	private JTable table;
	DbUtil dbUtil=new DbUtil();
	Connection con=null;


	/**
	 * Create the frame.
	 */
	public ManageOtherUser() {
		setTitle("\u7BA1\u7406\u5176\u4ED6\u7528\u6237");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 373);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "\u8D26\u53F7\u6635\u79F0", "\u8D26\u6237\u5BC6\u7801", "\u7528\u6237\u7C7B\u578B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5 \u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectUserAction(e);
			}
		});
		
		JButton button_1 = new JButton("\u5220 \u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteOtherUserAction(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(label)
				.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(button_1)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(76, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		fillTable(new User());
	}
	
	
	
	
	/**
	 * 查询按钮的监听事件
	 * @param e
	 */
	private void selectUserAction(ActionEvent e) {
		try {
			String userName=userNameTxt.getText();
			User user=new User(userName);
			fillTable(user);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	/**
	 * 删除用户按钮的监听
	 * @param e
	 */
	private void deleteOtherUserAction(ActionEvent e) {
		try {
			con=dbUtil.getConn();
			int selectRow=table.getSelectedRow();
			int userId=(int) table.getValueAt(selectRow, 0);	//获取点击行的第一个内容（即ID）
			String userType=(String) table.getValueAt(selectRow, 3);
			if (userId==1||"超级用户".equals(userType)) {
				JOptionPane.showMessageDialog(null, "超级用户，无法删除！");
				return;
			}
			UserDao userDao=new UserDao();
			 User user = new User(userId);
			int result=userDao.deleteUser(con, user);
			if (result==1) {
				fillTable(new User());
				JOptionPane.showMessageDialog(null, "删除成功！");
				userNameTxt.setText("");
			}else{
				JOptionPane.showMessageDialog(null, "删除失败！");
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
	 * 表格中显示所有用户数据
	 * @param book
	 */

	private void fillTable(User user){
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);		//每次填充数据前，将表格的内容清空
		try {
			UserDao userDao=new UserDao();
			con=dbUtil.getConn();
			ResultSet rSet=userDao.selectUser(con, user);	
			while (rSet.next()) {
				String userType="普通用户";
				if (rSet.getString("usertype").equals("1")) {
					userType="超级用户";
				}
				Vector vector=new Vector();
				vector.add(rSet.getInt("id"));
				vector.add(rSet.getString("userName"));
				vector.add(rSet.getString("password"));
				vector.add(userType);
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
