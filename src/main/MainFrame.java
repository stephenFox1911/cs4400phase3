package main;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import loginView.FirstView;
import UserView.UserView;

public class MainFrame {

    private static JFrame frame;
    private static FirstView login;
    private static UserView user;
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
                    MainFrame.frame.setResizable(false);
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
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        viewHolder = new JPanel();
        frame.getContentPane().add(viewHolder, BorderLayout.CENTER);
        card = new CardLayout(0, 0);
        viewHolder.setLayout(card);

        user = new UserView();
        viewHolder.add(user, "user");
        
        login = new FirstView();
        viewHolder.add(login, "login");
        card.show(viewHolder, "login");

    }

    /**
     * Changes the main frames length and height
     * 
     * @param x
     *            length
     * @param y
     *            height
     */
    public static void resize(int x, int y) {
        frame.setSize(x, y);

    }
    /**
     * Shows a users view
     */
    public static void showUserView(){
        card.show(viewHolder, "user");
        user.showBookSearch();
    }
    
    /**
     * Resets all and goes to login
     */
    public static void restartToLogin() {
        login.reset();
        card.show(viewHolder, "login");

    }

}
