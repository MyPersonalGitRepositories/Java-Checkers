package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuWindow {
    public static JFrame frame;
    public static JPanel panel;
    public static int rezhim;

    MenuWindow(){
        frame = new JFrame("Шашки");
        frame.setSize(new Dimension(500,600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setOpaque(true);
        frame.add(panel);

        JButton startButton = new JButton("Почати");
        startButton.addActionListener(e -> {
                    frame.setVisible(false);
                    try {
                        UIManager.setLookAndFeel(
                                UIManager.getSystemLookAndFeelClassName());
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    // Create a window to display the checkers game
                    CheckersWindow window = new CheckersWindow();
                    window.setDefaultCloseOperation(CheckersWindow.EXIT_ON_CLOSE);
                    window.setVisible(true);
        });
        panel.add(startButton, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
