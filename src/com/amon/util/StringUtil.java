package com.amon.util;
/**
* @author Amon E-mail:248779716@qq.com
* @version 创建时间：2018年3月28日 下午7:51:37
* 字符串工具类
*/
public class StringUtil {
	
	
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if (str==null||"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 判断是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if (str!=null&&!"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * 判断是不是数字
	 * @param str
	 * @return
	 */
	public static boolean isNum(String str){
	    for(int i=str.length();--i>=0;){
	        int chr=str.charAt(i);
	        if(chr<48 || chr>57)
	            return false;
	    }
			return true;
	}
	
	
	
}
