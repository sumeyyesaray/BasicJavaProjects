import java.io.IOException;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(System.in);
		char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};  //two dimensional array char[][]

		printBoard(board);

		int movecount = 0; // initial move count is zero.
		int currentplayer = 0;

		while (movecount < 9) {

			System.out.print("Player " + (currentplayer + 1) + " enter row number:");
			int row = reader.nextInt();
			System.out.print("Player " + (currentplayer + 1) + " enter col number:");
			int col = reader.nextInt();
			while (((row < 1 || col < 1) || (row > 3 || col > 3)) || (board[row - 1][col - 1] != ' ')) {  // if there is not empty or row or column is not between the 1-3 ,player can not make a move here.
				System.out.println("Invalid move ! Please choose another coordinate.");              //(If we can use 'if' statements it just check once,that's why we use while.)
				System.out.print(("Player " + (currentplayer + 1) + " enter row number:"));         //"board[row-1][col-1] != ' '" başlangıca koymadık. because of Short circuit .
				row = reader.nextInt();                                                            //when we write different from 1-3 , it will return true because there is empty.
				System.out.print(("Player " + (currentplayer + 1) + " enter col number:"));       // That's why we need to check the number range before checking the space.
				col = reader.nextInt();
			}
			if (currentplayer == 0)
				board[row - 1][col - 1] = 'X';
			else
				board[row - 1][col - 1] = 'O';

			printBoard(board);

			if (checkBoard(board)){
				System.out.println("Player " + (currentplayer + 1) + " won the game!");
				break;
			}


			currentplayer = (currentplayer + 1) % 2;  //players 0 and 1, when we increase the mode one by one, the players are determined according to the left of the mode. (mod = 0 => player 1)
			movecount++;

			if (movecount == 9){
				System.out.println("It's a draw!");
			}
		}
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

	public static boolean checkBoard(char[][] board) {
		//Check all the row
		for (int row = 0; row < 3; row++) {
			if ((board[row][0] == board[row][1]) && (board[row][1] == board[row][2]) && (board[row][0] != ' ')) {
				return true;
			}
		}
		//Check all the column
		for (int col = 0; col < 3; col++) {
			if ((board[0][col] == board[1][0]) && (board[1][col] == board[2][col]) && (board[0][col] != ' ')) {
				return true;
			}
		}
		// Check all the top-left to bottom-right
		if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) && (board[0][0] != ' ')) {
			return true;
		}
		// Check all the bottom-left to bottom right
		if (board[2][0] == board[1][1] && (board[1][1] == board[0][2]) && (board[0][2] != ' ')) {
			return true;
		}
			// No winner yet
			return false;

	}
}
