package com.algorithms.arrays;

import java.util.Arrays;
import java.util.Stack;

public class StackSort {

	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		for(Integer item : Arrays.asList(25, 2, 7, 58, 11, 17, 9)) {
			s1.push(item);
		}

		while(!s1.empty()) {
			int e1 = s1.pop();
			if(s2.empty()) {
				s2.push(e1);
			} else {
				while(!s2.empty()) {
					final int e2 = s2.pop();
					if(e1 > e2) {
						s2.push(e2);
						s2.push(e1);
						break;
					} else {
						s1.push(e2);
					}
				}
				if(s2.empty()) {
					s2.push(e1);
				}
			}
			System.out.println(s1);
			System.out.println(s2);
		}

		while(!s2.empty()) {
			s1.push(s2.pop());
		}

		System.out.println(s1);
	}
}
