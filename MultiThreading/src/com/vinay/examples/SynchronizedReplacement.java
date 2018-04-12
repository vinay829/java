package com.vinay.examples;

import java.util.concurrent.locks.ReentrantLock;

class DisplayReentrant
{ ReentrantLock l=new ReentrantLock();
	public  void wish(String name)
	{l.lock();
		for(int i=0;i<5;i++)
		{
			System.out.print("Good Morning :");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name);
			
			
			
			
		}//job completed
		l.unlock();
		
	}
	
}
class WishThreadReentrant extends Thread
{
String name;
DisplayReentrant display;

	public WishThreadReentrant(String name, DisplayReentrant display) {
	super();
	this.name = name;
	this.display = display;
}

	@Override
	public void run() {
		display.wish(this.name);
	}
	

}
public class SynchronizedReplacement {

	public static void main(String[] args) {
		DisplayReentrant d=new DisplayReentrant();
		WishThread t1=new WishThread("Vinay", d);
		WishThread t2=new WishThread("Piyush", d);
		t1.start();
		t2.start();
		
		
		

	}

}
