/**
 * 
 */
package com.shankarsan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author SHANKARSAN
 *
 */
public class ThreadController {

	public static void main(String [] args) {
		int count = 0;
		Thread thread = null;
		List<Thread> threadList = new ArrayList<Thread>(); // Creating a list of thread for joining them later
		Runner runner = new Runner();
		long entry = Calendar.getInstance().getTimeInMillis();
		System.out.println();
		while(count <= 1000000000) {
			thread = new Thread(runner);
			threadList.add(thread);
			thread.start();
			count++;
		}
		threadList.stream().forEach(thread1 -> { // lambda operation for joining the threads
			try {
				thread1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		long exit1 = Calendar.getInstance().getTimeInMillis();
		System.out.println("First time check: " + (exit1 - entry));
		//runner.print();
		long exit2 = Calendar.getInstance().getTimeInMillis();
		System.out.println("First time check: " + (exit2 - entry));
	}

}
