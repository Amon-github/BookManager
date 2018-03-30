package com.amon.view;

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

/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年3月29日 下午5:00:30
* 类说明
*/
public class HomeView extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView frame = new HomeView();
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
	public HomeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem menuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAdd bookTypeAdd=new BookTypeAdd();
				bookTypeAdd.setVisible(true);
				table.add(bookTypeAdd);
			}
		});
		mnNewMenu_1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TypeManagerIntFrm tpMage=new TypeManagerIntFrm();
				tpMage.setVisible(true);
				table.add(tpMage);
			}
		});
		mnNewMenu_1.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出");
				if (result==0) {
					dispose();
				}
			}
		});
		mnNewMenu.add(menuItem_5);
		
		JMenu menu = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menuBar.add(menu);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutMeIntFrm aboutMeIntFrm=new AboutMeIntFrm(); 
				aboutMeIntFrm.setVisible(true);
				table.add(aboutMeIntFrm); 
			}
		});
		menu.add(menuItem_2);
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
