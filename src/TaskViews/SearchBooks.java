package TaskViews;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JButton;

import main.MainFrame;
import UserView.UserView;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchBooks extends JPanel {
    private UserView containedIn;
    private JTextField textFieldISBN;
    private JTextField textFieldTitle;
    private JTextField textFieldAuthor;

    /**
     * Create the panel.
     */
    public SearchBooks(UserView in) {
        super();
        containedIn = in;
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{20, 0, 56, 0, 38, 89, 0, 0};
        gridBagLayout.rowHeights = new int[]{43, 0, 0, 0, 0, 0, 0, 0, 20, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblNewLabel = new JLabel("Book Search");
        lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 25));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.gridwidth = 5;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 0;
        add(lblNewLabel, gbc_lblNewLabel);
        
        JLabel lblISBN = new JLabel("ISBN:");
        GridBagConstraints gbc_lblISBN = new GridBagConstraints();
        gbc_lblISBN.insets = new Insets(0, 0, 5, 5);
        gbc_lblISBN.anchor = GridBagConstraints.EAST;
        gbc_lblISBN.gridx = 1;
        gbc_lblISBN.gridy = 1;
        add(lblISBN, gbc_lblISBN);
        
        textFieldISBN = new JTextField();
        GridBagConstraints gbc_textFieldISBN = new GridBagConstraints();
        gbc_textFieldISBN.fill = GridBagConstraints.BOTH;
        gbc_textFieldISBN.gridwidth = 4;
        gbc_textFieldISBN.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldISBN.gridx = 2;
        gbc_textFieldISBN.gridy = 1;
        add(textFieldISBN, gbc_textFieldISBN);
        textFieldISBN.setColumns(10);
        
        JLabel lblTitle = new JLabel("Title:");
        GridBagConstraints gbc_lblTitle = new GridBagConstraints();
        gbc_lblTitle.anchor = GridBagConstraints.EAST;
        gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
        gbc_lblTitle.gridx = 1;
        gbc_lblTitle.gridy = 3;
        add(lblTitle, gbc_lblTitle);
        
        textFieldTitle = new JTextField();
        GridBagConstraints gbc_textFieldTitle = new GridBagConstraints();
        gbc_textFieldTitle.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldTitle.gridwidth = 4;
        gbc_textFieldTitle.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldTitle.gridx = 2;
        gbc_textFieldTitle.gridy = 3;
        add(textFieldTitle, gbc_textFieldTitle);
        textFieldTitle.setColumns(10);
        
        JLabel lblAuthor = new JLabel("Author: ");
        GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
        gbc_lblAuthor.anchor = GridBagConstraints.EAST;
        gbc_lblAuthor.insets = new Insets(0, 0, 5, 5);
        gbc_lblAuthor.gridx = 1;
        gbc_lblAuthor.gridy = 5;
        add(lblAuthor, gbc_lblAuthor);
        
        textFieldAuthor = new JTextField();
        textFieldAuthor.setText("");
        GridBagConstraints gbc_textFieldAuthor = new GridBagConstraints();
        gbc_textFieldAuthor.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldAuthor.gridwidth = 4;
        gbc_textFieldAuthor.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldAuthor.gridx = 2;
        gbc_textFieldAuthor.gridy = 5;
        add(textFieldAuthor, gbc_textFieldAuthor);
        textFieldAuthor.setColumns(10);
        
        JButton btnNewButton = new JButton("Back");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 2;
        gbc_btnNewButton.gridy = 7;
        add(btnNewButton, gbc_btnNewButton);
        
        JButton btnSearch = new JButton("Search");
        
        GridBagConstraints gbc_btnSearch = new GridBagConstraints();
        gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
        gbc_btnSearch.gridx = 4;
        gbc_btnSearch.gridy = 7;
        add(btnSearch, gbc_btnSearch);
        
        JButton btnClose = new JButton("Close");
        GridBagConstraints gbc_btnClose = new GridBagConstraints();
        gbc_btnClose.insets = new Insets(0, 0, 5, 5);
        gbc_btnClose.gridx = 5;
        gbc_btnClose.gridy = 7;
        add(btnClose, gbc_btnClose);
        
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                MainFrame.restartToLogin();
            }
        });
        
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                containedIn.showSearchResults(Integer.parseInt(textFieldISBN.getText()));
            }
        });
        

    }

}
