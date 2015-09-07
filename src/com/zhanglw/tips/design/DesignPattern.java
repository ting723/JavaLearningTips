package com.zhanglw.tips.design;

import com.zhanglw.tips.base.TestTips;
/**
 * 
 * @author zhanglw
 * ����������ԭ��һ����
 * 	1. ��һְ��ԭ��  	  һ����ֻ��������������
 * 	2. ����ԭ��		 ����չ����,���޸Ĺر�
 * 	3. ������תԭ��  	 ����ӿڱ��
 *  4. �����滻ԭ��	�κ�ʱ�򶼿������������滻������
 *  5. �ӿڸ���ԭ�� 	�ӿ�ҪС��ר,�����ܴ��ȫ
 *  6. �ϳɾۺϸ���ԭ��   ����ʹ�þۺϻ�ϳɹ�ϵ���ô���
 *  7. �����ط���		һ������Ӧ�������������о������ٵ��˽� 
 * ���ģʽ����
 * 	1. ������: ����ģʽ,������ģʽ,��������ģʽ,���󹤳�ģʽ,ԭ��ģʽ
 *	2. �ṹ��: ������ģʽ,�Ž�ģʽ,���ģʽ,װ��ģʽ,���ģʽ,��Ԫģʽ,����ģʽ 
 *	3. ��Ϊ��: ������ģʽ,ģ�巽��ģʽ,������ģʽ,����ģʽ,����ģʽ,�н���ģʽ,����¼ģʽ,�۲���ģʽ,״̬ģʽ,����ģʽ,������ģʽ
 */
public class DesignPattern implements TestTips{

	@Override
	public void test() {
		

	}

}

class Singleton{
	private final static Singleton singleton = new Singleton();
	
	private  Singleton(){
	}
	
	public static Singleton getInstance(){
		return singleton;
	}
}