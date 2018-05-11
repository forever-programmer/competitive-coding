package com.problemsolving;

import java.util.ArrayList;
import java.util.List;

public class Permute {

	public static void main(String[] args) {
		List<String> l1 = new ArrayList<>();
		l1.add("1");
		l1.add("2");
		l1.add("3");
		l1.add("4");

		List<String> l2 = new ArrayList<>();
		l2.add("a");
		l2.add("b");
		l2.add("c");
		l2.add("d");

		List<String> l3 = new ArrayList<>();
		l3.add("e");
		l3.add("f");
		l3.add("g");

		List<List<String>> l = new ArrayList<>();
		l.add(l1);
		l.add(l2);
		l.add(l3);
		List<Integer> index = new ArrayList<>();
		index.add(0);
		index.add(0);
		index.add(0);
		//print(l, index, 0);
		permute("", l, 0);

	}

	private static void permute(String s, List<List<String>> l, int i) {
		final List<String> list = l.get(i);
		for(String element : list) {
			if(i == l.size() - 1) {
				System.out.print(s + "" + element);
				System.out.println();
			} else {
				permute(s + element, l, i + 1);
			}
		}
	}


	private static void print(List<List<String>> l, List<Integer> index, int h) {
		for (int j = 0; j < l.get(h).size(); j++) {
			index.set(h, j);
			if (h == l.size() - 1) {
				for (int i = 0; i < l.size(); i++) {
					System.out.print(l.get(i).get(index.get(i)));
				}
				System.out.println();
			} else {
				print(l, index, h + 1);
			}
		}
	}
}
