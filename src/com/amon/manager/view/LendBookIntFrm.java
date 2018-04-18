package com.amon.manager.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.amon.Dao.BookDao;
import com.amon.Dao.BorrowDao;
import com.amon.model.Book;
import com.amon.model.BorrowInfo;
import com.amon.util.DbUtil;
import com.amon.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author "Amon"
 * @version 创建时间：2018年4月11日 下午7:42:35 
 * 图书出借信息填写和提交界面
 */
public class LendBookIntFrm extends JInternalFrame {
	private JTextField bookId;
	private JTextField bookName;
	private JTextField cardid;
	private JTextField managerid;
	private JTextField borrowdate;
	private JTextField lendCount;
	int book_id; // 从图书搜索界面传过来的图书ID
	BorrowInfo borrowInfo;
	int bookIdbyGet = -1; // 根据传过来的ID得到的图书对象的ID
	String bookNamebyGet = null; // 根据传过来的ID得到的图书对象的图书名字
	Connection con = null;
	int userid;
	Book book=new Book();
	BookDao bookDao;

	


	/**
	 * Create the frame.
	 */
	public LendBookIntFrm(int book_id,int userid) {
		this.book_id = book_id;
		this.userid=userid;
		
		setTitle("\u501F\u552E\u4FE1\u606F");
		setClosable(true);
		setBounds(100, 100, 450, 363);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\u4FE1\u606F\u586B\u5199", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE));

		JLabel label = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");

		bookId = new JTextField();
		bookId.setEditable(false);
		bookId.setColumns(10);

		JLabel label_1 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");

		bookName = new JTextField();
		bookName.setEditable(false);
		bookName.setColumns(10);

		JLabel label_2 = new JLabel("\u501F\u552E\u5361\u53F7\uFF1A");

		cardid = new JTextField();
		cardid.setColumns(10);

		JLabel label_3 = new JLabel("\u5904 \u7406 \u5458\uFF1A");

		managerid = new JTextField();
		managerid.setEditable(false);
		managerid.setColumns(10);

		JLabel label_4 = new JLabel("\u51FA\u5E93\u65E5\u671F\uFF1A");

		borrowdate = new JTextField();
		borrowdate.setColumns(10);

		JLabel label_5 = new JLabel("\u501F\u4E66\u6570\u91CF\uFF1A");

		lendCount = new JTextField();
		lendCount.setText("1");
		lendCount.setColumns(10);

		JButton button = new JButton("\u786E   \u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lendBookIntFrmAction(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(borrowdate))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cardid))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookId, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
							.addGap(28)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookName, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(managerid))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lendCount)))
							.addGap(33))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(button)
							.addGap(168))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(bookId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(cardid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(managerid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(borrowdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(lendCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(57))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		try {
			initializeData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 出借按钮监听事件
	 * 
	 * @param e
	 * @throws Exception
	 */
	void lendBookIntFrmAction(ActionEvent e) throws Exception {
		String lendCard = cardid.getText();
		int managerId = Integer.valueOf(managerid.getText());
		String lendDate = borrowdate.getText();
		int lendCou = Integer.valueOf(lendCount.getText()); 
		if (StringUtil.isEmpty(lendCard)||StringUtil.isEmpty(lendDate)) {
			JOptionPane.showMessageDialog(null, "借书卡号和借书日记都不能为空！");
			return;
		}
		if (lendCou<=0) {
			JOptionPane.showMessageDialog(null, "数量有误，请检查！");
			return;
		}
		BorrowInfo binfo = new BorrowInfo(book_id, lendCard, managerId, lendDate, lendCou);
		BorrowDao borrowDao = new BorrowDao();
		con = DbUtil.getConn();
		int addResult = borrowDao.addBorrowInfo(con, binfo);
		if (addResult != 1) {
			JOptionPane.showMessageDialog(null, "操作失败！");
			return;
			}else{
				 bookDao=new BookDao();
				 ResultSet resultSet=bookDao.selectBookByID(con, book_id);
				 while (resultSet.next()) {
					 book.setId(book_id);
					book.setStocks(resultSet.getInt("Stocks")-lendCou);
				}
				 int restult=bookDao.updateBookStocks(con, book);
				 if (restult!=1) {
					 JOptionPane.showMessageDialog(null, "操作失败！");
						return;
				}
				 JOptionPane.showMessageDialog(null, "操作成功！");
				 dispose();
		}
	}

	/**
	 * 初始化界面
	 * 
	 * @throws Exception
	 */
	void initializeData() throws Exception {
		Connection con = DbUtil.getConn();
		BookDao bookDao = new BookDao();
		ResultSet rs = bookDao.selectBookByID(con, book_id);

		while (rs.next()) {
			bookIdbyGet = rs.getInt("id");
			bookNamebyGet = rs.getString("bookName");
		}
		this.bookId.setText(bookIdbyGet + "");
		this.bookName.setText(bookNamebyGet);
		managerid.setText(userid+"");

	}

}
