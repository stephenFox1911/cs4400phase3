package TaskViews;

import javax.swing.JPanel;

import DBdriver.DBdriver;
import UserView.UserView;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReturnBook extends JPanel {
    UserView containedIn;
    private JTextField textIssueID;
    private JTextField textISBN;
    private JTextField textField;
    private JTextField txtUserName;
    private Choice choice;
    /**
     * Create the panel.
     */
    public ReturnBook(UserView in) {
        containedIn = in;
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{5, 0, 100, 0, 0, 100, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblReturnBook = new JLabel("Return Book");
        GridBagConstraints gbc_lblReturnBook = new GridBagConstraints();
        gbc_lblReturnBook.gridwidth = 5;
        gbc_lblReturnBook.insets = new Insets(0, 0, 5, 5);
        gbc_lblReturnBook.gridx = 1;
        gbc_lblReturnBook.gridy = 1;
        add(lblReturnBook, gbc_lblReturnBook);
        
        JLabel lblIssueid = new JLabel("IssueId:");
        GridBagConstraints gbc_lblIssueid = new GridBagConstraints();
        gbc_lblIssueid.anchor = GridBagConstraints.EAST;
        gbc_lblIssueid.insets = new Insets(0, 0, 5, 5);
        gbc_lblIssueid.gridx = 1;
        gbc_lblIssueid.gridy = 2;
        add(lblIssueid, gbc_lblIssueid);
        
        textIssueID = new JTextField();
        GridBagConstraints gbc_textIssueID = new GridBagConstraints();
        gbc_textIssueID.insets = new Insets(0, 0, 5, 5);
        gbc_textIssueID.fill = GridBagConstraints.HORIZONTAL;
        gbc_textIssueID.gridx = 2;
        gbc_textIssueID.gridy = 2;
        add(textIssueID, gbc_textIssueID);
        textIssueID.setColumns(10);
        
        JLabel lblCopy = new JLabel("Copy #:");
        GridBagConstraints gbc_lblCopy = new GridBagConstraints();
        gbc_lblCopy.anchor = GridBagConstraints.EAST;
        gbc_lblCopy.insets = new Insets(0, 0, 5, 5);
        gbc_lblCopy.gridx = 4;
        gbc_lblCopy.gridy = 2;
        add(lblCopy, gbc_lblCopy);
        
        textField = new JTextField();
        textField.setEditable(false);
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 5;
        gbc_textField.gridy = 2;
        add(textField, gbc_textField);
        textField.setColumns(10);
        
        JLabel lblIsbn = new JLabel("ISBN:");
        GridBagConstraints gbc_lblIsbn = new GridBagConstraints();
        gbc_lblIsbn.anchor = GridBagConstraints.EAST;
        gbc_lblIsbn.insets = new Insets(0, 0, 5, 5);
        gbc_lblIsbn.gridx = 1;
        gbc_lblIsbn.gridy = 3;
        add(lblIsbn, gbc_lblIsbn);
        
        textISBN = new JTextField();
        textISBN.setEditable(false);
        GridBagConstraints gbc_textISBN = new GridBagConstraints();
        gbc_textISBN.insets = new Insets(0, 0, 5, 5);
        gbc_textISBN.fill = GridBagConstraints.HORIZONTAL;
        gbc_textISBN.gridx = 2;
        gbc_textISBN.gridy = 3;
        add(textISBN, gbc_textISBN);
        textISBN.setColumns(10);
        
        JLabel lblUserName = new JLabel("User Name:");
        GridBagConstraints gbc_lblUserName = new GridBagConstraints();
        gbc_lblUserName.anchor = GridBagConstraints.EAST;
        gbc_lblUserName.insets = new Insets(0, 0, 5, 5);
        gbc_lblUserName.gridx = 4;
        gbc_lblUserName.gridy = 3;
        add(lblUserName, gbc_lblUserName);
        
        txtUserName = new JTextField();
        txtUserName.setEditable(false);
        GridBagConstraints gbc_txtUserName = new GridBagConstraints();
        gbc_txtUserName.insets = new Insets(0, 0, 5, 5);
        gbc_txtUserName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtUserName.gridx = 5;
        gbc_txtUserName.gridy = 3;
        add(txtUserName, gbc_txtUserName);
        txtUserName.setColumns(10);
        
        JLabel lblReturnedInDammeged = new JLabel("Returned in Dammeged Condition");
        lblReturnedInDammeged.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_lblReturnedInDammeged = new GridBagConstraints();
        gbc_lblReturnedInDammeged.gridwidth = 3;
        gbc_lblReturnedInDammeged.insets = new Insets(0, 0, 5, 5);
        gbc_lblReturnedInDammeged.gridx = 1;
        gbc_lblReturnedInDammeged.gridy = 4;
        add(lblReturnedInDammeged, gbc_lblReturnedInDammeged);
        
        //TODO: Choice is out of scope for action listener. Needs to be resolved
        choice = new Choice();
        choice.add("No");
        choice.add("Yes");
        GridBagConstraints gbc_choice = new GridBagConstraints();
        gbc_choice.fill = GridBagConstraints.HORIZONTAL;
        gbc_choice.insets = new Insets(0, 0, 5, 5);
        gbc_choice.gridx = 4;
        gbc_choice.gridy = 4;
        add(choice, gbc_choice);
        
        JButton btnBack = new JButton("Back");
        GridBagConstraints gbc_btnBack = new GridBagConstraints();
        gbc_btnBack.insets = new Insets(0, 0, 0, 5);
        gbc_btnBack.gridx = 4;
        gbc_btnBack.gridy = 5;
        add(btnBack, gbc_btnBack);
        
        JButton btnReturnBook = new JButton("Return Book");
        GridBagConstraints gbc_btnReturnBook = new GridBagConstraints();
        gbc_btnReturnBook.insets = new Insets(0, 0, 0, 5);
        gbc_btnReturnBook.gridx = 5;
        gbc_btnReturnBook.gridy = 5;
        add(btnReturnBook, gbc_btnReturnBook);
        
        
        
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	containedIn.showBookSearch();
            }
        });
        
        btnReturnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	returnBook(textIssueID.getText());
                if (choice.getSelectedItem().equals("Yes")){
                	containedIn.showDamageLost();
                } else {
                	containedIn.showBookSearch();
                }
            }
        });
        

    }
   
    public void returnBook(String issueID) {
    	//Get information about the checkout to populate the GUI fields
    	String query = String.format("SELECT co_username,co_book_isbn,co_bcopy_no,DATEDIFF(NOW(),est_return_date) AS days_overdue FROM ISSUE WHERE issue_id=\'%s\'",issueID);
    	DBdriver db = new DBdriver();
    	ResultSet result = db.sendQuery(query);
    	try {
    		result.next();
			this.txtUserName.setText(result.getString("co_username"));
			this.textISBN.setText(result.getString("co_book_isbn"));
			this.textField.setText(result.getString("co_bcopy_no"));
			int daysOverdue = result.getInt("days_overdue");
			
			//Assess penalties if needed
			if (daysOverdue>0) {
				String getBookCostQuery = String.format("SELECT cost FROM BOOK WHERE isbn=\"%s\"",textISBN.getText());
				ResultSet bookCostResult = db.sendQuery(getBookCostQuery);
				bookCostResult.next();
				float bookCost = bookCostResult.getInt("cost");
				String updatePenaltiesQuery = String.format("UPDATE NON_STAFF_USER SET total_penalties = total_penalties+%f WHERE username=\"%s\"",Math.min(bookCost*.5,daysOverdue*.5),txtUserName.getText());
				db.sendUpdate(updatePenaltiesQuery);
			}
			
			//Unflag copy as being checked out
			String unflagCopyQuery = String.format("UPDATE COPY SET is_checked_out = FALSE WHERE copy_number=\"%s\" AND book_isbn=\"%s\";",textField.getText(),textISBN.getText());
			db.sendUpdate(unflagCopyQuery);
			
			//Check for a future hold request on the book. If one exists, place the book on hold.
			String checkFutureHoldQuery = String.format("SELECT future_requester FROM COPY WHERE copy_number=\"%s\" AND book_isbn=\"%s\" AND future_requester IS NOT NULL",textField.getText(),textISBN.getText());
			ResultSet futureHoldResult = db.sendQuery(checkFutureHoldQuery);
		
			if (futureHoldResult.next()) {
				String checkForOtherHoldsQuery = String.format("SELECT COUNT(*)>0 FROM NON_STAFF_USER, ISSUE WHERE NON_STAFF_USER.username=ISSUE.co_username AND ISSUE.co_book_isbn=\"%s\"",textISBN.getText());
				ResultSet checkForOtherHoldsResult = db.sendQuery(checkForOtherHoldsQuery);
				
				//Create the hold, set future requester to null
				if (!checkForOtherHoldsResult.next()) {
					String createNewHoldQuery = String.format("INSERT INTO ISSUE (est_return_date, date_created, co_username, co_bcopy_no, co_book_isbn, extensioncount) VALUES (DATE_ADD(CURDATE(), INTERVAL 17 DAY), CURDATE(),\"%s\",\"%s\",\"%s\", 0)",txtUserName.getText(),textField.getText(),textISBN.getText());
					db.sendUpdate(createNewHoldQuery);
					String clearFutureRequesterQuery = String.format("UPDATE COPY SET future_requester = NULL WHERE copy_number=\"%s\" AND book_isbn=\"%s\"",textField.getText(),textISBN.getText());
					db.sendUpdate(clearFutureRequesterQuery);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	db.closeConnection();
    }

}