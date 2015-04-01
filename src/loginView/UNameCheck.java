package loginView;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UNameCheck extends JPanel {
    private FirstView containedIn;
    private JTextField textUsername;
    private JPasswordField passwordField2;
    private JPasswordField passwordField1;

    /**
     * Create the panel.
     */
    public UNameCheck(FirstView in) {
        super();
        containedIn = in;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 0, 70, 119, 54, 28, 0, 0 };
        gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, Double.MIN_VALUE };
        setLayout(gridBagLayout);

        JLabel lblPleaseEnterA = new JLabel(
                "Please Enter a username and password.");
        GridBagConstraints gbc_lblPleaseEnterA = new GridBagConstraints();
        gbc_lblPleaseEnterA.gridwidth = 3;
        gbc_lblPleaseEnterA.insets = new Insets(0, 0, 5, 5);
        gbc_lblPleaseEnterA.gridx = 2;
        gbc_lblPleaseEnterA.gridy = 1;
        add(lblPleaseEnterA, gbc_lblPleaseEnterA);

        JLabel lblUsername = new JLabel("Username:");
        GridBagConstraints gbc_lblUsername = new GridBagConstraints();
        gbc_lblUsername.anchor = GridBagConstraints.EAST;
        gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
        gbc_lblUsername.gridx = 1;
        gbc_lblUsername.gridy = 2;
        add(lblUsername, gbc_lblUsername);

        textUsername = new JTextField();
        GridBagConstraints gbc_textUsername = new GridBagConstraints();
        gbc_textUsername.gridwidth = 3;
        gbc_textUsername.insets = new Insets(0, 0, 5, 5);
        gbc_textUsername.fill = GridBagConstraints.HORIZONTAL;
        gbc_textUsername.gridx = 2;
        gbc_textUsername.gridy = 2;
        add(textUsername, gbc_textUsername);
        textUsername.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.anchor = GridBagConstraints.EAST;
        gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblPassword.gridx = 1;
        gbc_lblPassword.gridy = 4;
        add(lblPassword, gbc_lblPassword);

        passwordField1 = new JPasswordField();
        GridBagConstraints gbc_passwordField1 = new GridBagConstraints();
        gbc_passwordField1.gridwidth = 3;
        gbc_passwordField1.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField1.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField1.gridx = 2;
        gbc_passwordField1.gridy = 4;
        add(passwordField1, gbc_passwordField1);

        JLabel lblRe = new JLabel("<html>Re Enter<br>Password:</html>");
        GridBagConstraints gbc_lblRe = new GridBagConstraints();
        gbc_lblRe.insets = new Insets(0, 0, 5, 5);
        gbc_lblRe.anchor = GridBagConstraints.EAST;
        gbc_lblRe.gridx = 1;
        gbc_lblRe.gridy = 5;
        add(lblRe, gbc_lblRe);

        passwordField2 = new JPasswordField();
        GridBagConstraints gbc_passwordField2 = new GridBagConstraints();
        gbc_passwordField2.gridwidth = 3;
        gbc_passwordField2.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField2.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField2.gridx = 2;
        gbc_passwordField2.gridy = 5;
        add(passwordField2, gbc_passwordField2);

        JButton btnNext = new JButton("Next");
        GridBagConstraints gbc_btnNext = new GridBagConstraints();
        gbc_btnNext.insets = new Insets(0, 0, 0, 5);
        gbc_btnNext.gridx = 3;
        gbc_btnNext.gridy = 6;
        add(btnNext, gbc_btnNext);

        JButton btnCancel = new JButton("Cancel");
        GridBagConstraints gbc_btnCancel = new GridBagConstraints();
        gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
        gbc_btnCancel.gridx = 4;
        gbc_btnCancel.gridy = 6;
        add(btnCancel, gbc_btnCancel);

        btnCancel.addActionListener(new ActionListener() {
            /**
             * Resets the container its in to initialized state.
             */
            public void actionPerformed(ActionEvent e) {
                containedIn.reset();
            }
        });

        btnNext.addActionListener(new ActionListener() {
            /**
             * Shows the registration page
             */
            public void actionPerformed(ActionEvent e) {
                containedIn.showRPage();
                System.out.println(textUsername.getText() + ", "
                        + passwordField1.getText() + ", "
                        + passwordField2.getText());
            }
        });

    }

    public void clearFields() {
        textUsername.setText("");
        passwordField2.setText("");
        passwordField1.setText("");
    }

}
