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
import javax.swing.border.BevelBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackBookLocation extends JPanel {
    private UserView containedIn;
    private JTextField txtIsbn;
    private JTextField txtFloornumber;
    private JTextField txtAislenumber;
    private JTextField txtShelfnumber;
    private JTextField txtSubject;
    /**
     * Create the panel.
     */
    public TrackBookLocation(UserView in) {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{5, 101, 84, 77, 131, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblTrackBookLocation = new JLabel("Track Book Location");
        GridBagConstraints gbc_lblTrackBookLocation = new GridBagConstraints();
        gbc_lblTrackBookLocation.gridwidth = 4;
        gbc_lblTrackBookLocation.insets = new Insets(0, 0, 5, 5);
        gbc_lblTrackBookLocation.gridx = 1;
        gbc_lblTrackBookLocation.gridy = 1;
        add(lblTrackBookLocation, gbc_lblTrackBookLocation);
        
        JLabel lblIsbn = new JLabel("ISBN: ");
        GridBagConstraints gbc_lblIsbn = new GridBagConstraints();
        gbc_lblIsbn.anchor = GridBagConstraints.EAST;
        gbc_lblIsbn.insets = new Insets(0, 0, 5, 5);
        gbc_lblIsbn.gridx = 1;
        gbc_lblIsbn.gridy = 2;
        add(lblIsbn, gbc_lblIsbn);
        
        txtIsbn = new JTextField();
        GridBagConstraints gbc_txtIsbn = new GridBagConstraints();
        gbc_txtIsbn.gridwidth = 2;
        gbc_txtIsbn.insets = new Insets(0, 0, 5, 5);
        gbc_txtIsbn.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtIsbn.gridx = 2;
        gbc_txtIsbn.gridy = 2;
        add(txtIsbn, gbc_txtIsbn);
        txtIsbn.setColumns(10);
        
        JButton btnLocate = new JButton("Locate");

        GridBagConstraints gbc_btnLocate = new GridBagConstraints();
        gbc_btnLocate.insets = new Insets(0, 0, 5, 5);
        gbc_btnLocate.gridx = 4;
        gbc_btnLocate.gridy = 2;
        add(btnLocate, gbc_btnLocate);
        
        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.gridwidth = 4;
        gbc_panel.insets = new Insets(0, 0, 5, 5);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 3;
        add(panel, gbc_panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        JLabel lblFloorNumber = new JLabel("Floor Number: ");
        GridBagConstraints gbc_lblFloorNumber = new GridBagConstraints();
        gbc_lblFloorNumber.insets = new Insets(0, 0, 5, 5);
        gbc_lblFloorNumber.anchor = GridBagConstraints.EAST;
        gbc_lblFloorNumber.gridx = 0;
        gbc_lblFloorNumber.gridy = 0;
        panel.add(lblFloorNumber, gbc_lblFloorNumber);
        
        txtFloornumber = new JTextField();
        txtFloornumber.setEditable(false);
        GridBagConstraints gbc_txtFloornumber = new GridBagConstraints();
        gbc_txtFloornumber.insets = new Insets(0, 0, 5, 0);
        gbc_txtFloornumber.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFloornumber.gridx = 1;
        gbc_txtFloornumber.gridy = 0;
        panel.add(txtFloornumber, gbc_txtFloornumber);
        txtFloornumber.setColumns(10);
        
        JLabel lblAisleNumber = new JLabel("Aisle Number:");
        GridBagConstraints gbc_lblAisleNumber = new GridBagConstraints();
        gbc_lblAisleNumber.anchor = GridBagConstraints.EAST;
        gbc_lblAisleNumber.insets = new Insets(0, 0, 5, 5);
        gbc_lblAisleNumber.gridx = 0;
        gbc_lblAisleNumber.gridy = 1;
        panel.add(lblAisleNumber, gbc_lblAisleNumber);
        
        txtAislenumber = new JTextField();
        txtAislenumber.setEditable(false);
        GridBagConstraints gbc_txtAislenumber = new GridBagConstraints();
        gbc_txtAislenumber.insets = new Insets(0, 0, 5, 0);
        gbc_txtAislenumber.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtAislenumber.gridx = 1;
        gbc_txtAislenumber.gridy = 1;
        panel.add(txtAislenumber, gbc_txtAislenumber);
        txtAislenumber.setColumns(10);
        
        JLabel lblShelfNumber = new JLabel("Shelf Number:");
        GridBagConstraints gbc_lblShelfNumber = new GridBagConstraints();
        gbc_lblShelfNumber.anchor = GridBagConstraints.EAST;
        gbc_lblShelfNumber.insets = new Insets(0, 0, 5, 5);
        gbc_lblShelfNumber.gridx = 0;
        gbc_lblShelfNumber.gridy = 2;
        panel.add(lblShelfNumber, gbc_lblShelfNumber);
        
        txtShelfnumber = new JTextField();
        txtShelfnumber.setEditable(false);
        GridBagConstraints gbc_txtShelfnumber = new GridBagConstraints();
        gbc_txtShelfnumber.insets = new Insets(0, 0, 5, 0);
        gbc_txtShelfnumber.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtShelfnumber.gridx = 1;
        gbc_txtShelfnumber.gridy = 2;
        panel.add(txtShelfnumber, gbc_txtShelfnumber);
        txtShelfnumber.setColumns(10);
        
        JLabel lblSubject = new JLabel("Subject: ");
        GridBagConstraints gbc_lblSubject = new GridBagConstraints();
        gbc_lblSubject.anchor = GridBagConstraints.EAST;
        gbc_lblSubject.insets = new Insets(0, 0, 0, 5);
        gbc_lblSubject.gridx = 0;
        gbc_lblSubject.gridy = 3;
        panel.add(lblSubject, gbc_lblSubject);
        
        txtSubject = new JTextField();
        txtSubject.setEditable(false);
        GridBagConstraints gbc_txtSubject = new GridBagConstraints();
        gbc_txtSubject.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtSubject.gridx = 1;
        gbc_txtSubject.gridy = 3;
        panel.add(txtSubject, gbc_txtSubject);
        txtSubject.setColumns(10);
        
        JButton btnBack = new JButton("Back");

        GridBagConstraints gbc_btnBack = new GridBagConstraints();
        gbc_btnBack.anchor = GridBagConstraints.EAST;
        gbc_btnBack.insets = new Insets(0, 0, 0, 5);
        gbc_btnBack.gridx = 4;
        gbc_btnBack.gridy = 4;
        add(btnBack, gbc_btnBack);
        containedIn = in;
        
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	containedIn.showBookSearch();
            }
        });
        
        btnLocate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	getLocation(txtIsbn.getText());
            }
        });
    }
    
    public void getLocation(String isbn) {
    	String query = String.format("SELECT BOOK.sname, BOOK.shelf_no, BOOK.shelf_floor_no, SHELF.aisle_number "
    			+ "FROM BOOK INNER JOIN SHELF ON BOOK.shelf_no=SHELF.shelf_number WHERE BOOK.isbn=\"%s\" "
    			+ "AND BOOK.shelf_floor_no=SHELF.fnumber",isbn);
    	DBdriver db = new DBdriver();
    	ResultSet result = db.sendQuery(query);
    	try {
    		if (result.next()) {
    			this.txtSubject.setText(result.getString("sname"));
    			this.txtShelfnumber.setText(result.getString("shelf_no"));
    			this.txtAislenumber.setText(result.getString("aisle_number"));
    			this.txtFloornumber.setText(result.getString("shelf_floor_no"));
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	db.closeConnection();
    	
    }

}
