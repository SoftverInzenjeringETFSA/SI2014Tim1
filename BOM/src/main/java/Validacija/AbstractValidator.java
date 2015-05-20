package Validacija;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.awt.*;
public abstract class AbstractValidator extends InputVerifier implements KeyListener {
    protected JDialog popup;
    protected Object parent;
    private JLabel messageLabel;
    private JLabel image;
    private Point point;
    private Dimension cDim;
    private Color color;
	
    private AbstractValidator() {
        color = new Color(243, 255, 159);
    }
	
    private AbstractValidator(JComponent c, String message) {
        this();
        c.addKeyListener(this);
        messageLabel = new JLabel(message + " ");
        image = new JLabel(new ImageIcon("exception_16x16.png"));
    }
	
    public AbstractValidator (JDialog parent, JComponent c, String message) {		
        this(c, message);
        this.parent = parent;
        popup = new JDialog(parent);
        initComponents();
    }
	
    public AbstractValidator (JFrame parent, JComponent c, String message) {
        this(c, message);
        this.parent = parent;
        popup = new JDialog(parent);
        initComponents();
    }
	
	
    protected abstract boolean validationCriteria(JComponent c);
	
  
    public boolean verify(JComponent c) {		
        if (!validationCriteria(c)) {
			
        //    if(parent instanceof WantsValidationStatus)
        //        ((WantsValidationStatus)parent).validateFailed();
			
            c.setBackground(Color.PINK);
            popup.setSize(0, 0);
            popup.setLocationRelativeTo(c);
            point = popup.getLocation();
            cDim = c.getSize();
            popup.setLocation(point.x-(int)cDim.getWidth()/2,
                point.y+(int)cDim.getHeight()/2);
            popup.pack();
            popup.setVisible(true);
            return false;
        }
        
        c.setBackground(Color.WHITE);
		
     //  if(parent instanceof WantsValidationStatus)
       //    ((WantsValidationStatus)parent).validatePassed();
		
        return true;
    }
	
    protected void setMessage(String message) {
       messageLabel.setText(message);
    }
	
	
    public void keyPressed(KeyEvent e) {
        popup.setVisible(false);
    }
	
    public void keyTyped(KeyEvent e) {}
	
    public void keyReleased(KeyEvent e) {}
	
    protected void initComponents() {
        popup.getContentPane().setLayout(new FlowLayout());
        popup.setUndecorated(true);
        popup.getContentPane().setBackground(color);
        popup.getContentPane().add(image);
        popup.getContentPane().add(messageLabel);
        popup.setFocusableWindowState(false);
    }
}
