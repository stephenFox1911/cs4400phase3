package TaskViews;

import javax.swing.JPanel;

import UserView.UserView;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DamagedLostBook extends JPanel {
    UserView containedIn;
    private JTextField textISBN;
    private JTextField txtCurrenttime;
    private JTextField txtLastuser;
    private JTextField txtChargeammount;
    /**
     * Create the panel.
     */
    public DamagedLostBook(UserView in) {
        containedIn = in;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{5, 0, 0, 129, 31, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblLostdamagedBook = new JLabel("Lost/Damaged Book");
        GridBagConstraints gbc_lblLostdamagedBook = new GridBagConstraints();
        gbc_lblLostdamagedBook.gridwidth = 4;
        gbc_lblLostdamagedBook.insets = new Insets(0, 0, 5, 5);
        gbc_lblLostdamagedBook.gridx = 1;
        gbc_lblLostdamagedBook.gridy = 1;
        add(lblLostdamagedBook, gbc_lblLostdamagedBook);
        
        JLabel lblIsbn = new JLabel("ISBN:");
        GridBagConstraints gbc_lblIsbn = new GridBagConstraints();
        gbc_lblIsbn.insets = new Insets(0, 0, 5, 5);
        gbc_lblIsbn.anchor = GridBagConstraints.EAST;
        gbc_lblIsbn.gridx = 1;
        gbc_lblIsbn.gridy = 2;
        add(lblIsbn, gbc_lblIsbn);
        
        textISBN = new JTextField();
        GridBagConstraints gbc_textISBN = new GridBagConstraints();
        gbc_textISBN.gridwidth = 3;
        gbc_textISBN.insets = new Insets(0, 0, 5, 5);
        gbc_textISBN.fill = GridBagConstraints.HORIZONTAL;
        gbc_textISBN.gridx = 2;
        gbc_textISBN.gridy = 2;
        add(textISBN, gbc_textISBN);
        textISBN.setColumns(10);
        
        JLabel lblCurrentTime = new JLabel("Current Time:");
        GridBagConstraints gbc_lblCurrentTime = new GridBagConstraints();
        gbc_lblCurrentTime.anchor = GridBagConstraints.EAST;
        gbc_lblCurrentTime.insets = new Insets(0, 0, 5, 5);
        gbc_lblCurrentTime.gridx = 1;
        gbc_lblCurrentTime.gridy = 3;
        add(lblCurrentTime, gbc_lblCurrentTime);
        
        txtCurrenttime = new JTextField();
        txtCurrenttime.setEditable(false);
        GridBagConstraints gbc_txtCurrenttime = new GridBagConstraints();
        gbc_txtCurrenttime.gridwidth = 3;
        gbc_txtCurrenttime.insets = new Insets(0, 0, 5, 5);
        gbc_txtCurrenttime.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCurrenttime.gridx = 2;
        gbc_txtCurrenttime.gridy = 3;
        add(txtCurrenttime, gbc_txtCurrenttime);
        txtCurrenttime.setColumns(10);
        
        JButton btnLookForLastUser = new JButton("Look For Last User");
        GridBagConstraints gbc_btnLookForLastUser = new GridBagConstraints();
        gbc_btnLookForLastUser.gridwidth = 4;
        gbc_btnLookForLastUser.insets = new Insets(0, 0, 5, 5);
        gbc_btnLookForLastUser.gridx = 1;
        gbc_btnLookForLastUser.gridy = 4;
        add(btnLookForLastUser, gbc_btnLookForLastUser);
        
        JLabel lblLastUser = new JLabel("Last User:");
        GridBagConstraints gbc_lblLastUser = new GridBagConstraints();
        gbc_lblLastUser.anchor = GridBagConstraints.EAST;
        gbc_lblLastUser.insets = new Insets(0, 0, 5, 5);
        gbc_lblLastUser.gridx = 1;
        gbc_lblLastUser.gridy = 5;
        add(lblLastUser, gbc_lblLastUser);
        
        txtLastuser = new JTextField();
        txtLastuser.setEditable(false);
        GridBagConstraints gbc_txtLastuser = new GridBagConstraints();
        gbc_txtLastuser.gridwidth = 3;
        gbc_txtLastuser.insets = new Insets(0, 0, 5, 5);
        gbc_txtLastuser.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtLastuser.gridx = 2;
        gbc_txtLastuser.gridy = 5;
        add(txtLastuser, gbc_txtLastuser);
        txtLastuser.setColumns(10);
        
        JLabel lblAmmountToCharge = new JLabel("Ammount to Charge:");
        GridBagConstraints gbc_lblAmmountToCharge = new GridBagConstraints();
        gbc_lblAmmountToCharge.anchor = GridBagConstraints.EAST;
        gbc_lblAmmountToCharge.insets = new Insets(0, 0, 5, 5);
        gbc_lblAmmountToCharge.gridx = 1;
        gbc_lblAmmountToCharge.gridy = 6;
        add(lblAmmountToCharge, gbc_lblAmmountToCharge);
        
        txtChargeammount = new JTextField();
        GridBagConstraints gbc_txtChargeammount = new GridBagConstraints();
        gbc_txtChargeammount.gridwidth = 3;
        gbc_txtChargeammount.insets = new Insets(0, 0, 5, 5);
        gbc_txtChargeammount.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtChargeammount.gridx = 2;
        gbc_txtChargeammount.gridy = 6;
        add(txtChargeammount, gbc_txtChargeammount);
        txtChargeammount.setColumns(10);
        
        JButton btnSubmit = new JButton("Submit");
        GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
        gbc_btnSubmit.anchor = GridBagConstraints.EAST;
        gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
        gbc_btnSubmit.gridx = 3;
        gbc_btnSubmit.gridy = 7;
        add(btnSubmit, gbc_btnSubmit);
        
        JButton btnBack = new JButton("Back");
        GridBagConstraints gbc_btnBack = new GridBagConstraints();
        gbc_btnBack.insets = new Insets(0, 0, 0, 5);
        gbc_btnBack.gridx = 4;
        gbc_btnBack.gridy = 7;
        add(btnBack, gbc_btnBack);
        
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                in.showReturns();
            }
        });
        
            
            
    }

}
