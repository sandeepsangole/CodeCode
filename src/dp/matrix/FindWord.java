package dp.matrix;
/*

79. Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are
those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

 */
public class FindWord {

	public static void main(String[] args) {
		FindWord obj = new FindWord();

		char[][] matrix = {
				{ 'A', 'B', 'C', 'E' },
				{ 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' }
		};

		System.out.println(obj.exist(matrix,"SFCSEEDA"));
	}

	public boolean exist(char[][] board, String word) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[ 0 ].length; j++) {
				if(board[i][j] == word.charAt(0)) {
					if (findWord(board, i, j, word, 0)) {
						return true;
					}
				}

			}
		}

		return false;

	}

	public boolean findWord(char[][] board , int r , int c , String word,int index){

		if(index == word.length()){
			return true;
		}

		if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)) {
			return false;
		}


		board[r][c] ='0';

		boolean exist = (findWord(board, r + 1 ,c , word,index+1) ||
		findWord(board, r  ,c + 1 , word,index+1) ||
		findWord(board, r - 1 , c , word,index+1) ||
		findWord(board, r  ,c - 1 , word,index+1));

		board[r][c] =word.charAt(index);

		return exist;


	}

}
