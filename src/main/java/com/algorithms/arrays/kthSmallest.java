package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kthSmallest {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81,
		                                   42,
		                                   28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39,
		                                   62, 20, 17, 46, 26, 81, 92);
		final int k = 9;
		System.out.println(kthsmallest(list, k));
	}

	private static int kthsmallest(final List<Integer> A, int B) {
		ArrayList<Integer> kElements = new ArrayList<>();

		for(Integer no : A) {
			if(kElements.size() == 0) {
				kElements.add(no);
			} else {
				addElementToList(kElements, no);
			}
			if(kElements.size() > B) {
				kElements.remove(kElements.size() - 1);
			}
		}
		//System.out.println(kElements);
		return kElements.remove(kElements.size() - 1);
	}

	private static void addElementToList(ArrayList<Integer> kElements, Integer no) {
		final int size = kElements.size();
		int start = 0;
		int end = size - 1;
		int mid = (start + end) / 2;

		while(start <= end) {
			if(no <= kElements.get(start)) {
				kElements.add(start, no);
				break;
			} else if(no >= kElements.get(end)) {
				kElements.add(end + 1, no);
				break;
			} else if(no <= kElements.get(mid)) {
				end = mid;
			} else if(no > kElements.get(mid)) {
				start = mid + 1;
			}
			mid = (start + end) / 2;
		}
	}
}
