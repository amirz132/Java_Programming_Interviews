package Leetcode;

public class sumOfTwoIntegers {
	
	/**
	 * Given two integers a and b, return the sum of the two integers
	 * without using the operators '+' and '-'.
	 * Strategy: Use bit manipulation.
	 * Iterative approach.
	 * 
	 * @param a: integer a
	 * @param b: integer b
	 * @return sum: sum of integers a and b.
	 * 
	 */
	public static int getSum(int a, int b) {
		while(b != 0) {
			//filter out identical component
			int carry = a & b;
			//filter out complementary component
			a = a ^ b;
			
			//shift b to the left the common components, assign to b.
			//on next iteration, there will be fewer and fewer common components.
			//gradually b will converge to 0 once we have shifted the integer to the left.
			//the appropriate number of times.
			b = carry << 1;
		}
		return a;
	}
	
	public static int getSubtract(int a, int b) {
		while(b != 0) {
			int borrow = (~a) & b;
			a = a ^ b;
			b = borrow << 1;
		}
		return a;
	}
	
	//Recursive approach to getSum
	public static int getSumRecursive(int a, int b) {
		return (b == 0) ? a : getSumRecursive(a ^ b, (a & b) << 1);
	}
	
	//Recursive approach to getSubtract
	public static int getSubtractRecursive(int a, int b) {
		return (b == 0) ? a : getSubtractRecursive(a ^ b, (~a & b) << 1);
	}
	
	
	public static void main(String[] args) {
		int a = 3;
		int b = 2;
		int sum = getSum(a,b);
		System.out.println(sum);
	}

}
