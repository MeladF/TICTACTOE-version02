import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {

    private TicTacToe game;
    private BoardPanel boardPanel;
    private JLabel textLabel;

    public GameController(BoardPanel boardPanel, JLabel textLabel) {
        this.boardPanel = boardPanel;
        this.textLabel = textLabel;
        this.game = new TicTacToe(boardPanel.getBoardSize());
        updateTextLabel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.isGameOver()) return;

        JButton button = (JButton) e.getSource();
        int[] position = boardPanel.getButtonPosition(button);
        if (position == null) return;

        int row = position[0];
        int col = position[1];

        if (game.makeMove(row, col)) {
            button.setText(game.getCurrentPlayer());
            updateBoard();
            if (game.isGameOver()) {
                updateTextLabelWithResult();
            } else if (game.isTie()) {
                textLabel.setText("Tie!");
            } else {
                game.switchPlayer();
                updateTextLabel();
            }
        }
    }

    public void resetGame() {
        game.resetBoard();
        boardPanel.resetBoard();
        updateTextLabel();
    }

    private void updateBoard() {
        for (int r = 0; r < boardPanel.getBoardSize(); r++) {
            for (int c = 0; c < boardPanel.getBoardSize(); c++) {
                boardPanel.getButton(r, c).setText(game.getCell(r, c));
            }
        }
    }

    private void updateTextLabel() {
        textLabel.setText(game.getCurrentPlayer() + "'s turn");
    }

    private void updateTextLabelWithResult() {
        if (game.isTie()) {
            textLabel.setText("Tie!");
        } else {
            textLabel.setText(game.getCurrentPlayer() + " is the winner");
        }
    }
}
