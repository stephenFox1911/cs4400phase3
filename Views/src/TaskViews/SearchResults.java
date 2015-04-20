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

public class SearchResults extends JPanel {
    private String[] header = {"Select", "ISBN", "Title of Book", "Edition",
        "Copies Available", "On Reserve"};
    private Object[][] data = new Object[0][6];
    private JScrollPane scrollPane;
    private JTable searchTable;
    private NewTableModel tableModel;
    private JButton RequestHold;
    private UserView containedIn;
    private JButton btnBack;
    

    /**
     * Create the panel.
     */
    public SearchResults(UserView in) {
        containedIn = in;
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] {5, 527, 53, 107, 0, 0};
        gridBagLayout.rowHeights = new int[] {20, 196, 53, 0};
        gridBagLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0,
            Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[] {0.0, 0.0, 0.0,
            Double.MIN_VALUE};
        setLayout(gridBagLayout);

        tableModel = new NewTableModel(header, data);
        
        JLabel lblBookselection = new JLabel("BookSelection");
        GridBagConstraints gbc_lblBookselection = new GridBagConstraints();
        gbc_lblBookselection.gridwidth = 3;
        gbc_lblBookselection.insets = new Insets(0, 0, 5, 5);
        gbc_lblBookselection.gridx = 1;
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
        gbc_scrollPane.gridwidth = 3;
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 1;
        scrollPane.setViewportView(searchTable);
        add(scrollPane, gbc_scrollPane);
        
        btnBack = new JButton("Back");
       
        GridBagConstraints gbc_btnBack = new GridBagConstraints();
        gbc_btnBack.anchor = GridBagConstraints.EAST;
        gbc_btnBack.gridwidth = 2;
        gbc_btnBack.insets = new Insets(0, 0, 0, 5);
        gbc_btnBack.gridx = 1;
        gbc_btnBack.gridy = 2;
        add(btnBack, gbc_btnBack);
        
        RequestHold = new JButton("Request Hold");
        
        GridBagConstraints gbc_RequestHold = new GridBagConstraints();
        gbc_RequestHold.insets = new Insets(0, 0, 0, 5);
        gbc_RequestHold.gridx = 3;
        gbc_RequestHold.gridy = 2;
        add(RequestHold, gbc_RequestHold);
        
        RequestHold.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try{
                    Object[] selected = tableModel.getSelected();
                    // if there is no copy available, switch to future hold screen
                    if(selected[5].equals("No")) {
                    	
                    	
                    	String[] dates = new String[3];
                    	DBdriver db = new DBdriver();
                    	
                        String query1 = "SELECT CURDATE(), DATE_ADD(CURDATE(), INTERVAL 17 DAY) "
                        		+ "FROM ISSUE;";
                        
                        String query2 = "SELECT est_return_date FROM ISSUE "
                        		+ "WHERE (co_book_isbn = %s) "
                        		+ "ORDER BY est_return_date "
                        		+ "LIMIT 1;";
                        
                        ResultSet estReturn;
                        ResultSet estAvailibility;
                        
                        if (((String)selected[5]).equals("0")) {
                        	estAvailibility = db.sendQuery(String.format(query2, (String) selected[2]));
                        	try{
                        		estAvailibility.next();
                        		dates[0] = "N/A";
                        		dates[1] = "N/A";
                        		dates[2] = estAvailibility.getString(1);
                        	} catch (Exception e) {
                        		e.printStackTrace();
                        	}
                        } else {
                        	
                        	try{
                        		estReturn = db.sendQuery(query1);
                        		
                        		estReturn.next();
                        		dates[0] = estReturn.getString(1);
                        		dates[1] = estReturn.getString(2);
                        		dates[2] = "N/A";
                        		
                        	} catch (Exception e) {
                        		e.printStackTrace();
                        	}
                        	containedIn.showHoldScreen(selected, dates);
                        	
                        }
                        
                        
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
    

    /**
     * Will instantiate a new table object
     * 
     * @param a
     */
    public void updateTable(Object[][] results) {
       
        tableModel.changeData(header, results);

    }
}
