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

import com.amon.generalUser.view.UserHomeViewGeneral;
import com.amon.manager.Dao.UserDao;
import com.amon.model.User;
import com.amon.util.DbUtil;
import com.amon.util.StringUtil;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

/**
* @author Amon E-mail:248779716@qq.com
* @version ����ʱ�䣺2018��3��28�� ����7:06:46
* ��¼����
*/
public class LogInFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passWordTxt;
	private static DbUtil dbUtil=new DbUtil();
	private UserDao userDao =new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInFrm frame = new LogInFrm();
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
	public LogInFrm() {
		setResizable(false);
		setTitle("ͼ�����ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801");
		
		JLabel label_2 = new JLabel("\u6CE8\u518C\u7528\u6237");
		label_2.setFont(new Font("����", Font.PLAIN, 30));
		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(113, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(40)
							.addComponent(button)
							.addGap(135))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(passWordTxt)
								.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
							.addGap(102))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(label_2)
							.addGap(152))))
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
						.addComponent(button))
					.addGap(58))
		);
		
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);	//���ô���յ���ʱ����
	}

	/**
	 * ��¼�¼�����
	 * @param event
	 */
	private void loginActionPerformed(ActionEvent event) {
		String userName=this.userNameTxt.getText();
		String passWord=new String(this.passWordTxt.getPassword());
		int userType=2;
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
			return;
		} else if (StringUtil.isEmpty(passWord)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
			return;
		}
		if (chackUserName(userName)==false) {
			JOptionPane.showMessageDialog(null, "���û��Ѿ����ڣ�");
			return;
		}
		try {
			User user=new User(userName,passWord,userType);
			Connection con=dbUtil.getConn();
			int currentUser=userDao.addUser(con,user);
			User newUser=userDao.login(con, userName, passWord); 	//��ȡ��ע�ᵽ���û�����
			int newUserID=newUser.getId();
			if (currentUser!=-1) {
				JOptionPane.showMessageDialog(null, "ע��ɹ������ס����˺ź�����Ŷ��");
				dispose();//��������
				new UserHomeViewGeneral(newUserID).setVisible(true);	//��ʾ��ͨ�û�������
			} else {
				JOptionPane.showMessageDialog(null, "ע��ʧ��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**�ж��û����Ƿ��Ѿ�����
	 * 	�û����ڵĻ�����false���û������ڵĻ�����true
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
			System.out.println("pwd:"+pwd);
			if ("��ȡ�û����ֳ���".equals(pwd)) {	//���ǻ�ȡ�������û��������ݿ��в����ڸ��û�
				tag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tag;
	}
	
	
	/**
	 * ���ð�ť����¼�
	 *  @param e
	 */
	void resetValueActionPerform(ActionEvent event){
		resetValue();
	}
	
/**
 * ���������
 *
 */
	private void resetValue() {
		this.userNameTxt.setText("");
		this.passWordTxt.setText("");
		
	}
}
