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
		int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
		boolean duplicate = containsDuplicate(nums);
		System.out.println(duplicate);
	}

}
