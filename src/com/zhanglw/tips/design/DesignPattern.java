package com.zhanglw.tips.design;

import com.zhanglw.tips.base.TestTips;
/**
 * 
 * @author zhanglw
 * 面向对象的六原则一法则
 * 	1. 单一职责原则  	  一个类只做它该做的事情
 * 	2. 开闭原则		 对扩展开放,对修改关闭
 * 	3. 依赖倒转原则  	 面向接口编程
 *  4. 里氏替换原则	任何时候都可以用子类型替换父类型
 *  5. 接口隔离原则 	接口要小而专,绝不能大而全
 *  6. 合成聚合复用原则   优先使用聚合或合成关系复用代码
 *  7. 迪米特法则		一个对象应当对其他对象有尽可能少的了解 
 * 设计模式分类
 * 	1. 创建型: 单例模式,建造者模式,工厂方法模式,原始模型模式,单例模式,门面模式
 */
public class DesignPattern implements TestTips{

	@Override
	public void test() {
		

	}

}

class Singleton{
	private final static Singleton singleton = new Singleton();
	
	private  Singleton(){
	}
	
	public static Singleton getInstance(){
		return singleton;
	}
}