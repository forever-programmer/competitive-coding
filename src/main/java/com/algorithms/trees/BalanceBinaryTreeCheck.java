package com.algorithms.trees;

import com.algorithms.trees.model.TreeNode;
import com.algorithms.trees.utils.TreeUtils;

public class BalanceBinaryTreeCheck {
	public static void main(String[] args) {
		TreeNode node = TreeUtils.getBalancedTree(10);

		if(checkBalancedTree(node)) {
			System.out.println("Balanced tree");
		}

	}

	private static boolean checkBalancedTree(TreeNode node) {
		if(node == null) {
			return true;
		}

		int heightDiff = Math.abs(height(node.left) - height(node.right));

		if(heightDiff > 1) {
			return false;
		}

		return checkBalancedTree(node.left) && checkBalancedTree(node.right);
	}

	private static int height(TreeNode node) {
		if(node == null) {
			return 0;
		}

		return Math.max(height(node.left), height(node.right)) + 1;
	}
}
