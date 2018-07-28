package com.algorithms.graphs;

import com.algorithms.graphs.model.Graph2;
import static com.algorithms.graphs.model.Graph2.COLOR.*;


public class GraphTraverseColoredEdge {

	public static void main(String[] args) {
		Graph2 g = new Graph2(5);
		g.addEdge(1, 2, BLUE.getColorCode());
		g.addEdge(1, 3, RED.getColorCode());
		g.addEdge(2, 3, SKY_BLUE.getColorCode());
		g.addEdge(3, 5, SKY_BLUE.getColorCode());
		g.addEdge(2, 5, RED.getColorCode());
		g.addEdge(2, 4, GREEN.getColorCode());
		g.addEdge(4, 5, GREEN.getColorCode());

		g.printGraph();

		int src = 2;
		int dest = 5;

		final int[][] edges = g.getEdges();

		for(int i = 0; i < g.getV(); i++) {
			final int edge = edges[src][i];
			if(edge != -1) {

			}
		}


	}
}
