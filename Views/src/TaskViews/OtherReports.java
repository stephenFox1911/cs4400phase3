package TaskViews;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
        
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                in.showBookSearch();
            }
        });
        
        
        
    }
    
    public void updateTable(Object[][] newData){
        model.changeData(header, newData);
    }

}
