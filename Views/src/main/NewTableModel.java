package main;

import javax.swing.table.AbstractTableModel;
/**
 * Used on jtables
 * @author JWJibilian
 *
 */
public class NewTableModel extends AbstractTableModel {
    private String[] columnNames;
    private Object[][] data;

    public NewTableModel(String[] header, Object[][] data) {
        this.data = data;
        columnNames = header;
    }

    public void changeData(String[] header, Object[][] data) {
        this.data = data;
        columnNames = header;
        this.fireTableDataChanged();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public void setValueAt(Object arg, int a, int b) {
        boolean checked = false;
        if (b == 0) {
            checked = (Boolean) arg;
            if (checked) {
                for (int i = 0; i < data.length; i++) {
                    data[i][0] = false;
                    this.fireTableCellUpdated(i, b);
                }
                data[a][0] = true;
            } else {
                data[a][0] = false;
            }
            this.fireTableCellUpdated(a, b);
        }

    }
    
    public Object[] getSelected() throws NothingSelectedException{
        for (Object[] x : data){
            if ((Boolean) x[0]){
                return x;
            }
        }
        throw new NothingSelectedException("Please select a book.");
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int column) {
        if (column != 0 && !(this.getValueAt(row, column) instanceof Boolean)) {
            return false;
        }
        return true;

    }

}