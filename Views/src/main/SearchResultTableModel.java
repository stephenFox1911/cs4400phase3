package main;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.directory.SearchResult;

import TaskViews.SearchResults;
import DBdriver.DBdriver;
import javax.swing.JTextField;

public class SearchResultTableModel extends NewTableModel {
	SearchResults containedIn = null;

	public SearchResultTableModel(String[] header, Object[][] data,
			SearchResults in) {
		super(header, data);
		containedIn = in;

	}

	public void setValueAt(Object arg, int a, int b) {
		super.setValueAt(arg, a, b);

		Object[] selected = new Object[6];
		try {
			selected = this.getSelected();
			String query2 = "SELECT est_return_date FROM ISSUE "
					+ "WHERE (co_book_isbn = %s) "
					+ "ORDER BY est_return_date DESC " + "LIMIT 1;";
			if (((String) selected[4]).equals("0")) {
				containedIn.getPlaceHoldButton().setEnabled(false);
				
				DBdriver db = new DBdriver();
				ResultSet result = db.sendQuery(String.format(query2,
						(String) selected[1]));
				try {
					if (result.next()) {
						containedIn.getNextAvailable().setText(
								result.getString(1));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				db.closeConnection();
			} else {
				containedIn.getPlaceHoldButton().setEnabled(true);
				containedIn.getNextAvailable().setText("N/A");
			}

		} catch (NothingSelectedException c) {

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
