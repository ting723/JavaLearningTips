package com.zhanglw.tips.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zhanglw.tips.base.TestTips;
/**
 * 
 * @author zhanglw
 * 正则表达式:
 * 	 用于描述匹配字符串规则的工具,记录文本规则的代码
 * Java String 提供的方法： matches()、replaceAll()、replaceFirst()、split()等
 * Pattern类表示正则表达式对象
 */
public class RegexTest implements TestTips{

	@Override
	public void test() {
		
		String str = "北京市(朝阳区)(西城区)(海淀区)";
        Pattern p = Pattern.compile(".*?(?=\\()");//(?=\() 分组  ?=exp 匹配exp前面的位置   .*? 懒惰匹配: 尽可能少的匹配 
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }
	}

}
