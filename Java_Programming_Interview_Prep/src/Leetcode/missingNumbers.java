package Leetcode;

import java.util.*;

public class missingNumbers {
	
	// Time-Complexity: O(nlgn): for-loop:(O(n)), sort: O(nlgn)
	// Space-Complexity: O(1) (or O(n)): nums is sorted in place, so 
	// additional space need not be allocated.
	public static int missingNumbersBruteForce(int[] nums) {
		
		Arrays.sort(nums);
		
		if(nums[nums.length - 1] != nums.length) {
			return nums.length;
		}
		
		if(nums[0] != 0) {
			return 0;
		}
		
		for(int i = 1; i < nums.length; i++) {
			int expectedNumber = nums[i - 1] + 1;
			if (nums[i] != expectedNumber) {
				return expectedNumber;
			}
		}
		
		// if no numbers are missing
		return -1;
	}
	
	//Time-complexity: O(n): 
	
	public static int missingNumbersHashSet(int[] nums) {
		Set<Integer> hashSet = new HashSet<Integer>();
		for(int num : nums) {
			hashSet.add(num);
		}
		
		int expectedNumCount = nums.length + 1;
		
		for(int i = 0; i < expectedNumCount; i++) {
			if(!hashSet.contains(i)) {
				return i;
			}
		}
		
		//no missing numbers
		return -1;
	}
	
	//Time-complexity: O(n): Assuming XOR is a constant-time operation: n(O(1)) = O(n)
	//Space-complexity: O(1): Algorithm allocates only constant additional space.
	public static int missingNumberBitManipulation(int[] nums) {
		int missing = nums.length;
		for (int i = 0; i < nums.length; i++) {
			missing ^= i ^ nums[i];
		}
		return missing;
	}
	
	//Time-Complexity: O(n): Sum function takes O(1) time. Done n times.
	//Space-Complexty: O(1): Constant memory usage.
	public static int missingNumberGaussFormula(int[] nums) {
		int n = nums.length;
		int expectedSum = n * (n + 1) / 2;
		int actualSum = 0;
		for(int i = 0; i < nums.length; i++) {
			actualSum += nums[i];
		}
		return expectedSum - actualSum;
	}
	
	public static void main(String[] args) {
		int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
		int missingNumBrute = missingNumbersBruteForce(nums);
		int missingNumHash = missingNumbersHashSet(nums);
		int missingNumBit = missingNumberBitManipulation(nums);
		int missingNumGauss = missingNumberGaussFormula(nums);
		System.out.println(missingNumBrute);
		System.out.println(missingNumHash);
		System.out.println(missingNumBit);
		System.out.println(missingNumGauss);
	}

} 