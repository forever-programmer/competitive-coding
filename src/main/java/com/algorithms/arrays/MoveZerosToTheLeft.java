package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZerosToTheLeft {

	public static void main(String[] args) {
		List<int[]> arrays = new ArrayList<>();

		arrays.add(new int[]{0, 4, 0, 3, 2, 0, 0, 9, 1, 0});
		arrays.add(new int[]{0, 4, 0, 3, 2, 0, 0, 9, 10});
		arrays.add(new int[]{1, 4, 0, 3, 2, 0, 0, 9, 0, 0});

		for(int[] arr : arrays) {
			for(int i = arr.length - 1; i > 0; i--) {
				if(arr[i] == 0) {
					int j = i - 1;
					while(j >= 0 && arr[j] == 0) {
						j--;
					}
					if(j >= 0) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					} else {
						break;
					}
				}
				//System.out.println(i + ":" + Arrays.toString(arr));
			}
			//System.out.println();
			System.out.println(Arrays.toString(arr));
		}
	}
}
