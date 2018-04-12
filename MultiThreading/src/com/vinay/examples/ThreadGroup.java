package com.vinay.examples;

public class ThreadGroup {

	public static void main(String[] args) {
System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
	}

}
