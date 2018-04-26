package com.algorithms.strings;

import java.util.Scanner;

/**
Sami's spaceship crashed on Mars! She sends sequential SOS messages to Earth for help.

[NASA_Mars_Rover.jpg]

Letters in some of the SOS messages are altered by cosmic radiation during transmission. Given the signal received by Earth as a string, , determine how many letters of Sami's SOS have been changed by radiation.

Input Format

There is one line of input: a single string, .

Note: As the original message is just SOS repeated times, 's length will be a multiple of .

Constraints

    will contain only uppercase English letters.

Output Format

Print the number of letters in Sami's message that were altered by cosmic radiation.

Sample Input 0

SOSSPSSQSSOR

Sample Output 0

3

Explanation 0

= SOSSPSSQSSOR, and signal length . Sami sent SOS messages (i.e.: ).

Expected signal: SOSSOSSOSSOS
Recieved signal: SOSSPSSQSSOR

We print the number of changed letters, which is .
 */

public class MarsExploration {

	static int marsExploration(String s) {
		if(s == null || s.trim().length() == 0 || (s.length() %3) != 0) {
			return 0;
		}

		int count = 0;
		int beginIndex = 0;
		int endIndex = 3;
		String s1;

		while(beginIndex < s.length()) {
			s1 = s.substring(beginIndex, endIndex);
			count += check(s1);
			beginIndex += 3;
			endIndex += 3;
		}

		return count;
	}

	private static int check(String s) {
		int retval = 0;

		if(s.charAt(0) != 'S') {
			retval++;
		}

		if(s.charAt(1) != 'O') {
			retval++;
		}

		if(s.charAt(2) != 'S') {
			retval++;
		}

		return retval;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int result = marsExploration(s);
		System.out.println(result);
		in.close();
	}

}
