package com.amon.manager.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.RespectBinding;

import com.amon.Dao.BookDao;
import com.amon.Dao.BookTypeDao;
import com.amon.model.Book;
import com.amon.model.BookType;
import com.amon.util.DbUtil;
import com.amon.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
* @author Amon E-mail:248779716@qq.com
* @version ����ʱ�䣺2018��3��31�� ����11:34:39
* ͼ�����ά�����棨ͼ����޸ĺ�ɾ����
*/
public class BookManagerIntFrm extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField bookAuthorTxt;
	private JTable table;
	private JComboBox bookTypeJCB;
	private JComboBox bookTypeJCB2;
	private JTextArea bookDescArea2;
	private JRadioButton rdBtnWem;
	private JRadioButton rdBtnMan;
	
	private BookTypeDao bookTypeDao=new BookTypeDao();
	DbUtil dbUtil=new DbUtil();
	Connection con=null;
	private JTextField bookIDTxt2;
	private JTextField bookNameTxt2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField bookPriceTxt2;
	private JTextField bookAuthorTxt2;
	private JTextField keepRoom2;
	private JTextField bookCount2;
	private JTextField stocks2;


	/**
	 * Create the frame.
	 */
	public BookManagerIntFrm() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u7BA1\u7406");
		setBounds(100, 100, 658, 581);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 587, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel label_3 = new JLabel("\u7F16\u53F7\uFF1A");
		
		bookIDTxt2 = new JTextField();
		bookIDTxt2.setEditable(false);
		bookIDTxt2.setColumns(10);
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		bookNameTxt2 = new JTextField();
		bookNameTxt2.setColumns(10);
		
		JLabel label_5 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		 rdBtnMan = new JRadioButton("\u7537");
		buttonGroup.add(rdBtnMan);
		rdBtnMan.setSelected(true);
		
		 rdBtnWem = new JRadioButton("\u5973");
		buttonGroup.add(rdBtnWem);
		
		JLabel label_6 = new JLabel("\u4EF7\u683C\uFF1A");
		
		bookPriceTxt2 = new JTextField();
		bookPriceTxt2.setColumns(10);
		
		JLabel label_7 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		bookAuthorTxt2 = new JTextField();
		bookAuthorTxt2.setColumns(10);
		
		JLabel label_8 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		 bookTypeJCB2 = new JComboBox();
		
		JLabel label_9 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		 bookDescArea2 = new JTextArea();
			bookDescArea2.setText("4374");
		
		JButton button = new JButton("\u4FEE   \u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBookActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u5220   \u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBookActionPerformed(e);
			}
		});
		
		JLabel label_10 = new JLabel("\u85CF\u4E66\u79D1\u5BA4\uFF1A");
		
		keepRoom2 = new JTextField();
		keepRoom2.setColumns(10);
		
		JLabel label_11 = new JLabel("\u603B\u85CF\u4E66\u91CF\uFF1A");
		
		bookCount2 = new JTextField();
		bookCount2.setColumns(10);
		
		JLabel label_12 = new JLabel("\u5E93\u5B58\uFF1A");
		
		stocks2 = new JTextField();
		stocks2.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_9)
									.addGap(18)
									.addComponent(bookDescArea2))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(label_10)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(keepRoom2))
										.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
											.addComponent(label_6)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(bookPriceTxt2))
										.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
											.addComponent(label_3)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(bookIDTxt2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(19)
											.addComponent(label_4)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(bookNameTxt2, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(18)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(label_7)
												.addComponent(label_11))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(bookCount2, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
												.addComponent(bookAuthorTxt2))))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(label_5)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(rdBtnMan)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(rdBtnWem))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
												.addComponent(label_8)
												.addComponent(label_12))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(stocks2, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
												.addComponent(bookTypeJCB2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(48)
							.addComponent(button)
							.addGap(18)
							.addComponent(button_1)))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(bookIDTxt2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(bookNameTxt2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(rdBtnMan)
						.addComponent(rdBtnWem))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(bookPriceTxt2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(bookAuthorTxt2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(bookTypeJCB2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_10)
						.addComponent(keepRoom2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_11)
						.addComponent(bookCount2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(stocks2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_12))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(31)
							.addComponent(label_9))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(9)
							.addComponent(bookDescArea2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tableItemSelectAction(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"���", "ͼ������", "ͼ������", "�����Ա�", "ͼ��۸�", "�������", "�ܲ�����", "���", "ͼ�����", "ͼ������"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		bookAuthorTxt = new JTextField();
		bookAuthorTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		 bookTypeJCB = new JComboBox();
		
		JButton searchBtn = new JButton("\u67E5   \u8BE2");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBtnActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookAuthorTxt, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookTypeJCB, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(searchBtn)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchBtn)
						.addComponent(bookTypeJCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(label_1)
						.addComponent(bookAuthorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		bookTypeJCB.removeAllItems();
		bookTypeJCB2.removeAllItems();
		this.fillBookType(1);
		this.fillBookType(2);
		fillTable(new Book());
	}	
	
	
	/**
	 * �޸�ͼ�鰴ť�ļ����¼�
	 * @param e
	 */
	private void addBookActionPerformed(ActionEvent e) {
		String bookName=bookNameTxt2.getText();
		String authorName=bookAuthorTxt2.getText();
		String bookdesc=bookDescArea2.getText();
		int bookid=Integer.valueOf(bookIDTxt2.getText());
		String keepRoom=keepRoom2.getText();	//�ղؿ���
		
		
		try {
			if (StringUtil.isEmpty(bookName)) {
				JOptionPane.showMessageDialog(null, "ͼ�����Ʋ���Ϊ��");
				return;
			}else if (StringUtil.isEmpty(authorName)) {
				JOptionPane.showMessageDialog(null, "���߲���Ϊ��");
				return;
			}else if (StringUtil.isEmpty(bookPriceTxt2.getText())) {
				JOptionPane.showMessageDialog(null, "�۸���Ϊ��");
				return;
			}else if (!StringUtil.isNum(bookPriceTxt2.getText())) {
				JOptionPane.showMessageDialog(null, "�۸������������飡");
				return;
			}else if (!StringUtil.isNum(bookCount2.getText())) {
				JOptionPane.showMessageDialog(null, "�����������������飡");
				return;
			}else if (!StringUtil.isNum(stocks2.getText())) {
				JOptionPane.showMessageDialog(null, "��������������飡");
				return;
			}
			int bCount=Integer.valueOf(bookCount2.getText());	//������
			int bStocks=Integer.valueOf(stocks2.getText());	//���
			int priceInt=Integer.valueOf(bookPriceTxt2.getText());	//�۸�
			if (priceInt<0) {
				JOptionPane.showMessageDialog(null, "�۸���С��0�����飡");
				return;}
			 if (bCount<0) {
					JOptionPane.showMessageDialog(null, "����������С��0�����飡");
					return;}
			 if (bStocks<0) {
					JOptionPane.showMessageDialog(null, "��治��С��0�����飡");
					return;}
			
			String sex;
			int bookTypeid;
		
			if (rdBtnMan.isSelected()) {
				sex="��";
			} else {
				sex="Ů";
			}
			BookType bookType=(BookType)bookTypeJCB2.getSelectedItem();
			bookTypeid=bookType.getId();
			con=dbUtil.getConn();
			
			Book book=new Book(bookid,bookName,authorName,sex,priceInt,bookTypeid,bookdesc,keepRoom,bCount,bStocks);
			BookDao bookDao=new BookDao();
			int result=bookDao.updateBook(con, book);
			if (result==1) {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				resetValues();//��ձ�����
			} else {
				JOptionPane.showMessageDialog(null, "�޸�ʧ��");
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
	 * ɾ����ť����¼�
	 * @param e
	 */
	private void deleteBookActionPerformed(ActionEvent e) {
		try {
			con=dbUtil.getConn();
			int id=Integer.valueOf(bookIDTxt2.getText());
			BookDao bookDao=new BookDao();
			int result=bookDao.deleteBook(con, id);
			if (result==1) {
				resetValues();//��ձ�����
				bookTypeJCB2.removeAllItems();
				JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
			}else {
				JOptionPane.showMessageDialog(null, "ɾ��ʧ���أ�");
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
	 * �����ѡ���ʾ�� ��������
	 * @param e
	 */
	private void tableItemSelectAction(MouseEvent e) {
		int selectRow=table.getSelectedRow();
		int bookid=(int) table.getValueAt(selectRow, 0);	//��ȡ��ѡ�е�1�е����ݣ����ص���object����ǿתΪint
		String bookName=(String) table.getValueAt(selectRow, 1);//��ȡ��ѡ�е�2�е�����
		String bookAuthor=(String) table.getValueAt(selectRow, 2);//��ȡ��ѡ�е�3�е�����
		String authorSex=(String) table.getValueAt(selectRow, 3);
		String bookPrise=table.getValueAt(selectRow, 4)+"";
		String keepRoom=(String) table.getValueAt(selectRow, 5);
		String bCount=table.getValueAt(selectRow, 6)+"";
		String bStocks=table.getValueAt(selectRow, 7)+"";
		String bookTypeName=(String) table.getValueAt(selectRow, 8);	
		String bookDesc=(String) table.getValueAt(selectRow, 9);
		
		if ("��".equals(authorSex)) {
			rdBtnMan.setSelected(true);
		}else {
			rdBtnWem.setSelected(true);
		}
		bookIDTxt2.setText(bookid+"");
		bookNameTxt2.setText(bookName);
		bookAuthorTxt2.setText(bookAuthor);
		bookPriceTxt2.setText(bookPrise);
		bookDescArea2.setText(bookDesc);
		keepRoom2.setText(keepRoom);
		bookCount2.setText(bCount);
		stocks2.setText(bStocks);
		bookTypeJCB2.removeAllItems();
		fillBookType(2);
		int countItem=bookTypeJCB2.getItemCount();
		for (int i = 0; i < countItem; i++) {
			BookType item=(BookType) bookTypeJCB2.getItemAt(i);
			if (item.getTypeName().equals(bookTypeName)) {	//�������õı��ͼ���������ƣ�bookTypeName����ͬ�Ļ�
				bookTypeJCB2.setSelectedIndex(i);	//����������ѡ��Ϊ��������������һ��
			}
		}
		
		
	}

	/**
	 * ��ѯ��ť�����¼�
	 * @param e
	 */
	private void searchBtnActionPerformed(ActionEvent e) {
		try {
			BookType bookType=(BookType) bookTypeJCB.getSelectedItem();
			int typeid=bookType.getId();
			String bookName=bookNameTxt.getText();
			String bookAuthor=bookAuthorTxt.getText();
			Book book=new Book(bookName,bookAuthor,typeid);
			fillTable(book);
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
	 * �������ʾ����ͼ������
	 * @param book
	 */

	private void fillTable(Book book){
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);		//ÿ���������ǰ���������������
		try {
			BookDao bookDao=new BookDao();	
			con=dbUtil.getConn();
			ResultSet rSet=bookDao.selectBook(con, book);	
			while (rSet.next()) {
				Vector vector=new Vector();
				vector.add(rSet.getInt("id"));
				vector.add(rSet.getString("bookName"));
				vector.add(rSet.getString("author"));
				vector.add(rSet.getString("sex"));
				vector.add(rSet.getInt("price"));
				vector.add(rSet.getString("keeproom"));
				vector.add(rSet.getInt("count"));
				vector.add(rSet.getInt("Stocks"));
				vector.add(rSet.getString("bookTypeName"));
				vector.add(rSet.getString("bookDesc"));
				dtm.addRow(vector);
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

	}
	
	
	/**
	 * ��ʼ��ͼ�����������
	 */
	private void fillBookType(int type) {
		BookType bookType=null;
		try {
			con=dbUtil.getConn();
			ResultSet resultSet=bookTypeDao.list(con, new BookType());
			if (type==1) {
				bookType=new BookType();
				bookType.setTypeName("��ѡ��...");
				bookType.setId(-1);
				this.bookTypeJCB.addItem(bookType);
			}
			
			while (resultSet.next()) {
				bookType=new BookType();
				bookType.setId(resultSet.getInt("id"));
				bookType.setTypeName(resultSet.getString("bookTypeName"));
				if (type==1) {
					bookTypeJCB.addItem(bookType);	//��������ӵ������б��
				}else if (type==2) {
					bookTypeJCB2.addItem(bookType);
				}
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
	 * ������ձ�����������
	 */
	void resetValues(){
		this.fillTable(new Book());	
		bookIDTxt2.setText("");
		bookNameTxt2.setText("");
		bookAuthorTxt2.setText("");
		bookPriceTxt2.setText("");
		bookDescArea2.setText("");
	}
	
}
