package com.amon.manager.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.amon.Dao.BookDao;
import com.amon.Dao.BookTypeDao;
import com.amon.model.Book;
import com.amon.model.BookType;
import com.amon.util.DbUtil;
import com.amon.util.StringUtil;

import javax.swing.JRadioButton;
import java.awt.TextArea;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.security.cert.PKIXRevocationChecker.Option;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

/**
 * @author Amon E-mail:248779716@qq.com
 * @version 创建时间：2018年3月30日 上午11:30:17 
 * 图书添加界面
 */
public class BookAddIntFrm extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JTextField bookPriceTxt;
	private JTextArea descArea;
	private JComboBox bookTypeJcb;
	private JRadioButton rdBtnWeman;
	private JRadioButton rdBtnMan;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private Connection con=null;
	private JTextField keepRoom;
	private JTextField bookCount;


	/**
	 * Create the frame.
	 */
	public BookAddIntFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBounds(100, 100, 486, 399);

		JLabel label = new JLabel("\u56FE\u4E66\u540D\u5B57\uFF1A");

		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);

		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");

		authorTxt = new JTextField();
		authorTxt.setColumns(10);

		JLabel label_2 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");

		 rdBtnMan = new JRadioButton("\u7537");
		rdBtnMan.setSelected(true);
		buttonGroup.add(rdBtnMan);

		 rdBtnWeman = new JRadioButton("\u5973");
		buttonGroup.add(rdBtnWeman);

		JLabel label_3 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");

		bookPriceTxt = new JTextField();
		bookPriceTxt.setText("20");
		bookPriceTxt.setColumns(10);

		JLabel label_4 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");

		JLabel label_5 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");

		descArea = new JTextArea();
		descArea.setText("66516516");

		JButton addBookBtn = new JButton("\u6DFB\u52A0");
		addBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});

		JButton resetBtn = new JButton("\u91CD\u7F6E");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValuesActionPerformed(e);
			}
		});

		 bookTypeJcb = new JComboBox();
		
		JLabel label_6 = new JLabel("\u85CF\u4E66\u79D1\u5BA4\uFF1A");
		
		keepRoom = new JTextField();
		keepRoom.setColumns(10);
		
		JLabel label_7 = new JLabel("\u85CF\u4E66\u603B\u91CF\uFF1A");
		
		bookCount = new JTextField();
		bookCount.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(130, Short.MAX_VALUE)
					.addComponent(addBookBtn)
					.addGap(57)
					.addComponent(resetBtn)
					.addGap(169))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(95)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(keepRoom, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(label_5)
											.addComponent(label_4))
										.addGap(4)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(descArea, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
											.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(label_7)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(label_2)
												.addGap(1)
												.addComponent(rdBtnMan)
												.addGap(2)
												.addComponent(rdBtnWeman)
												.addGap(18)
												.addComponent(label_3)))
										.addGap(10)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(bookCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(bookPriceTxt))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(label)
									.addGap(5)
									.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
							.addGap(84))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(label_2))
								.addComponent(rdBtnMan)
								.addComponent(rdBtnWeman)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(label_3)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(label_4))
								.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(bookPriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(keepRoom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(bookCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(descArea, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetBtn)
						.addComponent(addBookBtn))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		fillBookType();	//下拉列表框初始化
	}

	/**
	 * 图书添加按钮的监听事件
	 * @param e
	 */
	protected void bookAddActionPerformed(ActionEvent e) {
		String bookName=bookNameTxt.getText();//图书名称
		String authorName=authorTxt.getText();//作者
		String price=bookPriceTxt.getText();	//图书价格
		String bookdesc=descArea.getText();	//图书备注
		String sex=null;//作者性别
		String booksCount=bookCount.getText();	//藏书数量
		String kRoom=keepRoom.getText();
		int typeid;
		if (StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "书名不能为空");
			return;
		} else if (StringUtil.isEmpty(authorName)) {
			JOptionPane.showMessageDialog(null, "作者不能为空");
			return;
		} else if (StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "价格不能为空");
			return;
		} else if (StringUtil.isEmpty(kRoom)) {
			JOptionPane.showMessageDialog(null, "藏书科室不能为空");
			return;
		} else if (!StringUtil.isNum(price)) {
			JOptionPane.showMessageDialog(null, "价格输入有误，请检查！");
			return;
		}else if (!StringUtil.isNum(booksCount)) {
			JOptionPane.showMessageDialog(null, "藏书数量输入有误，请检查！");
			return;
		}
		int priceInt=Integer.valueOf(price);	//将String类型的价格转换为int
		int bCount=Integer.valueOf(booksCount);	//将String类型的藏书量转换为int
		if (bCount<0) {
			JOptionPane.showMessageDialog(null, "藏书数量不能小于0，请检查！");
			return;}
		if (priceInt<0) {
			JOptionPane.showMessageDialog(null, "价格不能小于0，请检查！");
			return;}
		
		
		
		if (rdBtnMan.isSelected()) {
			sex="男";
		} else {
			sex="女";
		}
		BookType bookType=(BookType)bookTypeJcb.getSelectedItem();
		typeid=bookType.getId();
		
			try {
				con=dbUtil.getConn();
				Book book=new Book(bookName,authorName,sex,priceInt,typeid,bookdesc,kRoom,bCount,bCount);
				
				BookDao bookDao=new BookDao();
				int result=bookDao.addBook(con, book);
				if (result==1) {
					JOptionPane.showMessageDialog(null, "添加成功");
					resetValues();
					
					
				} else {
					JOptionPane.showMessageDialog(null, "添加失败");
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
	 * 初始化图书类别下拉框
	 */
	private void fillBookType() {
		BookType bookType=null;
		bookTypeJcb.removeAllItems();
		try {
			con=dbUtil.getConn();
			ResultSet resultSet=bookTypeDao.list(con, new BookType());
			while (resultSet.next()) {
				bookType=new BookType();
				bookType.setId(resultSet.getInt("id"));
				bookType.setTypeName(resultSet.getString("bookTypeName"));
				bookTypeJcb.addItem(bookType);	//将对象添加到下拉列表框
			}
			
		} catch (Exception e) {
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

	
	
	/**
	 * 重置按钮的监听事件
	 * 
	 * @param e
	 */
	private void resetValuesActionPerformed(ActionEvent e) {
		resetValues();
	}
	
	/**
	 *重置数据 
	 */
	void resetValues(){
		bookNameTxt.setText("");
		authorTxt.setText("");
		bookPriceTxt.setText("");
		descArea.setText("");
		fillBookType();	//下拉列表框初始化
	}
}
