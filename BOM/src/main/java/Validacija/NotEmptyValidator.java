package Validacija;


import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JDialog;

 
public class NotEmptyValidator extends AbstractValidator {
    public NotEmptyValidator(JFrame parent, JTextField c, String message) {
        super(parent, c, message);
    }
	
    public boolean validationCriteria(JComponent c) {
        if (((JTextField)c).getText().equals(""))
            return false;
        return true;
    }
   
}