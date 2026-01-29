package utils;

public class Functions {

	public static final int ROWS = 5;
	public static final int COLS = 5;
	public static final int MINES = 4;

	public static void initBoard(char[][] board, char[][] visible) {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				board[i][j] = '0';
				visible[i][j] = '-';
			}
		}
	}

	public static void showBoard(char[][] grid) {
		System.out.println("\n  Tablero:");
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

}
