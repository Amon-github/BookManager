package com.amon.model;
/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年3月29日 下午7:29:25
* 图书类别实体
*/
public class BookType {
	public BookType(int id) {
		super();
		this.id = id;
	}

	private int  id;//类型编号
	private String typeName;//类别名称
	private String typeDesc;//备注
	
	
	
	public BookType(String typeName) {
		super();
		this.typeName = typeName;
	}

	public BookType(String typeName, String typeDesc) {
		super();
		this.typeName = typeName;
		this.typeDesc = typeDesc;
	}
	
	public BookType() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	@Override
	public String toString() {
		return getTypeName();
	}
	
	
}
