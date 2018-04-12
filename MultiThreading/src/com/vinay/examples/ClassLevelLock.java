package com.vinay.examples;
class Display2 
{ public synchronized void displayNumbers(){
	for(int i=1;i<=10;i++)
	{
		System.out.println(i);

	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
public synchronized void displayCharacter()
{for(int i=65;i<75;i++)
{
	System.out.println((char) i);

try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
	
}
	
}

class CountThread extends Thread
{
Display2 d;

public CountThread(Display2 d) {
	super();
	this.d = d;
}
public void run()
{
	
d.displayNumbers();
}

}
class CharThread extends Thread
{
	Display2 d;

	public CharThread(Display2 d) {
		super();
		this.d = d;
	}
	public void run()
	{
		
	d.displayCharacter();
	}

}
public class ClassLevelLock {


	public static void main(String[] args) {
	Display2 d=new Display2();
	CountThread t1=new CountThread(d);
	CharThread t2=new CharThread(d);
	t1.start();
	t2.start();
	

	}

}
