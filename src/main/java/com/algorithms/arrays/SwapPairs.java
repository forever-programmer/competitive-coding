package com.algorithms.arrays;

import com.algorithms.arrays.model.ListNode;

public class SwapPairs {


	public static void main(String[] args) {

		ListNode current = ListNode.getListNode();
		current = swapPairs(current);

		while(current != null) {
			System.out.println(current.val);
			current = current.next;
		}
	}

	private static ListNode swapPairs(ListNode head) {
	 	ListNode current = head;
	 	ListNode prev = null;

		while(current != null && current.next != null) {
			if(prev != null) {
				prev.next = current.next;
			} else {
				head = current.next;
			}
			prev = current;
			current = current.next;

			prev.next = current.next;
			current.next = prev;
			current = prev.next;
		}

		return head;
	}
}
