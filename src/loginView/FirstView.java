package loginView;
import java.awt.CardLayout;

import javax.swing.JPanel;

import main.MainFrame;
/**
 * This is the login screen
 * @author JWJibilian
 *
 */
@SuppressWarnings("serial")
public class FirstView extends JPanel {

    private LoginPage login;
    private UNameCheck nameCheck;
    private RegistrationPage rPage;
    private CardLayout layout;
    public String userUN;
    public String userPW;
    
    /**
     * Create the panel.
     */
    public FirstView() {
        super();
        
        
        
        login = new LoginPage(this);
        nameCheck = new UNameCheck(this);
        rPage = new RegistrationPage(this);

        layout = new CardLayout(0, 0);
        this.setLayout(layout);

        // adding all panels to the card layout
        this.add(login, "login");
        this.add(nameCheck, "nameCheck");
        this.add(rPage, "rPage");

        this.showLogin();

    }
    /**
     * Clears all the fields and switchses to login screen
     */
    public void reset() {
        login.clearFields();
        nameCheck.clearFields();
        rPage.clearFields();
        this.showLogin();

    }

    /**
     * Shows the main login page.
     */
    public void showLogin() {
        layout.show(this, "login");
        MainFrame.resize(315, 200);
    }

    /**
     * Show first step of registering. Goes to page where user can enter user
     * name and password
     */
    public void showUNameCheck() {
        layout.show(this, "nameCheck");
        MainFrame.resize(345, 175);

    }

    /**
     * Second step of registering. Goes to page where user can enter remaining
     * needed information
     */
    public void showRPage() {
        layout.show(this, "rPage");
        MainFrame.resize(390, 310);
    }

}
