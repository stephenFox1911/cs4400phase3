package TaskViews;

import main.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;

import javax.swing.JTable;









import java.awt.GridBagConstraints;
import java.awt.Insets;









import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableCellRenderer;

import DBdriver.DBdriver;
import UserView.UserView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class SearchResults extends JPanel {
    private String[] header = {"Select", "ISBN", "Title of Book", "Edition",
        "Copies Available", "On Reserve"};
    private Object[][] data = new Object[0][6];
    private JScrollPane scrollPane;
    private JTable searchTable;
    private SearchResultTableModel tableModel;
    private JButton RequestHold;
    private UserView containedIn;
    private JButton btnBack;
    private JLabel lblNextAvailable;
    private JTextField textNextAvailable;
   
    /**
     * Create the panel.
     */
    public SearchResults(UserView in) {
        containedIn = in;
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] {5, 111, 144, 100, 53, 107, 0, 0};
        gridBagLayout.rowHeights = new int[] {20, 196, 53, 0};
        gridBagLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
            Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[] {0.0, 0.0, 0.0,
            Double.MIN_VALUE};
        setLayout(gridBagLayout);

        tableModel = new SearchResultTableModel(header, data, this);
        
        JLabel lblBookselection = new JLabel("BookSelection");
        GridBagConstraints gbc_lblBookselection = new GridBagConstraints();
        gbc_lblBookselection.gridwidth = 3;
        gbc_lblBookselection.insets = new Insets(0, 0, 5, 5);
        gbc_lblBookselection.gridx = 3;
        gbc_lblBookselection.gridy = 0;
        add(lblBookselection, gbc_lblBookselection);
        
        searchTable = new JTable(tableModel);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int x= 0; x<5;x++){
            searchTable.getColumnModel().getColumn(x+1).setCellRenderer(centerRenderer);
        }
        searchTable.setFillsViewportHeight(true);
        
        
        scrollPane = new JScrollPane(searchTable);
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridwidth = 5;
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 1;
        scrollPane.setViewportView(searchTable);
        add(scrollPane, gbc_scrollPane);
        
        lblNextAvailable = new JLabel("Next available:");
        GridBagConstraints gbc_lblNextAvailable = new GridBagConstraints();
        gbc_lblNextAvailable.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNextAvailable.insets = new Insets(0, 0, 0, 5);
        gbc_lblNextAvailable.gridx = 1;
        gbc_lblNextAvailable.gridy = 2;
        add(lblNextAvailable, gbc_lblNextAvailable);
        
        textNextAvailable = new JTextField();
        textNextAvailable.setEditable(false);
        GridBagConstraints gbc_textNextAvailable = new GridBagConstraints();
        gbc_textNextAvailable.anchor = GridBagConstraints.NORTH;
        gbc_textNextAvailable.insets = new Insets(0, 0, 0, 5);
        gbc_textNextAvailable.fill = GridBagConstraints.HORIZONTAL;
        gbc_textNextAvailable.gridx = 2;
        gbc_textNextAvailable.gridy = 2;
        add(textNextAvailable, gbc_textNextAvailable);
        textNextAvailable.setColumns(10);
        
        btnBack = new JButton("Back");
       
        GridBagConstraints gbc_btnBack = new GridBagConstraints();
        gbc_btnBack.anchor = GridBagConstraints.EAST;
        gbc_btnBack.gridwidth = 2;
        gbc_btnBack.insets = new Insets(0, 0, 0, 5);
        gbc_btnBack.gridx = 3;
        gbc_btnBack.gridy = 2;
        add(btnBack, gbc_btnBack);
        
        RequestHold = new JButton("Request Hold");
        
        GridBagConstraints gbc_RequestHold = new GridBagConstraints();
        gbc_RequestHold.insets = new Insets(0, 0, 0, 5);
        gbc_RequestHold.gridx = 5;
        gbc_RequestHold.gridy = 2;
        add(RequestHold, gbc_RequestHold);
        
        RequestHold.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Object[] selected = tableModel.getSelected();
                    // if there is no copy available, switch to future hold screen
                    if(selected[5].equals("No")) {
                    	
                    	
                    	String[] dates = new String[2];
                    	DBdriver db = new DBdriver();
                    	
                        String query1 = "SELECT CURDATE(), DATE_ADD(CURDATE(), INTERVAL 17 DAY) "
                        		+ "FROM ISSUE;";
                        
                        
                        
                        ResultSet estReturn;
                        ResultSet estAvailibility;
                        
                        	
                        	try{
                        		estReturn = db.sendQuery(query1);
                        		
                        		estReturn.next();
                        		dates[0] = estReturn.getString(1);
                        		dates[1] = estReturn.getString(2);
                        		
                        	} catch (Exception e) {
                        		e.printStackTrace();
                        	}
                        	containedIn.showHoldScreen(selected, dates);
                        	
                        
                        
                        
                        db.closeConnection();
                    	
                    	
                    	
                    } else {
                    	JOptionPane.showMessageDialog(null, "Book is on Reserve");
                    }
                } catch (NothingSelectedException e){
                    
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Book not selected" , JOptionPane.INFORMATION_MESSAGE);
                }
                
                
                
            }
        });
        
        
        
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	containedIn.showBookSearch();
            }
        });
        
      

        // searchTable.setFillsViewportHeight(true);

    }
    
    public JTextField getNextAvailable(){
    	return textNextAvailable;
    }
    

    /**
     * Will instantiate a new table object
     * 
     * @param a
     */
    public void updateTable(Object[][] results) {
       
        tableModel.changeData(header, results);

    }
    public JButton getPlaceHoldButton(){
    	return RequestHold;
    }
}
