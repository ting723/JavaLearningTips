package com.zhanglw.tips.main;

import java.util.Date;

import com.zhanglw.tips.datetime.DateTimeTest;
import com.zhanglw.tips.exception.ExceptionTest;
import com.zhanglw.tips.string.StringTest;
import com.zhanglw.tips.threefinal.FinalThreeTest;

public class App {
	
	// λ���������
	//public static TestTips test = new BitTest();
	
	// �������ݶ���ֵ����
	//public static RefTest test = new RefTest();

//	public static StringTest test = new StringTest();
	
//	public static CloneTest test = new CloneTest();

//	public static ClassLoaderTest test= new ClassLoaderTest();

//	public static DateTimeTest test = new DateTimeTest();
//	public static FinalThreeTest test = new FinalThreeTest();
	public static ExceptionTest test = new ExceptionTest ();

	public static void main(String[] args) {
		System.out.println("ִ�п�ʼ");
		test.test();
		System.out.println("ִ�н���");
	}
}
