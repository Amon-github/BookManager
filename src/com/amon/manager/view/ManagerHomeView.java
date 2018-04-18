package com.amon.manager.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTextPane;

/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年3月29日 下午5:00:30
* 管理员主界面
*/
public class ManagerHomeView extends JFrame {

	private JPanel contentPane;
	static JDesktopPane table=null;
	private int userType;	//用户类型（图书管理员 还是普通用户）
	int userid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerHomeView frame = new ManagerHomeView(1);
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
	public ManagerHomeView(int userid) {
		this.userid=userid;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 21));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 21));
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem menuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 21));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TypeAddIntFrm bookTypeAdd=new TypeAddIntFrm();
				bookTypeAdd.setVisible(true);
				table.add(bookTypeAdd);
			}
		});
		mnNewMenu_1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 21));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TypeManagerIntFrm tpMage=new TypeManagerIntFrm();
				tpMage.setVisible(true);
				table.add(tpMage);
			}
		});
		mnNewMenu_1.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 21));
		mnNewMenu.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 21));
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddIntFrm bookAdd=new BookAddIntFrm();
				bookAdd.setVisible(true);
				table.add(bookAdd);
			}
		});
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		menuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 21));
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManagerIntFrm bookManagerIntFrm=new BookManagerIntFrm();
				bookManagerIntFrm.setVisible(true);
				table.add(bookManagerIntFrm);
			}
		});
		menu_1.add(menuItem_4);
		
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
		
		JMenu menu_2 = new JMenu("\u8D26\u6237\u7BA1\u7406");
		menu_2.setFont(new Font("Dialog", Font.PLAIN, 21));
		mnNewMenu.add(menu_2);
		
		JMenuItem menuItem_6 = new JMenuItem("\u7BA1\u7406\u672C\u8D26\u6237");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateManagerInfo updateManagerInfo=new UpdateManagerInfo(userid);
				updateManagerInfo.setVisible(true);
			}
		});
		
		JMenuItem menuItem_9 = new JMenuItem("\u6DFB\u52A0\u7BA1\u7406\u5458");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LogInFrm logInFrm=new LogInFrm(1);
				logInFrm.setVisible(true);
			}
		});
		menuItem_9.setFont(new Font("Dialog", Font.PLAIN, 21));
		menu_2.add(menuItem_9);
		menuItem_6.setFont(new Font("Dialog", Font.PLAIN, 21));
		menu_2.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u7BA1\u7406\u666E\u901A\u7528\u6237");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageOtherUser manageOtherUser=new ManageOtherUser();
				manageOtherUser.setVisible(true);
				table.add(manageOtherUser);
			}
		});
		menuItem_7.setFont(new Font("Dialog", Font.PLAIN, 21));
		menu_2.add(menuItem_7);
		mnNewMenu.add(menuItem_5);
		
		JMenu menu_3 = new JMenu("\u56FE\u4E66\u501F\u552E");
		menu_3.setFont(new Font("Dialog", Font.PLAIN, 21));
		menuBar.add(menu_3);
		
		JMenuItem menuItem_10 = new JMenuItem("\u56FE\u4E66\u501F\u552E");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseBookIntFrm chooseBookIntFrm=new ChooseBookIntFrm(userid);
				chooseBookIntFrm.setVisible(true);
				table.add(chooseBookIntFrm);
			}
		});
		menuItem_10.setFont(new Font("Dialog", Font.PLAIN, 21));
		menu_3.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("\u501F\u4E66\u8BB0\u5F55");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetlendInfo getlendInfo=new GetlendInfo(userid);
				getlendInfo.setVisible(true);
				table.add(getlendInfo);
			}
		});
		menuItem_11.setFont(new Font("Dialog", Font.PLAIN, 21));
		menu_3.add(menuItem_11);
		
		JMenu menu = new JMenu("\u5173\u4E8E\u6211\u4EEC");
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
		
		JMenuItem menuItem_8 = new JMenuItem("\u5F53\u524D\u8D26\u53F7");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CurrentManagerID currentManagerID=new CurrentManagerID(userid);
				currentManagerID.setVisible(true);
				table.add(currentManagerID);
			}
		});
		menuItem_8.setFont(new Font("Dialog", Font.PLAIN, 21));
		menu.add(menuItem_8);
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
