package com.problemsolving;

import java.util.*;

public class PowerSet {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>(Arrays.asList(0, 1));

		List<Set<Integer>> powerSet = new ArrayList<>();
		powerSet(set, powerSet);

		System.out.println(powerSet);
	}

	private static void powerSet(Set<Integer> set, List<Set<Integer>> powerSet) {
		for(Integer element : set) {
			final List<Set<Integer>> sets = powerSetOfElement(element);
			powerSet.addAll(sets);
		}
	}

	private static List<Set<Integer>> powerSetOfElement(Integer element) {
		if(element == 0) {
			return Collections.singletonList(new HashSet<>(Collections.singletonList(0)));
		}

		final List<Set<Integer>> sets = powerSetOfElement(element - 1);
		final List<Set<Integer>> copyList = new ArrayList<>(sets);

		for(Set<Integer> set : copyList) {
			set.add(element);
		}

		copyList.addAll(sets);
		return copyList;
	}
}
