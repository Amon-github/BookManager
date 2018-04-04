package com.amon.generalUser.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

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
import com.amon.manager.view.LogInFrm;
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
public class UpdateUserInfoInFrm extends JFrame {

	private JPanel contentPane;
	private JTextField oldPWDTxt;
	private JPasswordField newPWDTxt;
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao =new UserDao();
	private int userId;
	private JTextField newUserName;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUserInfoInFrm frame = new UpdateUserInfoInFrm(0);
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
	public UpdateUserInfoInFrm(int id) {
		this.userId=id;
		setResizable(false);
		setTitle("ͼ�����ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u65E7\u5BC6\u7801");
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801");
		
		JLabel label_2 = new JLabel("\u4FEE\u6539\u7528\u6237\u5BC6\u7801");
		label_2.setFont(new Font("����", Font.PLAIN, 30));
		
		oldPWDTxt = new JTextField();
		oldPWDTxt.setColumns(10);
		
		newPWDTxt = new JPasswordField();
		
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
		
		JLabel label_3 = new JLabel("\u7528\u6237\u540D");
		
		newUserName = new JTextField();
		newUserName.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(113, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(40)
							.addComponent(button)
							.addGap(33))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label)
								.addComponent(label_3))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(newPWDTxt)
								.addComponent(newUserName)
								.addComponent(oldPWDTxt, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_2)
							.addGap(20)))
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
						.addComponent(oldPWDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(newUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(newPWDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);	//���ô���յ���ʱ����
	}

	/**
	 * ��¼�¼�����
	 * @param event
	 */
	private void loginActionPerformed(ActionEvent event) {
		String newUserName=this.newUserName.getText();
		String oldPWD=this.oldPWDTxt.getText();
		String newPWD=new String(this.newPWDTxt.getPassword()); 
		int userType=2;
		if (StringUtil.isEmpty(oldPWD)) {
			JOptionPane.showMessageDialog(null, "�����벻��Ϊ��");
			return;
		}else if (StringUtil.isEmpty(newUserName)) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
			return;
		} else if (StringUtil.isEmpty(newPWD)) {
			JOptionPane.showMessageDialog(null, "�����벻��Ϊ��");
			return;
		}else if (newPWD.equals(oldPWD)){
			JOptionPane.showMessageDialog(null, "�����벻�ܺ;�������ͬ");
			return;
		}
		if (getUserOldPWD(oldPWD)!=true) {
			JOptionPane.showMessageDialog(null, "�����벻��Ŷ��");
			return;
		}
		if (LogInFrm.chackUserName(newUserName)==false) {
			JOptionPane.showMessageDialog(null, "���û��Ѿ����ڣ�");
			return;
		}
		try {
			User user=new User(userId,newUserName,newPWD);
			Connection con=dbUtil.getConn();
			int currentUser=userDao.updateUser(con, user);
			if (currentUser!=-1) {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ������ס����˺ź�����Ŷ��");
				dispose();//��������
			} else {
				JOptionPane.showMessageDialog(null, "�޸�ʧ��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**�жϾ������Ƿ���ȷ��
	 * ��ȡ����ʹ�õ��û������ݿ��е��˺�����
	 */
	Boolean getUserOldPWD(String newPWD){
		boolean tag=false;
		Connection con = null;
		try {
			con = dbUtil.getConn();
			UserDao userDao =new UserDao();
			User currentUser=new User(userId,"��������","��������");
			String oldUserPWD=userDao.selectUserByID(con, currentUser);	//�������ݿ��������ID��ȡ��Ӧ������
			if (!newPWD.equals(oldUserPWD)) {
				tag=false;
			}else{
				tag=true;
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
		this.oldPWDTxt.setText("");
		this.newPWDTxt.setText("");
		
	}
}
