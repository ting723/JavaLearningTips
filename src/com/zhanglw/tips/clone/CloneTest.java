package com.zhanglw.tips.clone;

import com.zhanglw.tips.base.TestTips;

/**
 *如何实现对象克隆？
 * 1). 实现Cloneable接口并重写Object类中的clone()方法；
 * 2). 实现Serializable接口，通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆，代码如下。 
 * @author zhanglw
 *
 */
public class CloneTest implements TestTips {

	@Override
	public void test() {

		try {
            Person p1 = new Person("Hao LUO", 33, new Car("Benz", 300));
            //浅克隆和深克隆都对基本类型数据进行原值克隆,(包含String)
            //继承Cloneable,重写Object的clone()方法,浅克隆,只克隆自身以及包含的所有对象的引用地址
            Person p2 = (Person)p1.clone();
            p2.setName("ZhangLw");
            p2.setAge(35);
            p2.getCar().setBrand("Vol");;
            //使用序列化进行深度克隆,克隆除自身以外所有对象,包含自身所含有的所有对象
            Person p3 = MyUtil.clone(p1);   // 深度克隆
            p3.getCar().setBrand("BYD");
            // 修改克隆的Person对象p2关联的汽车对象的品牌属性
            // 原来的Person对象p1关联的汽车不会受到任何影响
            // 因为在克隆Person对象时其关联的汽车对象也被克隆了
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
