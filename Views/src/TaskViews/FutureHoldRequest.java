package TaskViews;

import javax.swing.JPanel;

import DBdriver.DBdriver;
import UserView.UserView;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FutureHoldRequest extends JPanel {
    private UserView containedIn;
    private JTextField txtIsbn;
    private JTextField txtCopynumber;
    private JTextField txtExpectedavailabledate;
    /**
     * Create the panel.
     */
    public FutureHoldRequest(UserView in) {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{5, 0, 0, 161, 102, 13, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblFutureHoldRequest = new JLabel("Future Hold Request");
        GridBagConstraints gbc_lblFutureHoldRequest = new GridBagConstraints();
        gbc_lblFutureHoldRequest.gridwidth = 3;
        gbc_lblFutureHoldRequest.insets = new Insets(0, 0, 5, 5);
        gbc_lblFutureHoldRequest.gridx = 1;
        gbc_lblFutureHoldRequest.gridy = 1;
        add(lblFutureHoldRequest, gbc_lblFutureHoldRequest);
        
        JLabel lblISBN = new JLabel("ISBN: ");
        GridBagConstraints gbc_lblISBN = new GridBagConstraints();
        gbc_lblISBN.anchor = GridBagConstraints.EAST;
        gbc_lblISBN.insets = new Insets(0, 0, 5, 5);
        gbc_lblISBN.gridx = 1;
        gbc_lblISBN.gridy = 2;
        add(lblISBN, gbc_lblISBN);
        
        txtIsbn = new JTextField();
        GridBagConstraints gbc_txtIsbn = new GridBagConstraints();
        gbc_txtIsbn.gridwidth = 2;
        gbc_txtIsbn.insets = new Insets(0, 0, 5, 5);
        gbc_txtIsbn.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtIsbn.gridx = 2;
        gbc_txtIsbn.gridy = 2;
        add(txtIsbn, gbc_txtIsbn);
        txtIsbn.setColumns(10);
        
        JButton btnRequest = new JButton("Request");
        GridBagConstraints gbc_btnRequest = new GridBagConstraints();
        gbc_btnRequest.insets = new Insets(0, 0, 5, 5);
        gbc_btnRequest.gridx = 4;
        gbc_btnRequest.gridy = 2;
        add(btnRequest, gbc_btnRequest);
        
        JLabel lblCopyNumber = new JLabel("Copy Number: ");
        GridBagConstraints gbc_lblCopyNumber = new GridBagConstraints();
        gbc_lblCopyNumber.anchor = GridBagConstraints.EAST;
        gbc_lblCopyNumber.insets = new Insets(0, 0, 5, 5);
        gbc_lblCopyNumber.gridx = 2;
        gbc_lblCopyNumber.gridy = 4;
        add(lblCopyNumber, gbc_lblCopyNumber);
        
        txtCopynumber = new JTextField();
        txtCopynumber.setEditable(false);
        GridBagConstraints gbc_txtCopynumber = new GridBagConstraints();
        gbc_txtCopynumber.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCopynumber.insets = new Insets(0, 0, 5, 5);
        gbc_txtCopynumber.gridx = 3;
        gbc_txtCopynumber.gridy = 4;
        add(txtCopynumber, gbc_txtCopynumber);
        txtCopynumber.setColumns(10);
        
        JLabel lblExpectedAvailableDate = new JLabel("Expected Available Date: ");
        GridBagConstraints gbc_lblExpectedAvailableDate = new GridBagConstraints();
        gbc_lblExpectedAvailableDate.anchor = GridBagConstraints.EAST;
        gbc_lblExpectedAvailableDate.gridwidth = 2;
        gbc_lblExpectedAvailableDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblExpectedAvailableDate.gridx = 1;
        gbc_lblExpectedAvailableDate.gridy = 5;
        add(lblExpectedAvailableDate, gbc_lblExpectedAvailableDate);
        
        txtExpectedavailabledate = new JTextField();
        txtExpectedavailabledate.setEditable(false);
        GridBagConstraints gbc_txtExpectedavailabledate = new GridBagConstraints();
        gbc_txtExpectedavailabledate.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtExpectedavailabledate.insets = new Insets(0, 0, 5, 5);
        gbc_txtExpectedavailabledate.gridx = 3;
        gbc_txtExpectedavailabledate.gridy = 5;
        add(txtExpectedavailabledate, gbc_txtExpectedavailabledate);
        txtExpectedavailabledate.setColumns(10);
        
        JButton btnOk = new JButton("Ok");

        GridBagConstraints gbc_btnOk = new GridBagConstraints();
        gbc_btnOk.anchor = GridBagConstraints.EAST;
        gbc_btnOk.insets = new Insets(0, 0, 0, 5);
        gbc_btnOk.gridx = 3;
        gbc_btnOk.gridy = 6;
        add(btnOk, gbc_btnOk);
        
        JButton btnBack = new JButton("Back");

        GridBagConstraints gbc_btnBack = new GridBagConstraints();
        gbc_btnBack.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnBack.insets = new Insets(0, 0, 0, 5);
        gbc_btnBack.gridx = 4;
        gbc_btnBack.gridy = 6;
        add(btnBack, gbc_btnBack);
        containedIn = in;
        
        
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	containedIn.showBookSearch();
            }
        });
        
        btnRequest.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		getNextAvailCopy(txtIsbn.getText());
        		JOptionPane.showMessageDialog(null,"Press \"Ok\" to place your future hold request.");
        	}
        });
        
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	placeFutureHoldReq();
            	JOptionPane.showMessageDialog(null,"Your future hold request has been placed!");
            }
        });
    }
    
    public void getNextAvailCopy(String isbn) {
    	String query = String.format("SELECT MAX(ISSUE.est_return_date), ISSUE.co_bcopy_no FROM ISSUE INNER JOIN COPY ON ISSUE.co_book_isbn=COPY.book_isbn AND ISSUE.co_bcopy_no=COPY.copy_number WHERE COPY.future_requester IS NULL AND COPY.book_isbn=\"%s\" AND COPY.is_damaged=FALSE",isbn);
    	DBdriver db = new DBdriver();
    	ResultSet result = db.sendQuery(query);
    	try {
			if (result.next()) {
				 txtCopynumber.setText(result.getString(2));
				 txtExpectedavailabledate.setText(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	db.closeConnection();
    }
    
    public void placeFutureHoldReq() {
    	String query = String.format("UPDATE COPY  SET future_requester=\"%s\" WHERE book_isbn=\"%s\" AND copy_number=\"%s\"",containedIn.getCurrentUser(),txtIsbn.getText(),txtCopynumber.getText());
    	DBdriver db = new DBdriver();
    	db.sendUpdate(query);
    }

}
