package com.vinay.examples;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		List<Integer> sharedList = new ArrayList<>();
		Thread thread1=new Thread(new Producer(sharedList));
		Thread thread2=new Thread(new Consumer(sharedList));
		thread1.start();
		thread2.start();

	}

}

class Producer implements Runnable {
	final int MAX_SIZE = 5;
	private int i=0;
	List<Integer> sharedList = null;

	public Producer(List<Integer> sharedList) {
		super();
		this.sharedList = sharedList;
	}

	public void produce(int i) throws InterruptedException {
		synchronized (sharedList) {
			while (sharedList.size() == MAX_SIZE) {
				System.out.println("shared list is full waiting for consumer to consume");
				try {
					sharedList.wait();//producer thread leaves the lock of sharedList
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}

			}
		}//block1 to just wait for the consumer to consume 
		
		synchronized (sharedList) {
			System.out.println("producer produced "+i);
			sharedList.add(i);
			Thread.sleep(1000);
			sharedList.notify();
		}//block2 to add element if there is even 1 empty space

	}

	@Override
	public void run() {
		while(true)
			try {
				produce(i++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}


class Consumer implements Runnable {
	
	List<Integer> sharedList = null;

	public Consumer(List<Integer> sharedList) {
		super();
		this.sharedList = sharedList;
	}

	public void consume() throws InterruptedException {
		synchronized (sharedList) {
			while (sharedList.isEmpty()) {
				System.out.println("shared list is empty waiting for producer to produce");
				try {
					sharedList.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}//block1
		
		synchronized (sharedList) {
			
			Thread.sleep(1000);
			System.out.println("consuming the element"+sharedList.remove(0));
			sharedList.notify();
		}

	}

	@Override
	public void run() {
		while(true)
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
