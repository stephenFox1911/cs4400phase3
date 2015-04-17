package UserView;

import java.awt.CardLayout;

import javax.swing.JPanel;

import main.MainFrame;
import TaskViews.*;

public class UserView extends JPanel {
    private CardLayout layout;
    private SearchBooks bookSearch;
    private SearchResults results;
    private Holds holdsNow;

    /**
     * Create the panel.
     */
    public UserView() {
        super();

        layout = new CardLayout(0, 0);
        this.setLayout(layout);

        bookSearch = new SearchBooks(this);
        results = new SearchResults(this);
        holdsNow = new Holds(this);
        
        this.add(bookSearch, "bookSearch");
        this.add(results, "searchResults");
        this.add(holdsNow, "holdNow");

    }
    /**
     * Switches to the book search view
     */
    public void showBookSearch() {
        layout.show(this, "bookSearch");
        MainFrame.resize(340, 215);
        
    }
    /**
     * Resets all the panels and switches to book search
     */
    public void reset() {

        
    }
    /**
     * Switches and updates table in search result screen
     * @param a
     */
    public void showSearchResults(int a) {
        results.updateTable(a);
        MainFrame.resize(1000, 600);
        layout.show(this, "searchResults");

    }
    /**
     * Shows information of the book that they want to hold and 
     * and switches to the hold screen.
     * @param selectedItem
     */
    public void showHoldScreen(Object[] selectedItem) {
        holdsNow.setData(selectedItem);
        MainFrame.resize(560,220);
        layout.show(this, "holdNow");
    }

    public void showFutureHoldScreen() {

    }
}
