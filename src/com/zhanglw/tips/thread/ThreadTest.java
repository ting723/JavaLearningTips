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
				System.out.println("时间过去了5s");
				t.wait(10000);
				System.out.println("等待10s");
				/**
				 * sleep() 和yeild()区别
				 * 1. sleep 不考虑线程优先级级别,使得低优先级的有机会运行  yeild 只给线程优先级相同或者高的运行机会
				 * 2. sleep 进入阻塞状态  yeild 进入准备状态 
				 * 3. sleep 抛出异常InterruptedException,yeild 不抛出异常
				 * 4. sleep 更具有移植性
				 */
				t.yield();
				notify();
				System.out.println("继续执行");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
