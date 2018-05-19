package com.algorithms.strings;

public class HighestValuePalindrome {

	static String highestValuePalindrome(String s, int n, int k) {
		final char[] chars = s.toCharArray();

		for(int i = 0; i <= n/2; i++) {
			final char ch1 = chars[i];
			final char ch2 = chars[n - 1 - i];
			if(ch1 != ch2) {
				if(k-- > 0) {
					final int i1 = Integer.parseInt(Character.toString(ch1));
					final int i2 = Integer.parseInt(Character.toString(ch2));

					if(i1 > i2) {
						chars[n - 1 - i] = (char) (i1 + '0');
					} else {
						chars[i] = (char) (i2 + '0');
					}
				} else {
					return "-1";
				}
			}
		}

		return String.valueOf(chars);
	}

	public static void main(String[] args) {
		String s = "34493";
		int n = s.length();
		int k = 1;

		String result = highestValuePalindrome(s, n, k);

		System.out.println(result);
	}
}

