package com.zhanglw.tips.main;

import com.zhanglw.tips.thread.ThreadTest;

public class App {

	// λ���������
	// public static TestTips test = new BitTest();

	// �������ݶ���ֵ����
	// public static RefTest test = new RefTest();

	// public static StringTest test = new StringTest();

	// public static CloneTest test = new CloneTest();

	// public static ClassLoaderTest test= new ClassLoaderTest();

	// public static DateTimeTest test = new DateTimeTest();

	// public static FinalThreeTest test = new FinalThreeTest();

	// public static ExceptionTest test = new ExceptionTest ();

	public static ThreadTest test = new ThreadTest();

	public static void main(String[] args) {
		System.out.println("ִ�п�ʼ");
		test.test();
		System.out.println("ִ�н���");
	}
}
