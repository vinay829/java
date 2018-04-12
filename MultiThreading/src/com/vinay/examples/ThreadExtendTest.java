package com.vinay.examples;

public class ThreadExtendTest {

	public static void main(String[] args) {
		ThreadExtend t=new ThreadExtend();
		//t.start();
		Thread t2=new Thread(()->{for(int i=0;i<10;i++)System.out.println("run method using lambda");});	
		t2.start();
		for(int i=0;i<10;i++)
			System.out.println("main thread");
//System.out.println("main method executed by"+Thread.currentThread().getName());
	
		
	}

}
 