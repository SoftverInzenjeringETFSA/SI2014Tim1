package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.Color;
import java.awt.EventQueue;
import java.math.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;

import ba.unsa.etf.si.projekt.Klase.Klijent;
import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.Klase.Narudzbenica;
import ba.unsa.etf.si.projekt.Klase.Osoba;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.Klase.StavkaNarudzbenice;
import ba.unsa.etf.si.projekt.Klase.TipOsobe;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.KompanijaFacade;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class FNarudzbenicaD {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JFrame parentFrame;
	private List<Sastavnica> listaSastavnica;
	private List<Klijent> listaKlijenata;
	private JComboBox comboBox_1;
	private JSpinner spinner;
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	public Integer brojRedova;
	public DefaultTableModel model;
	public Double ukupnaCijena = (double) 0;;
	public Double ukupnoTrajanje = (double) 0;
	private JTextField serijskiBroj;;
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
					FNarudzbenicaD window = new FNarudzbenicaD();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setFrame(JFrame parentF, String akcijaA, String klasa) {
		parentFrame = parentF;
		parentFrame.setEnabled(false);
		frame.setVisible(true);
		
	}

	/**
	 * Create the application.
	 */
	public FNarudzbenicaD() {
		initialize();

		vratiSastavnice();
		popuniSastavnice();
		kreirajTabelu();
		vratiKlijente();
		popuniKlijente();

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
		frame.setBounds(100, 100, 816, 552);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 786, 494);
		panel.setBorder(BorderFactory
				.createTitledBorder("Kreiranje narudžbenice"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblOdgovornoLice = new JLabel("Odgovorno lice:");
		lblOdgovornoLice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOdgovornoLice.setBounds(12, 47, 169, 16);
		panel.add(lblOdgovornoLice);

		textField = new JTextField();
		textField.setBounds(193, 44, 195, 22);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblKlijent = new JLabel("Klijent:");
		lblKlijent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKlijent.setBounds(400, 47, 68, 16);
		panel.add(lblKlijent);

		// SkladisteFacade sf = new SkladisteFacade();
		// List<Materijal> materijali = sf.returnListaMaterijala();

		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(480, 44, 283, 22);
		panel.add(comboBox);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 99, 762, 277);
		panel_1.setBorder(BorderFactory.createTitledBorder("Proizvodi"));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblProizvod = new JLabel("Proizvod:");
		lblProizvod.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProizvod.setBounds(12, 35, 110, 16);
		panel_1.add(lblProizvod);

		comboBox_1 = new JComboBox();
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(134, 32, 315, 22);
		panel_1.add(comboBox_1);

		JLabel lblKoliina = new JLabel("Koli\u010Dina:");
		lblKoliina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKoliina.setBounds(461, 35, 104, 16);
		panel_1.add(lblKoliina);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1),
				null, new Integer(1)));
		spinner.setBounds(577, 32, 173, 22);
		panel_1.add(spinner);
		if ( spinner.getEditor() instanceof JSpinner.DefaultEditor ) {
			   JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) spinner.getEditor();
			   editor.getTextField().setEditable( false );
			   editor.getTextField().setBackground(Color.white);
			}

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 105, 738, 120);
		panel_1.add(scrollPane);

		JButton btnDodajProizvod = new JButton("Dodaj proizvod");
		btnDodajProizvod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Integer i = comboBox_1.getSelectedIndex();
				Double x = listaSastavnica.get(i).getUkupnaCijena();
				Double y = Double.parseDouble(spinner.getValue().toString());
				ukupnaCijena = ukupnaCijena + (x * y);
				ukupnoTrajanje = ukupnoTrajanje
						+ listaSastavnica.get(i).getTrajanjeProizvodnje() * y;
				textField_1.setText(Double.toString(ukupnaCijena));
				textField_2.setText(Double.toString(ukupnoTrajanje));

				model.addRow(new Object[] { listaSastavnica.get(i).getNaziv(),
						listaSastavnica.get(i).getSerijskiBroj(),
						listaSastavnica.get(i).getUkupnaCijena(),
						listaSastavnica.get(i).getTrajanjeProizvodnje(),
						spinner.getValue() });
				table = new JTable(model);
				scrollPane.setViewportView(table);

			}
		});
		btnDodajProizvod.setBounds(599, 67, 151, 25);
		panel_1.add(btnDodajProizvod);

		JButton btnIzbaciProizvod = new JButton("Izbaci proizvod");
		btnIzbaciProizvod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRowCount() != 1) {
					MessageBox.infoBox(frame, "Morate označiti jedan red",
							"Info");
				} else {
					Double kolicina = Double.parseDouble(table.getValueAt(
							table.getSelectedRow(), 4).toString());
					Double x = Double.parseDouble(table.getValueAt(
							table.getSelectedRow(), 2).toString());
					Double y = Double.parseDouble(table.getValueAt(
							table.getSelectedRow(), 3).toString());
					model.removeRow(table.getSelectedRow());
					table = new JTable(model);
					scrollPane.setViewportView(table);
					ukupnaCijena = ukupnaCijena - (x * kolicina);
					ukupnoTrajanje = ukupnoTrajanje - y * kolicina;

					textField_1.setText(Double.toString(ukupnaCijena));
					textField_2.setText(Double.toString(ukupnoTrajanje));
				}
			}
		});
		btnIzbaciProizvod.setBounds(599, 238, 151, 25);
		panel_1.add(btnIzbaciProizvod);

		JLabel lblUkupnaCijena = new JLabel("Ukupna cijena:");
		lblUkupnaCijena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUkupnaCijena.setBounds(12, 401, 102, 16);
		panel.add(lblUkupnaCijena);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(124, 398, 118, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblTrajanjeProizvodnje = new JLabel("Trajanje proizvodnje:");
		lblTrajanjeProizvodnje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrajanjeProizvodnje.setBounds(294, 401, 118, 16);
		panel.add(lblTrajanjeProizvodnje);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(422, 398, 86, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblH = new JLabel("h");
		lblH.setBounds(518, 401, 20, 16);
		panel.add(lblH);

		JLabel lblKm = new JLabel("KM");
		lblKm.setBounds(252, 401, 32, 16);
		panel.add(lblKm);

		JButton button = new JButton("Kreiraj");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<StavkaNarudzbenice> stav_nar=new ArrayList<StavkaNarudzbenice>();
				StavkaNarudzbenice sn;
				SkladisteFacade kf=new SkladisteFacade();
				KompanijaFacade f=new KompanijaFacade();
				for(int i=0;i<table.getSelectedRowCount();i++)
				{
					
			sn=new StavkaNarudzbenice(kf.pretragaSastavnica(table.getValueAt(i, 1).toString()), Double.parseDouble(table.getValueAt(i, 4).toString()));
			stav_nar.add(sn);
				}
				   Date date = new Date();
				   Calendar cal = Calendar.getInstance();
				   Narudzbenica narudzbenica=new Narudzbenica();
				   narudzbenica.setStav_nar(stav_nar);
				   narudzbenica.setKlijent(listaKlijenata.get(comboBox.getSelectedIndex()));
				   narudzbenica.setDatumKreiranja(cal.getTime());
				   narudzbenica.setOdgovornoLice((Menadzer)trenutniKorisnik);
				   narudzbenica.setSerijskiBroj(serijskiBroj.getText());
			      	if(kf.validirajNarudzbenicu(narudzbenica)){
			            kf.dodajNarudzbenicu(narudzbenica);				  
				   MessageBox.infoBox(frame, "Narudžbenica je uspješno kreirana","Info");			   
				}
				   else MessageBox.infoBox(frame, "Narudžbenica ne može biti kreirana zbog nedostatka materjala","Info");
			}
		});
		button.setBounds(612, 444, 151, 25);
		panel.add(button);
		
		serijskiBroj = new JTextField();
		serijskiBroj.setBounds(631, 399, 118, 20);
		panel.add(serijskiBroj);
		serijskiBroj.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Serijski broj");
		lblNewLabel.setBounds(572, 401, 86, 19);
		panel.add(lblNewLabel);

	}

	public void vratiSastavnice() {
		listaSastavnica = new ArrayList<Sastavnica>();
		SkladisteFacade sf = new SkladisteFacade();
		listaSastavnica = sf.returnListaSastavnica();
	}

	public void popuniSastavnice() {
		for (int i = 0; i < listaSastavnica.size(); i++)
			comboBox_1.addItem(listaSastavnica.get(i).getNaziv());
	}

	public void vratiKlijente() {
		KompanijaFacade kf = new KompanijaFacade();
		List<Osoba> klijenti = new ArrayList<Osoba>();
		listaKlijenata = new ArrayList<Klijent>();
		klijenti = kf.listaOsoba(TipOsobe.klijent);
		for (int i = 0; i < klijenti.size(); i++)
			listaKlijenata.add((Klijent) klijenti.get(i));

	}

	public void popuniKlijente() {
		for (int i = 0; i < listaKlijenata.size(); i++)
			comboBox.addItem(listaKlijenata.get(i).getIme() + " "
					+ listaKlijenata.get(i).getPrezime());
	}

	public void kreirajTabelu() {
		textField_1.setText(Double.toString(ukupnaCijena));
		textField_2.setText(Double.toString(ukupnoTrajanje));
		model = new DefaultTableModel();
		model.addColumn("Naziv");
		model.addColumn("Serijski broj");
		model.addColumn("Cijena");
		model.addColumn("Trajanje proizvodnje");
		model.addColumn("Količina");
		table = new JTable(model);
		scrollPane.setViewportView(table);

	}
	public void postaviKorisnika(Osoba os)
	{trenutniKorisnik=os;
	
	}
}
