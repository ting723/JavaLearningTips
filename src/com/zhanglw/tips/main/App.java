package com.zhanglw.tips.main;

import java.nio.channels.ServerSocketChannel;

import com.zhanglw.tips.stream.EchoClientNIO;
import com.zhanglw.tips.stream.EchoClientTest;
import com.zhanglw.tips.stream.EchoServerTest;
import com.zhanglw.tips.stream.ListFileTest;

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

	// public static ThreadTest test = new ThreadTest();

	// public static MulitiThreadTest test = new MulitiThreadTest ();

	// public static CallableTest test = new CallableTest();

	// public static StreamTest test = new StreamTest();

	// public static ListFileTest test = new ListFileTest();

	// public static EchoClientTest test = new EchoClientTest();

	 public static EchoClientNIO test = new EchoClientNIO ();
	public static void main(String[] args) {
		System.out.println("---------执行开始---------");
		test.test();
		System.out.println("---------执行结束---------");
	}
}
