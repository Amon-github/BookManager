package com.amon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.amon.manager.view.LogOnFrm;

/**
* @author Amon E-mail:248779716@qq.com
* @version ����ʱ�䣺2018��4��3�� ����3:41:36
* ��˵��
*/
public class BookManagerMain {

	public static void main(String[] args) {
		new DbUtil().buildUpDb();	//�������ݿ�����ݱ�
		//�򿪵�¼����
		LogOnFrm logOnFrm=new LogOnFrm();
		logOnFrm.setVisible(true);

	}
}
