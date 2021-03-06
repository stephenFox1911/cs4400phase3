package TaskViews;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import UserView.UserView;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class StaffPanel extends JPanel {
    UserView containedIn;
    /**
     * Create the panel.
     */
    public StaffPanel(UserView in) {
        containedIn = in;
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{301, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JButton btnCheckout = new JButton("Book Checkout");
        GridBagConstraints gbc_btnCheckout = new GridBagConstraints();
        gbc_btnCheckout.insets = new Insets(0, 0, 5, 0);
        gbc_btnCheckout.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnCheckout.gridx = 0;
        gbc_btnCheckout.gridy = 0;
        add(btnCheckout, gbc_btnCheckout);
        
        JButton btnBookReturn = new JButton("Book Return");
        GridBagConstraints gbc_btnBookReturn = new GridBagConstraints();
        gbc_btnBookReturn.insets = new Insets(0, 0, 5, 0);
        gbc_btnBookReturn.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnBookReturn.gridx = 0;
        gbc_btnBookReturn.gridy = 1;
        add(btnBookReturn, gbc_btnBookReturn);
        
        JButton btnDamagedBooksReport = new JButton("Damaged Books Report");
        GridBagConstraints gbc_btnDamagedBooksReport = new GridBagConstraints();
        gbc_btnDamagedBooksReport.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnDamagedBooksReport.insets = new Insets(0, 0, 5, 0);
        gbc_btnDamagedBooksReport.gridx = 0;
        gbc_btnDamagedBooksReport.gridy = 3;
        add(btnDamagedBooksReport, gbc_btnDamagedBooksReport);
        
        JButton btnPopularBooksReport = new JButton("Popular Books Report");
        GridBagConstraints gbc_btnPopularBooksReport = new GridBagConstraints();
        gbc_btnPopularBooksReport.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnPopularBooksReport.insets = new Insets(0, 0, 5, 0);
        gbc_btnPopularBooksReport.gridx = 0;
        gbc_btnPopularBooksReport.gridy = 4;
        add(btnPopularBooksReport, gbc_btnPopularBooksReport);
        
        JButton btnFrequentUsersReport = new JButton("Frequent Users Report");
        GridBagConstraints gbc_btnFrequentUsersReport = new GridBagConstraints();
        gbc_btnFrequentUsersReport.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnFrequentUsersReport.insets = new Insets(0, 0, 5, 0);
        gbc_btnFrequentUsersReport.gridx = 0;
        gbc_btnFrequentUsersReport.gridy = 5;
        add(btnFrequentUsersReport, gbc_btnFrequentUsersReport);
        
        JButton btnPopularSubjectReport = new JButton("Popular Subject Report");
        GridBagConstraints gbc_btnPopularSubjectReport = new GridBagConstraints();
        gbc_btnPopularSubjectReport.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnPopularSubjectReport.gridx = 0;
        gbc_btnPopularSubjectReport.gridy = 6;
        add(btnPopularSubjectReport, gbc_btnPopularSubjectReport);
        
        
        btnCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                in.showCheckout();
            }
        });
        
        btnBookReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                in.showReturns();
            }
        });
        
        btnDamagedBooksReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                in.showDamageReport();
            }
        });
        
        btnPopularBooksReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                in.showPopularBookReport();
            }
        });

        btnFrequentUsersReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                in.showFrequentUserReport();
            }
        });
        
        btnPopularSubjectReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                in.showPopularSubjectReport();
            }
        });
    }

}
