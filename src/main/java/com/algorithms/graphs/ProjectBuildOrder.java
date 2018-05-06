package com.algorithms.graphs;

import java.util.*;

public class ProjectBuildOrder {

	static class Graph {
		List<Node> nodes;
	}

	static class Node {
		String value;
		List<Node> children;

		public Node(String value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		Map<String, Node> nodeMap = getStringNodeMap(Arrays.asList("a", "b", "c", "d", "e", "g"));
		setEdges(nodeMap);

		Graph g = new Graph();
		g.nodes = new ArrayList<>(nodeMap.values());

		printBuildOrder(g);
	}

	private static void printBuildOrder(Graph g) {
		Set<Node> visited = new HashSet<>();
		Stack<Node> buildOrder = new Stack<>();

		for(Node node : g.nodes) {
			traverse(node, visited, buildOrder);
		}

		while(!buildOrder.empty()) {
			System.out.println(buildOrder.pop().value);
		}
	}

	private static void traverse(Node node, Set<Node> visited, Stack<Node> buildOrder) {
		//System.out.println("Traversing:" + node.value);
		if(!visited.contains(node)) {
			visited.add(node);
			if(node.children != null) {
				for(Node child : node.children) {
					traverse(child, visited, buildOrder);
				}
			}
			//System.out.println("Adding " + node.value +" to stack");
			buildOrder.push(node);
		}
	}

	private static void setEdges(Map<String, Node> nodeMap) {
		nodeMap.get("a").children = Collections.singletonList(nodeMap.get("e"));
		nodeMap.get("b").children = Collections.singletonList(nodeMap.get("g"));
		nodeMap.get("c").children = Arrays.asList(nodeMap.get("b"), nodeMap.get("d"));
		nodeMap.get("d").children = Collections.singletonList(nodeMap.get("b"));
	}

	private static Map<String, Node> getStringNodeMap(List<String> values) {
		Map<String, Node> nodesByValue = new HashMap<>();
		for(String nodeValue : values) {
			nodesByValue.put(nodeValue, new Node(nodeValue));
		}
		return nodesByValue;
	}

	@Override public String toString() {
		return "ProjectBuildOrder{}";
	}
}
