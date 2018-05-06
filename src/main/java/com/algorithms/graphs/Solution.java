package com.algorithms.graphs;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {

	static class Graph {
		Set<Integer> nodes; // 1, 3, 4, 5, 7, 8, 9, 10
		Map<Integer, List<Pair>> pairsStartingWithNode;
		// 1 : [[1,3]], 4: [[4,1],[4,7]]

		public Graph(int[][] pairs) {
			nodes = new HashSet<>();
			pairsStartingWithNode = new HashMap<>();
			for(int[] pair: pairs) {
				nodes.add(pair[0]);
				nodes.add(pair[1]);
				List<Pair> entry= pairsStartingWithNode.getOrDefault(pair[0], new ArrayList<>());
				entry.add(new Pair(pair[0], pair[1]));
				pairsStartingWithNode.put(pair[0], entry);
			}
		}

	}

	static class Pair {
		int src;
		int target;
		public Pair(int a, int b) {
			src = a;
			target = b;
		}

		@Override public String toString() {
			return "[" + src + "," + target + "]";
		}
	}

	public static void main(String[] args) {

		Graph g = new Graph(new int[][]{{1, 3},
		                                {4, 1},
		                                {6, 10},
		                                {4, 7},
		                                {5, 9},
		                                {10,8}});

		/*for(int key: g.pairsStartingWithNode.keySet()) {
			List<Pair> pairs = g.pairsStartingWithNode.get(key);
			for(Pair pair: pairs)
				System.out.println(pair.src+  " " + pair.target);
		}*/

	//	System.out.println(g.pairsStartingWithNode);

		Set<Integer> visited = new HashSet<>();
		Stack<Integer> buildOrder = new Stack<>();


		for(Integer n : g.nodes)
		{

			dfs(visited, n, buildOrder,g.pairsStartingWithNode);
		}

		while(!buildOrder.empty()) {
			Integer node = buildOrder.pop();
			System.out.println(node);
		}

	}

	public static void dfs(Set<Integer> visited, Integer n, Stack<Integer> s,
	                       Map<Integer, List<Pair>> pairsMap) {
		//System.out.println(visited);

		if(!visited.contains(n)) {
			visited.add(n);
			List<Pair> pairs = pairsMap.get(n);

			if(pairs != null) {
				for(Pair pair : pairs)
				{
					System.out.println(pair.src+" " + pair.target);
					dfs(visited, pair.target, s, pairsMap);
				}
			}
			System.out.println("Adding n: " + n);
			s.add(n);

			// s.add(n);
		} else {
			//System.out.println("Already visited:" + n);
		}

	}


}

/*


[1, 3]
[4, 1]
[4, 7]
[5, 9]
[10,8]




//[1, 10], [2, 3], [5, 9], [6, 9], [8, 18], return 4
/*
             [5,9]
         [2,7]    [6,9]
      [1,10]        [8,18]


     result =
*/


/*
if we've 2 global variables for minStart and maxEnd time

int result = 1;

for(meeting: meetings)
{
  if(meeting.start < minStart)
      minStart = meeting.start;
  same for maxEnd


}

*/


