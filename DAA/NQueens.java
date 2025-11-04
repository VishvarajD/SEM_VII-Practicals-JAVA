
public class NQueens {

    static int N; // Size of the chessboard (NxN)

    // Function to print the N-Queens board
    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Function to check if a queen can be placed at board[row][col]
    static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        // Check this row on left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on left side
        for (i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true; // Safe position
    }

    // Function to solve N-Queens using Backtracking
    static boolean solve(int[][] board, int col) {
        if (col == N) {
            return true; // All queens placed
        }
        for (int row = 0; row < N; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;         // Place queen
                if (solve(board, col + 1)) {    // Recur for next column
                    return true;
                } else {
                    board[row][col] = 0;  // Backtrack
                }
            }
        }
        return false; // No valid position found
    }

    public static void main(String[] args) {
        N = 5; // Example: 4x4 chessboard
        int[][] board = new int[N][N];

        // Place the first queen manually (as given in question)
        board[0][0] = 1;

        // Start solving from next column
        if (!solve(board, 1)) {
            System.out.println("Solution does not exist");
        } else {
            System.out.println("Final N-Queens Solution:");
            printBoard(board);
        }
    }

}
