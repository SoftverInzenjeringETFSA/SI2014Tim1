package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import org.apache.log4j.Logger;

import ba.unsa.etf.si.projekt.Klase.Osoba;
import ba.unsa.etf.si.projekt.Klase.TipOsobe;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.KompanijaFacade;

public class Login {

	private JFrame frame;
	final static Logger logger = Logger.getLogger(Login.class);
	private JTextField tfKorisnickoIme;
	private JButton btnNewButton;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				//ovaj try sluzi za postavljanje izgleda aplikacije slicnijeg platformi
				try { 
				    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					logger.error("Greska: ", e);
				}
				
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.error("Greska: ", e);
				}
			}
		});
	}
	public void setVisible(boolean visible)
	{
		frame.setVisible(visible);
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    
		    @Override
		    public void windowActivated(java.awt.event.WindowEvent windowEvent) {
		    	
		    	tfKorisnickoIme.setText("");
		    	tfKorisnickoIme.requestFocusInWindow();
				passwordField.setText("");
		    }
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Prijava");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		lblKorisnikoIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnikoIme.setBounds(12, 57, 149, 16);
		frame.getContentPane().add(lblKorisnikoIme);
		
		tfKorisnickoIme = new JTextField();
		tfKorisnickoIme.setBounds(173, 54, 195, 22);
		frame.getContentPane().add(tfKorisnickoIme);
		tfKorisnickoIme.setColumns(10);
		
		JLabel lblifra = new JLabel("\u0160ifra:");
		lblifra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblifra.setBounds(12, 108, 149, 16);
		frame.getContentPane().add(lblifra);
		
		btnNewButton = new JButton("Prijava");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user = tfKorisnickoIme.getText();
				String pass = passwordField.getText();
				
				KompanijaFacade f = new KompanijaFacade();
				Osoba o = f.returnByUsernamePassword(user, pass);
				
				if(o != null)
				{
					if(o.getTipOsobe()  == TipOsobe.menadzer)
					{
						FMenadzer m = new FMenadzer();
						m.setFrame(frame, null, null);
						m.postaviKorisnika(o);
						frame.setVisible(false);
					}
					else if(o.getTipOsobe()  == TipOsobe.radnik)
					{
						FZaposlenik z = new FZaposlenik();
						z.setFrame(frame, null, null);
						z.postaviKorisnika(o);
						frame.setVisible(false);
					}
				}
				else
				{
					MessageBox.infoBox(frame, "Pogrešni podaci za prijavu!", "Info");
				}
			}
		});
		btnNewButton.setBounds(239, 164, 129, 22);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 105, 195, 22);
		frame.getContentPane().add(passwordField);
	}
}