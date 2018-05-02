package com.algorithms.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BFS {

	private static final int VERTICES = 8;

	static class Graph {
		Node[] nodes;

		@Override public String toString() {
			return "Graph{" +
			       "nodes=" + Arrays.toString(nodes) +
			       '}';
		}
	}

	static class Node {
		int value;
		Node[] children;

		Node(int value) {
			this.value = value;
		}

		@Override public String toString() {
			return value + " -> " + Arrays.toString(children);
		}
	}

	public static void main(String[] args) {
		Graph g = constructGraph();
		LinkedList<Node> queue = new LinkedList<>();
		Set<Node> visited = new HashSet<>();

		final Node src = g.nodes[0];
		final Node dest = g.nodes[3];
		boolean routeExists = bfs(g, src, dest, queue, visited);

		if(routeExists) {
			System.out.println("There exists a path between nodes " + src.value + " and " + dest.value);
		} else {
			System.out.println("No path exists between nodes " + src.value + " and " + dest.value);
		}

		System.out.println(g);

	}

	private static boolean bfs(Graph g, Node src, Node dest, LinkedList<Node> queue, Set<Node> visited) {
		queue.add(src);

		while(!queue.isEmpty()) {
			final Node node = queue.removeFirst();
			if(!visited.contains(node)) {
				if(node == dest) {
					return true;
				}
				visited.add(node);
				if(node.children != null) {
					queue.addAll(Arrays.asList(node.children));
				}
			}
		}

		return false;
	}


	private static Graph constructGraph() {
		Graph g = new Graph();
		g.nodes = new Node[VERTICES];

		for(int i = 0; i < 8; i++) {
			Node n = new Node(i + 1);
			g.nodes[i] = n;
		}

		g.nodes[0].children = new Node[]{g.nodes[1], g.nodes[2]};
		g.nodes[1].children = new Node[]{g.nodes[2]};
		g.nodes[2].children = new Node[]{g.nodes[4]};
		g.nodes[3].children = new Node[]{g.nodes[5]};
		g.nodes[4].children = new Node[]{g.nodes[5], g.nodes[7]};
		g.nodes[5].children = new Node[]{g.nodes[6]};
		g.nodes[6].children = new Node[]{g.nodes[7]};
		return g;
	}
}
