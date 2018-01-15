package dp.matrix;


public class NearestOneorZero {

	/*
		1. Start with Zero
		2. Turn rest to MAX Value
		3. When found zero add to queue, row and col
		4. pop from queue and traverse 4 directions and update col value and insert it into Queue
		5.
	*/


	public static void main(String args[]) {
		NearestOneorZero obj = new NearestOneorZero();

		int mat[][] =
				{
						{ 1, 1, 1, 1 },
						{ 1, 1, 1, 0 },
						{ 1, 1, 1, 1 }
				};

		//System.out.println(updateMatrix(mat));

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[ 0 ].length; j++) {
				System.out.print(mat[ i ][ j ] + " ");
			}
			System.out.println();
		}

	}
}
