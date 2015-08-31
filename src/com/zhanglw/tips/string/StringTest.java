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

		System.out.println("�ַ�����������������໥ת��");
		
		int x = 2;
		String y = "2";
		System.out.println("������������ת�����ַ���");
		System.out.println("ͨ������ַ������"+x+"");
		System.out.println("ͨ��String��valueOf����"+String.valueOf(x));
		
		System.out.println("�ַ���ת������������");
		System.out.println("ʹ�ö�Ӧ�İ�װ���valueof����"+Integer.valueOf(y));
		System.out.println("ʹ�ö�Ӧ�İ�װ���parseXxx����"+Integer.parseInt(y));
		
		
		System.out.println("��ת�ַ���");
		String testStr = "You are my Honey!";
		System.out.println("ԭ�ַ�:"+testStr+"\n��ת����ַ�:"+ this.reverse(testStr));
		
		
		System.out.println("����ת��");
		String code = "����ת��";
		String newCode = null;
		try {
			newCode = new String(code.getBytes("GBK"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("ԭ����:"+code+"\t�ֱ���"+newCode);
	}
	
	private String reverse(String oringe){
		if(oringe==null||oringe.length()<=1)
			return oringe;
		return reverse(oringe.substring(1))+oringe.charAt(0);
	}
}
