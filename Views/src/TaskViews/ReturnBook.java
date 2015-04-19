package TaskViews;

import javax.swing.JPanel;

import UserView.UserView;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBook extends JPanel {
    UserView containedIn;
    private JTextField textIssueID;
    private JTextField textISBN;
    private JTextField textField;
    private JTextField txtUserName;
    /**
     * Create the panel.
     */
    public ReturnBook(UserView in) {
        containedIn = in;
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{5, 0, 100, 0, 0, 100, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblReturnBook = new JLabel("Return Book");
        GridBagConstraints gbc_lblReturnBook = new GridBagConstraints();
        gbc_lblReturnBook.gridwidth = 5;
        gbc_lblReturnBook.insets = new Insets(0, 0, 5, 5);
        gbc_lblReturnBook.gridx = 1;
        gbc_lblReturnBook.gridy = 1;
        add(lblReturnBook, gbc_lblReturnBook);
        
        JLabel lblIssueid = new JLabel("IssueId:");
        GridBagConstraints gbc_lblIssueid = new GridBagConstraints();
        gbc_lblIssueid.anchor = GridBagConstraints.EAST;
        gbc_lblIssueid.insets = new Insets(0, 0, 5, 5);
        gbc_lblIssueid.gridx = 1;
        gbc_lblIssueid.gridy = 2;
        add(lblIssueid, gbc_lblIssueid);
        
        textIssueID = new JTextField();
        GridBagConstraints gbc_textIssueID = new GridBagConstraints();
        gbc_textIssueID.insets = new Insets(0, 0, 5, 5);
        gbc_textIssueID.fill = GridBagConstraints.HORIZONTAL;
        gbc_textIssueID.gridx = 2;
        gbc_textIssueID.gridy = 2;
        add(textIssueID, gbc_textIssueID);
        textIssueID.setColumns(10);
        
        JLabel lblCopy = new JLabel("Copy #:");
        GridBagConstraints gbc_lblCopy = new GridBagConstraints();
        gbc_lblCopy.anchor = GridBagConstraints.EAST;
        gbc_lblCopy.insets = new Insets(0, 0, 5, 5);
        gbc_lblCopy.gridx = 4;
        gbc_lblCopy.gridy = 2;
        add(lblCopy, gbc_lblCopy);
        
        textField = new JTextField();
        textField.setEditable(false);
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 5;
        gbc_textField.gridy = 2;
        add(textField, gbc_textField);
        textField.setColumns(10);
        
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
        
        JLabel lblUserName = new JLabel("User Name:");
        GridBagConstraints gbc_lblUserName = new GridBagConstraints();
        gbc_lblUserName.anchor = GridBagConstraints.EAST;
        gbc_lblUserName.insets = new Insets(0, 0, 5, 5);
        gbc_lblUserName.gridx = 4;
        gbc_lblUserName.gridy = 3;
        add(lblUserName, gbc_lblUserName);
        
        txtUserName = new JTextField();
        txtUserName.setEditable(false);
        GridBagConstraints gbc_txtUserName = new GridBagConstraints();
        gbc_txtUserName.insets = new Insets(0, 0, 5, 5);
        gbc_txtUserName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtUserName.gridx = 5;
        gbc_txtUserName.gridy = 3;
        add(txtUserName, gbc_txtUserName);
        txtUserName.setColumns(10);
        
        JLabel lblReturnedInDammeged = new JLabel("Returned in Dammeged Condition");
        lblReturnedInDammeged.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_lblReturnedInDammeged = new GridBagConstraints();
        gbc_lblReturnedInDammeged.gridwidth = 3;
        gbc_lblReturnedInDammeged.insets = new Insets(0, 0, 5, 5);
        gbc_lblReturnedInDammeged.gridx = 1;
        gbc_lblReturnedInDammeged.gridy = 4;
        add(lblReturnedInDammeged, gbc_lblReturnedInDammeged);
        
        Choice choice = new Choice();
        choice.add("No");
        choice.add("Yes");
        GridBagConstraints gbc_choice = new GridBagConstraints();
        gbc_choice.fill = GridBagConstraints.HORIZONTAL;
        gbc_choice.insets = new Insets(0, 0, 5, 5);
        gbc_choice.gridx = 4;
        gbc_choice.gridy = 4;
        add(choice, gbc_choice);
        
        JButton btnBack = new JButton("Back");
        GridBagConstraints gbc_btnBack = new GridBagConstraints();
        gbc_btnBack.insets = new Insets(0, 0, 0, 5);
        gbc_btnBack.gridx = 4;
        gbc_btnBack.gridy = 5;
        add(btnBack, gbc_btnBack);
        
        JButton btnReturnBook = new JButton("Return Book");
        GridBagConstraints gbc_btnReturnBook = new GridBagConstraints();
        gbc_btnReturnBook.insets = new Insets(0, 0, 0, 5);
        gbc_btnReturnBook.gridx = 5;
        gbc_btnReturnBook.gridy = 5;
        add(btnReturnBook, gbc_btnReturnBook);
        
        
        
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                in.showBookSearch();
            }
        });
        
        btnReturnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (choice.getSelectedItem().equals("Yes")){
                    in.showDamageLost();
                } else {
                    in.showBookSearch();
                }
            }
        });
        

    }

}
