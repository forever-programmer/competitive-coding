package com.problemsolving;

public class MinNoOfJumps {
	public static void main(String[] args) {
		int arr[] = new int[]{2, 3, 2, 1, 2, 2, 1, 4};

		int minNoOfJumps = minJumps(arr, 0, arr.length - 1);

		System.out.println(minNoOfJumps);
	}

	private static int minJumps(int[] arr, int src, int dest) {

		if(src == dest) {
			return 0;
		}

		if(arr[src] == 0) {
			return Integer.MAX_VALUE;
		}

		int min = Integer.MAX_VALUE;

		for(int i = src + 1; i <= dest && i <= src + arr[src]; i++) {
			int jump = minJumps(arr, i, dest);
			if(jump + 1 < min) {
				min = jump + 1;
			}
		}
		if(min != Integer.MAX_VALUE) {
			System.out.println(src);
		}
		return min;
	}
}
