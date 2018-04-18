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
* @version ����ʱ�䣺2018��4��2�� ����7:00:02
* ���������û�
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
	 * ��ѯ��ť�ļ����¼�
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
	 * ɾ���û���ť�ļ���
	 * @param e
	 */
	private void deleteOtherUserAction(ActionEvent e) {
		try {
			con=dbUtil.getConn();
			int selectRow=table.getSelectedRow();
			int userId=(int) table.getValueAt(selectRow, 0);	//��ȡ����еĵ�һ�����ݣ���ID��
			String userType=(String) table.getValueAt(selectRow, 3);
			if (userId==1||"�����û�".equals(userType)) {
				JOptionPane.showMessageDialog(null, "�����û����޷�ɾ����");
				return;
			}
			UserDao userDao=new UserDao();
			 User user = new User(userId);
			int result=userDao.deleteUser(con, user);
			if (result==1) {
				fillTable(new User());
				JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
				userNameTxt.setText("");
			}else{
				JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
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
	 * �������ʾ�����û�����
	 * @param book
	 */

	private void fillTable(User user){
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);		//ÿ���������ǰ���������������
		try {
			UserDao userDao=new UserDao();
			con=dbUtil.getConn();
			ResultSet rSet=userDao.selectUser(con, user);	
			while (rSet.next()) {
				String userType="��ͨ�û�";
				if (rSet.getString("usertype").equals("1")) {
					userType="�����û�";
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
