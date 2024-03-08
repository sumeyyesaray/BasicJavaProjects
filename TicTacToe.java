import java.io.IOException;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(System.in);
		char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

		printBoard(board);

		System.out.print("Player 1 enter row number:");
		int row = reader.nextInt();
		System.out.print("Player 1 enter column number:");
		int col = reader.nextInt();
		board[row - 1][col - 1] = 'X';
		printBoard(board);

		System.out.print("Player 2 enter row number:");
		row = reader.nextInt();
		System.out.print("Player 2 enter column number:");
		col = reader.nextInt();
		board[row - 1][col - 1] = 'O';
		printBoard(board);

		reader.close();
	}

	public static void printBoard(char[][] board) {
		System.out.println("    1   2   3");
		System.out.println("   -----------");
		for (int row = 0; row < 3; ++row) {
			System.out.print(row + 1 + " ");
			for (int col = 0; col < 3; ++col) {
				System.out.print("|");
				System.out.print(" " + board[row][col] + " ");
				if (col == 2)
					System.out.print("|");

			}
			System.out.println();
			System.out.println("   -----------");

		}

	}

}