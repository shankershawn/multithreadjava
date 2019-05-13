/**
 * 
 */
package com.shankarsan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

/**
 * @author SHANKARSAN
 *
 */
public class Runner implements Runnable {

	private List<Integer> integerList = new ArrayList<Integer>();
	Map<List<Integer>, Double> resultMap = new HashMap<>();
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		calculateMean();
	}							
	
	public synchronized void calculateMean() {
		integerList.add(new Random().nextInt(1000));
		int sum = 0;
		double avg = 0.0d;
		for(Integer myInteger : integerList) {
			sum += myInteger;
		}
		avg = sum/integerList.size();
		resultMap.put(new ArrayList<Integer>(integerList), avg);
	}
	
	public void print() {
		Set<Entry<List<Integer>, Double>> resultMapEntry = null;
		/*List<Integer> integerListPrint = null;*/
		if(null != resultMap) {
			resultMapEntry = resultMap.entrySet();
			for(Entry<List<Integer>, Double> entry : resultMapEntry) {
				/*integerListPrint = entry.getKey();
				for(Integer integerPrint : integerListPrint) {
					System.out.print(integerPrint + ", ");
				}*/
				System.out.println("The average is " + entry.getValue());
			}
		}
	}
}
