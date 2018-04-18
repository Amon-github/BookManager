package com.amon.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
* @author "Amon"
* @version ����ʱ�䣺2018��4��18�� ����8:06:49
* �ļ�������
*/
public class FileUtil {
	static File file=new File("C:/bookManagerFile");
	
	
	
	/**
	 * �����ļ���
	 * @param fileName
	 * @return -1���ļ����ڣ�	 0:mkdirs()����ʧ��	1:�����ɹ�
	 */
	public static int createFile(){
		if (file.exists()) {
			return -1;
		}
		if (file.mkdirs()) {
			System.out.println("�����ļ��гɹ�");
			return 1;
		}else{
			System.out.println("�����ļ���ʧ��");
			return 0;
		}
	}
	
	
	/**
	 * �����ļ����ֻ�ȡ�ļ�����
	 * @param fileName	�ļ���
	 * @return	�ɹ��ļ�����   || -1���ı�������	||	-2���ı�����Ϊ��
	 */
	public static String getContext(String fileName){
		String result=null;
		FileReader fr = null;
		try {
			File file2=new File("C:/bookManagerFile/"+fileName+".txt");
			if (!file2.exists()) {
				return "-1";	//�ı�������
			}
			char[] cs=new char[(int) file2.length()];
			fr=new FileReader(file2);
			if (fr.read(cs)==-1) {
				return "-2";	//�ı�����Ϊ��
			}
			result=new String(cs);	//��char���鸳ֵ��result���
			
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		
		String  result=getContext("����");
		System.out.println(result);
		return;
	}
	
	
	

}
