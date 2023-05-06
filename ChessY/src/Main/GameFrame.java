package Main;

// import Main.Board;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private Board board;

    public GameFrame() {
        // Set the default close operation to exit the application when the window is
        // closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the title of the window
        setTitle("Check-Mate");

        // Set the background color Background
        getContentPane().setBackground(new Color(10, 10, 10, 255));

        // Set the layout manager of the JFrame to GridBagLayout
        setLayout(new GridBagLayout());

        // Set the minimum size of the JFrame
        setMinimumSize(new Dimension(800, 800));

        // Pack the JFrame to its minimum size
        pack();

        // Center the JFrame on the screen
        setLocationRelativeTo(null);

        // Create a new Board object
        board = new Board();
        add(board);
    }

    public void start() {
        // Set the JFrame to be visible
        setVisible(true);
    }

}
