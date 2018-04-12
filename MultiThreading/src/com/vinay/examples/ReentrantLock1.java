package com.vinay.examples;

import java.util.concurrent.locks.*;

public class ReentrantLock1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ReentrantLock l=new ReentrantLock();
l.lock();
l.lock();
System.out.println(l.isLocked());//true
System.out.println(l.isHeldByCurrentThread());//true
System.out.println(l.getQueueLength());//0
System.out.println(l.getHoldCount());//2 lock count
l.unlock();
System.out.println(l.getHoldCount());//1
System.out.println(l.isLocked());//true
l.unlock();
System.out.println(l.getHoldCount());//0
System.out.println(l.isLocked());//false
	}

}
