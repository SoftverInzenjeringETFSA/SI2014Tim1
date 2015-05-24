package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.Klase.Osoba;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.Klase.StavkaNarudzbenice;
import ba.unsa.etf.si.projekt.Klase.StavkaSastavnice;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.KompanijaFacade;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;
import ba.unsa.etf.si.projekt.Validacija.Validator;

import com.toedter.calendar.JCalendar;

public class FSastavnicaDM {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JSpinner spinner_3;
	private JSpinner spinner_4;
	private JTable table;
	private JFrame parentFrame;
	private String akcija;
	private JButton btnKreirajSastavnicu;
	private JPanel panel;
	//public Sastavnica sastavnica;
	//List<Sastavnica> sastavnice;
	//List<StavkaSastavnice> stavka;
	//List <String> listaSerBr;
	public Osoba trenutniKorisnik;
	public DefaultTableModel model;
	private JScrollPane scrollPane;
	private List<Materijal> listaMaterijala;
	private JComboBox comboBox_1;
	public Double ukupnaCijena = (double) 0;
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
					FSastavnicaDM window = new FSastavnicaDM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setFrame(JFrame parentF, String akcijaA, Sastavnica s)
	{
		
		akcija = akcijaA;
		
		if(akcija.equals("Kreiranje"))
		{
			
			btnKreirajSastavnicu.setText("Kreiraj");
		    	
		}
		else if(akcija.equals("Modifikovanje"))
		{
			
			btnKreirajSastavnicu.setText("Modifikuj");
		}
			
			
		panel.setBorder(BorderFactory.createTitledBorder(akcija + " sastavnice"));
		parentFrame = parentF;
		parentFrame.setEnabled(false);
		frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public FSastavnicaDM() {
		initialize();
		vratiMaterijale();
		popuniMaterijale();
		kreirajTabelu();
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	
		    	parentFrame.setEnabled(true);
		    	parentFrame.setVisible(true);
		    	
		    }
		});
		textField.setInputVerifier(new Validator(frame,textField,"Molimo da popunite ovo polje",""));
		
		textField_2 = new JTextField();
		textField_2.setBounds(107, 29, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSerijskiBroj = new JLabel("Serijski broj:");
		lblSerijskiBroj.setBounds(26, 32, 71, 14);
		panel.add(lblSerijskiBroj);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 919, 611);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Kreiranje sastavnice"));
		panel.setBounds(12, 13, 891, 569);
		frame.getContentPane().add(panel);
		
		JLabel lblNazivProizvoda = new JLabel("Naziv proizvoda:");
		lblNazivProizvoda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNazivProizvoda.setBounds(14, 69, 156, 16);
		panel.add(lblNazivProizvoda);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(180, 66, 342, 22);
		panel.add(textField);
		
		JLabel lblOdgovornoLice = new JLabel("Odgovorno lice:");
		lblOdgovornoLice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOdgovornoLice.setBounds(522, 47, 155, 16);
		panel.add(lblOdgovornoLice);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder("Materijali/poluproizvodi (stavke)"));
		panel_1.setBounds(12, 99, 865, 277);
		panel.add(panel_1);
		
		JLabel lblMaterijalpoluproizvod = new JLabel("Stavka:");
		lblMaterijalpoluproizvod.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaterijalpoluproizvod.setBounds(12, 35, 144, 16);
		panel_1.add(lblMaterijalpoluproizvod);
		 
		comboBox_1 = new JComboBox();
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(168, 32, 341, 22);
		panel_1.add(comboBox_1);
		
		JLabel label_3 = new JLabel("Koli\u010Dina:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(557, 35, 111, 16);
		panel_1.add(label_3);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(680, 32, 173, 22);
		panel_1.add(spinner);
		if ( spinner.getEditor() instanceof JSpinner.DefaultEditor ) {
			   JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) spinner.getEditor();
			   editor.getTextField().setEditable( false );
			   editor.getTextField().setBackground(Color.white);
			}
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 105, 841, 120);
		panel_1.add(scrollPane);
		
		JButton btnDodajStavku = new JButton("Dodaj stavku");
		btnDodajStavku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer i = comboBox_1.getSelectedIndex();
				Double x = listaMaterijala.get(i).getNabavnaCijena();
				Double y = Double.parseDouble(spinner.getValue().toString());
				ukupnaCijena = ukupnaCijena + (x * y) + (Double)spinner_2.getValue()*(Double)spinner_1.getValue()+(Double)spinner_3.getValue();
				textField_1.setText(Double.toString(ukupnaCijena));

				model.addRow(new Object[] { 
						listaMaterijala.get(i).getSerijskiBroj(),
						listaMaterijala.get(i).getOpis(),
						listaMaterijala.get(i).getTip(),
						spinner.getValue(),
						listaMaterijala.get(i).getNabavnaCijena()
						 });
				table = new JTable(model);
				scrollPane.setViewportView(table);
			}
		});
		btnDodajStavku.setBounds(680, 67, 173, 25);
		panel_1.add(btnDodajStavku);
		
		JButton btnIzbaciStavku = new JButton("Izbaci stavku");
		btnIzbaciStavku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRowCount() != 1) {
					MessageBox.infoBox(frame, "Morate označiti jedan red",
							"Info");
				} else {
					
					Double x = Double.parseDouble(table.getValueAt(
							table.getSelectedRow(), 3).toString());
					Double y = Double.parseDouble(table.getValueAt(
							table.getSelectedRow(), 4).toString());
					model.removeRow(table.getSelectedRow());
					table = new JTable(model);
					scrollPane.setViewportView(table);
					ukupnaCijena = ukupnaCijena - (x * y) - (Double)spinner_2.getValue()*(Double)spinner_1.getValue() - (Double)spinner_3.getValue();

					textField_1.setText(Double.toString(ukupnaCijena));
				}
			}
		});
		btnIzbaciStavku.setBounds(680, 239, 173, 25);
		panel_1.add(btnIzbaciStavku);
		
		JLabel label_4 = new JLabel("Ukupna cijena:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(137, 495, 96, 16);
		panel.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(245, 492, 130, 22);
		panel.add(textField_1);
		
		JLabel label_5 = new JLabel("Trajanje proizvodnje:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(12, 395, 221, 16);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("h");
		label_6.setBounds(387, 395, 19, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("KM");
		label_7.setBounds(387, 495, 56, 16);
		panel.add(label_7);
		
		
		
		btnKreirajSastavnicu = new JButton("Kreiraj");
		btnKreirajSastavnicu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Sastavnica s = new Sastavnica ();
				SkladisteFacade sf= new SkladisteFacade();
				KompanijaFacade f=new KompanijaFacade();
				//kreiranje sastavnice....
				//public Sastavnica(List<StavkaSastavnice> stavke, Menadzer m, String sb, Date dk, double tp, double co, double dt, double uc, String naziv)
				if (akcija.equals("Kreiranje"))
				{
					List<StavkaSastavnice> stavke = new ArrayList<StavkaSastavnice>();
					StavkaSastavnice ss;
					
					for(int i=0;i<table.getSelectedRowCount();i++)
					{
						
						//ss=new StavkaSastavnice(sf.pretragaSastavnica(table.getValueAt(i, 1).toString()), Double.parseDouble(table.getValueAt(i, 4).toString()));
						//stav_nar.add(sn);
					}
					
				//s.setStavke_sas(stavka);
				s.setSerijskiBroj(textField_2.getText());
				s.setNaziv(textField.getText());
				s.setIzdao((Radnik)trenutniKorisnik);
				double trajanje = (Double)spinner_1.getValue();
				double cijena = (Double)spinner_2.getValue();
				double troskovi = (Double)spinner_3.getValue();
				double otpad = (Double)spinner_4.getValue();
				
				s.setCijenaObavljenogRada(cijena);
				s.setDodatniTroskovi(troskovi);
				s.setTrajanjeProizvodnje(trajanje);
				s.setOtpad(otpad);
				
				sf.dodajSastavnicu(s);
				}
				
				if(akcija.equals("Modifikovanje"))
				{
					s.setSerijskiBroj(textField_2.getText());
					s.setNaziv(textField.getText());
					s.setIzdao((Radnik)trenutniKorisnik);
					double trajanje = (Double)spinner_1.getValue();
					double cijena = (Double)spinner_2.getValue();
					double troskovi = (Double)spinner_3.getValue();
					double otpad = (Double)spinner_4.getValue();
					
					s.setCijenaObavljenogRada(cijena);
					s.setDodatniTroskovi(troskovi);
					s.setTrajanjeProizvodnje(trajanje);
					s.setOtpad(otpad);
				    sf.izmijeniSastavnicu(s);
				}
			}
		});
		btnKreirajSastavnicu.setBounds(745, 533, 117, 25);
		panel.add(btnKreirajSastavnicu);
		
		textField_3 = new JTextField();
		textField_3.setBounds(689, 44, 177, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCijenaObavljenogRada = new JLabel("Cijena obavljenog rada:");
		lblCijenaObavljenogRada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCijenaObavljenogRada.setBounds(12, 441, 221, 16);
		panel.add(lblCijenaObavljenogRada);
		
		JLabel lblKmh = new JLabel("KM/h");
		lblKmh.setBounds(387, 441, 56, 16);
		panel.add(lblKmh);
		
		JLabel lblDodatniTrokovi = new JLabel("Dodatni tro\u0161kovi:");
		lblDodatniTrokovi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDodatniTrokovi.setBounds(493, 395, 184, 16);
		panel.add(lblDodatniTrokovi);
		
		JLabel lblKm = new JLabel("KM");
		lblKm.setBounds(835, 395, 37, 16);
		panel.add(lblKm);
		
		JLabel lblOtpad = new JLabel("Otpad:");
		lblOtpad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOtpad.setBounds(621, 441, 56, 16);
		panel.add(lblOtpad);
		
		JLabel label = new JLabel("%");
		label.setBounds(835, 441, 37, 16);
		panel.add(label);
		
		JButton btnPoniti = new JButton("Poništi");
		btnPoniti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				spinner.setValue(0);
				spinner_1.setValue(0);
				spinner_2.setValue(0);
				spinner_3.setValue(0);
				spinner_4.setValue(0);
			}
		});
		btnPoniti.setBounds(598, 533, 124, 25);
		panel.add(btnPoniti);
		
		SpinnerNumberModel m_numberSpinnerModel;
		m_numberSpinnerModel = new SpinnerNumberModel(0.0, 0, 100000, 0.01);
		
		SpinnerNumberModel m_numberSpinnerModel_1;
		m_numberSpinnerModel_1 = new SpinnerNumberModel(0.0, 0, 100000, 0.01);
		
		SpinnerNumberModel m_numberSpinnerModel_2;
		m_numberSpinnerModel_2 = new SpinnerNumberModel(0.0, 0, 100000, 0.01);

		SpinnerNumberModel m_numberSpinnerModel_3;
		m_numberSpinnerModel_3 = new SpinnerNumberModel(0.0, 0, 100000, 0.1);
		
		spinner_1 = new JSpinner(new SpinnerNumberModel(1.0, 1.0, 100000.0, 0.0));
		spinner_1.setBounds(245, 393, 130, 20);
		panel.add(spinner_1);
		
		if ( spinner_1.getEditor() instanceof JSpinner.DefaultEditor ) {
			   JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) spinner_1.getEditor();
			   editor.getTextField().setEditable( false );
			   editor.getTextField().setBackground(Color.white);
			}
		spinner_2 = new JSpinner(new SpinnerNumberModel(1.0, 1.0, 100000.0, 0.0));
		spinner_2.setBounds(245, 439, 130, 20);
		panel.add(spinner_2);
		if ( spinner_2.getEditor() instanceof JSpinner.DefaultEditor ) {
			   JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) spinner_2.getEditor();
			   editor.getTextField().setEditable( false );
			   editor.getTextField().setBackground(Color.white);
			}
		spinner_3 = new JSpinner(m_numberSpinnerModel_1);
		spinner_3.setBounds(689, 393, 136, 20);
		panel.add(spinner_3);
		if ( spinner_3.getEditor() instanceof JSpinner.DefaultEditor ) {
			   JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) spinner_3.getEditor();
			   editor.getTextField().setEditable( false );
			   editor.getTextField().setBackground(Color.white);
			}
		spinner_4 = new JSpinner(m_numberSpinnerModel_2);
		spinner_4.setBounds(689, 439, 136, 20);
		panel.add(spinner_4);
		if ( spinner_4.getEditor() instanceof JSpinner.DefaultEditor ) {
			   JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) spinner_4.getEditor();
			   editor.getTextField().setEditable( false );
			   editor.getTextField().setBackground(Color.white);
			}
	}
	public void postaviKorisnika(Osoba os)
	{ 
		trenutniKorisnik=os;
		textField_3.setText(trenutniKorisnik.getIme()+" "+ trenutniKorisnik.getPrezime());
	}
	
	public void kreirajTabelu() {
		
		model = new DefaultTableModel();
		
		model.addColumn("Serijski broj");
		model.addColumn("Naziv");
		model.addColumn("Tip");
		model.addColumn("Količina");
		model.addColumn("Cijena");
		table = new JTable(model);
		scrollPane.setViewportView(table);

	}
	
	public void vratiMaterijale() {
		listaMaterijala = new ArrayList<Materijal>();
		SkladisteFacade sf = new SkladisteFacade();
		listaMaterijala = sf.returnListaMaterijala();
	}

	public void popuniMaterijale() {
		for (int i = 0; i < listaMaterijala.size(); i++)
			comboBox_1.addItem(listaMaterijala.get(i).getOpis());
	}
}
