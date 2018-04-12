package dp.matrix;

/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes"
 (water inside that isn't connected to the water around the island). One cell is a square with side length 1.
 The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:


 */
public class IslandPerimeter {
	public static void main(String[] args) {

		int[][] mat = {
				{ 0, 1, 0, 0 },
				{ 1, 1, 1, 0 },
				{ 0, 1, 0, 0 },
				{ 1, 1, 0, 0 }
		};

		System.out.println(islandPerimeter(mat));
	}

	public static int islandPerimeter(int[][] grid) {

		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[ 0 ].length; j++) {

				if (grid[ i ][ j ] == 1) {
					count += 4;
				}

				//row - 1 - top
				if (isSafe(grid, i - 1, j) && grid[ i - 1 ][ j ] == 1) {
					count -= 1;
				}
				//col - 1 - left
				if (isSafe(grid, i, j - 1) && grid[ i ][ j - 1 ] == 1) {
					count -= 1;
				}
			}
		}

		return count;
	}

	static boolean isSafe(int[][] grid, int r, int c) {
		if (r < 0 || c < 0 || r >= grid.length || c >= grid[ 0 ].length) {
			return false;
		}
		return true;
	}

}
