package com.problemsolving;

public class NextPalindromeNumber {

	public static void main(String[] args) {
		int inp = 9998;
		int digits = getDigits(inp);

		int initialInp = (int) (inp / Math.pow(10, digits / 2));
		int probablePalindrome = (int) (initialInp * Math.pow(10, digits / 2) + getReverse(initialInp));

		if(probablePalindrome <= inp) {
			initialInp++;
			probablePalindrome = (int) (initialInp * Math.pow(10, digits / 2) + getReverse(initialInp));
		}

		System.out.println(initialInp + "," + probablePalindrome);
	}

	private static int getReverse(int initialInp) {
		int result = 0;
		while(initialInp > 0) {
			result = result * 10 + initialInp % 10;
			initialInp = initialInp / 10;
		}
		return result;
	}

	private static int getDigits(int inp) {
		int digits = 0;
		while(inp > 0) {
			inp = inp / 10;
			digits++;
		}
		return digits;
	}
}