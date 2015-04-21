package TaskViews;

import javax.swing.JPanel;

import main.NewTableModel;
import main.NothingSelectedException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.HeadlessException;
import java.awt.Insets;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import DBdriver.DBdriver;
import UserView.UserView;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Holds extends JPanel {
    private JTable table;
    private JScrollPane scrollPane;
    private NewTableModel tableModel;
    private String[] header = {"Select", "ISBN", "Title of Book", "Edition",
        "Copies Available"};
    private Object[][] data = new Object[0][5];
    private UserView containedIn;
    private JLabel lblPlaceAHold;
    private JLabel lblHoldRequestDate;
    private JTextField textHoldRequestDate;
    private JLabel lblEstimatedReturnDate;
    private JTextField textEstReturnDate;
    private JButton btnBack;

    /**
     * Create the panel.
     */
    public Holds(UserView in) {
        containedIn = in;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{15, 0, 92, 0, 92, 100, 5, 0};
        gridBagLayout.rowHeights = new int[]{15, 0, 118, 0, 15, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        tableModel = new NewTableModel(header, data);
        
        lblPlaceAHold = new JLabel("Place a hold");
        GridBagConstraints gbc_lblPlaceAHold = new GridBagConstraints();
        gbc_lblPlaceAHold.gridwidth = 5;
        gbc_lblPlaceAHold.insets = new Insets(0, 0, 5, 5);
        gbc_lblPlaceAHold.gridx = 1;
        gbc_lblPlaceAHold.gridy = 1;
        add(lblPlaceAHold, gbc_lblPlaceAHold);
        
        table = new JTable(tableModel);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int x= 0; x<4;x++){
            table.getColumnModel().getColumn(x+1).setCellRenderer(centerRenderer);
        }
        table.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(table);
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridwidth = 5;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 2;
        add(scrollPane, gbc_scrollPane);
        
        

        scrollPane.setViewportView(table);
        
        lblHoldRequestDate = new JLabel("Hold Request Date: ");
        GridBagConstraints gbc_lblHoldRequestDate = new GridBagConstraints();
        gbc_lblHoldRequestDate.anchor = GridBagConstraints.EAST;
        gbc_lblHoldRequestDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblHoldRequestDate.gridx = 1;
        gbc_lblHoldRequestDate.gridy = 3;
        add(lblHoldRequestDate, gbc_lblHoldRequestDate);
        
        textHoldRequestDate = new JTextField();
        textHoldRequestDate.setText("MM/DD/YYYY");
        textHoldRequestDate.setEditable(false);
        GridBagConstraints gbc_textHoldRequestDate = new GridBagConstraints();
        gbc_textHoldRequestDate.insets = new Insets(0, 0, 5, 5);
        gbc_textHoldRequestDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_textHoldRequestDate.gridx = 2;
        gbc_textHoldRequestDate.gridy = 3;
        add(textHoldRequestDate, gbc_textHoldRequestDate);
        textHoldRequestDate.setColumns(10);
        
        lblEstimatedReturnDate = new JLabel("Estimated Return Date: ");
        GridBagConstraints gbc_lblEstimatedReturnDate = new GridBagConstraints();
        gbc_lblEstimatedReturnDate.anchor = GridBagConstraints.EAST;
        gbc_lblEstimatedReturnDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblEstimatedReturnDate.gridx = 3;
        gbc_lblEstimatedReturnDate.gridy = 3;
        add(lblEstimatedReturnDate, gbc_lblEstimatedReturnDate);
        
        textEstReturnDate = new JTextField();
        textEstReturnDate.setText("MM/DD/YYYY");
        textEstReturnDate.setEditable(false);
        GridBagConstraints gbc_textEstReturnDate = new GridBagConstraints();
        gbc_textEstReturnDate.insets = new Insets(0, 0, 5, 5);
        gbc_textEstReturnDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_textEstReturnDate.gridx = 4;
        gbc_textEstReturnDate.gridy = 3;
        add(textEstReturnDate, gbc_textEstReturnDate);
        textEstReturnDate.setColumns(10);
        
        JButton btnPlaceHold = new JButton("Place Hold");
        GridBagConstraints gbc_btnPlaceHold = new GridBagConstraints();
        gbc_btnPlaceHold.insets = new Insets(0, 0, 5, 5);
        gbc_btnPlaceHold.gridx = 5;
        gbc_btnPlaceHold.gridy = 3;
        add(btnPlaceHold, gbc_btnPlaceHold);
        
        btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                containedIn.showSearchResults();
            }
        });
        GridBagConstraints gbc_btnBack = new GridBagConstraints();
        gbc_btnBack.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnBack.insets = new Insets(0, 0, 0, 5);
        gbc_btnBack.gridx = 5;
        gbc_btnBack.gridy = 4;
        add(btnBack, gbc_btnBack);
        
        btnPlaceHold.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//containedIn.showSearchResults();
            	
            	System.out.println("Request the hold");
            	try {
					requestHold(tableModel.getSelected());
					
				} catch (NothingSelectedException e1) {
					JOptionPane.showMessageDialog(null, "Please select a book.");
				}
            
            }
        });
    }
    
    public void setData(Object[] info){
        data = new Object[1][1];
        data[0]=info;
        tableModel.changeData(header, data);
    }

    public void requestHold(Object[] selected) {
    	String query1 = String.format("SELECT COUNT( * ) >= ( SELECT COUNT( * ) "
    			+ "FROM COPY JOIN ISSUE ON COPY.copy_number = ISSUE.co_bcopy_no "
    			+ "AND COPY.book_isbn = ISSUE.co_book_isbn WHERE COPY.book_isbn = \"%s\" ) "
    			, selected[1]);
    	String query2 = String.format("SELECT COUNT(*) < 1 "
    			+ "FROM NON_STAFF_USER, ISSUE WHERE NON_STAFF_USER.username=\"%s\" "
    			+ "AND NON_STAFF_USER.username=ISSUE.co_username "
    			,selected[1]);
    	DBdriver db = new DBdriver();
    	ResultSet result1 = db.sendQuery(query1);
    	ResultSet result2 = db.sendQuery(query2);
    	try {
			if (result1.next()&&result2.next()) {
				System.out.println(result1.getBoolean(1));
				System.out.println(result2.getBoolean(1));
				if (result1.getBoolean(1)&&result2.getBoolean(1)) {
					//Get smallest copy # which is available for checkout
					String query3 = String.format("SELECT MIN(COPY.copy_number),DATE(DATE_ADD(NOW(), INTERVAL 17 DAY)),"
							+ "DATE(NOW()) FROM COPY WHERE COPY.book_isbn=\"%s\" "
							+ "AND COPY.copy_number NOT IN (SELECT COPY.copy_number "
							+ "FROM COPY,ISSUE WHERE COPY.book_isbn=\"%s\" "
							+ "AND COPY.copy_number=ISSUE.co_bcopy_no "
							+ "AND COPY.book_isbn=ISSUE.co_book_isbn)",selected[1],selected[1]);
					ResultSet result3 = db.sendQuery(query3);
					result3.next();
					String minCopyNo = result3.getString(1);
					String expRetDate = result3.getString(2);
					String holdReqDate = result3.getString(3);
					
					String query4 = String.format("INSERT INTO ISSUE (est_return_date, "
							+ "date_created, co_username, co_bcopy_no, co_book_isbn, extension_count) "
							+ "VALUES (DATE_ADD(NOW(), INTERVAL 17 DAY), NOW(),\"%s\",\"%s\",\"%s\", 0)"
							,containedIn.getCurrentUser(),minCopyNo,selected[1]);
					db.sendUpdate(query4);
					
					String query5 = String.format("SELECT issue_id FROM ISSUE WHERE co_username=\"%s\" "
							+ "AND co_book_isbn=\"%s\" AND co_bcopy_no=\"%s\""
							,containedIn.getCurrentUser(),selected[1],minCopyNo);
					ResultSet result5 = db.sendQuery(query5);
					result5.next();
					textEstReturnDate.setText(expRetDate);
					textHoldRequestDate.setText(holdReqDate);
					JOptionPane.showMessageDialog(this,"Hold successfully created.\n Your issue ID is: "+result5.getString(1));
				}
				else if (!result1.getBoolean(1)) {
					JOptionPane.showMessageDialog(this,"All copies of this book are currently on hold or checked out.");
				}
				else {
					JOptionPane.showMessageDialog(this,"You already have a copy of this book on hold.");
				}
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(selected[1]);
    	System.out.println(selected[2]);
    	System.out.println(selected[3]);
    	System.out.println(selected[4]);
    	System.out.println(selected[5]);
    }
    
    public void setDate(String[] dates){
    	textHoldRequestDate.setText(dates[0]);
    	textEstReturnDate.setText(dates[1]);
    }
}
