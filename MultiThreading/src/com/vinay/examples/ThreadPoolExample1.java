package com.vinay.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample1 {

	class PrintJob implements Runnable {
		String name;

		public PrintJob(String name) {
			this.name = name;
		}

		@Override
		public void run() {

			System.out.println("Print job performed by " + this.name);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Print job completed by " + this.name);
		}

	}

	public static void main(String[] args) {

		PrintJob[] jobs = { new ThreadPoolExample1().new PrintJob("1"), new ThreadPoolExample1().new PrintJob("2"),
				new ThreadPoolExample1().new PrintJob("3"),
				new ThreadPoolExample1().new PrintJob("4"),
				new ThreadPoolExample1().new PrintJob("5"),
				new ThreadPoolExample1().new PrintJob("6")

		};// 6 jobs

		ExecutorService service = Executors.newFixedThreadPool(2);
		// service.submit(() -> System.out.println("Hello"));
		for(PrintJob j:jobs)
		{
			service.submit(j);
			
		}
		service.shutdown();
	}

}
