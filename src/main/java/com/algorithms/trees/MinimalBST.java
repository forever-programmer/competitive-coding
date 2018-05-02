package com.algorithms.trees;

import com.algorithms.trees.model.TreeNode;

public class MinimalBST {

	private static final int SIZE = 23;

	public static void main(String[] args) {
		int[] sortedArray = new int[SIZE];

		for(int i = 0; i < SIZE; i++) {
			sortedArray[i] = i + 4;
		}

		TreeNode root = createMinimalBST(sortedArray, 0, SIZE - 1);

		printTree(root);

	}

	private static void printTree(TreeNode root) {
		if(root == null) {
			System.out.println("null");
		} else {
			System.out.print(root.value + "->\t");
			printTree(root.left);
			printTree(root.right);
			System.out.println();
		}
	}

	private static TreeNode createMinimalBST(int[] sortedArray, int start, int end) {
		if(end < start) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(sortedArray[mid]);
		node.left = createMinimalBST(sortedArray, start, mid - 1);
		node.right = createMinimalBST(sortedArray, mid + 1, end);
		return node;
	}

}
