package com.zhanglw.tips.bit;

import com.zhanglw.tips.base.TestTips;

/**
 * ����λ����  
 * 1. �߼������ ~ & | ^
 * 2. ��λ����� >> << >>> 
 * @author zhanglw
 *
 */
public class BitTest implements TestTips{
	
	public void testLogicBitOperator(){
		
		int a = 1,b=2,c=3;
		//1 �Ķ����Ʋ���: 0000 0001
		//2 �Ķ����Ʋ���: 0000 0010
		//3 �Ķ����Ʋ���: 0000 0011
		//a|b �䲹��ÿһλ,����һ����1��Ϊ1,����Ϊ0 ��: a|b = 0000 0011=3
		System.out.println(a|b);
		//a&b �䲹��ÿһλ,������1��Ϊ1,����Ϊ0 ��: a&b = 0000 0000=0
		System.out.println(a&b);
		//~a ȡ��  �������λȡ��,0���1,1���0: ~a = 1111 1110 = 1000 0010(ԭ��) = -2
		System.out.println(~a);
		//c^a ���  �䲹���ÿһλ,����ͬ��Ϊ1,��ͬΪ0,��: c^a = 0000 0010=2
		System.out.println(c^a);
		
		
	//����>>,<<,>>> ���ǵõ����Ϊ����,ֱ����ȥС��λ	
		//>> ��������  �ϻ������������  ����һλ��ʾ����2
		System.out.println(-8>>3);

		//>> ��������  �ϻ������������ ����һλ��ʾ����2
		System.out.println(c<<2);
		
		//>>> �޷�����λ����   �ƶ�ָ����λ��  �������λ��0
		//-1�Ĳ���Ϊ: 1111 1111  >>> 0111 1111
		System.out.println(-1>>>1);
		
		//31*num = (32-1)*num = 32*num-num = (num<<5)-num  ��������ʹ����λ�������˷�����
		System.out.println((2<<5)-2);
	}

	@Override
	public void test() {
		
		testLogicBitOperator();
	}
	
	
}
