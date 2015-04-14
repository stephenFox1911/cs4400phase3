package TaskViews;

import javax.swing.JPanel;

import main.NewTableModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import UserView.UserView;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

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

    /**
     * Create the panel.
     */
    public Holds(UserView in) {
        containedIn = in;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{23, 0, 75, 0, 63, 100, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 118, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
        gbc_btnPlaceHold.insets = new Insets(0, 0, 0, 5);
        gbc_btnPlaceHold.gridx = 5;
        gbc_btnPlaceHold.gridy = 4;
        add(btnPlaceHold, gbc_btnPlaceHold);

    }
    
    public void setData(Object[] info){
        data = new Object[1][1];
        data[0]=info;
        tableModel.changeData(header, data);
    }

}
