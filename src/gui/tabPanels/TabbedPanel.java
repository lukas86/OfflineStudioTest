package gui.tabPanels;

import javax.swing.*;
import java.awt.*;

public class TabbedPanel extends JTabbedPane {

    public static final int systemTab = 0;
    public static final int zonesTab = 1;
    public static final int panelHierarchyTab = 2;
    public static final int outputProgramTab = 3;
    public static final int combinationTab = 4;

    public TabbedPanel() {
        this.setBackground(Color.ORANGE);
        this.addTab("System", new SystemPanel());
        this.addTab("Zones", new ZonesPanel());
        this.addTab("Panel Hierarchy", new PanelHierarchyPanel());
        this.addTab("Output Program", new OutputProgramPanel());
        this.addTab("Combinations", new CombinationPanel());
    }

    public void selectTab(int tabIndex) {
        this.setSelectedIndex(tabIndex);
    }
}
