package com.zhanglw.tips.string;

import java.io.UnsupportedEncodingException;

import com.zhanglw.tips.base.TestTips;

public class StringTest implements TestTips{

	@Override
	public void test() {
		
		String s1 = "Programming";
		String s2 = new String("Programming");
		String s3 = "Program"+"ming";
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1==s2.intern());

		System.out.println("字符串与基本数据类型相互转换");
		
		int x = 2;
		String y = "2";
		System.out.println("基本数据类型转换成字符串");
		System.out.println("通过与空字符串相加"+x+"");
		System.out.println("通过String的valueOf方法"+String.valueOf(x));
		
		System.out.println("字符串转基本数据类型");
		System.out.println("使用对应的包装类的valueof方法"+Integer.valueOf(y));
		System.out.println("使用对应的包装类的parseXxx方法"+Integer.parseInt(y));
		
		
		System.out.println("反转字符串");
		String testStr = "You are my Honey!";
		System.out.println("原字符:"+testStr+"\n反转后的字符:"+ this.reverse(testStr));
		
		
		System.out.println("编码转换");
		String code = "编码转换";
		String newCode = null;
		try {
			newCode = new String(code.getBytes("GBK"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("原编码:"+code+"\t现编码"+newCode);
	}
	
	private String reverse(String oringe){
		if(oringe==null||oringe.length()<=1)
			return oringe;
		return reverse(oringe.substring(1))+oringe.charAt(0);
	}
}
