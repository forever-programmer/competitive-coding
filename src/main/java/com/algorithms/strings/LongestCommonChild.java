package com.algorithms.strings;

public class LongestCommonChild {
	public static void main(String[] args) {
		String str1 = "ABXADNGL";
		String str2 = "BARKGLSP";

		System.out.println(LCS(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));

	}

	private static int LCS(char[] A, char[] B, int aLength, int bLength) {
		if(aLength == 0 || bLength == 0) {
			return 0;
		}
		if(A[aLength - 1] == B[bLength - 1]) {
			return LCS(A, B, aLength - 1, bLength - 1) + 1;
		}

		return Math.max(LCS(A, B, aLength, bLength - 1),
		                         LCS(A, B, aLength - 1, bLength));

	}

	private static void printArray(char[] A, int aLength) {
		for(int i = 0; i < aLength; i++) {
			System.out.print(A[i]);
		}
		System.out.println();
	}

}
