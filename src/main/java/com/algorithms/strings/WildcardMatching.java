package com.algorithms.strings;

public class WildcardMatching {

	/*public static void main(String[] args) {
		String text = "bacxaababx";
		String pattern = "*ba*ab?";
		//String simplifiedPattern = getSimplifiedPattern(pattern);

		if(patternMatches(text, pattern, text.length(), pattern.length())) {
			System.out.println("Pattern matches the word");
		} else {
			System.out.println("Pattern doesn't match!");
		}
	}

	private static boolean patternMatches(String text, String pattern, int n, int m) {
		//System.out.print("Comparing (" + (n - 1) + ", " + (m - 1) + ") ");

		if(m == 0 && n == 0) {
			//System.out.println();
			return true;
		}

		if(n == 0) {
			if(pattern.charAt(m - 1) == '*') {
				return patternMatches(text, pattern, n, m - 1);
			} else {
				return false;
			}
		}

		if(m == 0) {
			//System.out.println();
			return false;
		}

//		System.out.print(text.charAt(n - 1) + ", " + pattern.charAt(m - 1));
//		System.out.println();

		if(text.charAt(n - 1) == pattern.charAt(m - 1) || pattern.charAt(m-1) == '?') {
			return patternMatches(text, pattern, n - 1, m - 1);
		}

		if(pattern.charAt(m - 1) == '*') {
			return patternMatches(text, pattern, n, m - 1) ||
			       patternMatches(text, pattern, n - 1, m);
		}

		return false;
	}*/

	public static void main(String[] args) {
		String word = "bbbba";
		String pattern = ".*a*a";

		System.out.println(matches(word, pattern, 0, 0));
	}


	private static boolean matches(String word, String pattern, int i, int j) {
		System.out.println(i + ", " + j);
		if(i == word.length() && j == pattern.length()) {
			return true;
		}

		if(j < pattern.length() - 1 && pattern.charAt(j + 1) == '*') {
			if(i != word.length() && (word.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.')) {
				return matches(word, pattern, i + 1, j) ||
				       matches(word, pattern, i, j + 2);
			} else {
				return matches(word, pattern, i, j + 2);
			}
		} else if(j < pattern.length()) {
			if(i != word.length() && (word.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.')) {
				return matches(word, pattern, i + 1, j + 1);
			} else {
				return false;
			}
		} else {
			return false;
		}

	}
}
