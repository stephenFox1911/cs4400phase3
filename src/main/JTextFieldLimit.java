package main;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class JTextFieldLimit extends PlainDocument {
    private int limit;

    public JTextFieldLimit(int limit) {
        super();
        this.limit = limit;

    }

    public void insertString(int offset, String str, AttributeSet attr)
        throws BadLocationException {

        if (str == null)
            return;
        if (str.length() > 1
            || ((getLength() + str.length()) <= limit && test(str))) {
            super.insertString(offset, str, attr);

        }

    }

    public boolean test(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
