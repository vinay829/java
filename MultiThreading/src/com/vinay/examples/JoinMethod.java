package com.vinay.examples;
class JoinClass extends Thread
{

	@Override
	public void run() {
		for(int i=0;i<15;i++)
			System.out.println(this.getName());
	}
	

}
public class JoinMethod {

	public static void main(String[] args) throws InterruptedException {
		JoinClass t1=new JoinClass();
		t1.start();
		t1.join();
		for(int i=0;i<15;i++)
			System.out.println("main thread");
		

	}

}
