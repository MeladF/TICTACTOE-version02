public class TicTacToe {

    private int size;
    private String[][] board;
    private String currentPlayer;
    private boolean gameOver;
    private int turns;

    public TicTacToe(int size) {
        this.size = size;
        this.board = new String[size][size];
        this.currentPlayer = "X";
        this.gameOver = false;
        this.turns = 0;

        resetBoard();
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isTie() {
        return turns == size * size && !gameOver;
    }

    public String getCell(int r, int c) {
        return board[r][c];
    }

    public boolean makeMove(int r, int c) {
        if (board[r][c].isEmpty()) {
            board[r][c] = currentPlayer;
            turns++;
            checkWinner();
            return true;
        }
        return false;
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    public void resetBoard() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                board[r][c] = "";
            }
        }
        currentPlayer = "X";
        gameOver = false;
        turns = 0;
    }

    private void checkWinner() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < size; i++) {
            if (checkLine(board[i])) {
                gameOver = true;
                return;
            }
            if (checkLine(getColumn(i))) {
                gameOver = true;
                return;
            }
        }
        if (checkLine(getMainDiagonal())) {
            gameOver = true;
            return;
        }
        if (checkLine(getAntiDiagonal())) {
            gameOver = true;
        }
    }

    private boolean checkLine(String[] line) {
        String first = line[0];
        if (first.isEmpty()) return false;
        for (String cell : line) {
            if (!cell.equals(first)) return false;
        }
        return true;
    }

    private String[] getColumn(int col) {
        String[] column = new String[size];
        for (int i = 0; i < size; i++) {
            column[i] = board[i][col];
        }
        return column;
    }

    private String[] getMainDiagonal() {
        String[] diagonal = new String[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = board[i][i];
        }
        return diagonal;
    }

    private String[] getAntiDiagonal() {
        String[] diagonal = new String[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = board[i][size - 1 - i];
        }
        return diagonal;
    }
}
