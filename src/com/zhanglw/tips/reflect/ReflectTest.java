package com.zhanglw.tips.reflect;

import com.zhanglw.tips.base.TestTips;
/**
 * 
 * @author zhanglw
 * 1. ���һ�������ķ�ʽ��
 * 	  * ��.calss ��: String.class
 *    * ����.getClass  ��: "hell0".getClass()
 *    * Class.forName() ��: Class.forName("java.lang.String")
 * 2. ���䴴������
 * 	  * newInstance()���� ����: String.class.newInstance() 
 *    * ͨ��������getConstructor()��getDeclaredConstructor()������ù�������Constructor�����󲢵�����newInstance()������������
 *    	���磺String.class.getConstructor(String.class).newInstance("Hello");
 * 3. ͨ��������getDeclaredField()�����ֶ�(Field)���� ,
 * 		Ȼ����ͨ�����ֶζ����setAccessible(true)��������Ϊ���Է���,
 * 			�������Ϳ���ͨ��get/set��ȡ�������ֶε�ֵ�� 
 * 4. ������ö��󷽷�
 * 		String str = "hello";
 * 		Method m = str.getClass().getMethod("toUpperCase");
 *      System.out.println(m.invoke(str));  // HELLO
 */
public class ReflectTest implements TestTips {

	@Override
	public void test() {

		this.getClassMethod();
	}
	
	private void getClassMethod(){
		System.out.println(String.class);
		System.out.println("h3ll".getClass());
		try {
			System.out.println(Class.forName("com.zhanglw.tips.reflect.ReflectTest").getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
