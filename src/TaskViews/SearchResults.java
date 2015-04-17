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

import UserView.UserView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchResults extends JPanel {
    private String[] header = {"Select", "ISBN", "Title of Book", "Edition",
        "Copies Available"};
    private Object[][] data = new Object[0][5];
    private JScrollPane scrollPane;
    private JTable searchTable;
    private NewTableModel tableModel;
    private JButton RequestHold;
    private JButton btnLocationSearch;
    private UserView containedIn;
    

    /**
     * Create the panel.
     */
    public SearchResults(UserView in) {
        containedIn = in;
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] {117, 527, 53, 107, 55, 0};
        gridBagLayout.rowHeights = new int[] {20, 196, 53, 10, 0};
        gridBagLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0,
            Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0,
            Double.MIN_VALUE};
        setLayout(gridBagLayout);

        // Object[][] data = new Object[5][5];
        // for (int i = 0; i < 5; i++) {
        // data[i][0] = new Boolean(false);
        // data[i][1] = "SomeISSN String";
        // data[i][2] = "title";
        // data[i][3] = (Integer) i;
        // data[i][4] = (Integer) 2 * i;
        // }
        //

        // searchTable.setFillsViewportHeight(true);

        tableModel = new NewTableModel(header, data);
        
        JLabel lblBookselection = new JLabel("BookSelection");
        GridBagConstraints gbc_lblBookselection = new GridBagConstraints();
        gbc_lblBookselection.gridwidth = 3;
        gbc_lblBookselection.insets = new Insets(0, 0, 5, 5);
        gbc_lblBookselection.gridx = 1;
        gbc_lblBookselection.gridy = 0;
        add(lblBookselection, gbc_lblBookselection);
        
        searchTable = new JTable(tableModel);
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
        
        btnLocationSearch = new JButton("Location Search");
        GridBagConstraints gbc_btnLocationSearch = new GridBagConstraints();
        gbc_btnLocationSearch.insets = new Insets(0, 0, 5, 5);
        gbc_btnLocationSearch.gridx = 2;
        gbc_btnLocationSearch.gridy = 2;
        add(btnLocationSearch, gbc_btnLocationSearch);
        
        RequestHold = new JButton("Request Hold");
        
        GridBagConstraints gbc_RequestHold = new GridBagConstraints();
        gbc_RequestHold.insets = new Insets(0, 0, 5, 5);
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
        
      

        // searchTable.setFillsViewportHeight(true);

    }

    /**
     * Will instantiate a new table object
     * 
     * @param a
     */
    public void updateTable(int a) {
        Object[][] newData = new Object[a][5];
        for (int i = 0; i < a; i++) {

            newData[i][0] = false;
            newData[i][1] = "Some ISBN String";
            newData[i][2] = "title";
            newData[i][3] = (Integer) i;
            newData[i][4] = (Integer) 2 * i;
        }
        
        tableModel.changeData(header, newData);

        // searchTable = new JTable(data, header);

    }
}
