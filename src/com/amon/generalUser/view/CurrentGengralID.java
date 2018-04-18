package com.amon.generalUser.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.amon.Dao.UserDao;
import com.amon.model.User;
import com.amon.util.DbUtil;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @author "Amon"
 * @version 创建时间：2018年4月10日 下午7:53:18 
 * 显示当前账户的信息
 */
public class CurrentGengralID extends JInternalFrame {
	private JTextField currentName;
	private JTextField currentID;
	private int userId;
	String userName="出错，请重新登录";
	String userID="出错，请重新登录";



	/**
	 * Create the frame.
	 */
	public CurrentGengralID(int userId) {
		setClosable(true);
		this.userId = userId;
		
		setBounds(100, 100, 450, 300);

		JLabel label = new JLabel("\u672C\u673A\u540D\u5B57\uFF1A");

		currentName = new JTextField();
		currentName.setEditable(false);
		currentName.setColumns(10);

		JLabel lblid = new JLabel("\u672C\u673AID\uFF1A");

		currentID = new JTextField();
		currentID.setEditable(false);
		currentID.setColumns(10);

		JLabel label_1 = new JLabel("\u5F53 \u524D \u8D26 \u53F7 \u4FE1 \u606F");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 21));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(131)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup().addComponent(label)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(currentName,
														GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblid).addGap(18)
												.addComponent(currentID))))
						.addGroup(groupLayout.createSequentialGroup().addGap(139).addComponent(label_1)))
				.addContainerGap(139, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(22).addComponent(label_1).addGap(62)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(
						currentName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblid).addComponent(
						currentID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(102, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

		getUser();
	}

	/**
	 * 获取当前用户信息，填充到输入框中
	 */
	private void getUser() {
		try {
			User user = new User(userId);
			UserDao userDao = new UserDao();
			Connection con;
			con = DbUtil.getConn();
			ResultSet rs = userDao.selectUserByID2(con, user);
			
			while (rs.next()) {
				userName = rs.getString("userName");
				userID=rs.getInt("id")+"";
			}
				currentName.setText(userName);
				currentID.setText(userID+"");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
