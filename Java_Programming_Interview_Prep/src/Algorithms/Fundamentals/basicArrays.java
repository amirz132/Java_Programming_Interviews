package Algorithms.Fundamentals;

public class basicArrays {
	
	/**
	 * Find the maximum of the array values
	 * @param array a
	 */
	public static void findMax(double [] a) {
		double max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) max = a[i];
		}
	}
	
	/**
	 * Compute the average of double array values
	 * @param array a
	 * @return double average: average sum of array values
	 */
	public static double computeAverage(double[] a) {
		int N = a.length;
		double sum = 0.0;
		for (int i = 0; i < N; i++) {
			sum += a[i];
		}
		double average = sum / N;
		return average;
	}
	
	/**
	 * Method to copy one array to another
	 * @param array a
	 */
	public static void copyToAnotherArray(double[] a) {
		int N = a.length;
		double[] b = new double[N];
		for (int i = 0; i < N; i++) {
			b[i] = a[i];
		}
	}
	
	/**
	 * Method to reverse the elements within an array.
	 * @param array a
	 */
	public static void reverseArray(double[] a) {
		int N = a.length;
		for (int i = 0; i < N/2; i++) {
			double temp = a[i];
			a[i] = a[N-i-1];
			a[N-i-1] = temp;
		}
	}
	
	/**
	 * Method for matrix-matrix multiplication(square matrices)
	 * @param 2D array a
	 * @param 2D array b
	 * @return 2D array c: product of two 2D arrays
	 */
	public static double[][] squareMatrices(double[][] a, double[][] b) {
		int N = a.length;
		double[][] c = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// Compute dot product of row i and column j
				for (int k = 0; k < N; k++) {
					c[i][j] += a[i][k]*b[k][j];
				}
			}
		}
		return c;
	}
	

}
