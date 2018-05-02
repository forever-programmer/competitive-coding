package com.problemsolving;

import java.util.Scanner;

public class CatchAndWin {

	private static final double g = 32.0;


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final int noOfTestCases = Integer.parseInt(s.nextLine());

		int[] heights = new int[noOfTestCases];
		int[] distances = new int[noOfTestCases];
		int[] speeds = new int[noOfTestCases];

		for(int i = 0; i < noOfTestCases; i++) {
			heights[i] = s.nextInt();
			distances[i] = s.nextInt();
			speeds[i] = s.nextInt();
		}

		for(int i = 0; i < noOfTestCases; i++) {
			final int heightOfHouse = heights[i];
			final int distanceFromHouse = distances[i];
			final int speed = speeds[i];

			double timeForBallToHitGround = Math.sqrt(2 * heightOfHouse / g); //(2*d/g) ^ 1/2
			double timeToCoverTheDistance = distanceFromHouse / speed;

			if(timeToCoverTheDistance <= timeForBallToHitGround) {
				System.out.println("Rahul");
			} else {
				System.out.println("Raj");
			}
		}

	}
}
