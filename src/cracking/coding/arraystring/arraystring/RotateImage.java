package cracking.coding.arraystring.arraystring;

/*

48. Rotate Image

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
1 4 7
2 5 8
3 6 9


rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

 */
public class RotateImage {

	public static void main(String[] args) {

		int[][] mat = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};

		RotateImage obj = new RotateImage();
		obj.rotateImage(mat);

		for (int i = 0;i < mat.length;i++){

			for (int j =0;j<mat[0].length;j++){
				System.out.print(mat[i][j] +" ");
			}
			System.out.println();
		}

	}

	public void rotateImage(int[][] image){

		int[][] mat = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}

				/*
              0  1  2
				0{1, 2, 3},
				1{4, 5, 6},
				2{7, 8, 9}

				1 4 7
				2 5 8
				3 6 9

              0 1 2
				0[7,4,1],
            1[8,5,2],
            2[9,6,3]

            */

		};

		for (int i = 0;i < image.length;i++){

			for (int j =0;j<image[0].length;j++){
				System.out.print(image[i][j] +" ");
			}
			System.out.println();
		}

		for (int i =0;i < image.length;i++){

			for (int j = i;j<image[0].length;j++) {

				int tmp = image[ i ][ j ];
				image[ i ][ j ] = image[ j ][ i ];
				image[ j ][ i ] = tmp;
			}
		}

		for (int i = 0;i < image.length;i++){

			for (int j =0;j<image[0].length;j++){
				System.out.print(image[i][j] +" ");
			}
			System.out.println();
		}

		for(int[] row : image){
			swapRows(row, 0 ,row.length - 1);
		}



	}

	private void swapRows(int[] row , int left , int right){

		while (left < right){
			int tmp = row[left];
			row[left] = row[right];
			row[right] = tmp;
			left++;
			right--;
		}
	}
}
