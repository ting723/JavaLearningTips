package com.zhanglw.tips.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.zhanglw.tips.base.TestTips;

public class MulitiThreadTest implements TestTips{

	@Override
	public void test() {
		
		Account account = new Account();
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			service.execute(new AddMoneyThread(account, 10));
		}
		service.shutdown();
		while (!service.isTerminated()) {
			
		}
		System.out.println("ÕË»§Óà¶î:"+account.getBalance());
	}


}

class Account{
	
	private double balance;//ÕËºÅÓà¶î

	public void deposit(double money){
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
			double newBalance = this.balance+money;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.balance=newBalance;
		} finally{
			 lock.unlock();
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
}

class AddMoneyThread implements Runnable{
	private Account account;//´æÈëÕË»§
	private double money;//´æÈë½ð¶î
	
	public AddMoneyThread(Account account, double money) {
		super();
		this.account = account;
		this.money = money;
	}

	@Override
	public void run() {
		synchronized(account){
			this.account.deposit(this.money);
		}
	}
	
}