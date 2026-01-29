package main;

import java.util.Scanner;

import utils.Functions;

public class MInesweeper {
	public static void main(String[] args) {

		char[][] board = new char[Functions.ROWS][Functions.COLS];
		char[][] visible = new char[Functions.ROWS][Functions.COLS];

		Functions.initBoard(board, visible);
		Functions.placeMines(board);
		Functions.calculateClues(board);

		Scanner sc = new Scanner(System.in);
		boolean gameOver = false;

		while (!gameOver) {
			Functions.showBoard(visible); // Mostramos el tablero actual

			System.out.print("Introduce fila (0-" + (Functions.ROWS - 1) + "): ");
			int r = sc.nextInt();
			System.out.print("Introduce columna (0-" + (Functions.COLS - 1) + "): ");
			int c = sc.nextInt();

			if (r < 0 || r >= Functions.ROWS || c < 0 || c >= Functions.COLS) {
				System.out.println("¡Posición fuera de rango!");
				continue;
			}

			if (board[r][c] == '*') {
				System.out.println("💥 ¡BOOM! Pisaste una mina.");
				Functions.showBoard(board); // Revelamos todo el tablero
				gameOver = true;
			} else {
				visible[r][c] = board[r][c];
				// Aquí podrías añadir una condición de victoria si despejas todo
			}
		}
		sc.close();

	}

}
