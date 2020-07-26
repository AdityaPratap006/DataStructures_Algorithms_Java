package nQueens;

public class NQueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[5][5];
        System.out.println(countNQueens(board, 0));
    }

    public static int countNQueens(boolean[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return 1;
        }

        int count = 0;

        for (int col = 0; col < board[row].length; ++col) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count = count + countNQueens(board, row + 1);
                //backtrack
                board[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        for (int r = 0; r < row; ++r) {
            if (board[r][col]) {
                return false;
            }
        }

        int r = row - 1;
        int c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c]) {
                return false;
            }
            --r;
            --c;
        }

        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < board[r].length) {
            if (board[r][c]) {
                return false;
            }
            --r;
            ++c;
        }

        return true;
    }

    private static void printBoard(boolean[][] board) {
        for (boolean[] boardRow : board) {
            for (boolean boardCol: boardRow) {
                if (boardCol) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" _ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
