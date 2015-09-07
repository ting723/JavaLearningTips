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

	//û�м̳��κ���
	@SuppressWarnings("unused")
	private Map<K,V> map = new HashMap<>();
	
	//�̳���Collection<E>  ��������,����ֵ��������Ԫ��
	@SuppressWarnings("unused")
	private List<K> list = new ArrayList<>();
	
	//�̳���Collection<E>  �洢��ɢ�Ҳ��ظ���Ԫ��
	@SuppressWarnings("unused")
	private Set<V> set = new HashSet<>();
	
	/**
	 * ArrayList��Vector ����ʹ�����鷽ʽ�洢����
	 * ArrayList ��ѯ�죬����ɾ����
	 * Vector �еķ��������synchronized ����,���ܽϲ�,����������
	 * LinkedList ʹ����˫������ʵ�ִ洢,������洢�������,�����ʸ���,����ʱ,ֻ��Ҫ��¼�����ǰ�����,�ʲ������
	 * Java����������: Vector,Hashtable,Dictionary,BitSet,Stack,Properties �����Ƽ�ʹ��
	 * ArrayList��LinkedList �Ƿ��̰߳�ȫ��, �ڶ��߳������,����ͨ��Collections��synchronizedList����ת��
	 */
	private LinkedList<String> linkedList = new LinkedList<>();
	
	@Override
	public void test(){
		Collections.synchronizedList(linkedList).add("AB");//ʹ����װ��ģʽ
		
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
	 * Collection ��List,Set�ȵĸ���ӿ�,Collections�Ǽ��Ϲ�����,������������,�̰߳�ȫ���ȹ���
	 * List ������ȡֵ,Ԫ�ؿ����ظ�,  Set Ԫ�ز������ظ�(�ö����equal���������Ƿ��ظ�,ͬʱhasCodeҲҪ��ͬ)
	 * Map �Ǽ�ֵһ��һ,key�ǲ��ظ���,Value�����ظ�,(����ʵ�ְ汾:��ϣ�洢��������)
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
		Set<Student> stuSet = new TreeSet<>();//Java 7 ��ʯ�﷨(����������ļ����Ų���Ҫд����)
		stuSet.add(new Student("Hao LUO", 33));
		stuSet.add(new Student("XJ WANG", 32));
		stuSet.add(new Student("Bruce LEE", 60));
		stuSet.add(new Student("Bob YANG", 22));
		
//		Collections.sort(stuSet);
		for (Student student : stuSet) {
			System.out.println(student);
		}
		
		List<Student> list = new ArrayList<>();     // Java 7����ʯ�﷨(����������ļ������в���Ҫд����)
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











 