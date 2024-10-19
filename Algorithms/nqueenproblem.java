public class NQueens {

    // Function to check if it's safe to place a queen at board[row][col]
    private static boolean isSafe(char[][] board, int row, int col, int n) {
        // Check the column for another queen
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check the upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the upper-right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Utility function to solve the N-Queens problem
    private static boolean solveNQueensUtil(char[][] board, int row, int n) {
        // If all queens are placed, return true
        if (row == n) {
            return true;
        }

        // Try placing a queen in all columns of the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                // Place the queen
                board[row][col] = 'Q';

                // Recur to place the rest of the queens
                if (solveNQueensUtil(board, row + 1, n)) {
                    return true;
                }

                // If placing the queen in board[row][col] doesn't lead to a solution, backtrack
                board[row][col] = '.';
            }
        }

        // If the queen can't be placed in any column, return false
        return false;
    }

    // Function to solve the N-Queens problem and print the solution
    public static void solveNQueens(int n) {
        // Create an n x n board and initialize it with '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Try to solve the N-Queens problem
        if (solveNQueensUtil(board, 0, n)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }
    }

    // Function to print the solution board
    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 8;  // You can change this to solve for different sizes of N
        solveNQueens(n);
    }
}
