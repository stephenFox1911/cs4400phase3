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
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

import main.MainFrame;
import DBdriverPack.DBdriver;

import java.sql.*;
@SuppressWarnings("serial")
public class LoginPage extends JPanel {
    private JTextField userNameField;
    private JPasswordField passwordField;
    private FirstView containedIn;

    /**
     * Create the panel.
     */
    public LoginPage(FirstView in) {
        super();
        containedIn = in;
        MainFrame.resize(325, 220);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] {0, 63, 80, 141, 0};
        gridBagLayout.rowHeights = new int[] {26, 16, 35, 22, 22, 25, 0};
        gridBagLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0,
            Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
            Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblNewLabel_1 = new JLabel("Welcome.");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_1.gridwidth = 3;
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 1;
        add(lblNewLabel_1, gbc_lblNewLabel_1);

        JLabel label = new JLabel("  ");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 0;
        gbc_label.gridy = 2;
        add(label, gbc_label);

        JLabel lblNewLabel = new JLabel("Username:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 4;
        add(lblNewLabel, gbc_lblNewLabel);

        userNameField = new JTextField();
        GridBagConstraints gbc_userNameField = new GridBagConstraints();
        gbc_userNameField.anchor = GridBagConstraints.NORTH;
        gbc_userNameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_userNameField.insets = new Insets(0, 0, 5, 5);
        gbc_userNameField.gridwidth = 2;
        gbc_userNameField.gridx = 2;
        gbc_userNameField.gridy = 4;
        add(userNameField, gbc_userNameField);
        userNameField.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblPassword.gridx = 1;
        gbc_lblPassword.gridy = 5;
        add(lblPassword, gbc_lblPassword);

        passwordField = new JPasswordField();
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.anchor = GridBagConstraints.NORTH;
        gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField.gridwidth = 2;
        gbc_passwordField.gridx = 2;
        gbc_passwordField.gridy = 5;
        add(passwordField, gbc_passwordField);

        JButton btnRegister = new JButton("Register");
        GridBagConstraints gbc_btnRegister = new GridBagConstraints();
        gbc_btnRegister.anchor = GridBagConstraints.NORTH;
        gbc_btnRegister.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnRegister.insets = new Insets(0, 0, 5, 5);
        gbc_btnRegister.gridwidth = 2;
        gbc_btnRegister.gridx = 1;
        gbc_btnRegister.gridy = 5;
        add(btnRegister, gbc_btnRegister);

        JButton btnLogin = new JButton("Login");
        GridBagConstraints gbc_btnLogin = new GridBagConstraints();
        gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
        gbc_btnLogin.anchor = GridBagConstraints.NORTH;
        gbc_btnLogin.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnLogin.gridx = 3;
        gbc_btnLogin.gridy = 6;
        add(btnLogin, gbc_btnLogin);

        btnRegister.addActionListener(new ActionListener() {
            /**
             * starts registration process
             */
            public void actionPerformed(ActionEvent e) {
                
                containedIn.showUNameCheck();
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            /**
             * Log the user in with appropriate view
             */
            public void actionPerformed(ActionEvent e) {
            	//If user is non-staff
            	if(checkLogin(userNameField.getText(),passwordField.getText())==1) {
            		clearFields();
                    MainFrame.showUserView(userNameField.getText(),passwordField.getText());
            	}
            	//If user is staff
            	else if(checkLogin(userNameField.getText(),passwordField.getText())==2) {
            		clearFields();
            		//TODO: transition to staff stuff
            	}
            }
        });

    }

    public void clearFields() {
        userNameField.setText("");
        passwordField.setText("");

    }
    
    /*Checks login info, returns an int based on following:
     * 0 -> invalid login info
     * 1 -> valid non-staff user
     * 2 -> valid staff user
    */
    public int checkLogin(String username,String password){
    	int ret = 0;
    	DBdriver db = new DBdriver();
    	//TODO: Put correct query
    	String query1 = String.format("SELECT COUNT(*) FROM NON_STAFF_USER WHERE username=\"%s\" AND password=\"%s\"",username,password);
    	String query2 = String.format("SELECT COUNT(*) FROM STAFF WHERE staff_username=\"%s\" AND staff_password=\"%s\"",username,password);
    	ResultSet result1 = db.sendQuery(query1);
    	ResultSet result2 = db.sendQuery(query2);
    	try {
			if(result1.next()) {
				try {
					if(result1.getInt(1)==1) {
						ret = 1;
					}
					else if(result2.getInt(1)==1){
						ret = 2;
					}
				}
				catch (Exception e) {
					
				}
			}
			else {
				JOptionPane.showMessageDialog(this,"Username/password combination is invalid, try again.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	db.closeConnection();
    	return ret;
    }

}
