package com.problemsolving;

import java.util.Stack;

public class TowerOfHanoi {

	private static final int SIZE = 100;

	public static void main(String[] args) {
		Stack<Integer> tower1 = new Stack<>();
		Stack<Integer> tower2 = new Stack<>();
		Stack<Integer> tower3 = new Stack<>();

		for(int i = SIZE; i > 0; i--) {
			tower1.push(i);
		}

		System.out.println(tower1);
		System.out.println(tower2);
		System.out.println(tower3);

		moveDisks(SIZE, tower1, tower2, tower3);

		System.out.println(tower1);
		System.out.println(tower2);
		System.out.println(tower3);
	}

	private static void printStack(Stack<Integer> tower) {
		while(!tower.empty()) {
			System.out.println(tower.pop());
		}
	}

	private static void moveDisks(int size, Stack<Integer> tower1, Stack<Integer> tower2, Stack<Integer> tower3) {
		if(size == 1) {
			tower3.push(tower1.pop());
		} else if(size == 2) {
			tower2.push(tower1.pop());
			tower3.push(tower1.pop());
			tower3.push(tower2.pop());
		} else {
			moveDisks(size - 1, tower1, tower3, tower2);
			moveDisks(1, tower1, tower2, tower3);
			moveDisks(size - 1, tower2, tower1, tower3);
		}
	}
}
