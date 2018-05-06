package com.algorithms.lists;

import java.util.Arrays;

public class SumOf3Elements {

	public static void main(String[] args) {

		int[] array = new int[]{1, 3, 4, 5, 6, 11, 16, 23, 38, 41};
		final int sum = 60;
		final int noOfElements = 4;
		int[] solution = null;

		for(int i = 0; i < array.length; i++) {
			System.out.println("Iteration: " + (i + 1));
			solution = solution(noOfElements, sum, array, i, array.length - 1);
			if(solution != null) {
				break;
			}
		}

		System.out.println(Arrays.toString(solution));

	}

	private static int[] solution(int noOfElements, int sum, int[] input, int start, int end) {
		if(noOfElements == 2) {
			while(start < end) {
				final int tempSum = input[start] + input[end];
				if(tempSum == sum) {
					int[] solution = new int[2];
					solution[0] = input[start];
					solution[1] = input[end];
					return solution;
				} else if(tempSum < sum) {
					start++;
				} else {
					end--;
				}
			}
			return null;
		}

		final int pivot = input[start];
		int interimAddition = sum - pivot;
		final int[] solution = solution(noOfElements - 1, interimAddition, input, start + 1, end);
		if(solution != null) {
			final int[] retval  = new int[solution.length + 1];
			System.arraycopy(solution, 0, retval, 0, solution.length);
			retval[solution.length] = pivot;
			return retval;
		}
		return null;
	}
}
