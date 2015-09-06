package com.zhanglw.tips.xml;

import com.zhanglw.tips.base.TestTips;
/**
 * 
 * @author zhanglw
 * XML
 * 1. 分为DTD和Schema两种形式,都是对XML语法的约束,本质区别是Schema本身也是一个XML文件,可以被XML解析器所解析并可以为承载的数据定义类型,比DTD更强大
 * 2. XML解析主要有: DOM,SAX(Simpla API for XML),StAX(Java6中引入的新的解析XML的方式,Streaming API for XML)
 * 3. DOM 在处理大型文档下 性能不好， 在读取XML时,会一次性将所有的XML装入,内存占用较多,适合随机访问(典型用空间换时间的策略)
 * 4. SAX 事件驱动型的XML解析方式,顺序读取XML文件,不需要一次全部转载整个文件,遇到文档开头或结束,标签开头或结束,它会触发一个事件,用户通过事件回调代码来处理XML文件,适合顺序访问
 * 5. StAX 把XML作为一个事件流来处理
 * 6. XML主要作用: 数据交换和信息配置
 * 7. XML曾作为异构系统间数据交换标准,现基本被JSON取代
 * 8. 很多Java框架使用XML作信息配置，使用dom4j作为处理XML的工具
 */
public class XMLTest implements TestTips{
	
	@Override
	public void test() {
		
	}

}
