package com.algorithms.strings;

public class CompressString {

	public static void main(String[] args) {

		String str = "aabCcccccaaa";

		StringBuilder compressedStrBuilder = new StringBuilder();

		char ch = str.charAt(0);
		int count = 1;

		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == ch) {
				count++;
			} else {
				compressedStrBuilder.append(ch).append(count);
				ch = str.charAt(i);
				count = 1;
			}
		}
		String compressedString = compressedStrBuilder.append(ch).append(count).toString();
		if(compressedString.length() > str.length()) {
			compressedString = str;
		}
		System.out.println(compressedString);
	}
}
