package gui.tabPanels;

import gui.projectPanels.ProjectPanelsCardManager;
import gui.projectPanels.ProjectTreeViewPanel;

import javax.swing.*;
import java.awt.*;

public class SystemPanel extends JPanel {
    public SystemPanel() {
        super();
        this.setLayout(null);

        ProjectTreeViewPanel projectTreeViewPanel = new ProjectTreeViewPanel();
        projectTreeViewPanel.setBounds(new Rectangle(0, 0, 240, 640));
        this.add(projectTreeViewPanel);

        JPanel mainProjectPanel = ProjectPanelsCardManager.getMainProjectPanel();
        mainProjectPanel.setBounds(new Rectangle(240, 0, 720, 640));
        this.add(mainProjectPanel);
    }
}
