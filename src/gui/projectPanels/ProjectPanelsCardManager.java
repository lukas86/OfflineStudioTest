package gui.projectPanels;

import javax.swing.*;
import java.awt.*;

public class ProjectPanelsCardManager {
    private static final CardLayout cardLayout = new CardLayout();
    private static final JPanel mainProjectPanel = new JPanel(cardLayout);

    private static final int WIDTH = 720;
    private static final int HEIGHT = 640;

    public static final String PANEL_STATE_PANEL = "PANEL_STATE_PANEL";
    public static final String MODULE_STATE_PANEL = "MODULE_STATE_PANEL";
    public static final String MODULE_INPUT_LIST_PANEL = "MODULE_INPUT_LIST_PANEL";
    public static final String MODULE_OUTPUT_LIST_PANEL = "MODULE_OUTPUT_LIST_PANEL";
    public static final String LOOP_STATE_PANEL = "LOOP_STATE_PANEL";

    static {
        mainProjectPanel.add(new PanelStatePanel(), PANEL_STATE_PANEL);
        mainProjectPanel.add(new ModuleStatePanel(), MODULE_STATE_PANEL);
        mainProjectPanel.add(new ModuleInputListPanel(), MODULE_INPUT_LIST_PANEL);
        mainProjectPanel.add(new ModuleOutputListPanel(), MODULE_OUTPUT_LIST_PANEL);
        mainProjectPanel.add(new LoopStatePanel(), LOOP_STATE_PANEL);

        mainProjectPanel.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        mainProjectPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        mainProjectPanel.setBackground(Color.GREEN);
    }

    public static JPanel getMainProjectPanel() {
        return mainProjectPanel;
    }

    public static void changePanel(String panelName) {
        cardLayout.show(mainProjectPanel, panelName);
    }
}
