package gui;

import gui.dialog.DialogManager;
import project.ProjectManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame {

    public static final int WIDTH = 960;
    public static final int HEIGHT = 640;

    public MainFrame() {
        JFrame mainFrame = new JFrame();
        DialogManager.setFrame(mainFrame);

        mainFrame.setJMenuBar(new MainMenuBar());
        mainFrame.add(MainCardManager.getMainPanel());

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){ProjectManager.exit();
            }
        });
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        mainFrame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        mainFrame.setLayout(null);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
