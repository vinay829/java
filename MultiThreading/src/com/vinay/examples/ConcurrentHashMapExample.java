package com.vinay.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class ConcurrentThread extends Thread
{
static List<Integer> list=new ArrayList<>();

@Override
public void run() {

	super.run();
	
	try{
		
		Thread.sleep(2000);
		System.out.println("Thread updating value");
		list.add(3);
		
	}
	catch(InterruptedException e){e.printStackTrace();}
}	

}
public class ConcurrentHashMapExample {

	public static void main(String[] args) {
		HashMap<Integer,String> map=new HashMap<>();
		System.out.println(map.putIfAbsent(1,"Vinay"));
		System.out.println(map.putIfAbsent(1,"VinayP"));
	
		System.out.println(map);
		ConcurrentThread.list.add(1);
		ConcurrentThread.list.add(2);
		ConcurrentThread t=new ConcurrentThread();
		t.start();
		for(Integer item:ConcurrentThread.list)
		{
			System.out.println(item);
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}			
		}
		

	}

}
