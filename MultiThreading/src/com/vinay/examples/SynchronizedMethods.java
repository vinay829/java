package com.vinay.examples;
class Display
{ 
	public synchronized void wish(String name)
	{
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
			
			
			
			
		}
		
		
	}
	
}
class WishThread extends Thread
{
String name;
DisplayReentrant display;

	public WishThread(String name, DisplayReentrant display) {
	super();
	this.name = name;
	this.display = display;
}

	@Override
	public void run() {
		display.wish(this.name);
	}
	

}
public class SynchronizedMethods {

	public static void main(String[] args) {
		DisplayReentrant d=new DisplayReentrant();
		WishThreadReentrant t1=new WishThreadReentrant("Vinay", d);
		WishThreadReentrant t2=new WishThreadReentrant("Piyush", d);
		t1.start();
		t2.start();
		

	}

}
