package com.amon.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.amon.Dao.UserDao;
import com.amon.model.User;
import com.amon.util.DbUtil;
import com.amon.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

/**
* @author Amon E-mail:248779716@qq.com
* @version ����ʱ�䣺2018��3��28�� ����7:06:46
* ��˵��
*/
public class LogOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passWordTxt;
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao =new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		setResizable(false);
		setTitle("ͼ�����ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801");
		
		JLabel label_2 = new JLabel("\u7BA1\u7406\u5458\u767B\u5F55");
		label_2.setFont(new Font("����", Font.PLAIN, 30));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		passWordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("��¼");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerform(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(140)
					.addComponent(label_2)
					.addContainerGap(100, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(145, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(40)
					.addComponent(button)
					.addGap(135))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(113)
					.addComponent(label_1)
					.addGap(18)
					.addComponent(passWordTxt)
					.addGap(102))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(113, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(18)
					.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addGap(102))
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
						.addComponent(label_1)
						.addComponent(passWordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
			return;
		} else if (StringUtil.isEmpty(passWord)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
			return;
		}
		try {
			Connection con=dbUtil.getConn();
			User currentUser=userDao.login(con, userName,passWord);
			if (currentUser!=null) {
				dispose();//��������
				new HomeView().setVisible(true);	//��ʾ������
			} else {
				JOptionPane.showMessageDialog(null, "�˺Ż��������");
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
