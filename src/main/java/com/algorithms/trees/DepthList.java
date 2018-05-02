package com.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

import com.algorithms.trees.model.TreeNode;
import com.algorithms.trees.utils.TreeUtils;

public class DepthList {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.getBalancedTree(25);

		List<List<TreeNode>> depthList = new ArrayList<>();

		List<TreeNode> firstList = new ArrayList<>();
		firstList.add(root);

		List<TreeNode> currentList = firstList;

		while(!currentList.isEmpty()) {
			depthList.add(currentList);
			List<TreeNode> newList = new ArrayList<>();
			for(TreeNode node : currentList) {
				if(node.left != null) {
					newList.add(node.left);
				}
				if(node.right != null) {
					newList.add(node.right);
				}
			}
			currentList = newList;
		}

		for(List<TreeNode> nodeList : depthList) {
			System.out.println(nodeList);
		}
	}


}
