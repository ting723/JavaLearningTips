package com.zhanglw.tips.classLoader;

import java.util.Date;

import com.zhanglw.tips.base.TestTips;
/**
 * 1.执行静态变量和静态块(两者谁在前先执行谁,同是静态或非静态的变量和块谁在前,先执行谁)
 * 2.父类的静态变量和静态块
 * 3.执行父类的非静态变量和静态块
 * 4.执行父类的构造方法
 * 5.执行子类的非静态变量和静态块
 * 5.执行子类的构造方法
 * @author zhanglw
 *
 */
public class ClassLoaderTest implements TestTips {

	
	private String variable = "Str1";
	
	private Date dat= new Date();
	private int x = 9;

	{
		System.out.println("执行非静态块");
	}
	
	private static String staticVariable = "AB";
	
	private static Date date = new Date();
	
	private static int y = 8;
	static{
		if(y==8) System.out.println("初始化静态int变量"); 
		if(staticVariable!=null) System.out.println("初始化静态String变量");
		if(date!=null) System.out.println("初始化静态Date对象");
		System.out.println("执行静态块");
	}

	public ClassLoaderTest() {
		if(this.x==9) System.out.println("初始化int变量"); 
		if(this.variable.equals("Str1")) System.out.println("初始化String变量");
		if(this.dat!=null) System.out.println("初始化Date对象");
		System.out.println("执行无参构造方法");
		System.out.println(staticVariable);
	}
	
	public static void staticMethod(){
		System.out.println("执行静态方法");
	}
	@Override
	public void test() {
		
		System.out.println("执行私有方法");
	}
}