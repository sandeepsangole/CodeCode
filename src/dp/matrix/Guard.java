package dp.matrix;

import java.util.*;

/*
Problem:
Given a matrix that is filled with ‘O’, ‘G’, and ‘W’ where ‘O’ represents open space,
‘G’ represents guards and ‘W’ represents walls in a Bank.
Replace all of the O’s in the matrix with their shortest distance from a guard,
without being able to go through any walls. Also,
replace the guards with 0 and walls with -1 in output matrix.
 */

/*
The idea is to do BFS. We first enqueue all cells containing the guards and loop till queue is not empty.
For each iteration of the loop, we dequeue the front cell from the queue and for each of its four adjacent cells,
if cell is an open area and its distance from guard is not calculated yet,
we update its distance and enqueue it. Finally after BFS procedure is over, we print the distance matrix
 */
public class Guard {
/*
	public int[][] guardBFS(char[][] matrix){

		Queue<int[]> q = new LinkedList<>();
		int[][] res = new int[matrix.length][matrix[0].length];
		for(int i =0;i<matrix.length;i++){
			for(int j = 0;j<matrix[0].length;j++){
				if(matrix[i][j] == 'G'){
					queue.offer(new int[]{i,j});
				} else {
					res[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
		while(!q.isEmpty()){
			int[] cell = q.poll();
			for(int[] d : dirs){
				int r = cell[0] + d[0];
				int c = cell[1] + d [1];

				if(isSafe() &&res[r][c] < = res[cells[0]][cells[1] + 1){
					contunue;
				}

				if(matrix[r][c] == 'W)
				matrix[r][c] = -1;

				queue.offer(r)(c);
				res[i][j] = res[cells[0]][cells[1] + 1;

			}
		}
	}
 */
	public static void main(String args[]) {
		char[][] matrix = {
				{ 'O', 'O', 'O', 'O', 'G' },
				{ 'O', 'W', 'W', 'O', 'O' },
				{ 'O', 'O', 'O', 'W', 'O' },
				{ 'G', 'W', 'W', 'W', 'O' },
				{ 'O', 'O', 'O', 'O', 'G' }
		};

		int[][] res = guardBFS(matrix);

		for(int i =0;i<res.length;i++) {
			for (int j = 0; j < res[ 0 ].length; j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}



	}

	public static int[][] guardBFS(char[][] mat){

		int[][] cache = new int[mat.length][mat[0].length];
		Queue<int[]> queue = new LinkedList<>();

		for(int i =0;i<mat.length;i++){
			for(int j =0;j<mat[0].length;j++){
				if(mat[i][j] == 'G'){
					queue.offer(new int[]{i,j});
				}
				else{
					cache[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

		while (!queue.isEmpty()){
			int[] cells = queue.poll();
			for(int[] d : dirs){
					int r = cells[0] + d[0];
					int c = cells[1] + d[1];

					if(r < 0 || c < 0 || r >= mat.length || c >= mat[0].length ||
							cache[r][c] <= cache[cells[0]][cells[1]] + 1) {
						continue;
					}

					if(mat[r][c] == 'W'){
						cache[r][c] = -1;
						continue;
					}

					queue.offer(new int[]{r,c});
					cache[r][c] = cache[cells[0]][cells[1]] + 1;

			}

		}

		return cache;
	}
}