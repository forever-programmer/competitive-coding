package com.problemsolving.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RobotMazePath {

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override public boolean equals(Object o) {
			if(this == o) {
				return true;
			}
			if(!(o instanceof Point)) {
				return false;
			}
			Point point = (Point) o;
			return x == point.x &&
			       y == point.y;
		}

		@Override public int hashCode() {

			return Objects.hash(x, y);
		}

		@Override public String toString() {
			return "[" + x + ", " + y + "]";
		}
	}

	public static void main(String[] args) {
		int[][] maze = new int[][]{
				{1, 0, 1, 1, 1},
				{1, 1, 0, 0, 1},
				{1, 1, 1, 1, 1},
				{1, 0, 1, 1, 1},
				{0, 1, 1, 1, 0},
				{1, 1, 1, 1, 1}
		};

		int row = 6;
		int col = 5;

		final ArrayList<Point> path = new ArrayList<>();
		final Set<Point> failedPoints = new HashSet<>();

		if(pathExists(maze, 0, 0, row - 1, col - 1, path, failedPoints)) {
			System.out.println("Path Exists" + path);
		} else {
			System.out.println("Path doesn't exists");
		}
	}

	private static boolean pathExists(int[][] maze, int startRow, int startCol, int endRow, int endCol,
	                                  ArrayList<Point> path,
	                                  Set<Point> failedPoints) {
		System.out.println("Currently at " + endRow + ", " + endCol + ", " + failedPoints);
		Point p = new Point(endRow, endCol);
		if(startRow == endRow && startCol == endCol) {
			path.add(p);
			return true;
		}

		if(endRow < 0 || endCol < 0 || maze[endRow][endCol] == 0) {
			failedPoints.add(p);
			return false;
		}

		if(failedPoints.contains(p)) {
			return false;
		}


		if(pathExists(maze, startRow, startCol, endRow - 1, endCol, path, failedPoints) ||
		   pathExists(maze, startRow, startCol, endRow, endCol - 1, path, failedPoints)) {
			path.add(p);
			return true;
		}

		failedPoints.add(p);
		return false;
	}
}
