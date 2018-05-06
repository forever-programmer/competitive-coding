package com.algorithms.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidDictionaryWord {

	private static final Set<String> dictionary =
			new HashSet<>(Arrays.asList("jump", "jumped", "over", "some", "something"));

	public static void main(String[] args) {

		String word = "jumpedoversomething";

		if(isValidDictionaryWord(word)) {
			System.out.println("Word can be formed by dictionary words");
		} else {
			System.out.println("Word cannot be formed by dictionary words");
		}
	}

	private static boolean isValidDictionaryWord(String word) {
		StringBuilder tempWord = new StringBuilder();
		for(int i = 0; i < word.length(); i++) {
			tempWord.append(word.charAt(i));
			if(dictionary.contains(tempWord.toString())) {
				if(isValidDictionaryWord(word.substring(i + 1))) {
					return true;
				}
			}
		}
		return dictionary.contains(tempWord.toString());
	}
}
