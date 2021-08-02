package Leetcode;

public class containerWithMostWater {
	
	public static int maxArea(int[] H) {
		int area= 0, result = 0, i = 0, j = H.length - 1;
		while (i < j) {
			if(H[i] < H[j]) {
				result = H[i] * (j - i);
				i++;
			}
			else {
				result = H[j] * (j - i);
				j--;
			}
			if (result > area) {
				area = result;
			}
		}
		return area;
	}
	
	
	public static void main(String[] args) {
		int[] height = {4, 3, 2, 1, 4};
		int maximum = maxArea(height);
		System.out.println(maximum);
	}

}
