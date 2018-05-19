package com.problemsolving.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KnightTour {

	static class Cell {
		int r;
		int c;

		public Cell(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override public boolean equals(Object o) {
			if(this == o) {
				return true;
			}
			if(!(o instanceof Cell)) {
				return false;
			}
			Cell cell = (Cell) o;
			return r == cell.r &&
			       c == cell.c;
		}

		@Override public int hashCode() {

			return Objects.hash(r, c);
		}
	}


	private static final int SIZE = 8;

	private static int minRollBackedMove = 63;

	private static int maxMoveReached = 0;

	public static void main(String[] args) {
		int[][] solution = new int[SIZE][SIZE];
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				solution[i][j] = -1;
			}
		}

		boolean solutionExist = moves(solution, new Cell(0, 0), 0);

		if(solutionExist) {
			System.out.println("Solution exists!");
			printSolution(solution);
		} else {
			System.out.println("No solution found for the problem");
		}

	}

	private static void printSolution(int[][] solution) {
		String format = "%5d";
		System.out.println();
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				System.out.format(format, solution[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean moves(int[][] solution, Cell cell, int currentMove) {
		//System.out.println("CurrentMove:" + currentMove);
		if(currentMove > maxMoveReached) {
			maxMoveReached = currentMove;
			System.out.println("Reached till " + maxMoveReached);
			printSolution(solution);
		}
		solution[cell.r][cell.c] = currentMove;

		if(currentMove == (SIZE * SIZE - 1)) {
			return true;
		}

		List<Cell> nextMoves = getNextMoves(cell);
		for(Cell nextMove : nextMoves) {
			if(solution[nextMove.r][nextMove.c] == -1) {
				//solution[nextMove.r][nextMove.c] = currentMove + 1;
				if(moves(solution, nextMove, currentMove + 1)) {
					return true;
				} else {
					//	System.out.println("Backtracking: " +currentMove);
					//	solution[nextMove.r][nextMove.c] = 0;
					//printSolution(solution);
				}
			} else {
				//System.out.println("(" + nextMove.r + ", " + nextMove.c +"), already set");
			}
		}
		solution[cell.r][cell.c] = -1;
		if(currentMove < minRollBackedMove) {
			minRollBackedMove = currentMove;
			System.out.println("Rolled back till " + minRollBackedMove);
			printSolution(solution);
		}
		//System.out.println("Couldn't set (" + cell.r + ", " + cell.c +") with move:" + currentMove);
		return false;
	}

	private static List<Cell> getNextMoves(Cell cell) {
		List<Cell> cells = new ArrayList<>();

		//getRookMoves(cell, cells);
		getKnightMoves(cell, cells);

		return cells;
	}

	private static void getKnightMoves(Cell cell, List<Cell> cells) {
		checkAndAdd(cells, cell.r + 2, cell.c + 1);
		checkAndAdd(cells, cell.r + 2, cell.c - 1);
		checkAndAdd(cells, cell.r - 2, cell.c + 1);
		checkAndAdd(cells, cell.r - 2, cell.c - 1);
		checkAndAdd(cells, cell.r + 1, cell.c + 2);
		checkAndAdd(cells, cell.r - 1, cell.c + 2);
		checkAndAdd(cells, cell.r + 1, cell.c - 2);
		checkAndAdd(cells, cell.r - 1, cell.c - 2);
	}

	private static void getRookMoves(Cell cell, List<Cell> cells) {
		checkAndAdd(cells, cell.r, cell.c + 1);
		checkAndAdd(cells, cell.r, cell.c - 1);
		checkAndAdd(cells, cell.r - 1, cell.c);
		checkAndAdd(cells, cell.r + 1, cell.c);
	}

	private static void checkAndAdd(List<Cell> cells, int r, int c) {
		if(r >= 0 && r <= SIZE - 1
		   && c >= 0 && c <= SIZE - 1) {
			cells.add(new Cell(r, c));
		}
	}
}
