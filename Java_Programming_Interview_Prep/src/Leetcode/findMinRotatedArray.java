package Leetcode;

public class findMinRotatedArray {
	
	public static int findMin(int[] nums) {
		return findMinBinarySearch(nums, 0, nums.length - 1);
	}
	
	public static int findMinBinarySearch(int[] nums, int low, int high) {
		while(low < high) {
			int mid = low + (high - low) / 2;
			
			if(nums[mid] == nums[high]) {
				high--;
			}
			else if(nums[mid] > nums[high]) {
				low = mid + 1;
			}
			else {
				high = mid;
			}
		}
		return nums[high];
	}
	
	public static void main(String[] args) {
		int[] nums = {11, 13, 15,17};
		int maximum = findMin(nums);
		System.out.println(maximum);
	}

}
