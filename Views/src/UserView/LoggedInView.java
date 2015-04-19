package UserView;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import main.MainFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Holds the interface that the user will use for all
 * tasks and holds a general loggout button
 * @author JWJibilian
 *
 */
public class LoggedInView extends JPanel {

    private UserView userInterface;
    public String userUN;
    public String userPW;

    public LoggedInView() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] {0, 0};
        gridBagLayout.rowHeights = new int[] {0, 0, 0};
        gridBagLayout.columnWeights = new double[] {1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[] {1.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        userInterface = new UserView();
        GridBagConstraints gbc_loggedIn = new GridBagConstraints();
        gbc_loggedIn.insets = new Insets(0, 0, 5, 0);
        gbc_loggedIn.fill = GridBagConstraints.BOTH;
        gbc_loggedIn.gridx = 0;
        gbc_loggedIn.gridy = 0;
        add(userInterface, gbc_loggedIn);

        JPanel logOutPannel = new JPanel();
        GridBagConstraints gbc_logOutPannel = new GridBagConstraints();
        gbc_logOutPannel.anchor = GridBagConstraints.EAST;
        gbc_logOutPannel.fill = GridBagConstraints.VERTICAL;
        gbc_logOutPannel.gridx = 0;
        gbc_logOutPannel.gridy = 1;
        add(logOutPannel, gbc_logOutPannel);

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                
                userInterface.setAndShowType("");
                MainFrame.restartToLogin();
            }
        });
        logOutPannel.add(btnLogout);
        
    }
    public UserView getUserView() {
        return userInterface;
    }

    public void reset() {
        userInterface.setAndShowType("");
        
    }
}
