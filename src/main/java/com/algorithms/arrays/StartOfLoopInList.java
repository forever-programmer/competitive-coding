package com.algorithms.arrays;

import java.util.LinkedList;
import java.util.List;

public class StartOfLoopInList {

	private static final int SIZE = 123;
	private static final int LOOP_START = 83;

	static class Node {
		private int data;
		private Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		Node(int data) {
			this(data, null);
		}
	}

	public static void main(String[] args) {
		Node head = getCircularList();

		Node slow = head;
		Node fast = head;

		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if(slow == fast) {
				break;
			}
		}

		if(fast == null || fast.next == null) {
			System.out.println("No loop in list");
		} else {
			System.out.println("CollisionPoint:" + fast.data);

			slow = head;
			while(slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}

			System.out.println("Start of loop:" + fast.data);
		}


		//printList(head);

	}

	private static void printList(Node current) {
		int counter = 0;
		while(current != null) {
			counter++;
			System.out.print(current.data + " -> ");
			current = current.next;
			if(counter > 200) {
				break;
			}
		}
	}

	private static Node getCircularList() {
		List<Node> linkedList = new LinkedList<>();
		for(int i = 1; i <= SIZE; i++) {
			linkedList.add(new Node(i));
		}

		for(int i = 0; i < SIZE - 1; i++) {
			final Node node = linkedList.get(i);
			node.next = linkedList.get(i + 1);
		}

		final Node lastNode = linkedList.get(SIZE - 1);
		lastNode.next = linkedList.get(LOOP_START);
		return linkedList.get(0);
	}

	private static void printList(List<Node> linkedList) {
		System.out.print(linkedList.get(0).data + "->");

		for(Node node : linkedList) {
			System.out.print(node.next.data + "->");
		}
	}
}
