package dp.matrix;

/*
54. Spiral Matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

 */

import java.util.*;

public class SpiralMatrixI {

	public static void main(String[] args) {
		int[][] mat = {

				{2,3}
		};

		SpiralMatrixI obj = new SpiralMatrixI();
		List<Integer> res = obj.spiralOrder(mat);

		res.stream().forEach(System.out::println);

	}


		public enum Direction {
		RIGHT, DOWN, LEFT, UP
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		int topRow    = 0;
		int bottomRow = matrix.length - 1;
		int leftCol   = 0;
		int rightCol  = matrix[ 0 ].length -1;

		List<Integer> res = new ArrayList<>();
		Direction     dir = Direction.RIGHT;

		while (topRow <= bottomRow && leftCol <= rightCol) {


			if (dir == Direction.RIGHT) {

				for (int i = leftCol; i <= rightCol; i++) {
					res.add(matrix[ topRow ][ i ]);
				}

				topRow++;
				dir = Direction.DOWN;
			}

			if(leftCol <= rightCol) {
				if (dir == Direction.DOWN) {

					for (int i = topRow; i <= bottomRow; i++) {
						res.add(matrix[ i ][ rightCol ]);
					}
					dir = Direction.LEFT;
					rightCol--;
				}
			}

			if (dir == Direction.LEFT) {
				for (int i = rightCol; i >= leftCol; i--) {
					res.add(matrix[ bottomRow ][ i ]);
				}
				bottomRow--;
				dir = Direction.UP;

			}

			if(leftCol <= rightCol) {
				if (dir == Direction.UP) {

					for (int i = bottomRow; i >= topRow; i--) {
						res.add(matrix[ i ][ leftCol ]);
					}
					leftCol++;
					dir = Direction.RIGHT;
				}
			}

		}

		return res;

	}

}
