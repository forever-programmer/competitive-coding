package com.algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * Amanda has a string of lowercase letters that she wants to copy to a new string. She can perform the following
 * operations with the given costs. She can perform them any number of times to construct a new string :
 *
 *     Append a character to the end of string at a cost of dollar.
 *     Choose any substring of and append it to the end of at no charge.
 *
 * Given strings , find and print the minimum cost of copying each to on a new line.
 *
 * Input Format
 *
 * The first line contains a single integer , the number of strings.
 * Each of the next lines contains a single string, .
 *
 * Constraints
 *
 * Subtasks
 *
 *     for of the maximum score.
 *
 * Output Format
 *
 * For each string print the minimum cost of constructing a new string on a new line.
 *
 * Sample Input
 *
 * 2
 * abcd
 * abab
 *
 * Sample Output
 *
 * 4
 * 2
 *
 * Explanation
 *
 * Query 0: We start with and .
 *
 *     Append character '' to at a cost of dollar, .
 *     Append character '' to at a cost of dollar, .
 *     Append character '' to at a cost of dollar, .
 *     Append character '' to at a cost of dollar, .
 *
 * Because the total cost of all operations is dollars, we print on a new line.
 *
 * Query 1: We start with and .
 *
 *     Append character '' to at a cost of dollar, .
 *     Append character '' to at a cost of dollar, .
 *     Append substring to at no cost, .
 *
 * Because the total cost of all operations is dollars, we print on a new line.
 *
 * Note
 *
 * A substring of a string is another string that occurs "in" (Wikipedia). For example, the substrings of the string
 * "" are "", "" ,"", "", "", and "".
 */
public class StringCopyCost {

	static int stringConstruction(String source) {
		int cost = 0;
		Set<String> visited = new HashSet<String>();

		for(int i = 0; i < source.length(); i++) {
			final String currentChar = Character.toString(source.charAt(i));
			if(!visited.contains(currentChar)) {
				visited.add(currentChar);
				cost++;
			}
		}

		return cost;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			String s = in.next();
			int result = stringConstruction(s);
			System.out.println(result);
		}
		in.close();
	}
}
