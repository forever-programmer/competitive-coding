package com.problemsolving;

public class SingleBuySellStockProfit {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{114, 115, 113, 111, 117, 118, 115, 109, 112}));
	}

	private static int maxProfit(int[] prices) {
		if(prices==null||prices.length<=1)
			return 0;

		int min=prices[0]; // min so far
		int result=0;

		for(int i=1; i<prices.length; i++){
			result = Math.max(result, prices[i]-min);
			min = Math.min(min, prices[i]);
		}

		return result;
	}
}
