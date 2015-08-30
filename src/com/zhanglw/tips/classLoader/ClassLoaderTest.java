package com.zhanglw.tips.classLoader;

import java.util.Date;

import com.zhanglw.tips.base.TestTips;
/**
 * 1.ִ�о�̬�����;�̬��(����˭��ǰ��ִ��˭,ͬ�Ǿ�̬��Ǿ�̬�ı����Ϳ�˭��ǰ,��ִ��˭)
 * 2.����ľ�̬�����;�̬��
 * 3.ִ�и���ķǾ�̬�����;�̬��
 * 4.ִ�и���Ĺ��췽��
 * 5.ִ������ķǾ�̬�����;�̬��
 * 5.ִ������Ĺ��췽��
 * @author zhanglw
 *
 */
public class ClassLoaderTest implements TestTips {

	
	private String variable = "Str1";
	
	private Date dat= new Date();
	private int x = 9;

	{
		System.out.println("ִ�зǾ�̬��");
	}
	
	private static String staticVariable = "AB";
	
	private static Date date = new Date();
	
	private static int y = 8;
	static{
		if(y==8) System.out.println("��ʼ����̬int����"); 
		if(staticVariable!=null) System.out.println("��ʼ����̬String����");
		if(date!=null) System.out.println("��ʼ����̬Date����");
		System.out.println("ִ�о�̬��");
	}

	public ClassLoaderTest() {
		if(this.x==9) System.out.println("��ʼ��int����"); 
		if(this.variable.equals("Str1")) System.out.println("��ʼ��String����");
		if(this.dat!=null) System.out.println("��ʼ��Date����");
		System.out.println("ִ���޲ι��췽��");
		System.out.println(staticVariable);
	}
	
	public static void staticMethod(){
		System.out.println("ִ�о�̬����");
	}
	@Override
	public void test() {
		
		System.out.println("ִ��˽�з���");
	}
}