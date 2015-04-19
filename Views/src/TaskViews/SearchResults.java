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

import UserView.UserView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchResults extends JPanel {
    private String[] header = {"Select", "ISBN", "Title of Book", "Edition",
        "Copies Available", "Copies on Reserve"};
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
                    for(Object x : selected){
                        System.out.print(x + " ");
                    }
                    // if there is no copy available, switch to future hold screen
                    containedIn.showHoldScreen(selected);
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
