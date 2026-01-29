package minesweeperFinalMain;

import java.util.Scanner;

public class minesweeperFinalMainClass {
	static final int ROWS = 5;
    static final int COLS = 5;
    static final int MINES = 4;
	public static void main(String[] args) {
		
		 char[][] board = new char[ROWS][COLS];
	        char[][] visible = new char[ROWS][COLS];

	        initBoard(board, visible);
	        placeMines(board);
	        calculateClues(board);

	        Scanner sc = new Scanner(System.in);
	        boolean gameOver = false;

	        while (!gameOver) {
	            showBoard(visible); // Mostramos el tablero actual

	            System.out.print("Introduce fila (0-" + (ROWS - 1) + "): ");
	            int r = sc.nextInt();
	            System.out.print("Introduce columna (0-" + (COLS - 1) + "): ");
	            int c = sc.nextInt();

	            if (r < 0 || r >= ROWS || c < 0 || c >= COLS) {
	                System.out.println("¡Posición fuera de rango!");
	                continue;
	            }

	            if (board[r][c] == '*') {
	                System.out.println("💥 ¡BOOM! Pisaste una mina.");
	                showBoard(board); // Revelamos todo el tablero
	                gameOver = true;
	            } else {
	                visible[r][c] = board[r][c];
	                // Aquí podrías añadir una condición de victoria si despejas todo
	            }
	        }
	        sc.close();
		
		
		
	}

}
