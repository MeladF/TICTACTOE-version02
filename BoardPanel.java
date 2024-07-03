import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BoardPanel extends JPanel {

    private JButton[][] buttons;
    private int boardSize;

    public BoardPanel(int boardSize) {
        this.boardSize = boardSize;
        this.buttons = new JButton[boardSize][boardSize];
        setLayout(new GridLayout(boardSize, boardSize));
        setBackground(Color.darkGray);
        initializeBoard();
    }

    private void initializeBoard() {
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                JButton button = new JButton();
                buttons[r][c] = button;
                button.setBackground(Color.darkGray);
                button.setForeground(Color.white);
                button.setFont(new Font("Arial", Font.BOLD, 120));
                button.setFocusPainted(false);
                add(button);
            }
        }
    }

    public void addBoardButtonListener(ActionListener listener) {
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                buttons[r][c].addActionListener(listener);
            }
        }
    }

    public JButton getButton(int r, int c) {
        return buttons[r][c];
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int[] getButtonPosition(JButton button) {
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                if (buttons[r][c] == button) {
                    return new int[]{r, c};
                }
            }
        }
        return null;
    }

    public void resetBoard() {
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                buttons[r][c].setText("");
                buttons[r][c].setBackground(Color.darkGray);
                buttons[r][c].setForeground(Color.white);
            }
        }
    }
}
