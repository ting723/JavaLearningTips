package com.zhanglw.tips.serialization;

import com.zhanglw.tips.base.TestTips;
/**
 * 
 * @author zhanglw
 *	
 * 序列化:
 * 	1. 是用来处理对象流的机制
 * 	2. 对象流就是将对象的内容流化,便于读写操作,可以用于网络传输,
 * 	3. 序列化是为了解决对象流对象操作时可能引发的问题(如果不进行序列化可能存在数据乱序问题)
 * 	4. 实现序列化需继承: Serializable接口(该接口是一个标志性接口,标注该类对象是可被序列化的)
 * 	5. 序列化:构建一个输出流并通过writeObject(Object)方法就可以将实现对象写成
 * 	6. 反序列化:构建一个输入流并通过readObject(Object)方法从流中读取对象
 * 	7. 序列化可以用于对象的深度克隆
 */
public class SerializationTest implements TestTips{

	@Override
	public void test() {
		
	}


}
