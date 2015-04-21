package TaskViews;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import DBdriver.DBdriver;
import UserView.UserView;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTable;

import main.NewTableModel;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OtherReports extends JPanel {
    UserView containedIn;
    String[] header = {"Month", "", "#Checkouts"};
    private JTable table;
    private NewTableModel model;
    /**
     * Create the panel.
     */
    public OtherReports(String type, UserView in) {
        containedIn = in;
        header[1] = type;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{5, 258, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 123, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblReport = new JLabel(type + " Report");
        GridBagConstraints gbc_lblReport = new GridBagConstraints();
        gbc_lblReport.gridwidth = 2;
        gbc_lblReport.insets = new Insets(0, 0, 5, 5);
        gbc_lblReport.gridx = 1;
        gbc_lblReport.gridy = 1;
        add(lblReport, gbc_lblReport);
        
        Object[][] data = new Object[0][3];
        model = new NewTableModel(header, data);
        table = new JTable(model);
        table.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridwidth = 2;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 2;
        add(scrollPane, gbc_scrollPane);
        

        
        JButton buttonBack = new JButton("Back");
        GridBagConstraints gbc_buttonBack = new GridBagConstraints();
        gbc_buttonBack.anchor = GridBagConstraints.BELOW_BASELINE;
        gbc_buttonBack.insets = new Insets(0, 0, 0, 5);
        gbc_buttonBack.gridx = 2;
        gbc_buttonBack.gridy = 3;
        add(buttonBack, gbc_buttonBack);
        
        fillTable(type);
        
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	containedIn.showBookSearch();
            }
        });
        
        
        
    }
    
    public void fillTable(String type) {
    	DBdriver db = new DBdriver();
    	String query;

    	if(type.equals("Popular Subjects")) {
    		query = "SELECT MONTH(date_created),sname, COUNT(DISTINCT issue_id) "
    				+ "FROM ISSUE INNER JOIN BOOK ON co_book_isbn=isbn "
    				+ "WHERE MONTH(date_created)=4 OR MONTH(date_created)=5 "
    				+ "GROUP BY MONTH(date_created),sname "
    				+ "ORDER BY MONTH(date_created),COUNT(DISTINCT issue_id) DESC LIMIT 3";
    		
    	} else if(type.equals("Frequent Users")) {
    		query = "SELECT MONTH(date_created),username, COUNT(DISTINCT issue_id) "
    				+ "FROM ISSUE INNER JOIN NON_STAFF_USER ON co_username=username "
    				+ "WHERE MONTH(date_created)=4 OR MONTH(date_created)=5 "
    				+ "GROUP BY MONTH(date_created),username "
    				+ "ORDER BY MONTH(date_created),COUNT(DISTINCT issue_id) DESC LIMIT 5";
    		
    	} else if(type.equals("Popular Books")) {
    		query = "SELECT MONTH(date_created),title, COUNT(DISTINCT issue_id) "
    				+ "FROM ISSUE INNER JOIN BOOK ON co_book_isbn=isbn "
    				+ "WHERE MONTH(date_created)=4 OR MONTH(date_created)=5 "
    				+ "GROUP BY MONTH(date_created),title "
    				+ "ORDER BY MONTH(date_created),COUNT(DISTINCT issue_id) DESC LIMIT 3";
    	} else {
    		System.out.println("Invalid Type");
    		return;
    	}
    	
    	System.out.println("Actual query: " + query);
    	ResultSet rs = db.sendQuery(query);
		ArrayList<String> resValues = new ArrayList<String>();
		
		try {
			while(rs.next()){
					resValues.add(rs.getString(1));
					resValues.add(rs.getString(2));
					resValues.add(rs.getString(3));
			}
			Object[][] results = new Object[(resValues.size()/3)+1][3];
			
			for(int i=0; i<resValues.size(); i++){
				results[i/3][i%3] = resValues.get(i);
			}
			
			if(resValues.size() > 0) {
				model.changeData(header, results);
			} else {
				System.out.println("Empty result set");
			}
			
		} catch(Exception sqle){
			System.out.println("Error while processing results;");
			System.out.println(sqle.getMessage());
		}
    	db.closeConnection();
    }
    
    public void updateTable(Object[][] newData){
        model.changeData(header, newData);
    }

}
