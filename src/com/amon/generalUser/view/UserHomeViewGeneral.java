package com.amon.generalUser.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.amon.Dao.UserDao;
import com.amon.manager.view.AboutMeIntFrm;
import com.amon.manager.view.BookAddIntFrm;
import com.amon.manager.view.BookManagerIntFrm;
import com.amon.model.User;
import com.amon.util.DbUtil;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;

/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年3月29日 下午5:00:30
* 普通用户主界面
*/
public class UserHomeViewGeneral extends JFrame {

	private JPanel contentPane;
	public static JDesktopPane table=null;
	private int userID;	//用户ID



	/**
	 * Create the frame.
	 */
	public UserHomeViewGeneral(int userid) {
		this.userID=userid;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 21));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem_5 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 21));
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出");
				if (result==0) {
					dispose();
				}
			}
		});
		
		JMenuItem menuItem_4 = new JMenuItem("\u56FE\u4E66\u641C\u7D22");
		mnNewMenu.add(menuItem_4);
		menuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 21));
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchBookIntFrmGener bookManagerIntFrmGener=new SearchBookIntFrmGener();
				bookManagerIntFrmGener.setVisible(true);
				table.add(bookManagerIntFrmGener);
			}
		});
		
		JMenuItem menuItem = new JMenuItem("\u8D26\u53F7\u7BA1\u7406");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateUserInfoInFrm updateUserInfoInFrm=new UpdateUserInfoInFrm(userid);
				updateUserInfoInFrm.setVisible(true);
			}
		});
		menuItem.setFont(new Font("Dialog", Font.PLAIN, 21));
		mnNewMenu.add(menuItem);
		mnNewMenu.add(menuItem_5);
		
		JMenu menu = new JMenu("\u66F4\u591A");
		menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 21));
		menuBar.add(menu);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 21));
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutMeIntFrm aboutMeIntFrm=new AboutMeIntFrm(); 
				aboutMeIntFrm.setVisible(true);
				table.add(aboutMeIntFrm); 
			}
		});
		menu.add(menuItem_2);
		
		JMenuItem mntmid = new JMenuItem("\u672C\u673AID");
		mntmid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CurrentGengralID currentID=new CurrentGengralID(userID);
				currentID.setVisible(true);
				table.add(currentID); 
			}
		});
		mntmid.setFont(new Font("Dialog", Font.PLAIN, 21));
		menu.add(mntmid);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		 table = new JDesktopPane();
		table.setBackground(SystemColor.inactiveCaption);
		contentPane.add(table, BorderLayout.CENTER);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);	//设置窗体刚弹出时最大化
	}


	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
