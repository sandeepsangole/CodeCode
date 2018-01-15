package dp.matrix;

/*
	Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example,
	the below matrix contains 5 islands

Input : mat[][] = {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1}

      int[] rowNieghbours = { -1, -1, -1, 0, 0,   1, 1, 1 };
		int[] colNeighbours = { -1,   0, 1, 1, -1, -1, 0, 1 };

Output : 5

 */

public class NoOfIslands {

	public static void main(String[] args) {
		int mat[][] =
				{
						{ 1, 1, 0, 0, 0 },
						{ 0, 1, 0, 0, 1 },
						{ 1, 0, 0, 1, 1 },
						{ 0, 0, 0, 0, 1 },
						{ 1, 0, 1, 0, 1 }

		};

		System.out.println(coundIsland(mat));
	}

	private static int coundIsland(int[][] mat) {
		int count = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[ 0 ].length; j++) {
				if (mat[ i ][ j ] == 1) {
					count++;
					mergeIsland(mat, i, j);
				}
			}
		}

		return count;
	}

	private static void mergeIsland(int[][] mat , int r , int c){

		if(r < 0 || c< 0|| r >= mat.length || c >= mat[0].length || mat[r][c] != 1){
				return;
		}

		mat[r][c] = 0;

		mergeIsland(mat,r+1,c);
		mergeIsland(mat,r,c+1);
		mergeIsland(mat,r-1,c);
		mergeIsland(mat,r,c-1);

	}
}
