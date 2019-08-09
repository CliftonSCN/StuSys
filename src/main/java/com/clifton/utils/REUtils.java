package com.clifton.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Clifton
 * @date 2019年7月22日 下午5:06:26
 * @project jsj
 */
public class REUtils {

	/**
	 * 验证邮箱
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		// 邮箱验证规则
		String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
		// 编译正则表达式
		Pattern pattern = Pattern.compile(regEx);
		// 忽略大小写的写法
		// Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		// 字符串是否与正则表达式相匹配
		boolean rs = matcher.matches();
		return rs;
	}

	/**
	 * 验证手机
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str) {
		// 手机验证规则
		String regEx = "^[1](([3][0-9])|([4][5,7,9])|([5][0-9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";
		// 编译正则表达式
		Pattern pattern = Pattern.compile(regEx);
		// 忽略大小写的写法
		// Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		// 字符串是否与正则表达式相匹配
		boolean rs = matcher.matches();
		return rs;
	}

	/**
	 * 验证姓名
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isName(String str) {
		// 姓名验证规则
		String regEx = "^[A-Za-z][A-Za-z1-9_-]+$";
		// 编译正则表达式
		Pattern pattern = Pattern.compile(regEx);
		// 忽略大小写的写法
		// Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		// 字符串是否与正则表达式相匹配
		boolean rs = matcher.matches();
		return rs;
	}

}
