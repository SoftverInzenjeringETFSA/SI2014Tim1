package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.Color;
import java.awt.EventQueue;
import java.math.*;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import ba.unsa.etf.si.projekt.Validacija.Validator;

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

import org.apache.log4j.Logger;

public class FNarudzbenicaD {

	private JFrame frame;
	final static Logger logger = Logger.getLogger(FNarudzbenicaD.class);
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
	public Double ukupnaCijena = (double) 0;
	public Double ukupnoTrajanje = (double) 0;
	private JTextField serijskiBroj;
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
					logger.error("Greska: ", e);
				}

				try {
					FNarudzbenicaD window = new FNarudzbenicaD();
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.error("Greska: ", e);
				}
			}
		});
	}

	public void setFrame(JFrame parentF, String akcijaA, String nista) {
		parentFrame = parentF;
		parentFrame.setEnabled(false);
		frame.setVisible(true);
		
		
	}
	InputVerifier serijaVal;
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
		serijaVal = new Validator(frame,serijskiBroj , "Serijski broj može sadržavati samo slova i brojeve engleske abecede te treba početi sa slovom",
				"serija");
		serijskiBroj.setInputVerifier(serijaVal);
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
		lblOdgovornoLice.setBounds(12, 28, 169, 16);
		panel.add(lblOdgovornoLice);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(191, 25, 195, 22);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblKlijent = new JLabel("Klijent:");
		lblKlijent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKlijent.setBounds(396, 28, 68, 16);
		panel.add(lblKlijent);

		// SkladisteFacade sf = new SkladisteFacade();
		// List<Materijal> materijali = sf.returnListaMaterijala();

		comboBox = new JComboBox();
		comboBox.setBounds(474, 25, 283, 22);
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
				Integer ind=-1;
				for(int j=0;j<table.getRowCount();j++)
				{
					if(table.getValueAt(j, 1).equals(listaSastavnica.get(i).getSerijskiBroj()))
					{  
						Double h = Double.parseDouble(table.getValueAt(j, 4).toString()) +Double.parseDouble(spinner.getValue().toString())	;					
					    ind=j;
					    table.setValueAt(h, ind, 4);
					}
				}
				if(ind==-1){
				model.addRow(new Object[] { listaSastavnica.get(i).getNaziv(),
						listaSastavnica.get(i).getSerijskiBroj(),
						listaSastavnica.get(i).getUkupnaCijena(),
						listaSastavnica.get(i).getTrajanjeProizvodnje(),
						spinner.getValue() });
				table = new JTable(model);
				 table.setRowSelectionAllowed(true);
				scrollPane.setViewportView(table);
				
			}
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
					 table.setRowSelectionAllowed(true);
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
		lblUkupnaCijena.setBounds(30, 401, 151, 16);
		panel.add(lblUkupnaCijena);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(191, 398, 153, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblTrajanjeProizvodnje = new JLabel("Trajanje proizvodnje:");
		lblTrajanjeProizvodnje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrajanjeProizvodnje.setBounds(396, 401, 204, 16);
		panel.add(lblTrajanjeProizvodnje);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(612, 398, 133, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblH = new JLabel("h");
		lblH.setBounds(757, 401, 20, 16);
		panel.add(lblH);

		JLabel lblKm = new JLabel("KM");
		lblKm.setBounds(354, 401, 32, 16);
		panel.add(lblKm);

		
		JButton button = new JButton("Kreiraj");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SkladisteFacade kf=new SkladisteFacade();
				if(serijskiBroj.getText().isEmpty() || serijskiBroj.getText().contains(" "))
				{
					MessageBox.infoBox(frame, "Unesite serijski broj.", "Info");
				}
				else if (!serijaVal.verify(serijskiBroj))					
				{
					MessageBox.infoBox(frame, "Unesite ispravan serijski broj.", "Info");
				}
				else if(kf.pretragaNarudzbenica(serijskiBroj.getText())!=null)
						{
					MessageBox.infoBox(frame, "Narudžbenica sa ovim serijskim brojem je već kreirana.Izmjenu možete izvršiti preko prethodnog prozora.","Info");
						}
						 else{
				List<StavkaNarudzbenice> stav_nar=new ArrayList<StavkaNarudzbenice>();
				StavkaNarudzbenice sn;		
				if(table.getRowCount()==0)  MessageBox.infoBox(frame, "Morate unijeti barem jedan proizvod","Info");
				else{
				for(int i=0;i<table.getRowCount();i++)
				{
			sn=new StavkaNarudzbenice(kf.pretragaSastavnica(table.getValueAt(i, 1).toString()), Double.parseDouble(table.getValueAt(i, 4).toString()));
			stav_nar.add(sn);
				}
				   Date date = new Date();
				   Calendar cal = Calendar.getInstance();
				   Narudzbenica narudzbenica=new Narudzbenica(stav_nar,listaKlijenata.get(comboBox.getSelectedIndex()),cal.getTime(), (Menadzer)trenutniKorisnik, serijskiBroj.getText());
				   for (int i=0;i<stav_nar.size();i++)
			    	   narudzbenica.getStav_nar().get(i).setNarudzbenica(narudzbenica);
				   if (kf.validirajNarudzbenicu(narudzbenica)) {
			            kf.dodajNarudzbenicu(narudzbenica);	
				   MessageBox.infoBox(frame, "Narudžbenica je uspješno kreirana","Info");
				   frame.dispose();
					parentFrame.setEnabled(true);
					parentFrame.setVisible(true);
				   
				}
				
				
		else {
			MessageBox.infoBox(frame, "Narudžbenica ne može biti kreirana zbog nedostatka materjala","Info");
			   frame.dispose(); 
			   parentFrame.setVisible(true);
			   parentFrame.setEnabled(true);
		}
			}
                   }	
				
			}
		});
		button.setBounds(612, 444, 151, 25);
		panel.add(button);
		
		serijskiBroj = new JTextField();
		serijskiBroj.setBounds(191, 66, 195, 22);
		panel.add(serijskiBroj);
		serijskiBroj.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Serijski broj:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(30, 69, 151, 19);
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
		
		Object[][] data = {};
	        String[] columnNames = {"Naziv", "Serijski broj","Cijena","Trajanje proizvodnje","Količina"};
		model = new DefaultTableModel(data, columnNames) {

            private static final long serialVersionUID = 1L;

            @Override
            public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
		
		
		
		
		/*model = new DefaultTableModel();
		model.addColumn("Naziv");
		model.addColumn("Serijski broj");
		model.addColumn("Cijena");
		model.addColumn("Trajanje proizvodnje");
		model.addColumn("Količina");*/
		table = new JTable(model);
		table.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table);

	}
	public void postaviKorisnika(Osoba os)
	{ 
		trenutniKorisnik=os;
		textField.setText(trenutniKorisnik.getIme()+" "+ trenutniKorisnik.getPrezime());
		textField.setEditable(false);
	}
}
