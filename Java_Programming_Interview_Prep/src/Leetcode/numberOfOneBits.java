package Leetcode;

public class numberOfOneBits {
	
	/**
	 * Function that takes an unsigned integer and returns the number of '1'
	 * bits it has (Hamming Weight).
	 * Note: no unsigned integer type in Java. The integer will be given as a 
	 * signed integer type, although it would not affect the implementation, as the 
	 * integer's internal binary representation is the same, whether it is signed or unsigned.
	 * In Java, the compiler represents the signed integers using 2's complement notation.
	 * 
	 * Approach 1: Loop and Flip.
	 * 
	 * Algorithm: Check each of the 32 bits of the number. If the bit is 1, we add one to the number
	 * of 1-bits. We can check the ith bit of a number using a bit mask. We start with a mask m = 1, because
	 * the binary representation of 1 is 000000000000000000000000000000001. 
	 * A logical AND between any number and the mask 1 gives us the least significant bit of this number.
	 * To check the next bit, we shift the mask to the left by one.
	 * 000000000000000000000000000000010.
	 * 
	 * Complexity: Time-complexity: O(1), Space-Complexity: O(1).
	 */
	public int hammingWeight(int n) {
		int bits = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & mask) != 0) {
				bits++;
			}
			mask <<= 1;
		}
		return bits;
	}
	
	
	/**
	 * Approach 2: Bit Manipulation Trick.
	 * Algorithm: Instead of checking every bit of the number, we repeatedly flip the least
	 * significant 1-bit of the number to 0, and add 1 to the sum. As soon as the number becomes 0,
	 * we know that it does not have any more 1-bits, and we return the sum.
	 * 
	 * Key idea is to realize that for any number n, doing a bit-wise AND of n and n-1 flips the least-significant 1-bit in n
	 * to 0. In binary representation, the least significant 1-bit in n always corresponds to a 0-bit in n-1. Therefore, ANDing
	 * the two numbers n and n-1 always flips the least significant 1-bit in n to 0, and keeps all other bits the same.
	 */
	public int hammingWeightBM(int n) {
		int sum = 0;
		while (n != 0) {
			sum++;
			n &= (n - 1);
		}
		return sum;
	}
	

}
