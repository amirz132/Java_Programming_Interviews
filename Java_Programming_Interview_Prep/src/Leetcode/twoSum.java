package Leetcode;

import java.util.Arrays;
import java.util.HashMap;


public class twoSum {
	
	
	public static int[] twoSum(int[] nums, int target) {
		int N = nums.length;
		int[] res = new int[2];
		
		for(int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if(nums[i] + nums[j] == target) {
					res[0] = i;
					res[1] = j;
					break;
				}
			}
		}
		return res;
	}
	
	public static int[] twoSum_efficient(int[] nums, int target) {
		
		HashMap<Integer, Integer> tracker = new HashMap<Integer,Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			int diff = (Integer)(target - nums[i]);
			
			if(tracker.containsKey(diff)) {
				int toReturn[] = {tracker.get(diff), i};
				return toReturn;
			}
			
			tracker.put(nums[i], i);
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[3];
		nums[0] = 3;
		nums[1] = 2;
		nums[2] = 4;
		
		int[] res = new int[2];
		res = twoSum_efficient(nums, 6);
		
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

}
