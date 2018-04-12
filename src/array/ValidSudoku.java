package array;

import java.util.*;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < 9; i++) {
			Set<Character> rows = new HashSet<>();
			Set<Character> cols = new HashSet<>();
			Set<Character> cube = new HashSet<>();
			for (int j = 0; j < 9; j++) {

				if (board[i][j] != '.' && !rows.add(board[i][j])) {
					return false;
				}

				if (board[j][i] != '.' && !cols.add(board[j][i])) {
					return false;
				}

				int rowOffset = j / 3;
				int colOffset = j % 3;


				int colStart = 3 * (i % 3) + colOffset;
				int rowStart = 3 * (i / 3) + rowOffset;

				if (board[rowStart][colStart] != '.' &&
					!cube.add(board[rowStart][colStart])) {
					return false;
				}

			}
		}
		return true;
	}
}
