package com.algorithms.arrays;

import com.algorithms.arrays.model.ListNode;

public class MergeKLists {

	public static void main(String[] args) {
		int[] vals1 = new int[]{1, 3, 5, 7};
		int[] vals2 = new int[]{2, 4, 6, 8};
		int[] vals3 = new int[]{0, 9, 10, 11};
		int[] vals4 = new int[]{10, 19, 20, 21};

		ListNode[] lists = new ListNode[]{
				getListNode(vals1),
				getListNode(vals2),
				getListNode(vals3),
				getListNode(vals4)
		};

		ListNode listNode = mergeKLists(lists);

		while(listNode != null) {
			System.out.print(listNode.val + "->");
			listNode = listNode.next;
		}
		System.out.println("NULL");

	}

	private static ListNode mergeKLists(ListNode[] lists) {

		if(lists == null || lists.length == 0) {
			return null;
		}

		if(lists.length == 1) {
			return lists[0];
		}

		final boolean evenLists = lists.length % 2 == 0;
		final int size = evenLists ? lists.length / 2 : lists.length / 2 + 1;
		ListNode[] mergedLists = new ListNode[size];

		int k = 0;
		int i;

		for(i = 0; i < lists.length - 1; i += 2) {
			mergedLists[k++] = mergeTwoLists(lists[i], lists[i + 1]);
		}

		if(!evenLists) {
			mergedLists[k] = lists[i];
		}

		return mergeKLists(mergedLists);
	}

	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode p = head;

		while(l1 != null || l2 != null) {
			if(l1 != null && l2 != null) {
				if(l1.val < l2.val) {
					p.next = l1;
					l1 = l1.next;
				} else {
					p.next = l2;
					l2 = l2.next;
				}
				p = p.next;
			} else if(l1 == null) {
				p.next = l2;
				break;
			} else {
				p.next = l1;
				break;
			}
		}

		return head.next;
	}

	public static ListNode getListNode(int[] vals) {
		ListNode head = null;
		ListNode next = null;

		for(int val : vals) {
			ListNode node = new ListNode(val);
			if(head == null) {
				head = node;
				next = node;
			} else {
				next.next = node;
				next = node;
			}
		}
		return head;
	}
}
