package TaskViews;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import UserView.UserView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExtensionRequest extends JPanel {
    private UserView containedIn;
    private JTextField txtIssueID;
    private JTextField txtOrigionalcheckoutdate;
    private JTextField txtCurrentextensiondate;
    private JTextField txtNewExtensionDate;
    private JTextField txtCurrentReturnDate;
    private JTextField txtNewEstimatedReturnDate;

    /**
     * Create the panel.
     */
    public ExtensionRequest(UserView in) {
        containedIn = in;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 68, 107, 11, 61, 161, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 43, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblRequestAnExtenstion = new JLabel("Request an Extenstion");
        GridBagConstraints gbc_lblRequestAnExtenstion = new GridBagConstraints();
        gbc_lblRequestAnExtenstion.gridwidth = 6;
        gbc_lblRequestAnExtenstion.insets = new Insets(0, 0, 5, 5);
        gbc_lblRequestAnExtenstion.gridx = 1;
        gbc_lblRequestAnExtenstion.gridy = 1;
        add(lblRequestAnExtenstion, gbc_lblRequestAnExtenstion);
        
        JLabel lblIssueId = new JLabel("Issue ID: ");
        GridBagConstraints gbc_lblIssueId = new GridBagConstraints();
        gbc_lblIssueId.anchor = GridBagConstraints.EAST;
        gbc_lblIssueId.insets = new Insets(0, 0, 5, 5);
        gbc_lblIssueId.gridx = 1;
        gbc_lblIssueId.gridy = 2;
        add(lblIssueId, gbc_lblIssueId);
        
        txtIssueID = new JTextField();
        GridBagConstraints gbc_txtIssueID = new GridBagConstraints();
        gbc_txtIssueID.gridwidth = 2;
        gbc_txtIssueID.insets = new Insets(0, 0, 5, 5);
        gbc_txtIssueID.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtIssueID.gridx = 2;
        gbc_txtIssueID.gridy = 2;
        add(txtIssueID, gbc_txtIssueID);
        txtIssueID.setColumns(10);
        
        JButton btnSubmitIID = new JButton("Submit");
        GridBagConstraints gbc_btnSubmitIID = new GridBagConstraints();
        gbc_btnSubmitIID.gridwidth = 2;
        gbc_btnSubmitIID.anchor = GridBagConstraints.WEST;
        gbc_btnSubmitIID.insets = new Insets(0, 0, 5, 5);
        gbc_btnSubmitIID.gridx = 4;
        gbc_btnSubmitIID.gridy = 2;
        add(btnSubmitIID, gbc_btnSubmitIID);
        
        JLabel lblOrigonalCheckoutDate = new JLabel("Origonal Checkout Date: ");
        GridBagConstraints gbc_lblOrigonalCheckoutDate = new GridBagConstraints();
        gbc_lblOrigonalCheckoutDate.anchor = GridBagConstraints.EAST;
        gbc_lblOrigonalCheckoutDate.gridwidth = 2;
        gbc_lblOrigonalCheckoutDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblOrigonalCheckoutDate.gridx = 1;
        gbc_lblOrigonalCheckoutDate.gridy = 4;
        add(lblOrigonalCheckoutDate, gbc_lblOrigonalCheckoutDate);
        
        txtOrigionalcheckoutdate = new JTextField();
        GridBagConstraints gbc_txtOrigionalcheckoutdate = new GridBagConstraints();
        gbc_txtOrigionalcheckoutdate.insets = new Insets(0, 0, 5, 5);
        gbc_txtOrigionalcheckoutdate.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtOrigionalcheckoutdate.gridx = 3;
        gbc_txtOrigionalcheckoutdate.gridy = 4;
        add(txtOrigionalcheckoutdate, gbc_txtOrigionalcheckoutdate);
        txtOrigionalcheckoutdate.setColumns(10);
        
        JLabel lblCurrentReturnDate = new JLabel("Current Return Date: ");
        GridBagConstraints gbc_lblCurrentReturnDate = new GridBagConstraints();
        gbc_lblCurrentReturnDate.anchor = GridBagConstraints.EAST;
        gbc_lblCurrentReturnDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblCurrentReturnDate.gridx = 5;
        gbc_lblCurrentReturnDate.gridy = 4;
        add(lblCurrentReturnDate, gbc_lblCurrentReturnDate);
        
        txtCurrentReturnDate = new JTextField();
        GridBagConstraints gbc_txtCurrentReturnDate = new GridBagConstraints();
        gbc_txtCurrentReturnDate.insets = new Insets(0, 0, 5, 5);
        gbc_txtCurrentReturnDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCurrentReturnDate.gridx = 6;
        gbc_txtCurrentReturnDate.gridy = 4;
        add(txtCurrentReturnDate, gbc_txtCurrentReturnDate);
        txtCurrentReturnDate.setColumns(10);
        
        JLabel lblCurrentExtensionDate = new JLabel("Current Extension Date: ");
        GridBagConstraints gbc_lblCurrentExtensionDate = new GridBagConstraints();
        gbc_lblCurrentExtensionDate.anchor = GridBagConstraints.EAST;
        gbc_lblCurrentExtensionDate.gridwidth = 2;
        gbc_lblCurrentExtensionDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblCurrentExtensionDate.gridx = 1;
        gbc_lblCurrentExtensionDate.gridy = 5;
        add(lblCurrentExtensionDate, gbc_lblCurrentExtensionDate);
        
        txtCurrentextensiondate = new JTextField();
        GridBagConstraints gbc_txtCurrentextensiondate = new GridBagConstraints();
        gbc_txtCurrentextensiondate.insets = new Insets(0, 0, 5, 5);
        gbc_txtCurrentextensiondate.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCurrentextensiondate.gridx = 3;
        gbc_txtCurrentextensiondate.gridy = 5;
        add(txtCurrentextensiondate, gbc_txtCurrentextensiondate);
        txtCurrentextensiondate.setColumns(10);
        
        JLabel lblNewEstimatedReturn = new JLabel("New Estimated Return Date: ");
        GridBagConstraints gbc_lblNewEstimatedReturn = new GridBagConstraints();
        gbc_lblNewEstimatedReturn.anchor = GridBagConstraints.EAST;
        gbc_lblNewEstimatedReturn.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewEstimatedReturn.gridx = 5;
        gbc_lblNewEstimatedReturn.gridy = 5;
        add(lblNewEstimatedReturn, gbc_lblNewEstimatedReturn);
        
        txtNewEstimatedReturnDate = new JTextField();
        GridBagConstraints gbc_txtNewEstimatedReturnDate = new GridBagConstraints();
        gbc_txtNewEstimatedReturnDate.insets = new Insets(0, 0, 5, 5);
        gbc_txtNewEstimatedReturnDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtNewEstimatedReturnDate.gridx = 6;
        gbc_txtNewEstimatedReturnDate.gridy = 5;
        add(txtNewEstimatedReturnDate, gbc_txtNewEstimatedReturnDate);
        txtNewEstimatedReturnDate.setColumns(10);
        
        JLabel lblNewExtensionDate = new JLabel("New Extension Date: ");
        GridBagConstraints gbc_lblNewExtensionDate = new GridBagConstraints();
        gbc_lblNewExtensionDate.anchor = GridBagConstraints.EAST;
        gbc_lblNewExtensionDate.gridwidth = 2;
        gbc_lblNewExtensionDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewExtensionDate.gridx = 1;
        gbc_lblNewExtensionDate.gridy = 6;
        add(lblNewExtensionDate, gbc_lblNewExtensionDate);
        
        txtNewExtensionDate = new JTextField();
        GridBagConstraints gbc_txtNewExtensionDate = new GridBagConstraints();
        gbc_txtNewExtensionDate.insets = new Insets(0, 0, 5, 5);
        gbc_txtNewExtensionDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtNewExtensionDate.gridx = 3;
        gbc_txtNewExtensionDate.gridy = 6;
        add(txtNewExtensionDate, gbc_txtNewExtensionDate);
        txtNewExtensionDate.setColumns(10);
        
        JButton btnConfirmExtensionRequest = new JButton("Confirm");
        GridBagConstraints gbc_btnConfirmExtensionRequest = new GridBagConstraints();
        gbc_btnConfirmExtensionRequest.insets = new Insets(0, 0, 5, 5);
        gbc_btnConfirmExtensionRequest.gridx = 5;
        gbc_btnConfirmExtensionRequest.gridy = 6;
        add(btnConfirmExtensionRequest, gbc_btnConfirmExtensionRequest);
        
        JButton btnBack = new JButton("Back");

        GridBagConstraints gbc_btnBack = new GridBagConstraints();
        gbc_btnBack.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnBack.insets = new Insets(0, 0, 5, 5);
        gbc_btnBack.gridx = 6;
        gbc_btnBack.gridy = 6;
        add(btnBack, gbc_btnBack);
        
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                in.showBookSearch();
            }
        });

    }

}
