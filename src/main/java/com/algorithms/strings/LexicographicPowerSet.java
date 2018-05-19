package com.algorithms.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexicographicPowerSet {

	public static void main(String[] args) {
		String str = "abc";
		List<String> powerSet = new ArrayList<>();

		powerSet(powerSet, str, str.length());
		Collections.sort(powerSet);
		System.out.println(powerSet);
	}

	private static void powerSet(List<String> powerSet, String str, int length) {
		if(length == 1) {
			powerSet.add(Character.toString(str.charAt(length - 1)));
		} else {
			List<String> list = new ArrayList<>();
			powerSet(powerSet, str, length - 1);

			list.add(Character.toString(str.charAt(length - 1)));
			for(String s : powerSet) {
				list.add(s + Character.toString(str.charAt(length - 1)));
			}
			powerSet.addAll(list);
		}

	}
}
