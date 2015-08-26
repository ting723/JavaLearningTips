package com.zhanglw.tips.bit;

import com.zhanglw.tips.base.TestTips;

/**
 * 测试位运算  
 * 1. 逻辑运算符 ~ & | ^
 * 2. 移位运算符 >> << >>> 
 * @author zhanglw
 *
 */
public class BitTest implements TestTips{
	
	public void testLogicBitOperator(){
		
		int a = 1,b=2,c=3;
		//1 的二进制补码: 0000 0001
		//2 的二进制补码: 0000 0010
		//3 的二进制补码: 0000 0011
		//a|b 其补码每一位,若有一个是1则为1,否则为0 故: a|b = 0000 0011=3
		System.out.println(a|b);
		//a&b 其补码每一位,若都是1则为1,否则为0 故: a&b = 0000 0000=0
		System.out.println(a&b);
		//~a 取反  补码各个位取反,0变成1,1变成0: ~a = 1111 1110 = 1000 0010(原码) = -2
		System.out.println(~a);
		//c^a 异或  其补码的每一位,若不同则为1,相同为0,故: c^a = 0000 0010=2
		System.out.println(c^a);
		
		
	//无论>>,<<,>>> 都是得到结果为整数,直接舍去小数位	
		//>> 右移运算  较基本算数运算块  右移一位表示除以2
		System.out.println(-8>>3);

		//>> 左移运算  较基本算数运算块 左移一位表示乘以2
		System.out.println(c<<2);
		
		//>>> 无符号移位运算   移动指定的位数  并在最高位补0
		//-1的补码为: 1111 1111  >>> 0111 1111
		System.out.println(-1>>>1);
		
		//31*num = (32-1)*num = 32*num-num = (num<<5)-num  这样可以使用移位运算代替乘法运算
		System.out.println((2<<5)-2);
	}

	@Override
	public void test() {
		
		testLogicBitOperator();
	}
	
	
}
