package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import ba.unsa.etf.si.projekt.Klase.Narudzbenica;
import ba.unsa.etf.si.projekt.Klase.Osoba;
import ba.unsa.etf.si.projekt.Klase.TipOsobe;
import ba.unsa.etf.si.projekt.Validacija.Validator;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.KompanijaFacade;
import ba.unsa.etf.si.projekt.Klase.Klijent;

public class FKlijentDMPB {

	private JFrame frame;
	private JTextField txtFdsfd;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JFormattedTextField telefon;
	private String akcija;
	private JButton btnKreiraj;
	private JPanel panel;
	private JFrame parentFrame;
	public Klijent klijent;
	public Osoba trenutniKorisnik;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				// ovaj try sluzi za postavljanje izgleda aplikacije slicnijeg
				// platformi
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
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

	public void setFrame(JFrame parentF, String akcijaA, Klijent k) {
		klijent = k;
		akcija = akcijaA;
		if (akcija.equals("Brisanje") || akcija.equals("Pregled")) {
			txtFdsfd.setEditable(false);
			textField_1.setEditable(false);
			textField_3.setEditable(false);
			textField_4.setEditable(false);
			telefon.setEditable(false);
			popuniPodatke();
		}

		if (akcija.equals("Kreiranje")) {
			btnKreiraj.setText("Kreiraj");
		} else if (akcija.equals("Modifikovanje")) {
			btnKreiraj.setText("Modifikuj");
			popuniPodatke();
		} else if (akcija.equals("Brisanje")) {
			btnKreiraj.setText("Obriši");
		} else if (akcija.equals("Pregled")) {
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
	InputVerifier imeVal;
	InputVerifier prezimeVal;
	InputVerifier adresaVal;
	InputVerifier emailVal;
	InputVerifier telefonVal;

	public FKlijentDMPB() {
		initialize();
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {

				parentFrame.setEnabled(true);
				parentFrame.setVisible(true);

			}
		});

		imeVal = new Validator(frame, txtFdsfd, "Molimo unesite ispravno ime",
				"");
		prezimeVal = new Validator(frame, textField_1,
				"Molimo unesite ispravno prezime", "");
		adresaVal = new Validator(frame, textField_3,
				"Adresa koju ste unijeli nije ispravna", "adresa");
		emailVal = new Validator(frame, textField_4,
				"Email adresa mora da sadrži @ te ispravnu domenu", "email");
		telefonVal = new Validator(frame, telefon, "Molimo unesite telefon",
				"telefon");
		txtFdsfd.setInputVerifier(imeVal);
		textField_1.setInputVerifier(prezimeVal);
		textField_3.setInputVerifier(adresaVal);
		textField_4.setInputVerifier(emailVal);
		telefon.setInputVerifier(telefonVal);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 402, 311);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(12, 13, 372, 253);
		panel.setBorder(BorderFactory.createTitledBorder("Brisanje klijenta"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblIme = new JLabel("Ime:");
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(12, 50, 109, 16);
		panel.add(lblIme);

		txtFdsfd = new JTextField();
		txtFdsfd.setBounds(133, 47, 187, 22);
		panel.add(txtFdsfd);
		txtFdsfd.setColumns(10);

		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(12, 79, 109, 16);
		panel.add(lblPrezime);

		textField_1 = new JTextField();
		textField_1.setBounds(133, 76, 187, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefon.setBounds(12, 108, 109, 16);
		panel.add(lblTelefon);

		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresa.setBounds(12, 137, 109, 16);
		panel.add(lblAdresa);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(12, 166, 109, 16);
		panel.add(lblEmail);

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

				KompanijaFacade kf = new KompanijaFacade();

				if (akcija.equals("Kreiranje")) {

					String ime = ((JTextField) txtFdsfd).getText()
							.toLowerCase();
					ime = ime.substring(0, 1).toUpperCase() + ime.substring(1);
					String prezime = ((JTextField) textField_1).getText()
							.toLowerCase();
					prezime = prezime.substring(0, 1).toUpperCase()
							+ prezime.substring(1);
					if (kf.returnByImePrezime(ime, prezime, TipOsobe.klijent) != null) {
						MessageBox
								.infoBox(
										frame,
										"Klijent sa ovim imenom i prezimenom je već kreirana.Izmjenu možete izvršiti preko prethodnog prozora.",
										"Info");
					} else {
						String adresa = ((JTextField) textField_3).getText();
						String email = ((JTextField) textField_4).getText();
						String brojTelefona = ((JFormattedTextField) telefon)
								.getText();
						List<Narudzbenica> narudzbe = new ArrayList<Narudzbenica>();
						if (validacijaOnClick()) {
							if (kf.dodajKlijenta(ime, prezime, brojTelefona,
									adresa, email, narudzbe))
								MessageBox.infoBox(frame,
										"Klijent je uspješno kreiran.", "Info");
							frame.dispose();
							parentFrame.setEnabled(true);
							parentFrame.setVisible(true);
						} else
							MessageBox.infoBox(frame,
									"Molimo unesite sve podatke.", "Greska");
					}
				}
				if (akcija.equals("Modifikovanje")) {

					klijent.setIme(((JTextField) txtFdsfd).getText());
					klijent.setPrezime(((JTextField) textField_1).getText());
					klijent.setAdresa(((JTextField) textField_3).getText());
					klijent.setEmail(((JTextField) textField_4).getText());
					klijent.setBrojTelefona(((JFormattedTextField) telefon)
							.getText());
					if (validacijaOnClick()) {
						kf.mijenjajKlijenta(klijent);
						MessageBox.infoBox(frame,
								"Podaci o klijentu su uspješno izmijenjeni",
								"Info");
						frame.dispose();
						parentFrame.setEnabled(true);
						parentFrame.setVisible(true);
					} else
						MessageBox.infoBox(frame,
								"Molimo unesite sve podatke.", "Greska");
				}

				if (akcija.equals("Brisanje")) {
					kf.obrisiOsobu(klijent);
					MessageBox.infoBox(frame, "Klijent je uspješno obrisan",
							"Info");
					frame.dispose();
					parentFrame.setEnabled(true);
					parentFrame.setVisible(true);

				}
				if (akcija.equals("Pregled")) {
					frame.dispose();
					parentFrame.setEnabled(true);
					parentFrame.setVisible(true);
				}

			}
		});
		btnKreiraj.setBounds(190, 204, 130, 22);
		panel.add(btnKreiraj);
		MaskFormatter mf1 = new MaskFormatter();
		try {
			mf1 = new MaskFormatter("+###-##-###-###");
		} catch (Exception e) {

		}

		mf1.setPlaceholderCharacter('_');
		telefon = new JFormattedTextField(mf1);
		telefon.setBounds(133, 106, 187, 20);
		panel.add(telefon);

	}

	public void popuniPodatke() {
		txtFdsfd.setText(klijent.getIme());
		textField_1.setText(klijent.getPrezime());
		textField_3.setText(klijent.getAdresa());
		textField_4.setText(klijent.getEmail());
		telefon.setText(klijent.getBrojTelefona());
	}

	public boolean validacijaOnClick() {

		if (!imeVal.verify(txtFdsfd))
			return false;
		if (!prezimeVal.verify(textField_1))
			return false;
		if (!adresaVal.verify(textField_3))
			return false;
		if (!emailVal.verify(textField_4))
			return false;
		if (!telefonVal.verify(telefon))
			return false;

		Boolean da = true;
		if (txtFdsfd.getText().equals("") || textField_1.getText().equals("")
				|| telefon.getText().equals("")
				|| textField_4.getText().equals("")
				|| textField_3.getText().equals(""))
			da = false;
		return da;
	}

	public void postaviKorisnika(Osoba os) {
		trenutniKorisnik = os;
	}
}