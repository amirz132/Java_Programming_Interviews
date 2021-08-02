package Leetcode;

import java.util.*;

public class productExceptSelf {
	
	public static int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			int product = 1;
			for(int j = 0; j < nums.length; j++) {
				if(i != j) {
					product = product * nums[j];
				}
			}
			result[i] = product;
		}
		return result;
	}
	
	public static int[] productExceptSelfEfficient(int[] nums) {
		
		int[] result = new int[nums.length];
		
		result[0] = 1;
		for(int i = 1; i < nums.length; i++) {
			result[i] = result[i-1] * nums[i-1];
		}
		
		int right = 1;
		for(int i = nums.length - 1; i >= 0; i--) {
			result[i] = right * result[i];
			right *= nums[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[4];
		int[] result = new int[nums.length];
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 3;
		nums[3] = 4;
		
		result = productExceptSelfEfficient(nums);
		
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
