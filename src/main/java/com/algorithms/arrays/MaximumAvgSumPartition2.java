package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumAvgSumPartition2 {

	private  static List<String> combinations = new ArrayList<>();

	public static void main(String[] args) {
		int [] A =  { 9, 10, 2, 3, 9 };
		int K = 3;
		System.out.println(largestSumOfAverages(A,K));
		System.out.println(combinations);
	}

	private static double largestSumOfAverages(int[] a, int k) {
		final int length = a.length;
		return score(a, 0, length, k);
	}

	private static double score(int[] a, int start, int end, int k) {
		combinations.add("[" + start + ":" + end + ":" + k + "]");
		if(k == 1) {
			return average(a, start, end);
		}

		double max = 0;

		for(int i = start; i < end - 1; i++) {
			final double result = average(a, start, i + 1) + score(a, i + 1, end, k - 1);
			max = Math.max(max, result);
		}

		return max;
	}

	private static double average(int[] a, int start, int end) {
		if(start == end) {
			return a[start];
		}

		double sum = 0;
		for(int i = start; i < end; i++) {
			sum += a[i];
		}

		return sum / (end - start);
	}
}
