package com.amon.model;
/**
 * ͼ��ʵ����
 * @author Administrator
 *
 */
public class Book {
	public String getKeeproom() {
		return keeproom;
	}
	public void setKeeproom(String keeproom) {
		this.keeproom = keeproom;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStocks() {
		return Stocks;
	}
	public void setStocks(int stocks) {
		Stocks = stocks;
	}
	private int id;
	private String name;
	private String author;	//����
	private String authorSex;	//�����Ա�
	private int price;	//ͼ��۸�
	private Integer bookTypeId;	//�����ͼ�����͵�ID
	private String bookTypeName;	//ͼ����������
	private String bookDesc;	//ͼ�鱸ע
	private String keeproom;	//������������
	private int count;	//��������
	private int Stocks;	//��棨�������ͼ���ʣ���������
	
	
	
	
	
	public Book(Integer bookTypeId) {
		super();
		this.bookTypeId = bookTypeId;
	}
	public Book(String name,String author, Integer bookTypeId) {
		super();
		this.author = author;
		this.bookTypeId = bookTypeId;
		this.name = name;
	}
	public Book() {
		super();
	}
	
	public Book(String name, String author, String authorSex, int price, Integer bookTypeId, String bookDesc,
			String keeproom, int count,int stocks) {
		super();
		this.name = name;
		this.author = author;
		this.authorSex = authorSex;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
		this.keeproom = keeproom;
		this.count = count;
		Stocks = stocks;
	}
	public Book(int id, String name, String author, String authorSex, int price, Integer bookTypeId, String bookDesc) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.authorSex = authorSex;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
	}
	public Book(int id,String name, String author, String authorSex, int price, Integer bookTypeId, String bookDesc,
			String keeproom, int count, int stocks) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.authorSex = authorSex;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
		this.keeproom = keeproom;
		this.count = count;
		Stocks = stocks;
	}
	public Book(String name, String author, String authorSex, int price, Integer bookTypeId, String bookDesc) {
		super();
		this.name = name;
		this.author = author;
		this.authorSex = authorSex;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
	}
	public Integer getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthorSex() {
		return authorSex;
	}
	public void setAuthorSex(String authorSex) {
		this.authorSex = authorSex;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
