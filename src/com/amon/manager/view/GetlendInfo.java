package com.amon.manager.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.amon.Dao.BookDao;
import com.amon.Dao.BorrowDao;
import com.amon.model.Book;
import com.amon.model.BorrowInfo;
import com.amon.util.DbUtil;
import com.amon.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
* @author "Amon"
* @version 创建时间：2018年4月13日 下午8:02:19
* 类说明
*/
public class GetlendInfo extends JInternalFrame {
	/**
	 * @version 创建时间：2018年4月14日 下午2:31:56
	 *
	 */
	private static final long serialVersionUID = -8879857971467349552L;
	private JTextField txtCard;
	private JTable table;
	Connection con;
	DbUtil dbUtil;
	private JTextField lendIDtxt;
	private JTextField lendCounttxt;
	private JTextField returnDatetxt;
	private JTextField managertxt;
	int userid;
	/**
	 * Create the frame.
	 */
	public GetlendInfo(int userid) {
		this.userid=userid;
		setTitle("\u501F\u51FA\u67E5\u8BE2");
		setClosable(true);
		setBounds(100, 100, 450, 450);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label = new JLabel("\u501F\u4E66\u5361\u53F7\uFF1A");
		
		txtCard = new JTextField();
		txtCard.setColumns(10);
		
		JButton selectBtn = new JButton("\u67E5  \u8BE2");
		selectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serchBookinfoBtn(e); 
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		JButton BtnSure = new JButton("\u64CD  \u4F5C");
		BtnSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateLendInfoBtn(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		
		JButton deleteLendInfo = new JButton("\u5220  \u9664");
		deleteLendInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteLendInfoBtn(e); 
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8BB0\u5F55\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCard, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(selectBtn)
							.addGap(77))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(BtnSure)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(deleteLendInfo)
							.addGap(133))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(txtCard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(selectBtn))
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(BtnSure)
						.addComponent(deleteLendInfo))
					.addContainerGap())
		);
		
		JLabel label_1 = new JLabel("\u501F\u4E66\u5355\u53F7\uFF1A");
		
		lendIDtxt = new JTextField();
		lendIDtxt.setEditable(false);
		lendIDtxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u501F\u4E66\u6570\u91CF\uFF1A");
		
		lendCounttxt = new JTextField();
		lendCounttxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8FD8\u4E66\u65E5\u671F\uFF1A");
		
		returnDatetxt = new JTextField();
		returnDatetxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5904 \u7406 \u5458\uFF1A");
		
		managertxt = new JTextField();
		managertxt.setEditable(false);
		managertxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lendIDtxt, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(returnDatetxt)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lendCounttxt, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(managertxt)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(lendIDtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(lendCounttxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(returnDatetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(managertxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
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
				"借书单号", "图书名字", "借书卡号", "借书日期", "借书数量", "处理员"
			}
		));
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		fillTable(new BorrowInfo());
	}
	



	/**
	 * 更新按钮
	 * @param e
	 * @throws Exception 
	 */
	private void updateLendInfoBtn(ActionEvent e) throws Exception {
		int selectRow=table.getSelectedRow();
		int id=(int) table.getValueAt(selectRow, 0);
		int bookid=Integer.valueOf((String) table.getValueAt(selectRow, 1));
		String cardID=(String) table.getValueAt(selectRow, 2);
		String lendDate=(String) table.getValueAt(selectRow, 3);
		int lendCou=(int) table.getValueAt(selectRow, 4);
		
		BorrowInfo borrowInfo=new BorrowInfo(id,bookid,cardID,userid,lendDate,lendCou);
		BorrowDao borrowDao=new BorrowDao();
		con=DbUtil.getConn();
		int result=borrowDao.updateBorrowInfo(con, borrowInfo);
		if (result==-1) {
			JOptionPane.showMessageDialog(null, "修改失败！");
		}else{
			fillTable(new BorrowInfo());
			JOptionPane.showMessageDialog(null, "修改成功");
			clearTXT();
		}
		
	}




	/**
	 * 删除按钮
	 * @param e
	 */
	private void deleteLendInfoBtn(ActionEvent e) {
		int r=JOptionPane.showConfirmDialog(null, "确定删除？");
		if (r!=0) {
			return;
		}
		
		try {
			con=DbUtil.getConn();
			int selectRow=table.getSelectedRow();
			int lendID=(int) table.getValueAt(selectRow, 0);
			BorrowInfo borrowInfo=new BorrowInfo(lendID,null);
			BorrowDao borrowDao=new BorrowDao();

			int result=borrowDao.deleteBorrowInfo(con, borrowInfo);
			if (result==-1) {
				JOptionPane.showMessageDialog(null, "删除失败");
			}else{
				fillTable(new BorrowInfo());
				JOptionPane.showMessageDialog(null, "删除成功");
				clearTXT();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}


	/**
	 * 点击table显示在下面表单中
	 * @param e
	 */
	private void tableItemSelectAction(MouseEvent e) {
		int selectRow=table.getSelectedRow();
		lendIDtxt.setText(table.getValueAt(selectRow, 0)+"");
		lendCounttxt.setText(table.getValueAt(selectRow, 4)+"");
		managertxt.setText((String) table.getValueAt(selectRow, 5));
	}
	
	

	/**
	 * 查询按钮
	 * @param e
	 */
	private void serchBookinfoBtn(ActionEvent e) {
		BorrowInfo bInfo=new BorrowInfo(txtCard.getText());
		fillTable(bInfo);
	}

	/**
	 * 将信息填充到table
	 * @param bInf
	 */
	private void fillTable(BorrowInfo bInf){
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);		//每次填充数据前，将表格的内容清空
		try {
			Book book=new Book(bInf.getBookid());
			BookDao bookDao=new BookDao();
			BorrowDao borrowDao=new BorrowDao();
			con=dbUtil.getConn();
			ResultSet rSetLend=borrowDao.selectBorrowInfo(con, bInf);	
			while (rSetLend.next()) {
				Vector vector=new Vector();
				vector.add(rSetLend.getInt("id"));
				vector.add(rSetLend.getString("bookid"));
				vector.add(rSetLend.getString("cardid"));
				vector.add(rSetLend.getString("borrowdate"));
				vector.add(rSetLend.getInt("lendcount"));
				vector.add(rSetLend.getString("managerid"));
				dtm.addRow(vector);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DbUtil.closeCon(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 输入框清空 
	 */
	void clearTXT(){
		returnDatetxt.setText("");
		lendIDtxt.setText("");
		lendCounttxt.setText("");
		managertxt.setText("");
	}
	
}
