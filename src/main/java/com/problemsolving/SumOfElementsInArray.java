package com.problemsolving;

public class SumOfElementsInArray {

	private static final int CONSTANT = 60;

	public static void main(String[] args) {
		int[] sortedArray = new int[]{-3, -1, 0, 5, 7, 9, 15, 43, 109, 502};

		if(validate(sortedArray)) {
			System.out.println("Solution exists");
		} else {
			System.out.println("No solution exists");
		}

	}

	private static boolean validate(int[] sortedArray) {
		int pivotPtr = 0;

		while(pivotPtr < sortedArray.length - 2) {
			int leftPtr = pivotPtr + 1;
			int rightPtr = sortedArray.length - 1;
			while(leftPtr < rightPtr) {
				final int sum = sortedArray[pivotPtr] + sortedArray[leftPtr] + sortedArray[rightPtr];
				if(sum == CONSTANT) {
					System.out.println(sortedArray[pivotPtr] + ", " +
					                   sortedArray[leftPtr] + ", " +
					                   sortedArray[rightPtr] + " = " + CONSTANT);
					return true;
				}
				if(sum < CONSTANT) {
					leftPtr++;
				} else {
					rightPtr--;
				}
			}
			pivotPtr++;
		}
		return false;
	}
}
