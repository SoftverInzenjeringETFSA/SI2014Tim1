package ba.unsa.etf.si.projekt.Validacija;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.InputStream;
public abstract class AbstractValidator extends InputVerifier implements KeyListener {
    protected JDialog popup;
    protected Object parent;
    private JLabel messageLabel;
    private JLabel image;
    private Point point;
    private Dimension cDim;
    private Color color;
    protected String tip;
	
    private AbstractValidator() {
        color = new Color(255, 250 ,250);
    }
	
    private AbstractValidator(JComponent c, String message) {
        this();
        c.addKeyListener(this);
        messageLabel = new JLabel(message + " ");
        image = new JLabel(new ImageIcon(this.getClass().getResource("/ikonica.png")));
       
    }
    
    public AbstractValidator (JDialog parent, JComponent c, String message) {		
        this(c, message);
        this.parent = parent;
        popup = new JDialog(parent);
        initComponents();
    }
	
    protected AbstractValidator (JFrame parent, JComponent c, String message) {
        this(c, message);
        this.parent = parent;
        popup = new JDialog(parent);
        initComponents();
    }
    protected AbstractValidator (JFrame parent, JComponent c, String message,String tip) {
        this(c, message);
        this.parent = parent;
        popup = new JDialog(parent);
        this.tip=tip;
        initComponents();
    }
	
   
     public AbstractValidator(JFrame frame, Component component, String message) {
		// TODO Auto-generated constructor stub
    	 this(component, message);
         this.parent = frame;
         popup = new JDialog(frame);
         initComponents();
	}

	public AbstractValidator(Component component, String message) {
		 this();
	        component.addKeyListener(this);
	        messageLabel = new JLabel(message + " ");
	        image = new JLabel(new ImageIcon(this.getClass().getResource("/ikonica.png")));
	
		
	}

	protected abstract boolean validationCriteria(JComponent c, String tip2);
     protected abstract Boolean ValidirajJeLiPrazno(String kontrolaTekst);
     protected abstract Boolean ValidirajEmail(String mail);
     protected abstract Boolean ValidirajJMBG(String JMBG);
     protected abstract Boolean ValidirajSifru(String sifra);
     protected abstract Boolean ValidirajKorisnickoIme(String korIme);
     protected abstract Boolean ValidirajAdresu(String adresa);
     protected abstract Boolean ValidirajTelefon(String telefon);
     protected abstract Boolean ValidirajTekst(String tekst);
     protected abstract Boolean ValidirajSeriju(String tekst);
     
    public boolean verify(JComponent c) {		
        if (!validationCriteria(c,tip)) {
			
          // if(parent instanceof WantsValidationStatus)
          //     ((WantsValidationStatus)parent).validateFailed();
        	  Color color1=new Color(255,228,225);
            c.setBackground(color1);
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
