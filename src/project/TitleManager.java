package project;

import javax.swing.*;

public class TitleManager {
    private static final String OFFLINE_STUDIO_3000 = "Offline Studio 3000";

    private JFrame mainFrame;
    private String projectName = "";

    public TitleManager() {
    }

    public TitleManager(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setStateDescription(String stateDescription) {
        mainFrame.setTitle(OFFLINE_STUDIO_3000 + " - " + projectName + stateDescription);
    }

    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
