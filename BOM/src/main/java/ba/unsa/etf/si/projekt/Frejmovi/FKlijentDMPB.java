package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FKlijentDMPB {

	private JFrame frame;
	private JTextField txtFdsfd;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String akcija;
	private JButton btnKreiraj;
	private JPanel panel;
	private JFrame parentFrame;
 
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
				    e.printStackTrace();
				}
				
				try {
					FKlijentDMPB window = new FKlijentDMPB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//String klasa je sada stavljen samo beze
		//umjesto ovoga treba biti odg. klasa
		public void setFrame(JFrame parentF, String akcijaA, String klasa)
		{
			//mozda neka provjera da li je akcija validna (moze i enumeracija)
			//ali i ne mora :D
			akcija = akcijaA;
			
			
			//kreiranje, modifikovanje, brisanje, pregled
			//po defaultu je sve editabilno
			
			//za brisanje i pregleda ne trebaju biti editabilini!
			if(akcija.equals("Brisanje") || akcija.equals("Pregled"))
			{
				txtFdsfd.setEditable(false);
				textField_1.setEditable(false);
				textField_2.setEditable(false);
				textField_3.setEditable(false);
				textField_4.setEditable(false);
			}
			//tekst button-a
			if(akcija.equals("Kreiranje"))
			{
				btnKreiraj.setText("Kreiraj");
			}
			else if(akcija.equals("Modifikovanje"))
			{
				btnKreiraj.setText("Modifikuj");
			}
			else if(akcija.equals("Brisanje"))
			{
				btnKreiraj.setText("Obriši");
			}
			else if(akcija.equals("Pregled"))
			{
				btnKreiraj.setText("Nazad");
			}
				
				
			panel.setBorder(BorderFactory.createTitledBorder(akcija + " klijenta"));
			parentFrame = parentF;
			parentFrame.setEnabled(false);
			frame.setVisible(true);
		}

	/**
	 * Create the application.
	 */
	public FKlijentDMPB() {
		initialize();
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	
		    	parentFrame.setEnabled(true);
		    	parentFrame.setVisible(true);
		    	
		    }
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 311);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(12, 13, 408, 241);
		panel.setBorder(BorderFactory.createTitledBorder("Brisanje klijenta"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(65, 50, 56, 16);
		panel.add(lblIme);
		
		txtFdsfd = new JTextField();
		txtFdsfd.setBounds(133, 47, 187, 22);
		panel.add(txtFdsfd);
		txtFdsfd.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(65, 79, 56, 16);
		panel.add(lblPrezime);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 76, 187, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefon.setBounds(65, 108, 56, 16);
		panel.add(lblTelefon);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresa.setBounds(65, 137, 56, 16);
		panel.add(lblAdresa);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(65, 166, 56, 16);
		panel.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(133, 105, 187, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(133, 134, 187, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(133, 163, 187, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		btnKreiraj = new JButton("Obriši");
		btnKreiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//akcija za klik na dugme koje moze imati razlicite f-je
				//brisanje, kreiranje, modifikovanje, pregled
				if(akcija.equals("Kreiranje") || akcija.equals("Modifikovanje"))
				{
					//ovdje treba procitati formu i
					//uraditi validaciju
					//azurirati bazu npr
					//ispisati messageBox ?
					//vratiti se nazad
				}
				if(akcija.equals("Brisanje"))
				{
					//ispisati dialogBox ? (da zelite brisati)
					//azurirati bazu
					//vratiti se nazad
				}
				if(akcija.equals("Pregled"))
				{
					//vratiti se nazad
				}
				
			}
		});
		btnKreiraj.setBounds(223, 203, 97, 25);
		panel.add(btnKreiraj);
	}
}