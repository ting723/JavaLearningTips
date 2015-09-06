package com.zhanglw.tips.reflect;

import com.zhanglw.tips.base.TestTips;
/**
 * 
 * @author zhanglw
 * 1. 获得一个类对象的方式：
 * 	  * 类.calss 如: String.class
 *    * 对象.getClass  如: "hell0".getClass()
 *    * Class.forName() 如: Class.forName("java.lang.String")
 * 2. 反射创建对象
 * 	  * newInstance()方法 例如: String.class.newInstance() 
 *    * 通过类对象的getConstructor()或getDeclaredConstructor()方法获得构造器（Constructor）对象并调用其newInstance()方法创建对象，
 *    	例如：String.class.getConstructor(String.class).newInstance("Hello");
 * 3. 通过类对象的getDeclaredField()方法字段(Field)对象 ,
 * 		然后在通过将字段对象的setAccessible(true)将其设置为可以访问,
 * 			接下来就可以通过get/set获取或设置字段的值了 
 * 4. 反射调用对象方法
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
