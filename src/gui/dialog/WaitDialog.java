package gui.dialog;

import javax.swing.*;

public class WaitDialog {
    private static JDialog dialog;

//    public static void show(String operation, String newProjectName) {
//        Thread hideThread = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    if (!isDisplayed) {
//                        showDialog(operation, newProjectName);
//                        isDisplayed = true;
//                        hide = false;
//                        count = 0;
//                    }
//
//                    while (!hide && count < MIN_SECONDS_WAIT) {
//                        Thread.sleep(SLEEP_STEP);
//                        count++;
//                        System.out.println("= COUNT: " + count);
//                    }
//
//                    dispose();
//                    isDisplayed = false;
//                    hide = false;
//                    count = 0;
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        };
//        hideThread.start();
//    }

    public static void show(String operation, String newProjectName) {
        showDialog(operation, newProjectName);
    }

    private static void showDialog(String operation, String newProjectName) {
        SwingUtilities.invokeLater(() -> {
            System.out.println("=== SHOWING WAIT ALERT for: " + operation);

            final JOptionPane optionPane = new JOptionPane(operation + " project " + newProjectName + ". Please wait.",
                    JOptionPane.WARNING_MESSAGE,
                    JOptionPane.DEFAULT_OPTION,
                    null,
                    new Object[]{},
                    null);

            dialog = new JDialog();
            dialog.setTitle(operation);
            dialog.setModal(true);

            dialog.setContentPane(optionPane);
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            dialog.pack();

            dialog.setVisible(true);
        });
    }

    public static void dispose() {
        SwingUtilities.invokeLater(() -> {
            System.out.println("=== CLOSING WAIT ALERT");
            dialog.dispose();
        });
    }
}
