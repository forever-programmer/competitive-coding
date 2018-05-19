package com.algorithms.arrays;

public class LIS {
	static int max_ref; // stores the LIS


	public static void main(String[] args) {
		int[] arr = new int[]{10, 22, 9, 33, 21, 50, 41, 16};

		max_ref = 1;
		int size = lic(arr, arr.length - 1);
		System.out.println(size);
		System.out.println(max_ref);
	}

	private static int lic(int[] arr, int n) {
		if(n == 0) {
			return 1;
		}

		int max_ending_here = 1;

		for(int i = 0; i < n; i++) {
			int res = lic(arr, i);
			if(arr[i] < arr[n]) {
				max_ending_here = Math.max(max_ending_here, res + 1);
			}
		}

		if(max_ref < max_ending_here) {
			max_ref = max_ending_here;
		}

		return max_ending_here;
	}
}
