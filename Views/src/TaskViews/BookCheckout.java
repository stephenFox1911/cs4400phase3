package TaskViews;

import javax.swing.JPanel;

import DBdriver.DBdriver;
import UserView.UserView;

import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class BookCheckout extends JPanel {
    UserView containedIn;
    private JTextField textIssueID;
    private JTextField textISBN;
    private JTextField textCheckoutDate;
    private JTextField textUsername;
    private JTextField textCopyno;
    private JTextField txtEstReturnDate;
    private String currentInfoFor;
    BookCheckout thisItem = this;
    /**
     * Create the panel.
     */
    public BookCheckout(UserView in) {
    	
    	currentInfoFor = "";
    	
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{5, 53, 100, 5, 76, 0, 50, 50, 5, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblBookCheckout = new JLabel("Book Checkout");
        GridBagConstraints gbc_lblBookCheckout = new GridBagConstraints();
        gbc_lblBookCheckout.gridwidth = 7;
        gbc_lblBookCheckout.insets = new Insets(0, 0, 5, 5);
        gbc_lblBookCheckout.gridx = 1;
        gbc_lblBookCheckout.gridy = 1;
        add(lblBookCheckout, gbc_lblBookCheckout);
        
        JLabel lblIssueId = new JLabel("Issue Id:");
        GridBagConstraints gbc_lblIssueId = new GridBagConstraints();
        gbc_lblIssueId.anchor = GridBagConstraints.EAST;
        gbc_lblIssueId.insets = new Insets(0, 0, 5, 5);
        gbc_lblIssueId.gridx = 1;
        gbc_lblIssueId.gridy = 2;
        add(lblIssueId, gbc_lblIssueId);
        
        textIssueID = new JTextField();
        GridBagConstraints gbc_textIssueID = new GridBagConstraints();
        gbc_textIssueID.insets = new Insets(0, 0, 5, 5);
        gbc_textIssueID.fill = GridBagConstraints.HORIZONTAL;
        gbc_textIssueID.gridx = 2;
        gbc_textIssueID.gridy = 2;
        add(textIssueID, gbc_textIssueID);
        textIssueID.setColumns(10);
        
        JButton btnFindHold = new JButton("Find Hold");
        GridBagConstraints gbc_btnFindHold = new GridBagConstraints();
        gbc_btnFindHold.gridwidth = 2;
        gbc_btnFindHold.insets = new Insets(0, 0, 5, 5);
        gbc_btnFindHold.gridx = 3;
        gbc_btnFindHold.gridy = 2;
        add(btnFindHold, gbc_btnFindHold);
        
        JLabel lblUserName = new JLabel("User Name:");
        GridBagConstraints gbc_lblUserName = new GridBagConstraints();
        gbc_lblUserName.anchor = GridBagConstraints.EAST;
        gbc_lblUserName.insets = new Insets(0, 0, 5, 5);
        gbc_lblUserName.gridx = 5;
        gbc_lblUserName.gridy = 2;
        add(lblUserName, gbc_lblUserName);
        
        textUsername = new JTextField();
        textUsername.setEditable(false);
        GridBagConstraints gbc_txtUsername = new GridBagConstraints();
        gbc_txtUsername.gridwidth = 2;
        gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
        gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtUsername.gridx = 6;
        gbc_txtUsername.gridy = 2;
        add(textUsername, gbc_txtUsername);
        textUsername.setColumns(10);
        
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
        
        JLabel lblCopy = new JLabel("Copy #:");
        GridBagConstraints gbc_lblCopy = new GridBagConstraints();
        gbc_lblCopy.anchor = GridBagConstraints.EAST;
        gbc_lblCopy.insets = new Insets(0, 0, 5, 5);
        gbc_lblCopy.gridx = 5;
        gbc_lblCopy.gridy = 3;
        add(lblCopy, gbc_lblCopy);
        
        textCopyno = new JTextField();
        textCopyno.setEditable(false);
        GridBagConstraints gbc_txtCopyno = new GridBagConstraints();
        gbc_txtCopyno.gridwidth = 2;
        gbc_txtCopyno.insets = new Insets(0, 0, 5, 5);
        gbc_txtCopyno.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCopyno.gridx = 6;
        gbc_txtCopyno.gridy = 3;
        add(textCopyno, gbc_txtCopyno);
        textCopyno.setColumns(10);
        
        JLabel lblCheckoutDate = new JLabel("Checkout date:");
        GridBagConstraints gbc_lblCheckoutDate = new GridBagConstraints();
        gbc_lblCheckoutDate.anchor = GridBagConstraints.EAST;
        gbc_lblCheckoutDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblCheckoutDate.gridx = 1;
        gbc_lblCheckoutDate.gridy = 4;
        add(lblCheckoutDate, gbc_lblCheckoutDate);
        
        textCheckoutDate = new JTextField();
        textCheckoutDate.setEditable(false);
        GridBagConstraints gbc_textCheckoutDate = new GridBagConstraints();
        gbc_textCheckoutDate.insets = new Insets(0, 0, 5, 5);
        gbc_textCheckoutDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_textCheckoutDate.gridx = 2;
        gbc_textCheckoutDate.gridy = 4;
        add(textCheckoutDate, gbc_textCheckoutDate);
        textCheckoutDate.setColumns(10);
        
        JLabel lblEstimatedReturnDate = new JLabel("Estimated Return Date:");
        GridBagConstraints gbc_lblEstimatedReturnDate = new GridBagConstraints();
        gbc_lblEstimatedReturnDate.gridwidth = 2;
        gbc_lblEstimatedReturnDate.anchor = GridBagConstraints.EAST;
        gbc_lblEstimatedReturnDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblEstimatedReturnDate.gridx = 4;
        gbc_lblEstimatedReturnDate.gridy = 4;
        add(lblEstimatedReturnDate, gbc_lblEstimatedReturnDate);
        
        txtEstReturnDate = new JTextField();
        txtEstReturnDate.setEditable(false);
        GridBagConstraints gbc_txtEstreturndate = new GridBagConstraints();
        gbc_txtEstreturndate.gridwidth = 2;
        gbc_txtEstreturndate.insets = new Insets(0, 0, 5, 5);
        gbc_txtEstreturndate.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtEstreturndate.gridx = 6;
        gbc_txtEstreturndate.gridy = 4;
        add(txtEstReturnDate, gbc_txtEstreturndate);
        txtEstReturnDate.setColumns(10);
        
        JButton btnBack = new JButton("Back");
        GridBagConstraints gbc_btnBack = new GridBagConstraints();
        gbc_btnBack.insets = new Insets(0, 0, 0, 5);
        gbc_btnBack.gridx = 6;
        gbc_btnBack.gridy = 5;
        add(btnBack, gbc_btnBack);
        
        JButton btnConfirm = new JButton("Confirm");
        GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
        gbc_btnConfirm.insets = new Insets(0, 0, 0, 5);
        gbc_btnConfirm.gridx = 7;
        gbc_btnConfirm.gridy = 5;
        add(btnConfirm, gbc_btnConfirm);
        containedIn = in;
        
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                containedIn.showBookSearch();
                thisItem.clearFields();
            }
        });
        
        btnConfirm.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		if (textISBN.getText().length() == 0){
        			JOptionPane.showMessageDialog(null, "Please Check if a hold exsists.", "Did not check." , JOptionPane.INFORMATION_MESSAGE);
        		} else {
        			System.out.println('1');
        			String querry1 = "DELETE FROM ISSUE WHERE issue_id = %s AND co_book_isbn = %s;";
        			System.out.println('2');
        			String querry2 = "INSERT INTO ISSUE (est_return_date, date_created, co_username, co_bcopy_no, co_book_isbn) "
        					+ "VALUES (DATE_ADD(CURDATE(), INTERVAL 14 day), CURDATE(), '%s', %s, %s);" ;
        			System.out.println('3');
        			String querry3 = "UPDATE COPY SET is_checked_out = TRUE, is_on_hold = 0 WHERE copy_number = %s AND book_isbn = %s;";

        			DBdriver db = new DBdriver();
        			
        			try { 
       				if( db.sendUpdate(String.format(querry1, currentInfoFor, textISBN.getText())) == 1){
       					
       					db.sendUpdate(String.format(querry2 , textUsername.getText(), textCopyno.getText(), textISBN.getText()));
       					db.sendUpdate(String.format(querry3,textCopyno.getText(),textISBN.getText()));
       					
       					
        				System.out.println(String.format(querry1, currentInfoFor, textISBN.getText()));
        				
        				System.out.println(String.format(querry2, textUsername.getText(),
        							textCopyno.getText(), textISBN.getText()));
        				System.out.println(String.format(querry3, textCopyno.getText(),textISBN.getText()));
        				
        				ResultSet newID = db.sendQuery(String.format("SELECT issue_id FROM ISSUE WHERE co_username = '%s' "
        						+ "AND  co_book_isbn = %s AND co_bcopy_no = %s;", textUsername.getText()
        						, textISBN.getText(), textCopyno.getText()));
        				newID.next();
        				JOptionPane.showMessageDialog(null, "Book Checked out with new issueID: " + newID.getString(1), "Book Checked Out." , JOptionPane.INFORMATION_MESSAGE);
        					
      				} else {
       					JOptionPane.showMessageDialog(null, "Hold not droped.", "Hold not droped." , JOptionPane.INFORMATION_MESSAGE);
      				}
       				
        				
        			} catch (Exception e) {
        				e.printStackTrace();
        			}
        			
        			db.closeConnection();
        			containedIn.showBookSearch();
        			thisItem.clearFields();
        			
        		}
        		
        	}
        });
        
        btnFindHold.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		String querry1 = "SELECT co_username, co_bcopy_no, co_book_isbn "
        				+ "FROM ISSUE WHERE issue_id = %s AND (DATEDIFF(est_return_date, date_created)) = 17;";
        		String query2 =  "SELECT DATEDIFF(CURDATE(), date_created) <=3 FROM ISSUE WHERE issue_id = %s;";
        		System.out.println(querry1);
        		DBdriver db = new DBdriver();
        		ResultSet test = db.sendQuery(String.format(query2, textIssueID.getText()));
        		
        		ResultSet hold = db.sendQuery(String.format(querry1, textIssueID.getText(), textIssueID.getText()));
        		
        		try {
        			if (hold.next()){
        				test.next();
        				if (test.getBoolean(1)){
        					textUsername.setText(hold.getString(1));
        					textCopyno.setText(hold.getString(2));
        					textISBN.setText(hold.getString(3));
        					currentInfoFor = textIssueID.getText();
        				} else {
        					db.sendUpdate(String.format("DELETE FROM ISSUE WHERE issue_id = %s", textIssueID.getText()));
        					JOptionPane.showMessageDialog(null, "Your hold was droped because book was not picked up withing 3 days of hold.", "Hold droped." , JOptionPane.INFORMATION_MESSAGE);
        				}
        				
        				
        				
        			} else {
        				JOptionPane.showMessageDialog(null, "Hold with that issue id does not exsist.", "Hold doesn't exsist" , JOptionPane.INFORMATION_MESSAGE);
        			}
        			
        			
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
        		
        		db.closeConnection();
        	}
        });

    }
    
    public void clearFields(){
    	textIssueID.setText("");
    	textISBN.setText("");
    	textCheckoutDate.setText("");
    	textUsername.setText("");
    	textCopyno.setText("");
    	txtEstReturnDate.setText("");
    }
    
    public void setDates(String today, String estReturn){
    	textCheckoutDate.setText(today);
    	txtEstReturnDate.setText(estReturn);
    	
    }
    
   

}
