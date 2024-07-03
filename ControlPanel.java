import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    private JButton restartButton;

    public ControlPanel() {
        restartButton = new JButton("Restart");
        restartButton.setFont(new Font("Arial", Font.BOLD, 20));
        setLayout(new BorderLayout());
        add(restartButton, BorderLayout.CENTER);
    }

    public JButton getRestartButton() {
        return restartButton;
    }
}