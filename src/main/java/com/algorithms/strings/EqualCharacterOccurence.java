package com.algorithms.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Sherlock considers a string to be valid if it all characters of the string appear the same number of times. It is
 * also valid if he can remove just character at index in the string, and the remaining characters will occur the
 * same number of times. Given a string , determine if it is valid.
 *
 * For example, if , it is a valid string because frequencies are . So is because we can remove one and have of each
 * character in the remaining string. If however, the string is not valid as we can only remove occurrence of . That
 * would leave character frequencies of .
 *
 * Input Format
 *
 * A single string .
 *
 * Constraints
 *
 *     Each character
 *
 * Output Format
 *
 * Print YES if string is valid, otherwise, print NO.
 *
 * Sample Input 0
 *
 * aabbcd
 *
 * Sample Output 0
 *
 * NO
 *
 * Explanation 0
 *
 * We would need to remove two characters, both c and d, from to make it valid. We are limited to removing only one
 * character, so is invalid.
 *
 * Sample Input 1
 *
 * aabbccddeefghi
 *
 * Sample Output 1
 *
 * NO
 *
 * Explanation 1
 *
 * Frequency counts for the letters are as follows:
 *
 * {'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}
 *
 * There are characters with a frequency of that would need to be removed: . If only one of those had been in the
 * string, it would have been valid.
 */

public class EqualCharacterOccurence {

	static String isValid(String s){
		boolean valid = true;

		Map<Character, Integer> characterCount = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			final char c = s.charAt(i);
			Integer count = characterCount.get(c);
			if(count == null) {
				count = 1;
			} else {
				count++;
			}
			characterCount.put(c, count);
		}

		int firstCharFreq = 0;
		int secondCharFreq = 0;
		int correctFreq = 0;
		Character firstChar = null;
		Character secondChar = null;
		Character anamolyChar = null;

		for(Character character : characterCount.keySet()) {
			if(firstCharFreq == 0) {
				firstChar = character;
				firstCharFreq = characterCount.get(character);
			} else if(secondCharFreq == 0) {
				secondChar = character;
				secondCharFreq = characterCount.get(character);
				if(firstCharFreq == secondCharFreq) {
					correctFreq = firstCharFreq;
				}
			} else {
				final Integer currentFreq = characterCount.get(character);

				if(correctFreq != 0) {
					if(currentFreq != correctFreq) {
						if(anamolyChar == null) {
							if(currentFreq - correctFreq == 1 || currentFreq == 1) {
								anamolyChar = character;
							} else {
								valid = false;
								break;
							}
						} else {
							valid = false;
							break;
						}
					}
				} else {
					if(currentFreq == firstCharFreq) {
						anamolyChar = secondChar;
						correctFreq = firstCharFreq;
						if(secondCharFreq - correctFreq != 1 && secondCharFreq != 1) {
							valid = false;
							break;
						}
					} else if(currentFreq == secondCharFreq) {
						anamolyChar = firstChar;
						correctFreq = secondCharFreq;
						if(correctFreq - firstCharFreq != 1 && firstCharFreq != 1) {
							valid = false;
							break;
						}
					} else {
						valid = false;
						break;
					}
				}
			}
		}

		System.out.println(characterCount);

		return valid ? "YES" : "NO";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String result = isValid(s);
		System.out.println(result);
	}
}
