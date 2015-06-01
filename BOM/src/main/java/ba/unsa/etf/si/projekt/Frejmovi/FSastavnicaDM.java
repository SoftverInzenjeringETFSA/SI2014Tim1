package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.Klase.Osoba;
import ba.unsa.etf.si.projekt.Klase.Radnik;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.Klase.StavkaNarudzbenice;
import ba.unsa.etf.si.projekt.Klase.StavkaSastavnice;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.KompanijaFacade;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;
import ba.unsa.etf.si.projekt.Validacija.Validator;

import com.toedter.calendar.JCalendar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FSastavnicaDM {

	private JFrame frame;
	final static Logger logger = Logger.getLogger(FSastavnicaDM.class);
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
	private Sastavnica sastavnica;
	public Osoba trenutniKorisnik;
	public DefaultTableModel model;
	private JScrollPane scrollPane;
	private List<Materijal> listaMaterijala;
	private List<StavkaSastavnice> stavkeSastavnice;
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
					logger.error("Greska: ", e);
				}
				
				try {
					FSastavnicaDM window = new FSastavnicaDM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.error("Greska: ", e);
				}
			}
		});
	}
	
	public void setFrame(JFrame parentF, String akcijaA, Sastavnica s)
	{
		
		akcija = akcijaA;
		sastavnica=s;
		textField_1.setEditable(false);
		
		if(akcija.equals("Kreiranje"))
		{
			stavkeSastavnice = new ArrayList<StavkaSastavnice>();
			btnKreirajSastavnicu.setText("Kreiraj");
			popuniTabelu();
			sastavnica = new Sastavnica();
		    	
		}
		else if(akcija.equals("Modifikovanje"))
		{
			stavkeSastavnice = sastavnica.getStavke_sas();
			popuniTabelu();
			
			textField.setText(sastavnica.getNaziv());
			spinner_1.setValue(sastavnica.getTrajanjeProizvodnje());
			spinner_2.setValue(sastavnica.getCijenaObavljenogRada());
			textField_1.setText(String.valueOf(sastavnica.getUkupnaCijena()));
			spinner_3.setValue(sastavnica.getDodatniTroskovi());
		    spinner_4.setValue(sastavnica.getOtpad());
			btnKreirajSastavnicu.setText("Modifikuj");
		}
			
			
		panel.setBorder(BorderFactory.createTitledBorder(akcija + " sastavnice"));
		parentFrame = parentF;
		parentFrame.setEnabled(false);
		frame.setVisible(true);
		popuniSerBroj();
	}

	/**
	 * Create the application.
	 */
	public FSastavnicaDM() {
		
		initialize();
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	
		    	parentFrame.setEnabled(true);
		    	parentFrame.setVisible(true);
		    	
		    }
		    @Override
		    public void windowActivated(java.awt.event.WindowEvent windowEvent) {
		    	
		    	textField.requestFocusInWindow();
		    }
		});
		
		textField.setInputVerifier(new Validator(frame,textField,"Naziv proizvoda ne smije biti prazan!","prazno"));
		
		textField_2 = new JTextField();
		textField_2.setBounds(180, 33, 290, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSerijskiBroj = new JLabel("Serijski broj:");
		lblSerijskiBroj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSerijskiBroj.setBounds(26, 36, 144, 14);
		panel.add(lblSerijskiBroj);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 919, 632);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Kreiranje sastavnice"));
		panel.setBounds(12, 13, 891, 574);
		frame.getContentPane().add(panel);
		
		JLabel lblNazivProizvoda = new JLabel("Naziv proizvoda:");
		lblNazivProizvoda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNazivProizvoda.setBounds(14, 69, 156, 16);
		panel.add(lblNazivProizvoda);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(180, 66, 290, 22);
		panel.add(textField);
		
		JLabel lblOdgovornoLice = new JLabel("Odgovorno lice:");
		lblOdgovornoLice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOdgovornoLice.setBounds(524, 35, 155, 16);
		panel.add(lblOdgovornoLice);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder("Materijali/poluproizvodi (stavke)"));
		panel_1.setBounds(14, 112, 865, 277);
		panel.add(panel_1);
		
		JLabel lblMaterijalpoluproizvod = new JLabel("Stavka:");
		lblMaterijalpoluproizvod.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaterijalpoluproizvod.setBounds(12, 35, 144, 16);
		panel_1.add(lblMaterijalpoluproizvod);
		 
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(168, 32, 341, 22);
		popuniCStavke();
		panel_1.add(comboBox_1);
		
		JLabel label_3 = new JLabel("Koli\u010Dina:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(557, 35, 111, 16);
		panel_1.add(label_3);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 1000000, 1));
		spinner.setBounds(680, 32, 173, 22);
		panel_1.add(spinner);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 105, 841, 120);
		panel_1.add(scrollPane);
		
		JButton btnDodajStavku = new JButton("Dodaj stavku");
		btnDodajStavku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//dodavanje stavke
				if(comboBox_1.getSelectedIndex() > 0)
				{
					int indexMat = comboBox_1.getSelectedIndex()-1;
					boolean dodano = false;
					for(StavkaSastavnice s : stavkeSastavnice)
					{
						if(s.getMaterijal().getId() == listaMaterijala.get(indexMat).getId())
						{
							s.setKolicina(s.getKolicina() + (Integer)spinner.getValue());
							izracunajCijenu();
							popuniTabelu();
							dodano = true;
							break;
						}
					}
					if(!dodano)//ako nije bilo u listi
					{
						StavkaSastavnice ss = new StavkaSastavnice();
						ss.setMaterijal(listaMaterijala.get(indexMat));
						ss.setKolicina((Integer)spinner.getValue());
						//ss.setSastavnica(sastavnica);
						//ss.setId(id);
						stavkeSastavnice.add(ss);
						izracunajCijenu();
						popuniTabelu();
					}
				}
			}
		});
		btnDodajStavku.setBounds(680, 67, 173, 25);
		panel_1.add(btnDodajStavku);
		
		JButton btnIzbaciStavku = new JButton("Izbaci stavku");
		btnIzbaciStavku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//izbacivanje stavke
				if(table.getSelectedRow() >= 0)
				{
					int indexStavke = table.getSelectedRow();
					stavkeSastavnice.remove(stavkeSastavnice.get(indexStavke));
					izracunajCijenu();
					popuniTabelu();
				}
			}
		});
		btnIzbaciStavku.setBounds(680, 239, 173, 25);
		panel_1.add(btnIzbaciStavku);
		
		JLabel label_4 = new JLabel("Ukupna cijena:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(139, 485, 96, 16);
		panel.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(247, 482, 130, 22);
		panel.add(textField_1);
		
		JLabel label_5 = new JLabel("Trajanje proizvodnje:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(14, 418, 221, 16);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("h");
		label_6.setBounds(387, 418, 19, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("KM");
		label_7.setBounds(389, 485, 56, 16);
		panel.add(label_7);
		
		
		
		btnKreirajSastavnicu = new JButton("Kreiraj");
		btnKreirajSastavnicu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(akcija.equals("Kreiranje"))
				{
					if(stavkeSastavnice.size()>0)
					{
						popuniSastavnicu();
						SkladisteFacade sf = new SkladisteFacade();
						sf.dodajSastavnicu(sastavnica);
						MessageBox.infoBox(frame, "Uspješno ste kreirali sastavnicu.", "Info");
						
						frame.dispose(); 
						parentFrame.setVisible(true);
						parentFrame.setEnabled(true);
					}
					else
					{
						MessageBox.infoBox(frame, "Sastavnica mora sadržavati barem jednu stavku.", "Info");
					}
					
				}
				else if(akcija.equals("Modifikovanje"))
				{
					
					if(stavkeSastavnice.size()>0)
					{
						popuniSastavnicu();
						SkladisteFacade sf = new SkladisteFacade();
						sf.izmijeniSastavnicu(sastavnica);
						MessageBox.infoBox(frame, "Uspješno ste modifikovali sastavnicu.", "Info");
						
						frame.dispose(); 
						parentFrame.setVisible(true);
						parentFrame.setEnabled(true);
					}
					else
					{
						MessageBox.infoBox(frame, "Sastavnica mora sadržavati barem jednu stavku.", "Info");
					}
				}
			}
		});
		btnKreirajSastavnicu.setBounds(691, 517, 178, 25);
		panel.add(btnKreirajSastavnicu);
		
		textField_3 = new JTextField();
		textField_3.setBounds(691, 32, 178, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCijenaObavljenogRada = new JLabel("Cijena obavljenog rada:");
		lblCijenaObavljenogRada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCijenaObavljenogRada.setBounds(14, 451, 221, 16);
		panel.add(lblCijenaObavljenogRada);
		
		JLabel lblKmh = new JLabel("KM/h");
		lblKmh.setBounds(387, 451, 56, 16);
		panel.add(lblKmh);
		
		JLabel lblDodatniTrokovi = new JLabel("Dodatni tro\u0161kovi:");
		lblDodatniTrokovi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDodatniTrokovi.setBounds(510, 418, 184, 16);
		panel.add(lblDodatniTrokovi);
		
		JLabel lblKm = new JLabel("KM");
		lblKm.setBounds(854, 418, 37, 16);
		panel.add(lblKm);
		
		JLabel lblOtpad = new JLabel("Otpad:");
		lblOtpad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOtpad.setBounds(638, 451, 56, 16);
		panel.add(lblOtpad);
		
		JLabel label = new JLabel("%");
		label.setBounds(854, 451, 37, 16);
		panel.add(label);
		
		spinner_1 = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		spinner_1.addChangeListener(new ChangeListener() {

	        public void stateChanged(ChangeEvent e) {
	        	izracunajCijenu();
	        }
	    });
		spinner_1.setBounds(247, 416, 130, 20);
		panel.add(spinner_1);
		spinner_2 = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 50.0, 0.0001));
		spinner_2.addChangeListener(new ChangeListener() {

	        public void stateChanged(ChangeEvent e) {
	        	izracunajCijenu();
	        }
	    });
		spinner_2.setBounds(247, 449, 130, 20);
		panel.add(spinner_2);
		spinner_3 = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 100000.0, 0.0001));
		spinner_3.addChangeListener(new ChangeListener() {

	        public void stateChanged(ChangeEvent e) {
	        	izracunajCijenu();
	        }
	    });
		spinner_3.setBounds(706, 416, 136, 20);
		panel.add(spinner_3);
		spinner_4 = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 20.0, 0.1));
		spinner_4.addChangeListener(new ChangeListener() {

	        public void stateChanged(ChangeEvent e) {
	        	izracunajCijenu();
	        }
	    });
		spinner_4.setBounds(706, 449, 136, 20);
		panel.add(spinner_4);
	}
	public void postaviKorisnika(Osoba os)
	{ 
		trenutniKorisnik=os;
		//samo radnik moze otvarati ovu formu
		textField_3.setText(((Radnik)trenutniKorisnik).getUsername());
		textField_3.setEditable(false);
		sastavnica.setIzdao((Radnik)trenutniKorisnik);
	}
	public void popuniTabelu() {
		
		Object columnsName[] = { "Serijski broj", "Naziv", "Količina", "Tip", "Cijena"};
		Object rows[][] = new Object[stavkeSastavnice.size()][5];
		
		for (int i = 0; i < stavkeSastavnice.size(); i++)
		{
			rows[i][0] = stavkeSastavnice.get(i).getMaterijal().getSerijskiBroj();
	        rows[i][1] = stavkeSastavnice.get(i).getMaterijal().getOpis();
		    rows[i][2] = stavkeSastavnice.get(i).getKolicina();
			rows[i][3] = stavkeSastavnice.get(i).getMaterijal().getTip();
			rows[i][4] = stavkeSastavnice.get(i).getMaterijal().getProdajnaCijena();
		}
		
		table = new JTable(rows, columnsName);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		for (int i = 0; i < table.getColumnCount(); i++) 
		{ 
			Class<?> col_class = table.getColumnClass(i); 
			table.setDefaultEditor(col_class, null);
		}

		scrollPane.setViewportView(table);
	}
	private void popuniSerBroj()
	{
		textField_2.setEditable(false);
		if(akcija.equals("Kreiranje"))
		{
			SkladisteFacade sf = new SkladisteFacade();
		    String s = "SAS00" + Integer.toString(sf.sortirajSastavnice(null,null,null).size()+1);
		    sastavnica.setSerijskiBroj(s);
		    textField_2.setText(s);
		}
		else if(akcija.equals("Modifikovanje"))
		{
			textField_2.setText(sastavnica.getSerijskiBroj());
		}
	}
	private void izracunajCijenu()
	{
		double trajanjeProizvodnje = (Double)spinner_1.getModel().getValue();
		double cijenaPoSatu = (Double)spinner_2.getValue();
		double dodatno = (Double)spinner_3.getModel().getValue();
		
		//racunanje cijene svake stavke sastavnice
		double cijena = 0;
		for(StavkaSastavnice s : stavkeSastavnice)
			cijena += s.getKolicina() * s.getMaterijal().getProdajnaCijena();
		
		cijena += trajanjeProizvodnje * cijenaPoSatu + dodatno;
		textField_1.setText(String.valueOf((double)Math.round(cijena * 1000) / 1000));
		
		sastavnica.setCijenaObavljenogRada(cijenaPoSatu);
		sastavnica.setDodatniTroskovi(dodatno);
		sastavnica.setTrajanjeProizvodnje(trajanjeProizvodnje);
		sastavnica.setUkupnaCijena(cijena);
	}
	private void popuniSastavnicu()
	{
		double otpad = (Double)spinner_4.getModel().getValue();
		sastavnica.setNaziv(textField.getText());
		sastavnica.setOtpad(otpad);
		sastavnica.setDatumKreiranja(new Date());
		for(StavkaSastavnice s : stavkeSastavnice)
			s.setSastavnica(sastavnica);
		sastavnica.setStavke_sas(stavkeSastavnice);
	}
	private void popuniCStavke()
	{
		SkladisteFacade sf = new SkladisteFacade();
		listaMaterijala = sf.returnListaMaterijala();
		comboBox_1.addItem("");
		for(Materijal m : listaMaterijala)
			comboBox_1.addItem(m.getSerijskiBroj()+" "+m.getOpis());
	}
}







