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
	
	//�÷��������ڴ�й¶��Σ��,��ʹʹ��ջ�ĳ�����������Щ������Ϊջ�ڲ�ά���Ŷ���Щ����Ĺ������ã�obsolete reference����
	//��֧���������յ������У��ڴ�й¶�Ǻ����εģ������ڴ�й¶��ʵ��������ʶ�Ķ��󱣳֡�
	//���һ���������ñ�����ʶ�ı��������ˣ���ô�������������ᴦ���������Ҳ���ᴦ��ö������õ��������󣬼�ʹ�����Ķ���ֻ������������
    //Ҳ���ܻᵼ�ºܶ�Ķ����ų�����������֮�⣬�Ӷ�����������ش�Ӱ�죬��������»�����Disk Paging�������ڴ���Ӳ�̵������ڴ潻�����ݣ����������OutOfMemoryError��
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

