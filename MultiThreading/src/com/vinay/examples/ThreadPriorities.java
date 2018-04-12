package com.vinay.examples;
class MyThread extends Thread
{

	@Override
	public void run() {
		for(int i=0;i<20;i++)
			System.out.println("mythread thread");
	}
	

}
public class ThreadPriorities {

	public static void main(String[] args) {
	/*	System.out.println("main thread priority"+Thread.currentThread().getPriority());
MyThread t1=new MyThread();
System.out.println("MyThread priority"+t1.getPriority());//main thread is the parent thread

Thread.currentThread().setPriority(8);
MyThread t2=new MyThread();
System.out.println("MyThread t1 priority"+t1.getPriority());
System.out.println("MyThread t2 priority"+t2.getPriority());//main thread is the parent thread
*/
		MyThread t2=new MyThread();
		t2.setPriority(8);
		t2.start();
		System.out.println("main thread priority"+Thread.currentThread().getPriority());
		System.out.println("mythread priority"+t2.getPriority());
for(int i=0;i<20;i++)
	System.out.println("main thread");
	}

}
