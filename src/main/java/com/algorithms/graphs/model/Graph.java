package com.algorithms.graphs.model;

import java.util.Arrays;

public class Graph {
	public Node[] nodes;

	@Override public String toString() {
		return "Graph{" +
		       "nodes=" + Arrays.toString(nodes) +
		       '}';
	}

	public static class Node {
		public int value;
		public Node[] children;

		public Node(int value) {
			this.value = value;
		}

		@Override public String toString() {
			return "Node{" +
			       "value=" + value +
			       ", children=" + Arrays.toString(children) +
			       '}';
		}
	}


}

