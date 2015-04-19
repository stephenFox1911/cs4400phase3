package TaskViews;

import javax.swing.JPanel;

import DBdriver.DBdriver;
import UserView.UserView;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DamagedLostBook extends JPanel {
    UserView containedIn;
    private JTextField textISBN;
    private JTextField txtCurrenttime;
    private JTextField txtLastuser;
    private JTextField txtChargeammount;
    private String penaltyUsername;
    private JTextField txtCopynumber;
    /**
     * Create the panel.
     */
    public DamagedLostBook(UserView in) {
        containedIn = in;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{5, 0, 0, 129, 31, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
        
        JLabel lblCopyNumber = new JLabel("Copy Number:");
        GridBagConstraints gbc_lblCopyNumber = new GridBagConstraints();
        gbc_lblCopyNumber.anchor = GridBagConstraints.EAST;
        gbc_lblCopyNumber.insets = new Insets(0, 0, 5, 5);
        gbc_lblCopyNumber.gridx = 1;
        gbc_lblCopyNumber.gridy = 3;
        add(lblCopyNumber, gbc_lblCopyNumber);
        
        txtCopynumber = new JTextField();
        GridBagConstraints gbc_txtCopynumber = new GridBagConstraints();
        gbc_txtCopynumber.gridwidth = 2;
        gbc_txtCopynumber.insets = new Insets(0, 0, 5, 5);
        gbc_txtCopynumber.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCopynumber.gridx = 2;
        gbc_txtCopynumber.gridy = 3;
        add(txtCopynumber, gbc_txtCopynumber);
        txtCopynumber.setColumns(10);
        
        JLabel lblCurrentTime = new JLabel("Current Time:");
        GridBagConstraints gbc_lblCurrentTime = new GridBagConstraints();
        gbc_lblCurrentTime.anchor = GridBagConstraints.EAST;
        gbc_lblCurrentTime.insets = new Insets(0, 0, 5, 5);
        gbc_lblCurrentTime.gridx = 1;
        gbc_lblCurrentTime.gridy = 4;
        add(lblCurrentTime, gbc_lblCurrentTime);
        
        txtCurrenttime = new JTextField();
        txtCurrenttime.setEditable(false);
        GridBagConstraints gbc_txtCurrenttime = new GridBagConstraints();
        gbc_txtCurrenttime.gridwidth = 3;
        gbc_txtCurrenttime.insets = new Insets(0, 0, 5, 5);
        gbc_txtCurrenttime.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCurrenttime.gridx = 2;
        gbc_txtCurrenttime.gridy = 4;
        add(txtCurrenttime, gbc_txtCurrenttime);
        txtCurrenttime.setColumns(10);
        
        JButton btnLookForLastUser = new JButton("Look For Last User");
        GridBagConstraints gbc_btnLookForLastUser = new GridBagConstraints();
        gbc_btnLookForLastUser.gridwidth = 4;
        gbc_btnLookForLastUser.insets = new Insets(0, 0, 5, 5);
        gbc_btnLookForLastUser.gridx = 1;
        gbc_btnLookForLastUser.gridy = 5;
        add(btnLookForLastUser, gbc_btnLookForLastUser);
        
        JLabel lblLastUser = new JLabel("Last User:");
        GridBagConstraints gbc_lblLastUser = new GridBagConstraints();
        gbc_lblLastUser.anchor = GridBagConstraints.EAST;
        gbc_lblLastUser.insets = new Insets(0, 0, 5, 5);
        gbc_lblLastUser.gridx = 1;
        gbc_lblLastUser.gridy = 6;
        add(lblLastUser, gbc_lblLastUser);
        
        txtLastuser = new JTextField();
        txtLastuser.setEditable(false);
        GridBagConstraints gbc_txtLastuser = new GridBagConstraints();
        gbc_txtLastuser.gridwidth = 3;
        gbc_txtLastuser.insets = new Insets(0, 0, 5, 5);
        gbc_txtLastuser.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtLastuser.gridx = 2;
        gbc_txtLastuser.gridy = 6;
        add(txtLastuser, gbc_txtLastuser);
        txtLastuser.setColumns(10);
        
        JLabel lblAmmountToCharge = new JLabel("Ammount to Charge:");
        GridBagConstraints gbc_lblAmmountToCharge = new GridBagConstraints();
        gbc_lblAmmountToCharge.anchor = GridBagConstraints.EAST;
        gbc_lblAmmountToCharge.insets = new Insets(0, 0, 5, 5);
        gbc_lblAmmountToCharge.gridx = 1;
        gbc_lblAmmountToCharge.gridy = 7;
        add(lblAmmountToCharge, gbc_lblAmmountToCharge);
        
        txtChargeammount = new JTextField();
        GridBagConstraints gbc_txtChargeammount = new GridBagConstraints();
        gbc_txtChargeammount.gridwidth = 3;
        gbc_txtChargeammount.insets = new Insets(0, 0, 5, 5);
        gbc_txtChargeammount.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtChargeammount.gridx = 2;
        gbc_txtChargeammount.gridy = 7;
        add(txtChargeammount, gbc_txtChargeammount);
        txtChargeammount.setColumns(10);
        
        JButton btnSubmit = new JButton("Submit");
        GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
        gbc_btnSubmit.anchor = GridBagConstraints.EAST;
        gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
        gbc_btnSubmit.gridx = 3;
        gbc_btnSubmit.gridy = 8;
        add(btnSubmit, gbc_btnSubmit);
        
        JButton btnBack = new JButton("Back");
        GridBagConstraints gbc_btnBack = new GridBagConstraints();
        gbc_btnBack.insets = new Insets(0, 0, 0, 5);
        gbc_btnBack.gridx = 4;
        gbc_btnBack.gridy = 8;
        add(btnBack, gbc_btnBack);
        
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	assessPenalty(penaltyUsername,Float.parseFloat(txtChargeammount.getText()),textISBN.getText(),"temp");
            	containedIn.showBookSearch();
            }
        });
        
        btnLookForLastUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	penaltyUsername = getPreviousUser(textISBN.getText(),"2");
            }
        });
        
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	containedIn.showReturns();
            }
        });
        
            
            
    }
    
    public String getPreviousUser(String isbn,String copyNo) {
    	String query = String.format("SELECT username,fname,lname FROM (SELECT NON_STAFF_USER.username AS username, NON_STAFF_USER.fname AS fname, NON_STAFF_USER.lname AS lname, ISSUE.est_return_date AS est_return_date FROM NON_STAFF_USER INNER JOIN ISSUE ON NON_STAFF_USER.username=ISSUE.co_username WHERE ISSUE.co_book_isbn=\"%s\" AND ISSUE.co_bcopy_no=\"%s\")  AND est_return_date=(SELECT MIN(est_return_date) FROM ISSUE)) AS S",isbn,copyNo);
    	DBdriver db = new DBdriver();
    	ResultSet result = db.sendQuery(query);
    	try {
			result.next();
			txtLastuser.setText(result.getString("fname")+" "+result.getString("lname"));
			return result.getString("username");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	db.closeConnection();
    	return "";
    	
    }
    
    public void assessPenalty(String username,float penalty,String isbn,String copyNo) {
    	String query = String.format("UPDATE NON_STAFF_USER SET total_penalties = total_penalties+%f WHERE username=\"%s\"",penalty,username);
    	DBdriver db = new DBdriver();
    	db.sendUpdate(query);
    	db.sendUpdate("UPDATE NON_STAFF_USER SET is_debarred=TRUE WHERE total_penalties >= 100");
    	db.sendUpdate(String.format("UPDATE COPY SET is_damaged=TRUE WHERE book_isbn=\"%s\" AND copy_number=\"%s\"",isbn,copyNo));
    	db.closeConnection();
    }

}
