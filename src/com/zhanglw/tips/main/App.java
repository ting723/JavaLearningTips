package com.zhanglw.tips.main;

import com.zhanglw.tips.thread.ThreadTest;

public class App {

	// 位运算测试类
	// public static TestTips test = new BitTest();

	// 参数传递都是值传递
	// public static RefTest test = new RefTest();

	// public static StringTest test = new StringTest();

	// public static CloneTest test = new CloneTest();

	// public static ClassLoaderTest test= new ClassLoaderTest();

	// public static DateTimeTest test = new DateTimeTest();

	// public static FinalThreeTest test = new FinalThreeTest();

	// public static ExceptionTest test = new ExceptionTest ();

	public static ThreadTest test = new ThreadTest();

	public static void main(String[] args) {
		System.out.println("执行开始");
		test.test();
		System.out.println("执行结束");
	}
}
