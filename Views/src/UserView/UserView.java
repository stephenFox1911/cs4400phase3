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
    private ExtensionRequest extRequest;
    private String userType;
    private FutureHoldRequest futHoldReq;
    private TrackBookLocation trackBook;
    private BookCheckout checkout;
    private ReturnBook returns;
    private DamagedLostBook damageLost;
    private DamagedBooksReport damageReport;
    private OtherReports popularBooks;
    private OtherReports frequentUser;
    private OtherReports popularSubject;

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
        extRequest = new ExtensionRequest(this);
        futHoldReq = new FutureHoldRequest(this);
        trackBook = new TrackBookLocation(this);
        checkout = new BookCheckout(this);
        returns = new ReturnBook(this);
        damageLost = new DamagedLostBook(this);
        damageReport = new DamagedBooksReport(this);
        popularBooks = new OtherReports("Popular Books", this);
        frequentUser = new OtherReports("Frequent Users", this);
        popularSubject = new OtherReports("Popular Subjects", this);

        this.add(bookSearch, "bookSearch");
        this.add(results, "searchResults");
        this.add(holdsNow, "holdNow");
        this.add(extRequest, "extRequest");
        this.add(futHoldReq, "futHoldReq");
        this.add(trackBook, "trackBook");
        this.add(checkout, "checkout");
        this.add(returns, "returns");
        this.add(damageLost, "damageLost");
        this.add(damageReport, "damageReport");
        this.add(popularBooks, "popularBooks");
        this.add(frequentUser, "frequentUser");
        this.add(popularSubject, "popularSubject");

    }

    /**
     * Switches to the book search view
     */

    /**
     * Resets all the panels and switches to book search
     */
    public void reset() {

    }

    public void showSearchResults() {
        MainFrame.resize(725, 590);
        layout.show(this, "searchResults");

    }

    /**
     * Switches and updates table in search result screen
     * 
     * @param a
     */
    public void showSearchResults(int a) {
        results.updateTable(a);
        this.showSearchResults();

    }

    /**
     * Shows information of the book that they want to hold and and switches to
     * the hold screen.
     * 
     * @param selectedItem
     */
    public void showHoldScreen(Object[] selectedItem) {
        holdsNow.setData(selectedItem);
        MainFrame.resize(576,300);
        layout.show(this, "holdNow");

    }

    public void showRequestExtenstion() {
        layout.show(this, "extRequest");
    }

    public void setAndShowType(String type) {
        userType = type;
        bookSearch.setType(userType);
        layout.show(this, "bookSearch");

    }

    public void showBookSearch() {
        this.setAndShowType(userType);
    }

    public CardLayout getLayout() {
        return layout;
    }

    public void showFutureHoldRequest() {
        layout.show(this, "futHoldReq");
        MainFrame.resize(520, 220);
    }

    public void showTrackBookLocation() {
        layout.show(this, "trackBook");
        MainFrame.resize(415, 270);
    }

    public void showCheckout() {
        layout.show(this, "checkout");
        MainFrame.resize(500, 215);
    }

    public void showReturns() {
        layout.show(this, "returns");
        MainFrame.resize(410, 215);
    }

    public void showDamageLost() {
        layout.show(this, "damageLost");
        MainFrame.resize(343, 265);
    }

    public void showDamageReport() {
        layout.show(this, "damageReport");
        MainFrame.resize(345, 449);
    }

    public void showPopularBookReport() {
        layout.show(this, "popularBooks");
        MainFrame.resize(509, 258);
    }

    public void showFrequentUserReport() {
        layout.show(this, "frequentUser");
        MainFrame.resize(509, 258);
    }

    public void showPopularSubjectReport() {
        layout.show(this, "popularSubject");
        MainFrame.resize(509, 258);
    }
}
