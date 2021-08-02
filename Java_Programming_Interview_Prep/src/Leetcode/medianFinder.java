package Leetcode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.*;

public class medianFinder {
	
	private static Queue<Integer> minHeap;
	private static Queue<Integer> maxHeap;
	
	public medianFinder() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
	}
	
	public void addNum(int num) {
		int leftSize = maxHeap.size();
		int rightSize = minHeap.size();
		
		//first case: leftSize == 0
		if(leftSize == 0) {
			maxHeap.add(num);
		}
		
		//second case: leftSize == rightSize
		else if(leftSize == rightSize) {
			if(num < minHeap.peek()) {
				maxHeap.add(num);
			}
			else {
				int temp = minHeap.peek();  // save root of minHeap
				minHeap.poll();	  // remove root from minHeap
				minHeap.add(num); // add the num to minHeap
				maxHeap.add(temp); // add the previous root of minHeap to maxHeap
			}
		}
		
		//third Case: leftSize > rightSize by 1
		else {
			if(minHeap.size() == 0) {
				if(num > maxHeap.peek()) {
					minHeap.add(num);
				}
				else {
					int temp = maxHeap.peek();
					maxHeap.poll();
					maxHeap.add(num);
					minHeap.add(temp);
				}
			}
			else if(num >= minHeap.peek()) {
				minHeap.add(num);
			}
			else {
				if(num < maxHeap.peek()) {
					int temp = maxHeap.peek();
					maxHeap.poll();
					maxHeap.add(num);
					minHeap.add(temp);
				}
				else {
					minHeap.add(num);
				}
			}
		}
		
	}
	
	
	public double findMedian() {
		int left_size = maxHeap.size();
		int right_size = minHeap.size();
		double result = 0;
		
		if(left_size > right_size) {
			result = (double) maxHeap.peek();
		}
		else {
			result = (double) ((maxHeap.peek()) + (minHeap.peek())) / 2;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		medianFinder obj = new medianFinder();
		
		obj.addNum(1);
		obj.addNum(2);
		double param1 = obj.findMedian();
		obj.addNum(3);
		double param2 = obj.findMedian();
		System.out.println(param1);
		System.out.println(param2);
	}

}
