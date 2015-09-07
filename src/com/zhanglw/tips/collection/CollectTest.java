package com.zhanglw.tips.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.zhanglw.tips.base.TestTips;

public class CollectTest<K,V>  implements TestTips{

	//没有继承任何类
	@SuppressWarnings("unused")
	private Map<K,V> map = new HashMap<>();
	
	//继承自Collection<E>  线性容器,按数值索引访问元素
	@SuppressWarnings("unused")
	private List<K> list = new ArrayList<>();
	
	//继承自Collection<E>  存储零散且不重复的元素
	@SuppressWarnings("unused")
	private Set<V> set = new HashSet<>();
	
	/**
	 * ArrayList和Vector 都是使用数组方式存储数据
	 * ArrayList 查询快，插入删除慢
	 * Vector 中的方法添加了synchronized 修饰,性能较差,是遗留容器
	 * LinkedList 使用了双向链表实现存储,比数组存储方法相比,利用率更高,插入时,只需要记录本项的前后项即可,故插入更快
	 * Java遗留容器有: Vector,Hashtable,Dictionary,BitSet,Stack,Properties ，不推荐使用
	 * ArrayList和LinkedList 是非线程安全的, 在多线程情况下,可以通过Collections的synchronizedList方法转换
	 */
	private LinkedList<String> linkedList = new LinkedList<>();
	
	@Override
	public void test(){
		Collections.synchronizedList(linkedList).add("AB");//使用了装饰模式
		
		Set<Pers> newSet = new HashSet<>();
		Pers p1 = new Pers();
		p1.setName("AB");
		p1.setAge(9);
		
		Pers p2 = new Pers();
		p2.setName("AB");
		p2.setAge(10);
		newSet.add(p1);
		newSet.add(p2);
		System.out.println(p2.equals(p1));
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(newSet.size());
		for (Pers pers : newSet) {
			System.out.println(pers.getName());
		}
	}
	
	/**
	 * Collection 是List,Set等的父类接口,Collections是集合工具类,负责搜索排序,线程安全化等功能
	 * List 以索引取值,元素可以重复,  Set 元素不可以重复(用对象的equal方法区分是否重复,同时hasCode也要相同)
	 * Map 是键值一对一,key是不重复的,Value可以重复,(两种实现版本:哈希存储和排序树)
	 */
	public static void main(String[] args) {
		CollectTest<String,String> text = new CollectTest<String, String>();
//		text.test();
		text.test1();
	}
	
	/**
	 * TreeMap
	 */
	public void test1(){
		Set<Student> stuSet = new TreeSet<>();//Java 7 钻石语法(构造器后面的尖括号不需要写类型)
		stuSet.add(new Student("Hao LUO", 33));
		stuSet.add(new Student("XJ WANG", 32));
		stuSet.add(new Student("Bruce LEE", 60));
		stuSet.add(new Student("Bob YANG", 22));
		
//		Collections.sort(stuSet);
		for (Student student : stuSet) {
			System.out.println(student);
		}
		
		List<Student> list = new ArrayList<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        list.add(new Student("Hao LUO", 33));
        list.add(new Student("XJ WANG", 32));
        list.add(new Student("Bruce LEE", 60));
        list.add(new Student("Bob YANG", 22));
        
        Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
        
        for (Student student : list) {
			System.out.println(student);
		}
	}
}

class Pers{

	private String name;
	
	private int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj!=null&&(obj instanceof Pers)){
			if(((Pers)obj).name.equals(this.name)){
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 31;
	}
}


class Student implements Comparable<Student>{

	private String name;
	
	private int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Student o) {
		return this.age-o.age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
}











 