package gui.dialog;

import javax.swing.*;
import java.util.Arrays;

public class DialogManager {
    private static JFrame mainFrame;

    public static void setFrame(JFrame mainFrame) {
        DialogManager.mainFrame = mainFrame;
    }

    public static boolean showSaveDialog() {
        return JOptionPane.showConfirmDialog(mainFrame,
                "Would you like to save the changed, otherwise the changes will be lost?",
                "Project changes not saved",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    public static String inputProjectNameDialog(String[] listOfExistingProjects) {
        return JOptionPane.showInputDialog(mainFrame,
                "Input new project name",
                "Project creation",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static String choseExistingProjectDialog(String[] listOfExistingProjects) {
        return (String)JOptionPane.showInputDialog(mainFrame,
                "Choose which project you wish to open.",
                "Open project", JOptionPane.PLAIN_MESSAGE,
                null,
                listOfExistingProjects,
                listOfExistingProjects[0]);
    }

    public static void showProjectNameIsBlankAlert() {
        JOptionPane.showMessageDialog(mainFrame, "Project name cannot be empty");
    }

    public static void showProjectNameIsTakenAlert(String newProjectName) {
        JOptionPane.showMessageDialog(mainFrame, "Project name " + newProjectName + " is already in use, please provide different project name.");
    }

    public static String getValidNewProjectName(String[] listOfProjects) {
        while(true) {
            String newProjectName = DialogManager.inputProjectNameDialog(listOfProjects);

            if (newProjectName == null) {
                return null;
            }

            if(newProjectName.isBlank()
                    || newProjectName.isEmpty()) {
                DialogManager.showProjectNameIsBlankAlert();
            } else if (Arrays.asList(listOfProjects).contains(newProjectName)) {
                DialogManager.showProjectNameIsTakenAlert(newProjectName);
            } else {
                return newProjectName;
            }
        }
    }

}
