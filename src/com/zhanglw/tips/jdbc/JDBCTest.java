package com.zhanglw.tips.jdbc;

import com.zhanglw.tips.base.TestTips;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * @author zhanglw 1.JDBC操作步骤:加载驱动->创建连接->创建语句->执行语句->处理结果->关闭资源 2.
 *         外部资源的关闭顺序(Result->Statement->Connection)和创建顺序相反 3.
 *         Statement和PrepareStatement的区别及性能： * PrepareStatement接口代表预编译语句,优势是
 *         减少编译错误 安全性 防止SQL注入 *
 *         PrepareStatement中的SQL可以带参数的,避免了用字符串连接拼接SQL语句的麻烦和不安全 *
 *         批量处理SQL和频繁执行相同的查询时,PrepareStatement有明显的性能优势(数据库可以将编译后的SQL语句缓存起来,
 *         下次执行相同的结构的语句时就会很快,不用编译和生成执行计划 ) 4. 调用CallableStatement 5. 提升读取性能:
 *         可以指定通过结果集（ResultSet）对象的setFetchSize()方法指定每次抓取的记录数（典型的空间换时间策略） 6.
 *         提升更新性能: 可以使用PreparedStatement语句构建批处理，将若干SQL语句置于一个批处理中执行。 7.
 *         进行数据库编程时,采用池化技术:可以减少数据库连接的创建和销毁所造成的开销,提高访问数据库的性能,常用的Java开源数据库连接池主要有:
 *         C3P0,Proxool,DBCP,BoneCP,Druid等 8. DAO (data Access Object)
 *         不暴露持久化方案实现细节的前提下 提供了所有对数据源的访问操作 DAO模式包含两个模式:Data Accessor(数据访问器)
 *         解决如何访问对象问题,Data Object(数据对象) 解决如何用对象封装数据 9. 事务的ACID * A Atomic 原子性
 *         要么全做,要么不做 * C Consistent 一致性 事务结束后系统状态时一致的 * I Isolated 隔离性
 *         并发执行的事务彼此无法看到对方的中间状态 * D Durable 持久性 事务完成后的改动都会被持久化 10.并发才需要事务控制
 *         问题包括: 数据读取问题(脏读、不可重复读、幻读) 数据更新问题(两种更新丢失)
 *         11.事务隔离级别和数据访问的并发性是对立的,隔离级别越高,并发性就越差 12.JDBC
 *         通过setAutoCommit(false)可以设置手动提交事务,事务完成用commit()提交,否则rollback()
 *         此外,JDBC3.0中还引入饿了Savepoit(保存点)的概念,允许通过保存点并让事务回滚到指定的保存点
 *         13.JDBC还可以出来Blob(二进制大对象Binary Large Object)和Clob(大字符对象Character Large
 *         Object)数据类型,PreparedStatement和ResultSet提供相应的方法制成Blob和Clob操作
 * 
 */
public class JDBCTest implements TestTips {
	/**
	 * 测试Blob数据,需要有数据库支持
	 *  create table tb_user ( id int primary key
	 * 	auto_increment, 
	 * 	name varchar(20) 
	 * 	unique not null, 
	 * 	photo longblob );
	 */
	@Override
	public void test() {
		Connection con = null;
		try {
			// 1. 加载驱动（Java6以上版本可以省略）
			Class.forName("com.mysql.jdbc.Driver");
			// 2. 建立连接
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
			// 3. 创建语句对象
			PreparedStatement ps = con.prepareStatement("insert into tb_user values (default, ?, ?)");
			ps.setString(1, "骆昊"); // 将SQL语句中第一个占位符换成字符串
			try (InputStream in = new FileInputStream("test.jpg")) { // Java
																		// 7的TWR
				ps.setBinaryStream(2, in); // 将SQL语句中第二个占位符换成二进制流
				// 4. 发出SQL语句获得受影响行数
				System.out.println(ps.executeUpdate() == 1 ? "插入成功" : "插入失败");
			} catch (IOException e) {
				System.out.println("读取照片失败!");
			}
		} catch (ClassNotFoundException | SQLException e) { // Java 7的多异常捕获
			e.printStackTrace();
		} finally { // 释放外部资源的代码都应当放在finally中保证其能够得到执行
			try {
				if (con != null && !con.isClosed()) {
					con.close(); // 5. 释放数据库连接
					con = null; // 指示垃圾回收器可以回收该对象
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
