package com.algorithms.arrays;

import java.util.Arrays;

public class MaximumAvgSumPartition {

	private static final int SIZE = 10;
	private static double[][] memo = new double[SIZE][SIZE];

	private static double score(int n, int[] a, int k) {
		if(memo[n][k] > 0) {
			return memo[n][k];
		}

		double sum = 0;
		for(int i = n - 1; i > 0; i--) {
			sum += a[i];

			final double score = score(i, a, k - 1);
			final double sumAvg = sum / (n - i);
			memo[n][k] = Math.max(memo[n][k], score + sumAvg);
			System.out.println("memo[" + n + "][" + k + "]: " + memo[n][k]);
			System.out.println("score + sumAvg: " + (score + sumAvg));
		}
		return memo[n][k];
	}

	private static double largestSumOfAverages(int[] a, int k) {
		int n = a.length;
		double sum = 0;
		for(int i = 0; i < n; i++) {
			sum += a[i];
			memo[i + 1][1] = sum / (i + 1);
		}
		//printMemo();
		System.out.println(n);
		System.out.println(Arrays.toString(a));
		return score(n, a, k);
	}

	private static void printMemo() {
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				System.out.print(memo[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int [] A =  { 9, 10, 2, 3, 9 };
		int K = 3;
		System.out.println(largestSumOfAverages(A,K));
	}
}
