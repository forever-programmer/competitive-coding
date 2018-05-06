package com.algorithms.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MoveZerosToTheEnd {

	public static void main(String[] args) {
		//int[] arr = new int[]{1, 4, 0, 3, 2, 0, 0, 9, 1, 0, 18};
		List<int[]> arrays = new ArrayList<>();

		Scanner s = new Scanner(System.in);
		int T = Integer.parseInt(s.nextLine());
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(s.nextLine());
			int[] arr = new int[N];
			for(int j = 0; j < N; j++) {
				arr[j] = s.nextInt();
			}
			arrays.add(arr);
		}

		for(int[] arr : arrays) {
			for(int i = 0; i < arr.length - 1; i++) {
				if(arr[i] == 0) {
					int j = i + 1;
					while(j<arr.length && arr[j] == 0) {
						j++;
					}
					if(j < arr.length) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}
}
