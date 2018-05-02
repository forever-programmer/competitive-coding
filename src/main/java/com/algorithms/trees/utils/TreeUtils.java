package com.algorithms.trees.utils;

import com.algorithms.trees.model.TreeNode;

public class TreeUtils {

	private static final int DEFAULT_SIZE = 23;


	public static TreeNode getBalancedTree() {
		return getBalancedTree(getSortedArray(DEFAULT_SIZE), 0, DEFAULT_SIZE - 1);
	}

	public static TreeNode getBalancedTree(int size) {
		return getBalancedTree(getSortedArray(size), 0, size - 1);
	}

	private static int[] getSortedArray(int size) {
		int[] sortedArray = new int[size];

		for(int i = 0; i < size; i++) {
			sortedArray[i] = i + 4;
		}
		return sortedArray;
	}

	private static TreeNode getBalancedTree(int[] sortedArray, int start, int end) {
		if(end < start) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(sortedArray[mid]);
		node.left = getBalancedTree(sortedArray, start, mid - 1);
		node.right = getBalancedTree(sortedArray, mid + 1, end);
		return node;
	}
}
