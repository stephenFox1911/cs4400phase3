package TaskViews;

import javax.swing.JPanel;

import DBdriver.DBdriver;
import UserView.UserView;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.NewTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DamagedBooksReport extends JPanel {
	UserView containedIn;
	private NewTableModel model;
	private JTable table;
	private String[] header = { "Month", "Subject", "#damaged Books" };;

	/**
	 * Create the panel.
	 */
	public DamagedBooksReport(UserView in) {

		containedIn = in;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 83, 5, 0, 109, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 5, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0,
				1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblDamageBooksReport = new JLabel("Damage Books Report");
		GridBagConstraints gbc_lblDamageBooksReport = new GridBagConstraints();
		gbc_lblDamageBooksReport.gridwidth = 5;
		gbc_lblDamageBooksReport.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamageBooksReport.gridx = 1;
		gbc_lblDamageBooksReport.gridy = 1;
		add(lblDamageBooksReport, gbc_lblDamageBooksReport);

		JLabel lblMonth = new JLabel("Month:");
		GridBagConstraints gbc_lblMonth = new GridBagConstraints();
		gbc_lblMonth.anchor = GridBagConstraints.EAST;
		gbc_lblMonth.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonth.gridx = 1;
		gbc_lblMonth.gridy = 2;
		add(lblMonth, gbc_lblMonth);

		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"Aug", "Sep", "Oct", "Nov", "Dec" };

		DBdriver db = new DBdriver();
		
		ResultSet subjects = db.sendQuery("SELECT name FROM SUBJECT;");

		ArrayList<String> subString = new ArrayList<String>();
		subString.add("");
		try {
			
			while (subjects.next()) {
				subString.add(subjects.getString(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		db.closeConnection();
		
		String[] foundSubjects = new String[0];
		
		foundSubjects = subString.toArray(foundSubjects);

		JComboBox comboMonth = new JComboBox(months);
		GridBagConstraints gbc_comboMonth = new GridBagConstraints();
		gbc_comboMonth.insets = new Insets(0, 0, 5, 5);
		gbc_comboMonth.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboMonth.gridx = 2;
		gbc_comboMonth.gridy = 2;
		add(comboMonth, gbc_comboMonth);

		JLabel lblSubject1 = new JLabel("Subject 1:");
		GridBagConstraints gbc_lblSubject1 = new GridBagConstraints();
		gbc_lblSubject1.anchor = GridBagConstraints.EAST;
		gbc_lblSubject1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubject1.gridx = 4;
		gbc_lblSubject1.gridy = 2;
		add(lblSubject1, gbc_lblSubject1);

		JComboBox<String> comboSubject1 = new JComboBox<String>(foundSubjects);
		GridBagConstraints gbc_comboSubject1 = new GridBagConstraints();
		gbc_comboSubject1.insets = new Insets(0, 0, 5, 5);
		gbc_comboSubject1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboSubject1.gridx = 5;
		gbc_comboSubject1.gridy = 2;
		add(comboSubject1, gbc_comboSubject1);

		JLabel lblSubject = new JLabel("Subject 2:");
		GridBagConstraints gbc_lblSubject = new GridBagConstraints();
		gbc_lblSubject.anchor = GridBagConstraints.EAST;
		gbc_lblSubject.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubject.gridx = 4;
		gbc_lblSubject.gridy = 3;
		add(lblSubject, gbc_lblSubject);

		JComboBox<String> comboSubject2 = new JComboBox<String>(foundSubjects);
		GridBagConstraints gbc_comboSubject2 = new GridBagConstraints();
		gbc_comboSubject2.insets = new Insets(0, 0, 5, 5);
		gbc_comboSubject2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboSubject2.gridx = 5;
		gbc_comboSubject2.gridy = 3;
		add(comboSubject2, gbc_comboSubject2);

		JLabel lblSubject_1 = new JLabel("Subject 3:");
		GridBagConstraints gbc_lblSubject_1 = new GridBagConstraints();
		gbc_lblSubject_1.anchor = GridBagConstraints.EAST;
		gbc_lblSubject_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubject_1.gridx = 4;
		gbc_lblSubject_1.gridy = 4;
		add(lblSubject_1, gbc_lblSubject_1);

		JComboBox<String> comboSubject3 = new JComboBox<String>(foundSubjects);
		GridBagConstraints gbc_comboSubject3 = new GridBagConstraints();
		gbc_comboSubject3.insets = new Insets(0, 0, 5, 5);
		gbc_comboSubject3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboSubject3.gridx = 5;
		gbc_comboSubject3.gridy = 4;
		add(comboSubject3, gbc_comboSubject3);

		JButton btnShowReport = new JButton("Show Report");
		GridBagConstraints gbc_btnShowReport = new GridBagConstraints();
		gbc_btnShowReport.gridwidth = 5;
		gbc_btnShowReport.insets = new Insets(0, 0, 5, 5);
		gbc_btnShowReport.gridx = 1;
		gbc_btnShowReport.gridy = 5;
		add(btnShowReport, gbc_btnShowReport);

		Object[][] data = new Object[0][3];
		model = new NewTableModel(header, data);

		table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 6;
		add(scrollPane, gbc_scrollPane);

		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.EAST;
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 5;
		gbc_btnBack.gridy = 7;
		add(btnBack, gbc_btnBack);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				containedIn.showBookSearch();
			}
		});

	}

	public void updateTable(Object[][] newData) {
		model.changeData(header, newData);
	}

}
