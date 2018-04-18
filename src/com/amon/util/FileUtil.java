package com.amon.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
* @author "Amon"
* @version 创建时间：2018年4月18日 上午8:06:49
* 文件操作类
*/
public class FileUtil {
	static File file=new File("C:/bookManagerFile");
	
	
	
	/**
	 * 创建文件夹
	 * @param fileName
	 * @return -1：文件存在；	 0:mkdirs()创建失败	1:创建成功
	 */
	public static int createFile(){
		if (file.exists()) {
			return -1;
		}
		if (file.mkdirs()) {
			System.out.println("创建文件夹成功");
			return 1;
		}else{
			System.out.println("创建文件夹失败");
			return 0;
		}
	}
	
	
	/**
	 * 根据文件名字获取文件内容
	 * @param fileName	文件名
	 * @return	成功文件内容   || -1：文本不存在	||	-2：文本内容为空
	 */
	public static String getContext(String fileName){
		String result=null;
		FileReader fr = null;
		try {
			File file2=new File("C:/bookManagerFile/"+fileName+".txt");
			if (!file2.exists()) {
				return "-1";	//文本不存在
			}
			char[] cs=new char[(int) file2.length()];
			fr=new FileReader(file2);
			if (fr.read(cs)==-1) {
				return "-2";	//文本内容为空
			}
			result=new String(cs);	//将char数组赋值给result结果
			
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		
		String  result=getContext("体育");
		System.out.println(result);
		return;
	}
	
	
	

}
