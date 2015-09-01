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
				System.out.println("时间过去了5s");
				wait(10000);
				System.out.println("等待10s");
				/**
				 * sleep() 和yeild()区别
				 * 1. sleep 不考虑线程优先级级别,使得低优先级的有机会运行  yeild 只给线程优先级相同或者高的运行机会
				 * 2. sleep 进入阻塞状态  yeild 进入准备状态 
				 * 3. sleep 抛出异常InterruptedException,yeild 不抛出异常
				 * 4. sleep 更具有移植性
				 */
				t.yield();
				/**
				 * wait(): 使线程出于阻塞状态,并释放所持有对象的锁
				 * sleep(): 使一个正在运行的线程处于睡眠状态,是一静态方法
				 * notify(); 唤醒某个正在等待的线程,  具体唤醒哪个,由JVM决定
				 * notifyAll(); 唤醒所有等待的线程, 不是对象的锁给所有线程,而是让它们进行竞争,只有获得锁的线程才能进入就绪状态
				 */
				notify();
				Lock lock = new ReentrantLock();//通过Lock接口提供显示锁机制,增强灵活性,以及对线程的协调
				//加锁
				lock.lock();//
				//解锁
				lock.unlock();
				//用于线程之间通信的Condition对象
				Condition con= lock.newCondition();
				
				//信号量机制,信号量可以用来限制对共享资源进行访问的线程的数量
				Semaphore sem= new Semaphore(5);
				// 线程访问前,必须得到信号量的许可
				sem.acquire();
				// 资源访问后,必须向信号量的许可
				sem.release();
				System.out.println("继续执行");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
