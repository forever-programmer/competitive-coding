package com.algorithms.arrays;

import java.util.*;

public class Test {

	static class Dummy {
		final String name;
		final int no;

		public Dummy(String name, int no) {
			this.name = name;
			this.no = no;
		}

		@Override public boolean equals(Object o) {
			if(this == o) {
				return true;
			}
			if(!(o instanceof Dummy)) {
				return false;
			}
			Dummy dummy = (Dummy) o;
			return no == dummy.no;
		}

		@Override public int hashCode() {

			return Objects.hash(no);
		}
	}

	public static void main(String[] args) {

		Dummy d1 = new Dummy("hello", 5);
		Dummy d2 = new Dummy("world", 6);
		Dummy d3 = new Dummy("dummy", 3);

		Set<Dummy> testSet = new TreeSet<>((o1, o2) -> o1.equals(o2) ? 0 : o1.no > o2.no ? 1 : -1);
		testSet.add(d1);
		testSet.add(d3);
		testSet.add(d2);

		for(Dummy dummy : testSet) {
			System.out.println(dummy.name);
		}

		System.out.println("-------------------------------");
		Map<Dummy, String> testMap = new HashMap<>();
		System.out.println(testMap.put(d1, d1.name));
		System.out.println(testMap.put(d3, d3.name));
		System.out.println(testMap.put(d2, d2.name));

		System.out.println("-------------------------------");
		for(Dummy dummy : testMap.keySet()) {
			System.out.println(dummy.name);
		}

	}


}
