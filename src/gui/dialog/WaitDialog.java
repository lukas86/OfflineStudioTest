package gui.dialog;

import javax.swing.*;

public class WaitDialog {
    private static JDialog dialog;

    public static void showWaitDialog(String operation, String newProjectName) {
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
    }

    public static void dispose() {
        dialog.dispose();
    }
}
