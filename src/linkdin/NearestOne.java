package linkdin;


/*
Given a binary matrix of order m*n, the task is to find the distance of nearest 1 for each 0 in the matrix
and print final distance matrix. From any cell (i,j), we can move only in four directions up, down, left and right.
Note : Distance from one cell to immediate another cell is always incremented by 1.

Examples:

Input : m = 3, n = 4
        mat[m][n] = {{0, 0, 0, 1},
                     {0, 0, 1, 1},
                     {0, 1, 1, 0}}
Output: 3 2 1 0
        2 1 0 0
        1 0 0 1



 */

import java.util.*;

public class NearestOne {

	public static void main(String args[]) {

		int[][] mat =
				{  { 0, 0, 0, 1 },
						{ 0, 0, 1, 1 },
						{ 0, 1, 1, 0 }
				};

		NearestOne obj = new NearestOne();
		int[][] res = obj.findDistance(mat);

		for(int i =0;i<res.length;i++){
			for(int j = 0;j<res[0].length;j++){
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}

	public int[][] findDistance(int[][] mat){

		Queue<int[]> q = new LinkedList<>();
		for(int i = 0; i<mat.length;i++){

			for(int j = 0;j<mat[0].length;j++){
				if(mat[i][j] == 0){
					mat[i][j] = Integer.MAX_VALUE;
				} else {
					mat[i][j] = 0;
					q.offer(new int[]{i,j});
				}
			}
		}

		int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

		while(!q.isEmpty()){

			int[] cell = q.poll();

			for(int[] d : dirs){

				int row = cell[0] + d[0];
				int col = cell[1] + d[1];

				if(row < 0 || col < 0 || row >= mat.length  || col >= mat[0].length || mat[row][col] <= mat[cell[0]][cell[1]]){
					continue;
				}

				if(mat[row][col] == 1){
					mat[row][col] = 0;
				}

				mat[row][col] = mat[cell[0]][cell[1]] + 1;

				q.offer(new int[]{row,col});

			}

		}

		return mat;


	}





}
