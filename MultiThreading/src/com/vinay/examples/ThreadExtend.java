package com.vinay.examples;
public class ThreadExtend extends Thread {

	@Override
	public void run() {
		
		for(int i=0;i<10;i++)
			System.out.println("Thread class");
		System.out.println("run method executed by"+Thread.currentThread().getName());
	}

	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
		System.out.println("start method executed by"+Thread.currentThread().getName());
	}

	
	

}
