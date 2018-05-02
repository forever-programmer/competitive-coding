package com.problemsolving;

import java.util.Scanner;

public class MultiplesOf3And5 {
	public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int noOfTests = Integer.parseInt(s.nextLine());

		int[] inputs = new int[noOfTests];
		for(int i = 0; i < noOfTests; i++) {
			inputs[i] = s.nextInt();
		}

		for(int i = 0; i < inputs.length; i++) {
			for(int j = 1; j <= inputs[i]; j++) {
				if(j % 3 == 0 && j % 5 == 0) {
					System.out.println("FizzBuzz");
				} else if(j % 3 == 0) {
					System.out.println("Fizz");
				} else if(j % 5 == 0) {
					System.out.println("Buzz");
				} else {
					System.out.println(j);
				}
			}
		}

	}
}
