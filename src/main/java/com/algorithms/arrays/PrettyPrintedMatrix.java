package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class PrettyPrintedMatrix {
	public static void main(String[] args) {
		int N = 4;

		ArrayList<ArrayList<Integer>> matrix = getPrettyPrintedMatrix(N);
		for(ArrayList<Integer> integers : matrix) {
			System.out.println(integers);
		}
	}

	private static ArrayList<ArrayList<Integer>> getPrettyPrintedMatrix(int A) {
		if(A == 1) {
			ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
			lists.add(new ArrayList<>(Collections.singletonList(1)));
			return lists;
		}
		final int newSize = (A * 2) - 1;

		final ArrayList<ArrayList<Integer>> matrix = getPrettyPrintedMatrix(A - 1);
		for(ArrayList<Integer> integers : matrix) {
			if(integers.size() != newSize) {
				integers.add(0, A);
				integers.add(A);
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < newSize; i++) {
			list.add(A);
		}
		matrix.add(0, list);
		matrix.add(list);
		return matrix;
	}
}
