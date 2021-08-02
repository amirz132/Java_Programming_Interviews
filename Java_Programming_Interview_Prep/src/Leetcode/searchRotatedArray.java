package Leetcode;

public class searchRotatedArray {
	
	public static int search(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length-1);
	}
	
	public static int binarySearch(int[] nums, int target, int low, int high) {
		if(low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
			
		if(nums[mid] == target) {
			return mid;
		}
		if(nums[low] <= nums[mid]) {
			//Assuming first-half subarray is sorted.
			if(target >= nums[low] && target <= nums[mid]) {
				return binarySearch(nums, target, low, mid-1);
			}
				
			return binarySearch(nums, target, mid + 1, high);	
			}
		
		//Assuming first-half subarray is not sorted.
		if(target >= nums[mid] && target <= nums[high]) {
			return binarySearch(nums, target, mid + 1, high);
		}
		
		return binarySearch(nums, target, low, mid-1);
	
	}
	
	
	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int found = search(nums, 0);
		System.out.println(found);
	}

}
