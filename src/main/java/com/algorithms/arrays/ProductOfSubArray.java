package com.algorithms.arrays;

import java.util.Arrays;

public class ProductOfSubArray {

	private static int[] leftSubArrayProduct;

	private static int[] rightSubArrayProduct;

	public static void main(String[] args) {

		int[] arr = new int[]{1, 2, 3, 4, 5, 6};

		int[] target = new int[arr.length];

		leftSubArrayProduct = new int[arr.length];
		rightSubArrayProduct = new int[arr.length];

		for(int i = 0; i < arr.length ; i++) {
			target[i] = leftSubArrayProduct(arr, i) * rightSubArrayProduct(arr, i);
		}

		System.out.println(Arrays.toString(target));

	}

	private static int leftSubArrayProduct(int[] arr, int index) {
		if(index == 0) {
			return 1;
		} else {
			return leftSubArrayProduct(arr, index - 1) * arr[index - 1];
		}
	}

	private static int rightSubArrayProduct(int[] arr, int index) {
		if(index == arr.length - 1) {
			return 1;
		} else {
			return arr[index + 1] * rightSubArrayProduct(arr, index + 1);
		}
	}
}
