package UserView;

import java.awt.CardLayout;

import javax.swing.JPanel;

import main.MainFrame;
import TaskViews.*;



public class UserView extends JPanel {
    private CardLayout layout;
    private SearchBooks bookSearch;
    /**
     * Create the panel.
     */
    public UserView() {
        super();
        
        layout = new CardLayout(0,0);
        this.setLayout(layout);
        
        bookSearch = new SearchBooks(this);

        this.add(bookSearch, "bookSearch");
        

        

    }
    
    public void showBookSearch(){
        int height;
        int width;
        height = (int) bookSearch.getSize().getHeight();
        width = (int) bookSearch.getSize().getWidth();
        MainFrame.resize(width, height); 
    }

}
