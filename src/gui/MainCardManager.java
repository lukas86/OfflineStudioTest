package gui;

import gui.tabPanels.TabbedPanel;

import javax.swing.*;
import java.awt.*;

public class MainCardManager {

    private static final CardLayout cardLayout = new CardLayout();
    private static final JPanel mainPanel = new JPanel(cardLayout);

    private static final int WIDTH = 960;
    private static final int HEIGHT = 640;

    public static final String MAIN_MENU_PANEL = "MAIN_MENE_PANEL";
    public static final String TABBED_PANEL = "TABBED_PANEL";

    static {
        mainPanel.add(new MainMenuPanel(), MAIN_MENU_PANEL);
        mainPanel.add(new TabbedPanel(), TABBED_PANEL);

        mainPanel.setBackground(Color.BLUE);
        mainPanel.setBounds(0, 0, WIDTH, HEIGHT);
    }

    public static JPanel getMainPanel() {
        return mainPanel;
    }

    public static void changePanel(String panelName) {
        //TODO: ali je mainPanel ali mainFrame
        cardLayout.show(mainPanel, panelName);
    }

}
