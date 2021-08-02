package Leetcode;

import java.util.*;

public class threeSum {
	
	public static List<List<Integer>> threeSum(int[] nums) {
		if (nums.length < 3) {
			return Collections.emptyList();
		}
		
		Set<List<Integer>> set = new HashSet<>();
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			int target = -nums[i];
			int j = i + 1;
			int k = nums.length - 1;
			
			while (j < k) {
				if (nums[j] + nums[k] == target) {
					set.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
				}
				else if (nums[j] + nums[k] > target) {
					k--;
				}
				else {
					j++;
				}
			}
		}
		return new ArrayList(set);
	}
	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> newSet = threeSum(nums);
		System.out.println(newSet);
	}
}
