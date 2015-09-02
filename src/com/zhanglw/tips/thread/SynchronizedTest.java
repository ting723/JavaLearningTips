package com.zhanglw.tips.thread;
/**
 * 
 * @author zhanglw
 *	synchronize 三种写法
 * 1. 修饰方法
 * 2. 修饰对象
 * 
 * 
 * 同步和异步的区别:
 * 1. 同步 ： 资源少,线程多,为保证资源的读写正常,需要采取同步措施,保证资源的同步读取
 * 2. 异步 : 由于某个调用方法执行时间过长,并且不希望程序等待返回结果时，可以采取异步编程,更有效率
 *  所谓同步即阻塞式操作，异步即非阻塞式操作
 *  
 *  
 *  start()方法 和run()方法
 *  1. 启动一个线程调用start()方法,使线程所代表的虚拟处理机处于可运行状态,由JVM调度并执行,但并不意味着立即执行
 *  2. run()方法是线程启动后要进行回调(callback)的方法
 *  
 * 
 *  thread pool 线程池 
 *  1. 使用线程池的原因: 创建和销毁资源很耗费时间， 创建一个资源时,要获取内存和其他资源
 *  2. 提高服务程序的效率就是尽可能减少创建和销毁对象的次数,特别是一些很耗资源的对象,解决这个问题的一个途径就是“池化资源”技术
 *  3. 线程池： 即事先存放若干个可以执行的线程放入一个池(容器)中,需要时从线程池中取出,使用完毕不需要销毁线程而是放回池中，减少创建和销毁线程的开销
 *  
 *  Java5+的线程池相关类 
 *  Executor接口定义一个执行线程的工具
 *  它的子类型即线程池接口ExecutorService
 *  常见方法：
 *  1.newSingleThreadExecutor 创建单个线程(此线程池支持定时以及周期性执行任务的需求)
 *  2.newFixedThreadPool 创建固定大小的线程池(在服务器使用,推荐使用该线程池)
 *  3.newCachedThreadPool 创建可缓存的线程池
 *  4.newScheduledThreadPool 创建一下无限大小的线程池(此线程池支持定时以及周期性执行任务的需求)
 *  
 *  阻塞状态:可能有多种情况,可能是wait()方法进入等待池中,可能是执行同步方法或同步代码块进入等锁池中,
 *  		或者调用了sleep()方法等待休眠或其他线程结束,或是因为发生了I/O中断
 *  
 *  synchronized和java.util.concurrent.locks.Lock的异同
 *  1. Lock java5以后引入
 *  2. Lock能完成synchronized所有实现功能
 *  3. Lock有比synchronized更精确的线程语义和更好的性能,而且不强制性的要求一定要获得锁
 *  4. synchronized 会释放锁,而Lock一定要程序员手工释放,并且最好在finally块中释放(这是释放外部资源的最好地方)
 * */
public class SynchronizedTest {

	public synchronized void synMethod() {
		// 方法体
	}

	public int synMethodVod(Integer a1) {
		synchronized (a1) {
			// 一次只能有一个线程进入
			return a1;
		}
	}

	public void run() {
	    synchronized (this) {
	      System.out.println(Thread.currentThread().getName());
	    }
	}
}
