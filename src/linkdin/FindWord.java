package linkdin;

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

		System.out.println(obj.findWord(matrix, "SKE"));
	}

	public boolean findWord(char[][] board, String str) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[ 0 ].length; j++) {
				if (findWord(board, str, i, j, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean findWord(char[][] board, String str, int row, int col, int index) {

		if (index == board.length) {
			return true;
		}

		if (row < 0 || col < 0 || row >= board.length || col >= board[ 0 ].length) {
			return false;
		}

		if (board[ row ][ col ] != str.charAt(index)) {
			return false;
		}

		board[row][col] = '0';

		boolean exist = findWord(board, str, row + 1, col, index + 1) ||
				findWord(board, str, row, col + 1, index + 1) ||
				findWord(board, str, row - 1, col, index + 1) ||
				findWord(board, str, row, col - 1, index + 1);

		board[row][col] = str.charAt(index);

		return exist;
	}

}
