package com.vinay.examples;

public class RunnableImplement implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<10;i++)
			System.out.println("thread class");
		
	}

}
