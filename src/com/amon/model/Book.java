package com.amon.model;
/**
 * 图书实体类
 * @author Administrator
 *
 */
public class Book {
	private int id;
	private String name;
	private String author;	//作者
	private String authorSex;	//作者性别
	private int price;	//图书价格
	private Integer bookTypeId;	//外键，图书类型的ID
	private String bookTypeName;	//图书类型名称
	private String bookDesc;	//图书备注
	
	
	
	
	
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
