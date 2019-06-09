package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuWindow {
    public static JFrame frame;
    public static JPanel panel;
    public BufferedImage image;
    private Image img;

    MenuWindow(){
        frame = new JFrame("Checkers");
        frame.setSize(new Dimension(500,600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(new BorderLayout());
        frame.add(panel);

        JPanel buttons = new JPanel(new GridLayout(0,1,10,10));
        buttons.setBackground(Color.white);
        buttons.setBorder(new EmptyBorder(20,30,20,30));


        File f; // Создаём файл
        f = new File("images.jpg"); // Устанавливаем путь для файла
        try {
            img = ImageIO.read(f); // Считываем картинку
        } catch(IOException ioe) {
            JOptionPane.showConfirmDialog(null, "Error!\n" + ioe.toString(),
                    "Error!", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
        JLabel jl = new JLabel(new ImageIcon(img));
//        panel.setLayout(new BorderLayout());
        panel.add(jl,BorderLayout.NORTH);

        JButton infoButton = new JButton("Help");
        infoButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "\n" +
                    "If you have any problems with the program \"Checkers\" \n" +
                    " you can ask for help from its author: Maksym Pidlisnyi" +
                    "  \n by contact: \n" + "\n E-mail: p.maxsym@gmail.com " + "\n Phone: +1234567890 \n");
        });


        JButton licenseButton = new JButton("License");
        licenseButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Software: \"Checkers\"\nAuthor: Maksym Pidlisnyi\n\n                   " +
                    "                                   " +
                    "LICENSE\nThis License certifies the right to use the software to LICENSOR  \"Checkers\".\n ");
        });


        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close the app?", "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        JButton startButton = new JButton("Start");
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

        buttons.add(startButton);
        buttons.add(licenseButton);
        buttons.add(infoButton);
        buttons.add(exitButton);
        panel.add(buttons,BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
