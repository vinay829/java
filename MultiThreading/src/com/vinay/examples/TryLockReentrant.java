package com.vinay.examples;

import java.util.concurrent.locks.ReentrantLock;

public class TryLockReentrant {

	public static void main(String[] args) {
NoWait t1=new NoWait();
NoWait t2=new NoWait();
t1.start();
t2.start();


	}

}

class NoWait extends Thread {
	static ReentrantLock l = new ReentrantLock();

	@Override
	public void run() {
		super.run();

		try {
			if (l.tryLock()) {
				System.out.println(Thread.currentThread().getName() + " Got the lock");
				Thread.sleep(5000);
				System.out.println(Thread.currentThread().getName() + " completed the operation so releasing the lock");
				l.unlock();
			} else {
				System.out.println(Thread.currentThread().getName() + " did not get the lock so performing other operations");

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
