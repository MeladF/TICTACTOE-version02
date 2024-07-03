import javax.swing.*;
import java.awt.*;

public class TicTacToeGUI {

    private JFrame frame;
    private JLabel textLabel;
    private BoardPanel boardPanel;
    private ControlPanel controlPanel;
    private GameController gameController;

    public TicTacToeGUI(int boardSize) {
        frame = new JFrame("Tic Tac Toe");
        textLabel = new JLabel();
        boardPanel = new BoardPanel(boardSize); // Dynamische Größe des Spielfelds
        controlPanel = new ControlPanel();
        gameController = new GameController(boardPanel, textLabel);

        initializeGUI();
    }

    private void initializeGUI() {
        frame.setSize(600, 650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(textLabel, BorderLayout.CENTER);
        frame.add(textPanel, BorderLayout.NORTH);

        frame.add(boardPanel, BorderLayout.CENTER);

        controlPanel.getRestartButton().addActionListener(e -> gameController.resetGame());
        JPanel controlPanelWrapper = new JPanel(new BorderLayout());
        controlPanelWrapper.add(controlPanel, BorderLayout.CENTER);
        frame.add(controlPanelWrapper, BorderLayout.SOUTH);

        boardPanel.addBoardButtonListener(gameController);

        frame.setVisible(true);
    }
}
