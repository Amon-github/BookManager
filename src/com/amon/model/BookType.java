package com.amon.model;
/**
* @author Amon E-mail:248779716@qq.com
* @version ����ʱ�䣺2018��3��29�� ����7:29:25
* ͼ�����ʵ��
*/
public class BookType {
	public BookType(int id) {
		super();
		this.id = id;
	}

	private int  id;//���ͱ��
	private String typeName;//�������
	private String typeDesc;//��ע
	
	
	
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
