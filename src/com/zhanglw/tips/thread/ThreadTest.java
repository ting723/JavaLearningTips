package com.zhanglw.tips.thread;

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.zhanglw.tips.base.TestTips;

public class ThreadTest implements TestTips{
	
	@Override
	public synchronized void test() {

		try {
			LocalDateTime time = LocalDateTime.now();
			while (LocalDateTime.now().minusMinutes(1).compareTo(time)<0) {
				Thread t = Thread.currentThread();
				t.sleep(5000);
				System.out.println("ʱ���ȥ��5s");
				wait(10000);
				System.out.println("�ȴ�10s");
				/**
				 * sleep() ��yeild()����
				 * 1. sleep �������߳����ȼ�����,ʹ�õ����ȼ����л�������  yeild ֻ���߳����ȼ���ͬ���߸ߵ����л���
				 * 2. sleep ��������״̬  yeild ����׼��״̬ 
				 * 3. sleep �׳��쳣InterruptedException,yeild ���׳��쳣
				 * 4. sleep ��������ֲ��
				 */
				t.yield();
				/**
				 * wait(): ʹ�̳߳�������״̬,���ͷ������ж������
				 * sleep(): ʹһ���������е��̴߳���˯��״̬,��һ��̬����
				 * notify(); ����ĳ�����ڵȴ����߳�,  ���廽���ĸ�,��JVM����
				 * notifyAll(); �������еȴ����߳�, ���Ƕ�������������߳�,���������ǽ��о���,ֻ�л�������̲߳��ܽ������״̬
				 */
				notify();
				Lock lock = new ReentrantLock();//ͨ��Lock�ӿ��ṩ��ʾ������,��ǿ�����,�Լ����̵߳�Э��
				//����
				lock.lock();//
				//����
				lock.unlock();
				//�����߳�֮��ͨ�ŵ�Condition����
				Condition con= lock.newCondition();
				
				//�ź�������,�ź��������������ƶԹ�����Դ���з��ʵ��̵߳�����
				Semaphore sem= new Semaphore(5);
				// �̷߳���ǰ,����õ��ź��������
				sem.acquire();
				// ��Դ���ʺ�,�������ź��������
				sem.release();
				System.out.println("����ִ��");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
