package com.zhanglw.tips.main;

import com.zhanglw.tips.classLoader.ClassLoaderTest;
import com.zhanglw.tips.clone.CloneTest;

public class App {
	
	// λ���������
	//public static TestTips test = new BitTest();
	
	// �������ݶ���ֵ����
	//public static RefTest test = new RefTest();

//	public static StringTest test = new StringTest();
	
//	public static CloneTest test = new CloneTest();

	public static ClassLoaderTest test= new ClassLoaderTest();
	public static void main(String[] args) {
		System.out.println("ִ�п�ʼ");
		test.test();
		System.out.println("ִ�н���");
	}
}
