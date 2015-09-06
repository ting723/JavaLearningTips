package com.zhanglw.tips.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.zhanglw.tips.base.TestTips;
/**
 * 
 * @author zhanglw
 * 实现多线程有三种方式:
 * 1. 继承Thread类(单继承,不能再继承其它类了,不灵活)
 * 2. 实现Runable接口(推荐,更灵活)
 * 3. 实现Callable接口
 * 
 * 
 * 
 */
public class CallableTest implements TestTips{

	@Override
	public void test() {
		
		List<Future<Integer>> list = new ArrayList<>();
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			list.add(service.submit(new MyTask((int)(Math.random()*100))));
		}
		
		int sum=0;
		for (Future<Integer> future : list) {
			try {
				sum+=future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sum);
	}
}

class MyTask implements Callable<Integer>{

	private int upperBounds;

	
	public MyTask(int upperBounds) {
		this.upperBounds = upperBounds;
	}

	@Override
	public synchronized Integer call() throws Exception {
		int sum=0;
		for (int i = 0; i < this.upperBounds; i++) {
			sum+=i;
		}
		return sum;
	}
	
}
