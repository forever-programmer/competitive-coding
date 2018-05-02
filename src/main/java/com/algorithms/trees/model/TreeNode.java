package com.algorithms.trees.model;

public class TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int value) {
		this.value = value;
	}

	@Override public String toString() {
		return "TreeNode{" +
		       "value=" + value +
		       '}';
	}


}
