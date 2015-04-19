package TaskViews;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import UserView.UserView;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserPanel extends JPanel {
    UserView containedIn;
    /**
     * Create the panel.
     */
    public UserPanel(UserView in) {
        containedIn = in;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JButton btnRequestExtension = new JButton("Request Extension");
        GridBagConstraints gbc_btnRequestExtension = new GridBagConstraints();
        gbc_btnRequestExtension.insets = new Insets(0, 0, 0, 5);
        gbc_btnRequestExtension.gridx = 0;
        gbc_btnRequestExtension.gridy = 0;
        add(btnRequestExtension, gbc_btnRequestExtension);
        
        JButton btnRequestFutureHold = new JButton("Request Future Hold");
        
                GridBagConstraints gbc_btnRequestFutureHold = new GridBagConstraints();
                gbc_btnRequestFutureHold.gridx = 1;
                gbc_btnRequestFutureHold.gridy = 0;
                add(btnRequestFutureHold, gbc_btnRequestFutureHold);
                
                btnRequestFutureHold.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	containedIn.showFutureHoldRequest();
                    }
                });
        
        
        btnRequestExtension.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	containedIn.showRequestExtenstion();
            }
        });

    }

}
