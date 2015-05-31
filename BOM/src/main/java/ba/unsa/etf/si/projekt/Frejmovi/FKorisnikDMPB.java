package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.InputVerifier;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.Klase.Osoba;
import ba.unsa.etf.si.projekt.Klase.Ovlasti;
import ba.unsa.etf.si.projekt.Klase.Radnik;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.KompanijaFacade;
import ba.unsa.etf.si.projekt.Validacija.Validator;

import javax.swing.JPasswordField;

public class FKorisnikDMPB {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox;
	private JPanel panel;
	private JButton btnKreiraj;
	private JFrame parentFrame;
	private String akcija;
	private JFormattedTextField formattedTextField;
	private JPasswordField passwordField;
	private Radnik radnik = null;
	private Menadzer menadzer = null;
	InputVerifier imeVal;
	InputVerifier prezimeVal;
	InputVerifier adresaVal;
	InputVerifier emailVal;
	InputVerifier telefonVal;
	InputVerifier JMBGVal;
	InputVerifier korImeVal;
	InputVerifier passVal;
	private JTextField textField_3;
	
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
	public boolean validacija() 
	{
		if(!imeVal.verify(textField)) return false;
		if(!prezimeVal.verify(textField_1)) return false;
		if(!JMBGVal.verify(textField_2)) return false;
		if(!telefonVal.verify(formattedTextField)) return false;
		if(!adresaVal.verify(textField_4)) return false;
		if(!emailVal.verify(textField_3)) return false;
		if(!korImeVal.verify(textField_5)) return false;
		if(!passVal.verify(passwordField)) return false;
		Boolean da = true;
		if(textField.getText().equals("")  || textField_1.getText().equals("") || formattedTextField.getText().equals("+___-__-___-___") || textField_4.getText().equals("") || textField_3.getText().equals("") || textField_2.getText().equals("") ||  textField_5.getText().equals("") )//|| passwordField.getText().equals("") )
			da = false;
		return da;
	}
	
	
	public void setFrame(JFrame parentF, String akcijaA, Osoba os, int osobaMenadzer)
	{
		imeVal = new Validator(frame, textField, "Molimo unesite ispravno ime(samo slova).",
				"");
		prezimeVal = new Validator(frame, textField_1,
				"Molimo unesite ispravno prezime(samo slova).", "");
		JMBGVal=new Validator(frame,textField_2,"Molimo unesite ispravan JMBG","JMBG");
		
		telefonVal = new Validator(frame, formattedTextField, "Molimo unesite ispravan telefon",
				"telefon");
		adresaVal = new Validator(frame, textField_4,
				"Adresa koju ste unijeli nije ispravna", "adresa");
		emailVal = new Validator(frame, textField_4,
				"Email adresa mora da sadrži @ te ispravnu domenu", "email");
		korImeVal=new Validator(frame,textField_5,"Korisničko ime mora sadržavati najmanje 4 karaktera","korIme");
		passVal=new Validator(frame,passwordField,"Šifra mora sadržavati najmanje 4 karaktera","pass");
		
		if(akcijaA.equals("Kreiranje") || akcijaA.equals("Modifikovanje"))
		{
			textField.setInputVerifier(imeVal);
			textField_1.setInputVerifier(prezimeVal);
			textField_2.setInputVerifier(JMBGVal);
			formattedTextField.setInputVerifier(telefonVal);
			textField_4.setInputVerifier(adresaVal);
			textField_3.setInputVerifier(emailVal);
			textField_5.setInputVerifier(korImeVal);
		    passwordField.setInputVerifier(passVal);
		}
		
		
		if(osobaMenadzer == 1)
		{
			menadzer = (Menadzer)os;
		}
		else if(osobaMenadzer == 0)
		{
			radnik = (Radnik)os;
		}
		
		if(osobaMenadzer != -1)
			popuniPolja();
		
		akcija = akcijaA;
		
		
		//kreiranje, modifikovanje, brisanje, pregled
		//po defaultu je sve editabilno
		
		//za brisanje i pregleda ne trebaju biti editabilini!
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
			OnemoguciPolja();
			btnKreiraj.setText("Obriši");
		}
		else if(akcija.equals("Pregled"))
		{
			OnemoguciPolja();
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
		frame.setResizable(false);
		frame.setBounds(100, 100, 455, 401);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(12, 13, 413, 343);
		//panel.setBorder(BorderFactory.createTitledBorder("Pregled korisnika"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(12, 38, 145, 16);
		panel.add(lblIme);
		
		textField = new JTextField();
		textField.setBounds(169, 35, 201, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(12, 67, 145, 16);
		panel.add(lblPrezime);
		
		JLabel lblJmb = new JLabel("JMBG:");
		lblJmb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJmb.setBounds(12, 96, 145, 16);
		panel.add(lblJmb);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefon.setBounds(12, 125, 145, 16);
		panel.add(lblTelefon);
		
		JLabel lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		lblKorisnikoIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnikoIme.setBounds(12, 210, 145, 16);
		panel.add(lblKorisnikoIme);
		
		JLabel lblifra = new JLabel("\u0160ifra:");
		lblifra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblifra.setBounds(12, 237, 145, 16);
		panel.add(lblifra);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresa.setBounds(12, 154, 145, 16);
		panel.add(lblAdresa);
		
		JLabel lblPozicija = new JLabel("Pozicija:");
		lblPozicija.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPozicija.setBounds(12, 269, 145, 16);
		panel.add(lblPozicija);
		
		textField_1 = new JTextField();
		textField_1.setBounds(169, 64, 201, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(169, 93, 201, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(169, 151, 201, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(169, 207, 201, 22);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(169, 266, 201, 22);
		panel.add(comboBox);
		comboBox.addItem("Menadžer");
		comboBox.addItem("Zaposlenik");
		comboBox.setRenderer(new DefaultListCellRenderer() {
	        @Override
	        public void paint(Graphics g) {
	            setBackground(Color.WHITE);
	        	setForeground(Color.BLACK);
	            super.paint(g);
	        }
	    });
		
		btnKreiraj = new JButton("Nazad");
		btnKreiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//akcija za klik na dugme koje moze imati razlicite f-je
				//brisanje, kreiranje, modifikovanje, pregled
				
				if(akcija.equals("Kreiranje"))
				{
					
					if(validacija())
					{
						String ime = textField.getText().toLowerCase();
						ime= ime.substring(0, 1).toUpperCase() + ime.substring(1);
						String prezime = textField_1.getText().toLowerCase();
						prezime= prezime.substring(0, 1).toUpperCase() + prezime.substring(1);
						if(comboBox.getSelectedItem().toString().equals("Menadžer"))
						{
							KompanijaFacade kf = new KompanijaFacade();
							if(kf.dodajMenadzera(ime, prezime, formattedTextField.getText(), textField_4.getText(), textField_3.getText(), comboBox.getSelectedItem().toString(), Ovlasti.kreiranjeIzvjestaja, textField_5.getText(), passwordField.getText(),textField_2.getText()))
								{
								 MessageBox.infoBox(frame, "Korisnik je uspješno kreiran", "Info");
								 frame.setVisible(false);
								 frame.dispose();
								 parentFrame.setEnabled(true);
							     parentFrame.setVisible(true);
								}
							else MessageBox.infoBox(frame, "Korisnik sa unesenim podacima već postoji!", "Greška");
						}
						else if(comboBox.getSelectedItem().toString().equals("Zaposlenik"))
						{
							KompanijaFacade kf1 = new KompanijaFacade();
							if(kf1.dodajRadnika(ime, prezime, formattedTextField.getText(), textField_4.getText(), textField_3.getText(), comboBox.getSelectedItem().toString(), Ovlasti.pretragaMaterijala, textField_5.getText(), passwordField.getText(),textField_2.getText()))
								{
								 MessageBox.infoBox(frame, "Korisnik je uspješno kreiran", "Info");
								 frame.setVisible(false);
								 frame.dispose();
								 parentFrame.setEnabled(true);
							     parentFrame.setVisible(true);
								}
							else MessageBox.infoBox(frame, "Korisnik sa unesenim podacima već postoji!", "Greška");
						}
					}
					else MessageBox.infoBox(frame, "Molimo unesite sve podatke.", "Greska");
					
				}
				if(akcija.equals("Modifikovanje"))
				{
					if(validacija())
					{
						if(comboBox.getSelectedItem().toString().equals("Menadžer"))
						{
							KompanijaFacade kf = new KompanijaFacade();
							menadzer.setIme(textField.getText());
							menadzer.setPrezime(textField_1.getText());
							menadzer.setBrojTelefona(formattedTextField.getText());
							menadzer.setAdresa(textField_4.getText());
							menadzer.setPozicija(comboBox.getSelectedItem().toString());
							menadzer.setEmail(textField_3.getText());
							menadzer.setOvlasti(Ovlasti.kreiranjeIzvjestaja);
							menadzer.setUsername(textField_5.getText());
							menadzer.setPassword(passwordField.getText());
							menadzer.setJMBG(textField_2.getText());
							if(kf.mijenjajMenadzera(menadzer))
								{
								MessageBox.infoBox(frame, "Korisnik je uspješno modifikovan", "Info");
								 frame.setVisible(false);
								 frame.dispose();
								 parentFrame.setEnabled(true);
							     parentFrame.setVisible(true);
								}
						}
						else if(comboBox.getSelectedItem().toString().equals("Zaposlenik"))
						{
							KompanijaFacade kf1 = new KompanijaFacade();
							radnik.setIme(textField.getText());
							radnik.setPrezime(textField_1.getText());
							radnik.setBrojTelefona(formattedTextField.getText());
							radnik.setAdresa(textField_4.getText());
							radnik.setPozicija(comboBox.getSelectedItem().toString());
							radnik.setEmail(textField_3.getText());
							radnik.setNivoOvlasti(Ovlasti.pretragaMaterijala);
							radnik.setUsername(textField_5.getText());
							radnik.setPassword(passwordField.getText());
							radnik.setJMBG(textField_2.getText());
							if(kf1.mijenjajRadnika(radnik))
								{MessageBox.infoBox(frame, "Korisnik je uspješno modifikovan", "Info");
								 frame.setVisible(false);
								 frame.dispose();
								 parentFrame.setEnabled(true);
							     parentFrame.setVisible(true);
								}
							}
					}
					else MessageBox.infoBox(frame, "Molimo unesite sve podatke.", "Greska");
				}
				if(akcija.equals("Brisanje"))
				{
					KompanijaFacade f = new KompanijaFacade();
					boolean obrisano = true;;
					if(menadzer != null)
					{
						try{
							f.obrisiOsobu(menadzer);
						}catch(Exception es)
						{
							obrisano = false;
						}
						
					}
					else
					{
						try{
							f.obrisiOsobu(radnik);
						}catch(Exception es)
						{
							obrisano = false;
						}
					}
					if(obrisano)
						MessageBox.infoBox(null, "Korisnik je uspješno obrisan", "Info");
					else
						MessageBox.infoBox(null, "Ovog korisnika nije moguce obrisati!", "Greška");
					
					frame.setVisible(false);
					frame.dispose();
			    	parentFrame.setVisible(true);
			    	parentFrame.setEnabled(true);
			    	
				}
				if(akcija.equals("Pregled"))
				{
					frame.setVisible(false);
			    	parentFrame.setVisible(true);
			    	parentFrame.setEnabled(true);
			    	frame.dispose();
				}
				
			}
		});
		btnKreiraj.setBounds(291, 299, 79, 22);
		panel.add(btnKreiraj);
		
		MaskFormatter mf1 = new MaskFormatter();
		try{
			mf1 = new MaskFormatter("+###-##-###-###");
		}
		catch( Exception e)
		{
			
		}
		mf1.setPlaceholderCharacter('_');
		formattedTextField = new JFormattedTextField(mf1);
		formattedTextField.setBounds(169, 123, 201, 20);
		panel.add(formattedTextField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(169, 235, 201, 20);
		panel.add(passwordField);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(129, 185, 28, 14);
		panel.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setBounds(169, 178, 201, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
	}
	private void popuniPolja()
	{
		if(menadzer == null)
		{
			textField.setText(radnik.getIme());
			textField_1.setText(radnik.getPrezime());
			textField_2.setText(radnik.getJMBG());
			formattedTextField.setText(radnik.getBrojTelefona());
			textField_3.setText(radnik.getEmail());
			textField_4.setText(radnik.getAdresa());
			textField_5.setText(radnik.getUsername());
			passwordField.setText(radnik.getPassword());
			comboBox.setSelectedItem("Zaposlenik");
		}
		else
		{
			textField.setText(menadzer.getIme());
			textField_1.setText(menadzer.getPrezime());
			textField_2.setText(menadzer.getJMBG());
			formattedTextField.setText(menadzer.getBrojTelefona());
			textField_4.setText(menadzer.getAdresa());
			textField_3.setText(menadzer.getEmail());
			textField_5.setText(menadzer.getUsername());
			passwordField.setText(menadzer.getPassword());
			comboBox.setSelectedItem("Menadžer");
		}
	}
	
	private void OnemoguciPolja()
	{
		textField.setEnabled(false);
		textField_1.setEnabled(false);
		textField_2.setEnabled(false);
		formattedTextField.setEnabled(false);
		textField_4.setEnabled(false);
		textField_3.setEnabled(false);
		textField_5.setEnabled(false);
		passwordField.setEnabled(false);
		comboBox.setEnabled(false);
		
		comboBox.setEditable(false);
	}
}
