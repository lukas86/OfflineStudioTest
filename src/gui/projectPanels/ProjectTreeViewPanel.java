package gui.projectPanels;

import javax.swing.*;
import java.awt.*;

public class ProjectTreeViewPanel extends JPanel {

    private static final int WIDTH = 240;
    private static final int HEIGHT = 640;

    public ProjectTreeViewPanel() {
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        this.setBackground(Color.magenta);
    }
}
