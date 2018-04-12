package com.vinay.examples;
class T1 extends Thread
{

	@Override
	public void run() {
		for(int i=0;i<10000;i++)
		{System.out.println("I am running and still waiting for interruption "+i);
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("t1 got interrupted");
		}
		
		
		
	}
	
}
public class ThreadInterruptionWithoutWaitingState {

	
	public static void main(String[] args) {
		
T1 t1=new T1();
t1.start();
t1.interrupt();

	}

}
