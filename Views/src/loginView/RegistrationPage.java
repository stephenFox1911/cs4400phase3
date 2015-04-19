package loginView;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import DBdriver.DBdriver;
import main.JTextFieldLimit;

/**
 * This is the panel where a user can enter all information to register.
 * 
 * @author JWJibilian
 *
 */
@SuppressWarnings("serial")
public class RegistrationPage extends JPanel {

    private FirstView containedIn;
    private JTextField textDay;
    private JTextField textLastName;
    private JTextField textFirstName;
    private JTextField textMonth;
    private JLabel label_1;
    private JRadioButton rdbtnMale;
    private JRadioButton rdbtnFemale;
    private JCheckBox chckbxFaculty;
    private JLabel lblEmail;
    private JLabel lblStreet;
    private JLabel lblCity;
    private JLabel lblState;
    private JLabel lblZIP;
    private JTextField textEmail;
    private JTextField textStreet;
    private JTextField textCity;
    private JTextField textState;
    private JTextField textZIP;
    private JTextField textYear;
    private ButtonGroup radioGroup;
    private JButton btnCancel;
    private JButton btnSubmit;
    private Choice departmentsList;
    GridBagLayout gridBagLayout;
    private GridBagConstraints gbc_departmentsList;
    private final String[] departments = {"", "Dep_1", "Dep_2", "Dep_3"};
    private JLabel lblSelDep;
    private JPanel panel;

    /**
     * Create the panel.
     */
    public RegistrationPage(FirstView in) {
        super();
        containedIn = in;
        gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] {10, 0, 30, -1, 30, 1, 75, 46,
            45, 31, 37, 33, 0};
        gridBagLayout.rowHeights = new int[] {10, 16, 0, 0, 0, 11, 0, 0, 0, 0,
            0};
        gridBagLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0,
            0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
            0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
        gbc_lblFirstName.anchor = GridBagConstraints.EAST;
        gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
        gbc_lblFirstName.gridx = 1;
        gbc_lblFirstName.gridy = 1;
        add(lblFirstName, gbc_lblFirstName);

        textFirstName = new JTextField();
        GridBagConstraints gbc_textFirstName = new GridBagConstraints();
        gbc_textFirstName.fill = GridBagConstraints.BOTH;
        gbc_textFirstName.gridwidth = 5;
        gbc_textFirstName.insets = new Insets(0, 0, 5, 5);
        gbc_textFirstName.gridx = 2;
        gbc_textFirstName.gridy = 1;
        add(textFirstName, gbc_textFirstName);
        textFirstName.setColumns(10);

        panel = new JPanel();
        panel.setBorder(new TitledBorder(UIManager
            .getBorder("TitledBorder.border"), "Gender", TitledBorder.LEADING,
            TitledBorder.TOP, null, new Color(0, 0, 0)));
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridheight = 2;
        gbc_panel.gridwidth = 4;
        gbc_panel.insets = new Insets(0, 0, 5, 5);
        gbc_panel.gridx = 7;
        gbc_panel.gridy = 1;
        add(panel, gbc_panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] {46, 45, 33, 0};
        gbl_panel.rowHeights = new int[] {16, 0};
        gbl_panel.columnWeights = new double[] {0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[] {0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        radioGroup = new ButtonGroup();

        rdbtnMale = new JRadioButton("Male");
        GridBagConstraints gbc_rdbtnMale = new GridBagConstraints();
        gbc_rdbtnMale.insets = new Insets(0, 0, 0, 5);
        gbc_rdbtnMale.gridx = 0;
        gbc_rdbtnMale.gridy = 0;
        panel.add(rdbtnMale, gbc_rdbtnMale);
        radioGroup.add(rdbtnMale);

        rdbtnFemale = new JRadioButton("Female");
        GridBagConstraints gbc_rdbtnFemale = new GridBagConstraints();
        gbc_rdbtnFemale.gridwidth = 2;
        gbc_rdbtnFemale.gridx = 1;
        gbc_rdbtnFemale.gridy = 0;
        panel.add(rdbtnFemale, gbc_rdbtnFemale);
        radioGroup.add(rdbtnFemale);

        JLabel lblLastName = new JLabel("Last Name:");
        GridBagConstraints gbc_lblLastName = new GridBagConstraints();
        gbc_lblLastName.anchor = GridBagConstraints.EAST;
        gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
        gbc_lblLastName.gridx = 1;
        gbc_lblLastName.gridy = 2;
        add(lblLastName, gbc_lblLastName);

        textLastName = new JTextField();
        GridBagConstraints gbc_textLastName = new GridBagConstraints();
        gbc_textLastName.fill = GridBagConstraints.BOTH;
        gbc_textLastName.gridwidth = 5;
        gbc_textLastName.insets = new Insets(0, 0, 5, 5);
        gbc_textLastName.gridx = 2;
        gbc_textLastName.gridy = 2;
        add(textLastName, gbc_textLastName);
        textLastName.setColumns(10);

        JLabel lblDateOfBirth = new JLabel("Date of Birth:");
        GridBagConstraints gbc_lblDateOfBirth = new GridBagConstraints();
        gbc_lblDateOfBirth.anchor = GridBagConstraints.EAST;
        gbc_lblDateOfBirth.insets = new Insets(0, 0, 5, 5);
        gbc_lblDateOfBirth.gridx = 1;
        gbc_lblDateOfBirth.gridy = 3;
        add(lblDateOfBirth, gbc_lblDateOfBirth);

        textMonth = new JTextField();
        GridBagConstraints gbc_textMonth = new GridBagConstraints();
        gbc_textMonth.fill = GridBagConstraints.BOTH;
        gbc_textMonth.insets = new Insets(0, 0, 5, 5);
        gbc_textMonth.gridx = 2;
        gbc_textMonth.gridy = 3;
        add(textMonth, gbc_textMonth);
        textMonth.setColumns(2);
        textMonth.setDocument(new JTextFieldLimit(2));
        textMonth.setText("MM");

        JLabel label = new JLabel("/");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.anchor = GridBagConstraints.EAST;
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 3;
        gbc_label.gridy = 3;
        add(label, gbc_label);

        textDay = new JTextField();
        textDay.setText("dd");
        GridBagConstraints gbc_textDay = new GridBagConstraints();
        gbc_textDay.fill = GridBagConstraints.BOTH;
        gbc_textDay.insets = new Insets(0, 0, 5, 5);
        gbc_textDay.gridx = 4;
        gbc_textDay.gridy = 3;
        add(textDay, gbc_textDay);
        textDay.setColumns(2);
        textDay.setDocument(new JTextFieldLimit(2));
        textDay.setText("DD");

        label_1 = new JLabel("/");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.insets = new Insets(0, 0, 5, 5);
        gbc_label_1.anchor = GridBagConstraints.EAST;
        gbc_label_1.gridx = 5;
        gbc_label_1.gridy = 3;
        add(label_1, gbc_label_1);

        textYear = new JTextField();
        textYear.setText("yyyy");
        GridBagConstraints gbc_textYear = new GridBagConstraints();
        gbc_textYear.insets = new Insets(0, 0, 5, 5);
        gbc_textYear.fill = GridBagConstraints.BOTH;
        gbc_textYear.gridx = 6;
        gbc_textYear.gridy = 3;
        add(textYear, gbc_textYear);
        textYear.setColumns(2);
        textYear.setDocument(new JTextFieldLimit(4));
        textYear.setText("YYYY");

        chckbxFaculty = new JCheckBox("Faculty");
        GridBagConstraints gbc_chckbxFaculty = new GridBagConstraints();
        gbc_chckbxFaculty.anchor = GridBagConstraints.EAST;
        gbc_chckbxFaculty.insets = new Insets(0, 0, 5, 5);
        gbc_chckbxFaculty.gridx = 1;
        gbc_chckbxFaculty.gridy = 4;
        add(chckbxFaculty, gbc_chckbxFaculty);

        lblSelDep = new JLabel("Select Department:");
        GridBagConstraints gbc_lblSelDep = new GridBagConstraints();
        gbc_lblSelDep.anchor = GridBagConstraints.EAST;
        gbc_lblSelDep.gridwidth = 5;
        gbc_lblSelDep.insets = new Insets(0, 0, 5, 5);
        gbc_lblSelDep.gridx = 2;
        gbc_lblSelDep.gridy = 4;
        add(lblSelDep, gbc_lblSelDep);

        departmentsList = new Choice();
        gbc_departmentsList = new GridBagConstraints();
        gbc_departmentsList.fill = GridBagConstraints.HORIZONTAL;
        gbc_departmentsList.gridwidth = 2;
        gbc_departmentsList.insets = new Insets(0, 0, 5, 5);
        gbc_departmentsList.gridx = 7;
        gbc_departmentsList.gridy = 4;
        add(departmentsList, gbc_departmentsList);

        lblEmail = new JLabel("Email:");
        GridBagConstraints gbc_lblEmail = new GridBagConstraints();
        gbc_lblEmail.anchor = GridBagConstraints.EAST;
        gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmail.gridx = 1;
        gbc_lblEmail.gridy = 5;
        add(lblEmail, gbc_lblEmail);

        textEmail = new JTextField();
        GridBagConstraints gbc_textEmail = new GridBagConstraints();
        gbc_textEmail.gridwidth = 6;
        gbc_textEmail.insets = new Insets(0, 0, 5, 5);
        gbc_textEmail.fill = GridBagConstraints.BOTH;
        gbc_textEmail.gridx = 2;
        gbc_textEmail.gridy = 5;
        add(textEmail, gbc_textEmail);
        textEmail.setColumns(10);

        for (int i = 0; i < departments.length; i++) {
            departmentsList.add(departments[i]);
        }

        lblStreet = new JLabel("Street Address:");
        GridBagConstraints gbc_lblStreet = new GridBagConstraints();
        gbc_lblStreet.anchor = GridBagConstraints.EAST;
        gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
        gbc_lblStreet.gridx = 1;
        gbc_lblStreet.gridy = 6;
        add(lblStreet, gbc_lblStreet);

        textStreet = new JTextField();
        GridBagConstraints gbc_textStreet = new GridBagConstraints();
        gbc_textStreet.gridwidth = 9;
        gbc_textStreet.insets = new Insets(0, 0, 5, 5);
        gbc_textStreet.fill = GridBagConstraints.BOTH;
        gbc_textStreet.gridx = 2;
        gbc_textStreet.gridy = 6;
        add(textStreet, gbc_textStreet);
        textStreet.setColumns(10);

        lblCity = new JLabel("City:");
        GridBagConstraints gbc_lblCity = new GridBagConstraints();
        gbc_lblCity.anchor = GridBagConstraints.EAST;
        gbc_lblCity.insets = new Insets(0, 0, 5, 5);
        gbc_lblCity.gridx = 1;
        gbc_lblCity.gridy = 7;
        add(lblCity, gbc_lblCity);

        textCity = new JTextField();
        GridBagConstraints gbc_textCity = new GridBagConstraints();
        gbc_textCity.gridwidth = 6;
        gbc_textCity.insets = new Insets(0, 0, 5, 5);
        gbc_textCity.fill = GridBagConstraints.BOTH;
        gbc_textCity.gridx = 2;
        gbc_textCity.gridy = 7;
        add(textCity, gbc_textCity);
        textCity.setColumns(10);

        lblState = new JLabel("State:");
        GridBagConstraints gbc_lblState = new GridBagConstraints();
        gbc_lblState.anchor = GridBagConstraints.EAST;
        gbc_lblState.insets = new Insets(0, 0, 5, 5);
        gbc_lblState.gridx = 8;
        gbc_lblState.gridy = 7;
        add(lblState, gbc_lblState);

        textState = new JTextField();
        GridBagConstraints gbc_textState = new GridBagConstraints();
        gbc_textState.fill = GridBagConstraints.BOTH;
        gbc_textState.insets = new Insets(0, 0, 5, 5);
        gbc_textState.gridx = 9;
        gbc_textState.gridy = 7;
        add(textState, gbc_textState);
        textState.setColumns(2);

        lblZIP = new JLabel("ZIP:");
        GridBagConstraints gbc_lblZIP = new GridBagConstraints();
        gbc_lblZIP.anchor = GridBagConstraints.EAST;
        gbc_lblZIP.insets = new Insets(0, 0, 5, 5);
        gbc_lblZIP.gridx = 1;
        gbc_lblZIP.gridy = 8;
        add(lblZIP, gbc_lblZIP);

        textZIP = new JTextField();
        GridBagConstraints gbc_textZIP = new GridBagConstraints();
        gbc_textZIP.gridwidth = 4;
        gbc_textZIP.insets = new Insets(0, 0, 5, 5);
        gbc_textZIP.fill = GridBagConstraints.BOTH;
        gbc_textZIP.gridx = 2;
        gbc_textZIP.gridy = 8;
        add(textZIP, gbc_textZIP);
        textZIP.setColumns(10);
        textZIP.setDocument(new JTextFieldLimit(5));

        btnSubmit = new JButton("Submit");

        GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
        gbc_btnSubmit.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
        gbc_btnSubmit.gridx = 1;
        gbc_btnSubmit.gridy = 9;
        add(btnSubmit, gbc_btnSubmit);

        btnCancel = new JButton("Cancel");
        GridBagConstraints gbc_btnCancel = new GridBagConstraints();
        gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnCancel.gridwidth = 5;
        gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
        gbc_btnCancel.gridx = 2;
        gbc_btnCancel.gridy = 9;
        add(btnCancel, gbc_btnCancel);

        this.departmentVisibility(false);

        textMonth.addFocusListener(new FocusAdapter() {
            /**
             * Clears month field from format needed.
             */
            public void focusGained(FocusEvent e) {
                if (textMonth.getText().equals("MM")) {
                    textMonth.setText("");
                }
            }
        });

        textDay.addFocusListener(new FocusAdapter() {
            /**
             * Clears the day field from the format needed.
             */
            public void focusGained(FocusEvent e) {
                if (textDay.getText().equals("DD")) {
                    textDay.setText("");
                }
            }
        });

        textYear.addFocusListener(new FocusAdapter() {
            /**
             * Clears the year field from shown format needed.
             */
            public void focusGained(FocusEvent e) {
                if (textYear.getText().equals("YYYY")) {
                    textYear.setText("");
                }
            }
        });

        chckbxFaculty.addItemListener(new ItemListener() {
            /**
             * Event on the faculty check box, Toggles the visibility of
             * department label and selection box/
             */
            public void itemStateChanged(ItemEvent e) {
                departmentVisibility(chckbxFaculty.isSelected());

            }

        });

        btnCancel.addActionListener(new ActionListener() {
            /**
             * Resets the container its in;
             */
            public void actionPerformed(ActionEvent e) {
                containedIn.reset();
            }
        });

        btnSubmit.addActionListener(new ActionListener() {
            /**
             * Event where the select button is pressed.
             */
            public void actionPerformed(ActionEvent arg0) {
                String print = textFirstName.getText() + ", "
                    + textLastName.getText() + ", " + rdbtnMale.isSelected()
                    + ", " + chckbxFaculty.isSelected() + ", "
                    + departmentsList.getSelectedItem() + ", "
                    + textMonth.getText() + ", " + textDay.getText() + ", "
                    + textYear.getText() + ", " + textEmail.getText() + ", "
                    + textStreet.getText() + ", " + textCity.getText() + ", "
                    + textState.getText() + ", " + textZIP.getText() + ".";
                System.out.println("RegistrationPage Attempting to register user with values: ");
                System.out.println(print);
                
                registerUser(textFirstName.getText(), textLastName.getText(), 
                		rdbtnMale.isSelected(), chckbxFaculty.isSelected(),
                		departmentsList.getSelectedItem(), textMonth.getText(),
                		textDay.getText(), textYear.getText(), textEmail.getText(),
                		textStreet.getText(), textCity.getText(), textState.getText(),
                		textZIP.getText());
                containedIn.reset();
            }
        });
    }


    public boolean validInfo(String fname,String lname,boolean isMale,boolean isFemale,
    		boolean isFaculty,String dep,String m,String d,String y,String email,
    		String st,String city,String state,String zip) {
    	String errMsg = "";
    	//Check for empty fields
    	if (fname.equals("")||lname.equals("")||!(isMale||isFemale)||(isFaculty&&dep.equals(""))
    			||m.equals("")||d.equals("")||y.equals("")||email.equals("")
    			||st.equals("")||city.equals("")||state.equals("")||zip.equals("")) {
    		JOptionPane.showMessageDialog(this,"One or more fields was left blank.");
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
    public void registerUser(String fname,String lname,boolean isMale,
    		boolean isFaculty,String dep,String m,String d,String y,String email,
    		String st,String city,String state,String zip) {
    	    	
    	DBdriver db = new DBdriver();
    	
    	if(isFaculty) {
    		System.out.println("Registering a new Faculty member.");
    		String facQuery1 = String.format("UPDATE NON_STAFF_USER SET fname=\'%s\', lname=\'%s\', gender=\'%s\', address=\'%s\', total_penalties=0, dob=\'%s\', email=\'%s\' WHERE username=\'%s\'", fname,lname,(isMale ? "m":"f"), st+","+city+","+state+","+zip,y+"-"+m+"-"+d,email,containedIn.userUN);
    		String facQuery2 = String.format("INSERT INTO FACULTY (faculty_username, department) VALUES (\'%s\', \'%s\')", containedIn.userUN, dep);
    		db.sendUpdate(facQuery1);
    		db.sendUpdate(facQuery2);
    	} else {
    		System.out.println("Registering a new student.");
	    	String query = String.format("UPDATE NON_STAFF_USER SET fname=\'%s\', lname=\'%s\', gender=\'%s\', address=\'%s\', total_penalties=0, dob=\'%s\', email=\'%s\' WHERE username=\'%s\'", fname,lname,(isMale ? "m":"f"), st+","+city+","+state+","+zip,y+"-"+m+"-"+d,email,containedIn.userUN);
	    	db.sendUpdate(query);
    	}
    	db.closeConnection();
    }
   
    /**
     * Hides or shows department list and its label. True will show them, false
     * will hide.
     * 
     * @param show
     */
    public void departmentVisibility(boolean show) {

        departmentsList.setVisible(show);
        departmentsList.getParent().revalidate();
        lblSelDep.setVisible(show);
        lblSelDep.getParent().revalidate();

    }

    /**
     * Clears all the fields of the registration page
     */
    public void clearFields() {
        textFirstName.setText("");
        textLastName.setText("");
        radioGroup.clearSelection();
        chckbxFaculty.setSelected(false);
        this.departmentVisibility(false);
        departmentsList.select("");
        textMonth.setText("MM");
        textDay.setText("DD");
        textYear.setText("YYYY");
        textEmail.setText("");
        textStreet.setText("");
        textCity.setText("");
        textZIP.setText("");
    }

}
