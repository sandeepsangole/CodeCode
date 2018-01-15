package graph;

import java.net.Inet4Address;
import java.util.*;

public class Graph {

	private int vertices;
	private LinkedList<Integer> adjLst[];

	Graph(int V){
		this.vertices = V;
		adjLst = new LinkedList[V];
		for(int i =0;i<V;i++){
			adjLst[i] = new LinkedList<>();
		}
	}


	public void addEdge(int vertex , int edge){
		adjLst[vertex].add(edge);
	}

	public void BFS(int startVertex, List<Integer> res){
		boolean[] visited = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(startVertex);
		visited[startVertex] = true;

		while (!queue.isEmpty()){

			int tmp = queue.poll();
			res.add(tmp);
			Iterator<Integer> it = adjLst[tmp].iterator();
			while(it.hasNext()){

				int v = it.next();
				if(!visited[v]){
					queue.offer(v);
					visited[v] = true;
				}
			}
		}

	}


	public List<Integer> DFS(int startIndex){

		boolean[] visited = new boolean[vertices];
		List<Integer> res = new ArrayList<>();
		DFS(startIndex,visited,res);
		return res;
	}

	private void DFS(int vertex , boolean[] visited , List<Integer> res){

		visited[vertex] = true;
		res.add(vertex);

		Iterator<Integer> it = adjLst[vertex].iterator();
		while(it.hasNext()){
			int tmp = it.next();
			if(!visited[tmp])
			DFS(tmp,visited,res);
		}


	}


	public void topologicalSort(){

		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[vertices];

		for(int i =0;i<vertices;i++){
			if(!visited[i]){
				topoSortUtil(i,stack,visited);
			}
		}

		while(!stack.isEmpty())
			System.out.print(stack.pop() +" ");
	}

	public void topoSortUtil(int vertex, Stack<Integer> stack, boolean[] visited){

		visited[vertex] = true;

		Iterator<Integer> it = adjLst[vertex].iterator();

		while(it.hasNext()){
			int tmp = it.next();

			if(!visited[tmp])
			topoSortUtil(tmp,stack,visited);
		}
		stack.push(vertex);

	}
}
