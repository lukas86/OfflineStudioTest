package gui.dialog;

import javax.swing.*;

public class DialogManager {
    private static JFrame mainFrame;

    public static void setFrame(JFrame mainFrame) {
        DialogManager.mainFrame = mainFrame;
    }

    public static void showSaveDialog() {
        System.out.println("showing save project dialog...");
        JOptionPane.showConfirmDialog(mainFrame, "Would you like to save the changed, otherwise the changes will be lost?");
    }

    public static void provideProjectNameDialog() {
        System.out.println("showing new project dialog...");
        JOptionPane.showConfirmDialog(mainFrame, "Input new project name");
    }

    public static void choseExistingProjectDialog() {
        System.out.println("showing load project dialog...");
        JOptionPane.showConfirmDialog(mainFrame, "Chose the project to load");
    }
}
