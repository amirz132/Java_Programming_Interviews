package Leetcode;

import java.util.*;

public class maximumSubArray {
	
	public static int maxSubArray(int[] nums) {
		return maxArraySum(nums, 0, nums.length - 1);
	}
	
	public static int maxArraySum(int[] nums, int low, int high) {
		if(low == high) {
			return nums[low];
		}
		else {
			//divide
			int mid = (low + high) / 2;
			
			//conquer
			int leftSum = maxArraySum(nums, low, mid);
			int rightSum = maxArraySum(nums, mid+1, high);
			
			//combine
			int crossSum = crossSum(nums, low, high);
			return Math.max(crossSum, Math.max(leftSum, rightSum));
		}
	}
	
	public static int crossSum(int[] nums, int low, int high) {
		int mid = low + (high - low) / 2;
		
		//left
		int leftSum = 0, leftMax = Integer.MIN_VALUE;
		for(int i = mid; i >= 0; i--) {
			leftSum += nums[i];
			leftMax = Math.max(leftMax, leftSum);
		}
		
		//right
		int rightSum = 0, rightMax = Integer.MIN_VALUE;
		for(int i = mid+1; i <= high; i++) {
			rightSum += nums[i];
			rightMax = Math.max(rightMax, rightSum);
		}
		
		return leftMax + rightMax;
	}
	
	public static void main(String[] args) {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int maximum = maxSubArray(nums);
		System.out.println(maximum);
	}

}
