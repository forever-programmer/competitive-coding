package com.algorithms.graphs;

import java.util.*;

public class GraphColoring {

	private static List<String> COLORS = Arrays.asList("COLOR1", "COLOR2", "COLOR3");

	static class Graph {
		private List<GraphNode> nodes;

		public List<GraphNode> getNodes() {
			return nodes;
		}

		public void setNodes(List<GraphNode> nodes) {
			this.nodes = nodes;
		}

		@Override public String toString() {
			final StringBuilder s = new StringBuilder();
			for(GraphNode node : nodes) {
				s.append(node.getLabel()).append(", ");
			}
			return s.toString();
		}
	}


	static class GraphNode {

		private String label;
		private Set<GraphNode> neighbors;
		private Optional<String> color;

		public GraphNode(String label) {
			this.label = label;
			neighbors = new HashSet<GraphNode>();
			color = Optional.empty();
		}

		public String getLabel() {
			return label;
		}

		public Set<GraphNode> getNeighbors() {
			return Collections.unmodifiableSet(neighbors);
		}

		public void addNeighbor(GraphNode neighbor) {
			if(!neighbors.contains(neighbor)) {
				neighbors.add(neighbor);
				neighbor.addNeighbor(this);
			}
		}

		public boolean hasColor() {
			return color.isPresent();
		}

		public String getColor() {
			return color.orElse(null);
		}

		public void setColor(String color) {
			this.color = Optional.ofNullable(color);
		}

		@Override public String toString() {
			StringBuilder s = new StringBuilder();
			for(GraphNode neighbor : neighbors) {
				s.append("(").append(neighbor.getLabel()).append(", ").append(neighbor.getColor()).append(")");
			}

			return s.toString();
		}
	}

	public static void main(String[] args) {
		Graph g = getGraph();
		Set<GraphNode> visited = new HashSet<>();
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(g.getNodes().iterator().next());

		while(!queue.isEmpty()) {
			final GraphNode node = queue.remove();
			if(!visited.contains(node)) {
				visited.add(node);
				final Set<String> colors = getColors(node.getNeighbors());
				node.setColor(colors.iterator().next());
				queue.addAll(node.getNeighbors());
			}
		}

		printGraph(g);

	}
	

	private static Set<String> getColors(Set<GraphNode> neighbors) {
		Set<String> colors = new HashSet<>(COLORS);
		for(GraphNode neighbor : neighbors) {
			colors.remove(neighbor.getColor());
		}
		return colors;
	}

	private static Graph getGraph() {
		Graph g = new Graph();
		List<GraphNode> nodes = new ArrayList<>();
		Map<Integer, GraphNode> nodeMap = new HashMap<>();
		g.setNodes(nodes);

		for(int i = 1; i <= 10; i++) {
			final GraphNode node = new GraphNode(i + "");
			nodes.add(node);
			nodeMap.put(i, node);
		}

		setNeighbours(nodeMap);
		return g;
	}

	private static void printGraph(Graph g) {
		for(GraphNode graphNode : g.getNodes()) {
			System.out.println(graphNode.getLabel() + "(" + graphNode.getColor() +") -> {");
			for(GraphNode neighbour : graphNode.getNeighbors()) {
				System.out.println("\t" + neighbour.getLabel() + " -> " + neighbour.getColor());
			}
			System.out.println("}");
		}
	}

	private static void setNeighbours(Map<Integer, GraphNode> nodes) {
		nodes.get(1).addNeighbor(nodes.get(2));
		nodes.get(1).addNeighbor(nodes.get(3));
		nodes.get(1).addNeighbor(nodes.get(6));
		nodes.get(2).addNeighbor(nodes.get(7));
		nodes.get(2).addNeighbor(nodes.get(8));
		nodes.get(3).addNeighbor(nodes.get(4));
		nodes.get(3).addNeighbor(nodes.get(9));
		nodes.get(4).addNeighbor(nodes.get(5));
		nodes.get(4).addNeighbor(nodes.get(8));
		nodes.get(5).addNeighbor(nodes.get(6));
		nodes.get(5).addNeighbor(nodes.get(7));
		nodes.get(6).addNeighbor(nodes.get(10));
		nodes.get(7).addNeighbor(nodes.get(9));
		nodes.get(8).addNeighbor(nodes.get(10));
		nodes.get(9).addNeighbor(nodes.get(10));
	}

}
