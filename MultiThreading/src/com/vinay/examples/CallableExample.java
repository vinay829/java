package com.vinay.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



class MyCallable implements Callable
{int num=2;


	public MyCallable(int num) {
	super();
	this.num = num;
}


	@Override
	public Object call() throws Exception {
		int sum=0;
	System.out.println(Thread.currentThread().getName()+" is computing sum of first "+num+" numbers");
	for(int i=1;i<=num;i++)
		sum+=i;
	return sum;
	}
	

}
public class CallableExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyCallable[] jobs={new MyCallable(1),
				new MyCallable(2),new MyCallable(3),new MyCallable(4),new MyCallable(5),new MyCallable(6)};
ExecutorService service=Executors.newFixedThreadPool(3);
for(MyCallable c:jobs)
{
Future f= service.submit(c);	
System.out.println(f.get());
}
service.shutdown();

	}

}
