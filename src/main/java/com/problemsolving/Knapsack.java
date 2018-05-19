package com.problemsolving;

public class Knapsack {

	public static void main(String[] args) throws InterruptedException {
		int[] values = new int[]{60, 100, 120};
		int[] weights = new int[]{10, 20, 30};
		int maxWeight = 50;
		int startIndex = 0;
		int profit = maxProfit(values, weights, startIndex, maxWeight);
		System.out.println("MaxProfit: " + profit);

	}

	private static int maxProfit(int[] values, int[] weights, int startIndex, int maxWeightRemaining) {
		System.out.println(startIndex + ", " + maxWeightRemaining);
		if(startIndex == values.length - 1) {
			if(weights[startIndex] <= maxWeightRemaining) {
				return values[startIndex];
			} else {
				return 0;
			}
		}

		int profit = 0;

		for(int i = startIndex; i < values.length - 1; i++) {
			if(weights[i] <= maxWeightRemaining) {
				int choosing_i = values[i] + maxProfit(values, weights, i + 1, maxWeightRemaining - weights[i]);
				int skipping_i = maxProfit(values, weights, i + 1, maxWeightRemaining);
				System.out.println("choosing_i: " + choosing_i + ", skipping_i: " + skipping_i);
				profit = Math.max(choosing_i, skipping_i);

			} else {
				profit = maxProfit(values, weights, i + 1, maxWeightRemaining);
			}
			System.out.println("i:" + i + ", profit:" + profit);

		}

		System.out.println(profit);
		return profit;
	}

}
