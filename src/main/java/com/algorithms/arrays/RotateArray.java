package com.algorithms.arrays;

public class RotateArray {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
		final int k = 3;

		final int n = arr.length;
		for(int i = 0; i < n; i++) {
			int temp = arr[i + k];
			arr[i + k] = arr[i];
			arr[i] = arr[n - k + i];
		}
	}
}
