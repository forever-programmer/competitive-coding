package com.algorithms.arrays.model;

import java.util.HashMap;
import java.util.Map;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) { val = x; }

	public static ListNode getListNode() {
		Map<Integer, ListNode> nodeById = new HashMap<>();

		for(int i = 1; i <= 100; i++) {
			ListNode n = new ListNode(i);
			nodeById.put(i, n);
			if(i != 1) {
				final ListNode listNode = nodeById.get(i - 1);
				listNode.next = n;
			}
		}


		return nodeById.get(1);
	}
}
