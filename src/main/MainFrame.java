package main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import loginView.FirstView;
import UserView.LoggedInView;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
/**
 * The Frame of the application
 * Contains Main Method
 * @author JWJibilian
 *
 */
public class MainFrame {

    public static JFrame frame;
    private static FirstView login;
    private static LoggedInView LoggedIn;
    private static CardLayout card;
    private static JPanel viewHolder;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    @SuppressWarnings("unused")
                    MainFrame window = new MainFrame();
                    
                    MainFrame.frame.setResizable(true);
                    MainFrame.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Library System");
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent arg0) {
                
            }
        });
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setBounds(200, 200, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewHolder = new JPanel();
        frame.getContentPane().add(viewHolder, BorderLayout.CENTER);
        card = new CardLayout(0, 0);
        viewHolder.setLayout(card);

        LoggedIn = new LoggedInView();
        viewHolder.add(LoggedIn, "userView");

        login = new FirstView();
        viewHolder.add(login, "login");
        card.show(viewHolder, "login");
        

    }

    /**
     * Changes the main frames length and height
     * 
     * @param x
     *            width
     * @param y
     *            height
     */
    public static void resize(int x, int y) {
        frame.setSize(x, y);

    }

    /**
     * Shows This switches over to what a logged in user will see
     * @param type the type of user, this will affect what shows
     */
    public static void showUserView(String username,String password,String type) {
        card.show(viewHolder, "userView");
        LoggedIn.userUN = username;
        LoggedIn.userPW = password;
        LoggedIn.getUserView().setAndShowType(type);
    }

    /**
     * Resets all and goes to login screen
     */
    public static void restartToLogin() {
        login.reset();
        LoggedIn.reset();
        login.showLogin();
        card.show(viewHolder, "login");

    }

}
