package com.algorithms.graphs.model;

public class Graph2 {

	public enum COLOR{
		BLUE(1, "BLUE"),
		RED(2, "RED"),
		GREEN(3, "GREEN"),
		SKY_BLUE(4, "SKY_BLUE");

		private int colorCode;
		private String colorName;

		COLOR(int colorCode, String colorName) {
			this.colorCode = colorCode;
			this.colorName = colorName;
		}

		public int getColorCode() {
			return colorCode;
		}

		public static String getColorByCode(int colorCode) {
			for(COLOR color : COLOR.values()) {
				if(color.colorCode == colorCode) {
					return color.colorName;
				}
			}
			return null;
		}


	}

	private int V;

	private int[][] adj;

	public Graph2(int v) {
		V = v + 1;
		adj = new int[V][V];
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				adj[i][j] = -1;
			}
		}
	}

	public int getV() {
		return V;
	}

	public void printGraph() {
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				if(adj[i][j] != -1) {
					System.out.println(i + " to " + j + ", " + COLOR.getColorByCode(adj[i][j]) + " color edge");
				}
			}
		}
	}

	public void addEdge(int v, int w, int color) {
		adj[v][w] = color;
	}

	public int getEdge(int v, int w) {
		return adj[v][w];
	}

	public int[][] getEdges() {
		return adj;
	}
}
