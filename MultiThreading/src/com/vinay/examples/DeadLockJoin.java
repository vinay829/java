package com.vinay.examples;
class Deadlock extends Thread
{

	@Override
	public void run() {
		System.out.println("Deadlock thread");
	}
	
}
public class DeadLockJoin {

	public static void main(String[] args) throws InterruptedException {
	Thread.currentThread().join();

	}

}
