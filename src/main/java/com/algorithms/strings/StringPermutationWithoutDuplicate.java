package com.algorithms.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringPermutationWithoutDuplicate {
	public static void main(String[] args) {
		final String str = "abc";
		List<String> permutations = getAllPermutations(str);

		Collections.sort(permutations);
		System.out.println(permutations);
	}

	private static List<String> getAllPermutations(String str) {
		if(str == null || str.length() == 0) {
			return new ArrayList<>();
		}

		if(str.length() == 1) {
			return Collections.singletonList(str);
		}

		List<String> permutations = new ArrayList<>();

		int n = str.length();
		String lastChar = str.substring(n - 1);

		for(String permutation : getAllPermutations(str.substring(0, n - 1))) {
			final int length = permutation.length();
			for(int i = 0; i <= length; i++) {
				StringBuilder sb = new StringBuilder();
				sb.append(permutation, 0, i).append(lastChar).append(permutation, i, length);
				permutations.add(sb.toString());
			}
		}

		return permutations;
	}

}
