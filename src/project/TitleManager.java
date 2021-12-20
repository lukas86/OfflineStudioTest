package project;

import javax.swing.*;

public class TitleManager {
    private static final String OFFLINE_STUDIO_3000 = "Offline Studio 3000";
    public static final String SAVED = " [saved]";
    public static final String NOT_SAVED = " [not saved]";

    private JFrame mainFrame;
    private String projectName = "";

    public TitleManager() {
    }

    public TitleManager(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void save() {
        mainFrame.setTitle(OFFLINE_STUDIO_3000 + " - " + projectName + SAVED);
    }

    public void change() {
        mainFrame.setTitle(OFFLINE_STUDIO_3000 + " - " + projectName + NOT_SAVED);
    }

    public void clear() {
        mainFrame.setTitle(OFFLINE_STUDIO_3000);
    }

    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
