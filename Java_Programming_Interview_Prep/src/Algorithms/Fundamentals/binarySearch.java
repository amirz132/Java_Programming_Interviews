package Algorithms.Fundamentals;
import java.util.Arrays;

public class binarySearch {
	
	public static int rank(int key, int [] a) {
		int lo = 0; 	// initialize declaration statement
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;	// expression
			if	(key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else	return mid;
		}
		return -1;	// return statement
	}
	
	/**
	 * Driver function for recursive implementation of binary search
	 * @param key: element to be found
	 * @param array a
	 * @return
	 */
	public static int rank_recursive(int key, int[] a) {
		return rank_recursive(key, a, 0, a.length - 1);
	}
	
	public static int rank_recursive(int key, int[] a, int lo, int hi) {
		//Index of key in a[], if present, 
		//is not smaller than lo
		//and not larger than hi
		
		if (lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid]) return rank_recursive(key, a, lo, mid-1);
		else if (key > a[mid]) return rank_recursive(key, a, mid+1, hi);
		else return mid;
	}
	
	public static void main(String[] args) {
		
		int [] whitelist = In.readInts(args[0]);
		
		Arrays.sort(whitelist);	// call method in Java library
		
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if (rank(key, whitelist) == -1)
				StdOut.println(key);
		}
		
	}

}
