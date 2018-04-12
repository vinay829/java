package com.vinay.examples;
class YieldThread extends Thread
{

	@Override
	public void run() {
		for(int i=0;i<10;i++)
		{System.out.println("mythread is running "+Thread.currentThread().getName());
		Thread.yield();
		}
	}
	

}
public class YieldMethod {

	public static void main(String[] args) {
		YieldThread t1=new YieldThread();
		t1.setPriority(8);
		t1.setName("t1");
		YieldThread t2=new YieldThread();
		t2.setPriority(6);
		t2.setName("t2");
	//we have 3 threads in total : main(5 priority),t1(8 priority) and t2(6 priority)
		
		t1.start();//has 8 priority
		t2.start();//has 6 priority

	}

}
