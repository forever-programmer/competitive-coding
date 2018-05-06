package com.algorithms.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.algorithms.graphs.model.Graph;

public class BFS {

	private static final int VERTICES = 8;


	public static void main(String[] args) {
		Graph g = constructGraph();
		LinkedList<Graph.Node> queue = new LinkedList<>();
		Set<Graph.Node> visited = new HashSet<>();

		final Graph.Node src = g.nodes[0];
		final Graph.Node dest = g.nodes[3];
		boolean routeExists = bfs(g, src, dest, queue, visited);

		if(routeExists) {
			System.out.println("There exists a path betweenGraph.Nodes " + src.value + " and " + dest.value);
		} else {
			System.out.println("No path exists betweenGraph.Nodes " + src.value + " and " + dest.value);
		}

		System.out.println(g);

	}

	private static boolean bfs(Graph g, Graph.Node src, Graph.Node dest, LinkedList<Graph.Node> queue, Set<Graph.Node> visited) {
		queue.add(src);

		while(!queue.isEmpty()) {
			final Graph.Node node = queue.removeFirst();
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
		g.nodes = new Graph.Node[VERTICES];

		for(int i = 0; i < 8; i++) {
			Graph.Node n = new Graph.Node(i + 1);
			g.nodes[i] = n;
		}

		g.nodes[0].children = new Graph.Node[]{g.nodes[1], g.nodes[2]};
		g.nodes[1].children = new Graph.Node[]{g.nodes[2]};
		g.nodes[2].children = new Graph.Node[]{g.nodes[4]};
		g.nodes[3].children = new Graph.Node[]{g.nodes[5]};
		g.nodes[4].children = new Graph.Node[]{g.nodes[5], g.nodes[7]};
		g.nodes[5].children = new Graph.Node[]{g.nodes[6]};
		g.nodes[6].children = new Graph.Node[]{g.nodes[7]};
		return g;
	}
}
