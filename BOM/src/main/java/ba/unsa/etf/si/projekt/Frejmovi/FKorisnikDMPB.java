package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FKorisnikDMPB {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JComboBox comboBox;
	private JPanel panel;
	private JButton btnKreiraj;
	private JFrame parentFrame;
	private String akcija;

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
					FKorisnikDMPB window = new FKorisnikDMPB();
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
			textField.setEditable(false);
			textField_1.setEditable(false);
			textField_2.setEditable(false);
			textField_3.setEditable(false);
			textField_4.setEditable(false);
			textField_5.setEditable(false);
			textField_6.setEditable(false);
			comboBox.setEditable(false);
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
			
			
		panel.setBorder(BorderFactory.createTitledBorder(akcija + " korisnika"));
		parentFrame = parentF;
		parentFrame.setEnabled(false);
		frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	
	public FKorisnikDMPB() {
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
		frame.setBounds(100, 100, 455, 401);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(12, 13, 413, 331);
		//panel.setBorder(BorderFactory.createTitledBorder("Pregled korisnika"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(74, 38, 56, 16);
		panel.add(lblIme);
		
		textField = new JTextField();
		textField.setBounds(142, 35, 201, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(74, 67, 56, 16);
		panel.add(lblPrezime);
		
		JLabel lblJmb = new JLabel("JMB:");
		lblJmb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJmb.setBounds(74, 96, 56, 16);
		panel.add(lblJmb);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefon.setBounds(74, 125, 56, 16);
		panel.add(lblTelefon);
		
		JLabel lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		lblKorisnikoIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnikoIme.setBounds(43, 183, 87, 16);
		panel.add(lblKorisnikoIme);
		
		JLabel lblifra = new JLabel("\u0160ifra:");
		lblifra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblifra.setBounds(74, 212, 56, 16);
		panel.add(lblifra);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresa.setBounds(74, 154, 56, 16);
		panel.add(lblAdresa);
		
		JLabel lblPozicija = new JLabel("Pozicija:");
		lblPozicija.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPozicija.setBounds(74, 241, 56, 16);
		panel.add(lblPozicija);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 64, 201, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(142, 93, 201, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(142, 122, 201, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(142, 151, 201, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(142, 180, 201, 22);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(142, 209, 201, 22);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(142, 238, 201, 22);
		panel.add(comboBox);
		
		btnKreiraj = new JButton("Nazad");
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
		btnKreiraj.setBounds(246, 293, 97, 25);
		panel.add(btnKreiraj);
	}
}