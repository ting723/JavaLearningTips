package com.zhanglw.tips.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {

	private T[] elements;
	private int size=0;
	
	private final int INIT_SIZE = 16;
	
	@SuppressWarnings("unchecked")
	public Stack() {
		elements = (T[]) new Object[INIT_SIZE];
	}
	
	public void push(T t){
		ensureCapacity();
		elements[size++]=t;
	}
	
	//该方法存在内存泄露的危险,即使使用栈的程序不再引用这些对象，因为栈内部维护着对这些对象的过期引用（obsolete reference）。
	//在支持垃圾回收的语言中，内存泄露是很隐蔽的，这种内存泄露其实就是无意识的对象保持。
	//如果一个对象引用被无意识的保留起来了，那么垃圾回收器不会处理这个对象，也不会处理该对象引用的其他对象，即使这样的对象只有少数几个，
    //也可能会导致很多的对象被排除在垃圾回收之外，从而对性能造成重大影响，极端情况下会引发Disk Paging（物理内存与硬盘的虚拟内存交换数据），甚至造成OutOfMemoryError。
	public T pop(){
		if(elements.length==0)
			throw new EmptyStackException();
		return elements[--size];
	}
	
	private void ensureCapacity(){
		if(elements.length==size){
			elements = Arrays.copyOf(elements, size*2+1);
		}
	}
}

