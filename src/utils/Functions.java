package utils;

import java.util.Random;

public class Functions {

	public static final int ROWS = 5;
	public static final int COLS = 5;
	public static final int MINES = 4;

	// Initializes both the hidden board and the visible board
	public static void initBoard(char[][] board, char[][] visible) {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				board[i][j] = '0';	// Default value before calculating clues
				visible[i][j] = '-';	// What the player sees initially
			}
		}
	}

	// Places a fixed number of mines randomly on the board
	static void placeMines(char[][] board) {

	    Random rand = new Random();
	    int placed = 0;

	    // Place mines until reaching the required amount
	    while (placed < MINES) {

	        int r = rand.nextInt(ROWS); // random row
	        int c = rand.nextInt(COLS); // random column

	        if (board[r][c] != '*') {   // place only if empty
	            board[r][c] = '*';
	            placed++;
	        }
	    }
	}

	
	// Calculates the number of adjacent mines for each non-mine cell
	public static void calculateClues(char[][] board) {
	    for (int row = 0; row < ROWS; row++) {
	        for (int col = 0; col < COLS; col++) {

	        	// Skip cells that already contain a mine
	            if (board[row][col] != '*') {
	                int adjacentMines = 0;

	             // Check the 8 surrounding cells 
	                for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
	                    for (int colOffset = -1; colOffset <= 1; colOffset++) {

	                        int neighborRow = row + rowOffset;
	                        int neighborCol = col + colOffset;

	                     // Check that the neighbor is inside the board boundaries
	                        boolean insideBoard =
	                                neighborRow >= 0 && neighborRow < ROWS &&
	                                neighborCol >= 0 && neighborCol < COLS;

	                             // If the neighbor exists and contains a mine, count it
	                        if (insideBoard && board[neighborRow][neighborCol] == '*') {
	                            adjacentMines++;
	                        }
	                    }
	                }
	             // Convert the number of adjacent mines to a character
	                board[row][col] = (char) (adjacentMines + '0');
	            }
	        }
	    }
	}

	// Displays the board passed as parameter
	public static void showBoard(char[][] grid) {
		System.out.println("\n  Board:");
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

}
