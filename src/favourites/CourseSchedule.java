package favourites;

/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take
course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more
 about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

 */

import java.util.*;

public class CourseSchedule {

	public static void main(String[] args) {
		CourseSchedule obj = new CourseSchedule();
		int[][] pre ={
				{1,0},
				{2,1},
				{3,1},
				{3,2},
				{4,3},
				{5,4},
		};

		System.out.printf(" Can Finish Course " +obj.canFinish(6,pre));

	}

	/*
		build counter for dependancy
		Find the courses which has no dependancy add it to queue
		find dependernt courses on queue course and reduct dependancy , if its zerop add to queue and incrase cpint

		course , dependancy
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		int[] indegree = new int[numCourses];

		for(int i = 0;i<prerequisites.length;i++){
			System.out.println(i +"  "+prerequisites[i][0]);
			indegree[prerequisites[i][0]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0;i<indegree.length;i++){
			if(indegree[i] == 0){
				queue.offer(i);
			}
		}

		int noPre = queue.size();

		while (!queue.isEmpty()){

			int top = queue.remove();

			for (int i = 0;i<prerequisites.length;i++){
				if(prerequisites[i][1] == top){
					indegree[prerequisites[i][0]]--;

					if(indegree[prerequisites[i][0]] == 0){
						noPre++;
						queue.offer(prerequisites[i][0]);

					}
				}
			}
		}


		return noPre == numCourses;
	}
}





























