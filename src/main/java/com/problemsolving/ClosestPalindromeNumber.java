package com.problemsolving;

public class ClosestPalindromeNumber {
	public static void main(String[] args) {
		int no = 289;

		int digits = getDigits(no);
		int oddOffset = 0;
		int midDigit = -1;


		if(digits % 2 != 0) {
			oddOffset = 1;
		}
		int firstPart = (int) (no / Math.pow(10, digits / 2 + oddOffset));
		int firstPartInc = firstPart + 1;

		if(oddOffset != 0) {
			midDigit = (int) ((no / Math.pow(10, digits / 2)) % 10);
		}
		//	System.out.println(firstPart);
		//		System.out.println(midDigit);

		int reverseFirstPart = reverse(firstPart);
		int reverseFirstPartInc = reverse(firstPartInc);
		//		System.out.println(reverse);

		if(midDigit == -1) {
			int result1 = (int) (firstPart * Math.pow(10, digits / 2));
			result1 += reverseFirstPart;

			int result2 = (int) (firstPartInc * Math.pow(10, digits / 2));
			result2 += reverseFirstPartInc;

			int result = Math.abs(result1 - no) < Math.abs(result2 - no) ? result1 : result2;
			System.out.println(result1);
			System.out.println(result2);
			System.out.println(result);
		} else {
			int result1 = firstPart * 10;
			result1 += midDigit;

			int result2 = result1 + 1;
			result2 = (int) (result2 * Math.pow(10, digits / 2));
			result2 += reverseFirstPartInc;

			result1 = (int) (result1 * Math.pow(10, digits / 2));
			result1 += reverseFirstPart;

			int result = Math.abs(result1 - no) < Math.abs(result2 - no) ? result1 : result2;
			System.out.println(result1);
			System.out.println(result2);
			System.out.println(result);
		}

	}

	private static int reverse(int number) {
		int reverse = 0;
		while(number != 0) {
			reverse = 10 * reverse + number % 10;
			number = number / 10;
		}
		return reverse;
	}

	private static int getDigits(int no) {
		int digits = 0;
		while(no > 0) {
			digits++;
			no = no / 10;
		}
		return digits;
	}
}
