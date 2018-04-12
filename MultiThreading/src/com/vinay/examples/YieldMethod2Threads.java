package com.vinay.examples;
 class YieldThreadClass extends Thread
{
	@Override
	public void run()
	{
		for(int i=0;i<15;i++){
		System.out.println(Thread.currentThread().getName());
		Thread.yield();
		}
	}
}
public class YieldMethod2Threads {

	public static void main(String[] args) {
		YieldThreadClass t1=new YieldThreadClass();
		t1.setPriority(6);
		t1.start();
		for(int i=0;i<15;i++)
			System.out.println("main thread");

	}

}
