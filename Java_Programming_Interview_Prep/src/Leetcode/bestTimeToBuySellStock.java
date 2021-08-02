package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class bestTimeToBuySellStock {
	
	public static int bestTimetoBuySellStock(int[] prices) {
		int localMax = 0;		
		for(int i = 0; i < prices.length; i++) {
			for(int j = i + 1; j < prices.length; j++) {
				int diff = prices[j] - prices[i];
				if(diff > localMax) {
					localMax = diff;
				}
			}
		}
		return localMax;
	}
	
	public static int bestTimeToBuySellStockEfficient(int[] prices) {
		int minimum = Integer.MAX_VALUE;
		int maximum = 0;
		for(int i = 0; i < prices.length; i++) {
			if(prices[i] < minimum) {
				minimum = prices[i];
			}
			else if(prices[i] - minimum > maximum) {
				maximum = prices[i] - minimum;
			}
		}
		return maximum;
	}
	
	public static void main(String[] args) {
		int[] prices = new int[6];
		prices[0] = 7;
		prices[1] = 1;
		prices[2] = 5;
		prices[3] = 3;
		prices[4] = 6;
		prices[5] = 4;
		
		int[] prices2 = new int[5];
		prices2[0] = 7;
		prices2[1] = 6;
		prices2[2] = 4;
		prices2[3] = 3;
		prices2[4] = 1;
		
		int bestTime = bestTimetoBuySellStock(prices);
		int bestTime2 = bestTimeToBuySellStockEfficient(prices);
		
		System.out.println(bestTime);
		System.out.println(bestTime2);
	}

}
