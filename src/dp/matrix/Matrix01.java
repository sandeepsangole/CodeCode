package dp.matrix;

/*

542. 01 Matrix

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1:
Input:

0 0 0
0 1 0
0 0 0
Output:
0 0 0
0 1 0
0 0 0
Example 2:
Input:

0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1
Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.

 */

import java.util.LinkedList;
import java.util.*;

public class Matrix01 {

	public static void main(String[] args) {
		Matrix01 obj = new Matrix01();
		int[][] mat = {
				{0, 0, 0},
				{0, 1, 0},
				{1, 1, 1}
		};
		int[][] res = obj.updateMatrix(mat);
		for(int i =0;i<res.length;i++){
			for(int j = 0;j<res[0].length;j++) {
				System.out.print(res[i][j] +" ");
			}
			System.out.println();
			}

	}
	public int[][] updateMatrix(int[][] matrix) {


			int r = matrix.length;
			int c = matrix[0].length;

			int[][] cache = new int[r][c];
			Queue<int[]> queue = new LinkedList<>();

			for(int i =0;i<r;i++){
				for(int j = 0;j<c;j++){
					if(matrix[i][j] == 1){
						cache[i][j] = Integer.MAX_VALUE;
					} else {
						queue.offer(new int[]{i,j});
					}
				}
			}

			int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

			while(!queue.isEmpty()){

				int[] cells = queue.poll();

				for(int[] d : dirs){
					int row = cells[0] + d[0];
					int col = cells[1] + d[1];

					if(row < 0 || col < 0 || row >= r || col >= c || cache[row][col] <= cache[cells[0]][cells[1]] + 1){
						continue;
					}

					if(matrix[row][col] == 0){
						cache[row][col] = 0;
					}

					cache[row][col] = cache[cells[0]][cells[1]] + 1;
					queue.offer(new int[]{row , col});


				}



			}

		return cache;
	}

}
