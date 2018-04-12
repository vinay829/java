package com.vinay.examples;

class LocalThread extends Thread {

	@Override
	public void run() {

		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("local thread");//printed only once

				Thread.sleep(5000);
			}

		} // try
		catch (InterruptedException e) {

			// e.printStackTrace();

			System.out.println("local thread got interrupted");
		} // catch
	}// for loop
}

public class ThreadInterruption {

	public static void main(String[] args) {
		LocalThread t1 = new LocalThread();
		t1.start();
		t1.interrupt();// executed by main,so main thread interrupts t1
		System.out.println("end of main");

	}

}
