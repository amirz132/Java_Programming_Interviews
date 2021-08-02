package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class containsDuplicate {
	
	public static boolean containsDuplicate(int[] nums) {
		boolean hasDuplicate = false;
		HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			if(tracker.containsKey(nums[i])) {
				hasDuplicate = true;
				break;
			}
			else {
				tracker.put(nums[i], 1);
			}
		}
		return hasDuplicate;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[10];
		nums[0] = 1;
		nums[1] = 1;
		nums[2] = 1;
		nums[3] = 3;
		nums[4] = 3;
		nums[5] = 4;
		nums[6] = 3;
		nums[7] = 2;
		nums[8] = 4;
		nums[9] = 2;
		
		boolean duplicate = containsDuplicate(nums);
		System.out.println(duplicate);
	}

}
