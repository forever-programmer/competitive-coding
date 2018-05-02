package com.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterleaveLists {

	public static void main(String[] args) {
		List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3),
		                                          Arrays.asList(9, 0),
		                                          Arrays.asList(5),
		                                          Arrays.asList(-4, -5, -2, -3, -1));

		List<Integer> output = new ArrayList<>();

		int maxSize = 0;

		for(List<Integer> list : lists) {
			maxSize += list.size();
		}

		for(int i = 0; i < maxSize; i++) {
			for(List<Integer> list : lists) {
				if(i < list.size()) {
					output.add(list.get(i));
				}
			}
		}

		System.out.println(output);

	}
}
