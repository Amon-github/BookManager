package com.amon.model;
/**
* @author "Amon"
* @version 创建时间：2018年4月11日 下午7:21:24
* 借书记录Model
*/
public class BorrowInfo {
	private int id;
	private int bookid;
	private String cardid;
	private int managerid;
	private String borrowdate;
	private String returndate;
	private int lendcount;
	
	
	

	public BorrowInfo(int id, int bookid, String cardid, int managerid, String borrowdate, int lendcount) {
		super();
		this.id = id;
		this.bookid = bookid;
		this.cardid = cardid;
		this.managerid = managerid;
		this.borrowdate = borrowdate;
		this.lendcount = lendcount;
	}
	public BorrowInfo(String cardid) {
		super();
		this.cardid = cardid;
	}
	public BorrowInfo(int id,String cardid) {
		super();
		this.id = id;
		this.cardid = cardid;
	}
	public BorrowInfo( int bookid, String cardid, int managerid, String borrowdate, int lendcount) {
		super();
		this.bookid = bookid;
		this.cardid = cardid;
		this.managerid = managerid;
		this.borrowdate = borrowdate;
		this.lendcount = lendcount;
	}
	public BorrowInfo() {
		super();
	}
	
	public int getLendcount() {
		return lendcount;
	}
	public void setLendcount(int lendcount) {
		this.lendcount = lendcount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public String getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	
	
	
	

}
