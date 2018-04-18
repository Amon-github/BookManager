package com.amon.manager.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.amon.Dao.UserDao;
import com.amon.generalUser.view.UserHomeViewGeneral;
import com.amon.model.User;
import com.amon.util.DbUtil;
import com.amon.util.StringUtil;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Component;

/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年3月28日 下午7:06:46
* 登录界面
*/
public class LogInFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	JLabel label_2;
	private JPasswordField passWordTxt;
	private static DbUtil dbUtil=new DbUtil();
	private UserDao userDao =new UserDao();
	int type;


	/**
	 * Create the frame.
	 */
	public LogInFrm(int type) {
		this.type=type;
		setResizable(false);
		setTitle("图书管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801");
		
		 label_2 = new JLabel("注 册 用 户");
		label_2.setFont(new Font("宋体", Font.PLAIN, 30));
		if (type==1) {
			label_2.setText("添加超级管理员");
		}else{
			label_2.setText("注 册 用 户");
		}
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		passWordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u63D0 \u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		JButton button = new JButton("\u91CD \u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerform(e);
			}
		});
		
		JButton button_1 = new JButton("\u53D6  \u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(90, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(label_1)
									.addComponent(label))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(passWordTxt)
									.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
								.addGap(102))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnNewButton)
								.addGap(18)
								.addComponent(button)
								.addGap(18)
								.addComponent(button_1)
								.addGap(101)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(label_2)
							.addGap(129))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_2)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passWordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(58))
		);
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnNewButton, button, button_1});
		
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);	//设置窗体刚弹出时居中
	}

	/**
	 * 登录事件处理
	 * @param event
	 */
	private void loginActionPerformed(ActionEvent event) {
		String userName=this.userNameTxt.getText();
		String passWord=new String(this.passWordTxt.getPassword());
		
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		} else if (StringUtil.isEmpty(passWord)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		if (chackUserName(userName)==false) {
			JOptionPane.showMessageDialog(null, "该用户已经存在！");
			return;
		}
		try {
			User user=new User(userName,passWord,type);
			Connection con=dbUtil.getConn();
			int currentUser=userDao.addUser(con,user);
			User newUser=userDao.login(con, userName, passWord,type); 	//获取刚注册到的用户对象
			int newUserID=newUser.getId(); 	//获取刚注册到的用户的id
			if (currentUser!=-1) {
				JOptionPane.showMessageDialog(null, "注册成功，请记住你的账号和密码哦！");
				dispose();//窗体销毁
				if (type==1) {
					new ManagerHomeView(newUserID).setVisible(true);
				}else{
					new UserHomeViewGeneral(newUserID).setVisible(true);	//显示普通用户主窗口
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "注册失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**判断用户名是否已经存在
	 * 	用户存在的话返回false；用户不存在的话返回true
	 * @param userName
	 */
	public static Boolean chackUserName(String userName){
		boolean tag=false;
		Connection con = null;
		try {
			con = dbUtil.getConn();
			UserDao userDao =new UserDao();
			User user=new User(userName);
			String pwd=userDao.selectUserByName(con, user);
			if ("获取用户名字出错".equals(pwd)) {	//就是获取不到该用户名，数据库中不存在该用户
				tag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tag;
	}
	
	
	/**
	 * 重置按钮点击事件
	 *  @param e
	 */
	void resetValueActionPerform(ActionEvent event){
		resetValue();
	}
	
/**
 * 重置输入框
 *
 */
	private void resetValue() {
		this.userNameTxt.setText("");
		this.passWordTxt.setText("");
		
	}
}
