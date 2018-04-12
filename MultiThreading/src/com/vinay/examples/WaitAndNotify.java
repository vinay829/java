package com.vinay.examples;



class Resource {

	int num = 1;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		
	}

}

class Thread1 implements Runnable {// prints 1
	Resource r = null;

	public Thread1(Resource r) {
		super();
		this.r = r;
		
	}

	public void print() {
		while (true) {
			synchronized (r) {
				if (r.getNum() == 2)
					try {
						r.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Thread1 value " + r.getNum());
					r.setNum(2);
					r.notify();

				}
			}

		}

	}

	public void run() {
		while (true) {
			print();

		}

	}

}

class Thread2 implements Runnable {
	Resource r = null;

	public Thread2(Resource r) {
		super();
		this.r = r;
	}

	public void print() {
		while (true) {
			synchronized (r) {
				if (r.getNum() == 1)
					try {
						r.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					System.out.println("Thread2 value " + r.getNum());
					// System.out.println(r.getNum());
					r.setNum(1);
					r.notify();

				}
			}

		}

	}

	public void run() {
		while (true) {
			print();

		}

	}

}

public class WaitAndNotify {

	public static void main(String[] args) {

		Resource r = new Resource();
		Thread t1 = new Thread(new Thread1(r));
		Thread t2 = new Thread(new Thread2(r));
		t1.start();
		t2.start();

		/*
		 * Output: Thread1 value 1 Thread2 value 2 Thread1 value 1 Thread2 value 2 Thread1 value 1 Thread2 value 2 Thread1 value 1 Thread2 value 2
		 * Thread1 value 1 Thread2 value 2 Thread1 value 1
		 */

	}

}
