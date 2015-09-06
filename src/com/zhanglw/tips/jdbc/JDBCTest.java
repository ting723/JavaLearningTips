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
 * @author zhanglw 1.JDBC��������:��������->��������->�������->ִ�����->������->�ر���Դ 2.
 *         �ⲿ��Դ�Ĺر�˳��(Result->Statement->Connection)�ʹ���˳���෴ 3.
 *         Statement��PrepareStatement���������ܣ� * PrepareStatement�ӿڴ���Ԥ�������,������
 *         ���ٱ������ ��ȫ�� ��ֹSQLע�� *
 *         PrepareStatement�е�SQL���Դ�������,���������ַ�������ƴ��SQL�����鷳�Ͳ���ȫ *
 *         ��������SQL��Ƶ��ִ����ͬ�Ĳ�ѯʱ,PrepareStatement�����Ե���������(���ݿ���Խ�������SQL��仺������,
 *         �´�ִ����ͬ�Ľṹ�����ʱ�ͻ�ܿ�,���ñ��������ִ�мƻ� ) 4. ����CallableStatement 5. ������ȡ����:
 *         ����ָ��ͨ���������ResultSet�������setFetchSize()����ָ��ÿ��ץȡ�ļ�¼�������͵Ŀռ任ʱ����ԣ� 6.
 *         ������������: ����ʹ��PreparedStatement��乹��������������SQL�������һ����������ִ�С� 7.
 *         �������ݿ���ʱ,���óػ�����:���Լ������ݿ����ӵĴ�������������ɵĿ���,��߷������ݿ������,���õ�Java��Դ���ݿ����ӳ���Ҫ��:
 *         C3P0,Proxool,DBCP,BoneCP,Druid�� 8. DAO (data Access Object)
 *         ����¶�־û�����ʵ��ϸ�ڵ�ǰ���� �ṩ�����ж�����Դ�ķ��ʲ��� DAOģʽ��������ģʽ:Data Accessor(���ݷ�����)
 *         �����η��ʶ�������,Data Object(���ݶ���) �������ö����װ���� 9. �����ACID * A Atomic ԭ����
 *         Ҫôȫ��,Ҫô���� * C Consistent һ���� ���������ϵͳ״̬ʱһ�µ� * I Isolated ������
 *         ����ִ�е�����˴��޷������Է����м�״̬ * D Durable �־��� ������ɺ�ĸĶ����ᱻ�־û� 10.��������Ҫ�������
 *         �������: ���ݶ�ȡ����(����������ظ������ö�) ���ݸ�������(���ָ��¶�ʧ)
 *         11.������뼶������ݷ��ʵĲ������Ƕ�����,���뼶��Խ��,�����Ծ�Խ�� 12.JDBC
 *         ͨ��setAutoCommit(false)���������ֶ��ύ����,���������commit()�ύ,����rollback()
 *         ����,JDBC3.0�л��������Savepoit(�����)�ĸ���,����ͨ������㲢������ع���ָ���ı����
 *         13.JDBC�����Գ���Blob(�����ƴ����Binary Large Object)��Clob(���ַ�����Character Large
 *         Object)��������,PreparedStatement��ResultSet�ṩ��Ӧ�ķ����Ƴ�Blob��Clob����
 * 
 */
public class JDBCTest implements TestTips {
	/**
	 * ����Blob����,��Ҫ�����ݿ�֧��
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
			// 1. ����������Java6���ϰ汾����ʡ�ԣ�
			Class.forName("com.mysql.jdbc.Driver");
			// 2. ��������
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
			// 3. ����������
			PreparedStatement ps = con.prepareStatement("insert into tb_user values (default, ?, ?)");
			ps.setString(1, "���"); // ��SQL����е�һ��ռλ�������ַ���
			try (InputStream in = new FileInputStream("test.jpg")) { // Java
																		// 7��TWR
				ps.setBinaryStream(2, in); // ��SQL����еڶ���ռλ�����ɶ�������
				// 4. ����SQL�������Ӱ������
				System.out.println(ps.executeUpdate() == 1 ? "����ɹ�" : "����ʧ��");
			} catch (IOException e) {
				System.out.println("��ȡ��Ƭʧ��!");
			}
		} catch (ClassNotFoundException | SQLException e) { // Java 7�Ķ��쳣����
			e.printStackTrace();
		} finally { // �ͷ��ⲿ��Դ�Ĵ��붼Ӧ������finally�б�֤���ܹ��õ�ִ��
			try {
				if (con != null && !con.isClosed()) {
					con.close(); // 5. �ͷ����ݿ�����
					con = null; // ָʾ�������������Ի��ոö���
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
