package com.zhanglw.tips.thread;

import java.time.LocalDateTime;

import com.zhanglw.tips.base.TestTips;

public class ThreadTest implements TestTips{
	
	@Override
	public synchronized void test() {

		try {
			LocalDateTime time = LocalDateTime.now();
			while (LocalDateTime.now().minusMinutes(1).compareTo(time)<0) {
				Thread t = Thread.currentThread();
				t.sleep(5);
				System.out.println("ʱ���ȥ��5s");
				t.wait(10000);
				System.out.println("�ȴ�10s");
				/**
				 * sleep() ��yeild()����
				 * 1. sleep �������߳����ȼ�����,ʹ�õ����ȼ����л�������  yeild ֻ���߳����ȼ���ͬ���߸ߵ����л���
				 * 2. sleep ��������״̬  yeild ����׼��״̬ 
				 * 3. sleep �׳��쳣InterruptedException,yeild ���׳��쳣
				 * 4. sleep ��������ֲ��
				 */
				t.yield();
				notify();
				System.out.println("����ִ��");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
