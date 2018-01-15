package graph;

import java.util.*;

public class GraphMain {

	public static void main(String[] args) {
		Graph obj = new Graph(5);

		obj.addEdge(0,1);
		obj.addEdge(0,2);
		obj.addEdge(1,3);
		obj.addEdge(2,4);

		System.out.println("BFS:");
		List<Integer> res = new ArrayList<>();
		obj.BFS(0,res);
		res.stream().forEach(System.out::println);

		System.out.println("DFS : ");

		List<Integer> res1 = obj.DFS(0);

		res1.stream().forEach(System.out::println);

		obj.topologicalSort();


	}

}
