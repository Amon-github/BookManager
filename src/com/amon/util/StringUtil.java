package com.amon.util;
/**
* @author Amon E-mail:248779716@qq.com
* @version ����ʱ�䣺2018��3��28�� ����7:51:37
* �ַ���������
*/
public class StringUtil {
	/**
	 * �ж��Ƿ�Ϊ��
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
	 * �ж��Ƿ�Ϊ��
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
	
}
