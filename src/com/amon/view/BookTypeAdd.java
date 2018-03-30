package com.amon.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.amon.Dao.BookTypeDao;
import com.amon.model.BookType;
import com.amon.util.DbUtil;
import com.amon.util.StringUtil;
import com.mysql.jdbc.Util;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年3月29日 下午7:41:10
* 类说明
*/
public class BookTypeAdd extends JInternalFrame {
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAdd frame = new BookTypeAdd();
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
	public BookTypeAdd() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		 bookTypeDescTar = new JTextArea();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(112)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(button_1)
							.addGap(82))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(79)
							.addComponent(label_1)
							.addGap(18)
							.addComponent(bookTypeDescTar, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(79)
							.addComponent(label)
							.addGap(18)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bookTypeDescTar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(24))
		);
		getContentPane().setLayout(groupLayout);
	}

	/**
	 * 添加图书类别按钮的事件
	 * @param e
	 */
	protected void addActionPerformed(ActionEvent e) {
		String typeTxt=bookTypeNameTxt.getText();
		String typeDesc=bookTypeDescTar.getText();
		BookType bookType=new BookType(typeTxt,typeDesc);
		BookTypeDao bookTypeDao=new BookTypeDao();
		
		if (StringUtil.isEmpty(typeTxt)) {
			JOptionPane.showMessageDialog(null, "图书类型名称不能为空");
			return;
		}else if (StringUtil.isEmpty(typeDesc)) {
			JOptionPane.showMessageDialog(null, "图书类型描述不能为空");
			return;
		}
		try {
			Connection con=DbUtil.getConn();
			if (bookTypeDao.add(con, bookType)==1) {
				JOptionPane.showMessageDialog(null, "成功添加一条数据");
				resetValue();
			}else {
				resetValue();
				JOptionPane.showMessageDialog(null, "添加失败");
			}
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
	}

	
	/**
	 * 重置按钮的点击事件
	 * @param event
	 */
	protected void resetActionPerformed(ActionEvent event) {
		resetValue();
	}
	
	
	
	/**
	 * 重置输入框
	 * @param event
	 */
	protected void resetValue() {
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTar.setText("");
		
	}
}
