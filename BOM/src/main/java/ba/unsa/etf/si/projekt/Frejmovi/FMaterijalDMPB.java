package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;





import java.util.ArrayList;
import java.util.Date;

import ba.unsa.etf.si.projekt.Klase.Kategorija;
import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.Klase.Osoba;
import ba.unsa.etf.si.projekt.Klase.Radnik;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.Klase.TipMaterijala;
import ba.unsa.etf.si.projekt.Klase.TipOsobe;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;
import ba.unsa.etf.si.projekt.Util.CijenaKalkulator;
import ba.unsa.etf.si.projekt.Validacija.Validator;

import com.toedter.calendar.JDateChooser;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import org.apache.log4j.Logger;

import java.util.List;

public class FMaterijalDMPB {

	private JFrame frame;
	final static Logger logger = Logger.getLogger(FMaterijalDMPB.class);
	private Java2sAutoComboBox comboBox;
	private Java2sAutoComboBox comboBox_1;
	private Java2sAutoComboBox comboBox_2;
	private Java2sAutoComboBox comboBox_3;
	private JDateChooser dateChooser;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JSpinner spinner_3;
	private String akcija;
	private JFrame parentFrame;
	private JButton btnUnesi;
	private JPanel panel;
	public Materijal materijal;
	List<Materijal> materijali;
	List <String> listaSerBr;
	List <String> listaNaziv;
	List <String> listaMJ;
	List <String> listaTip;
	public Osoba trenutniKorisnik;
	private JTextField textField;
	private JTextField textField_1;
	InputVerifier naziv;
	InputVerifier sB;
	
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
					FMaterijalDMPB window = new FMaterijalDMPB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.error("Greska: ", e);
				}
			}
		});
	}
	
	public void OnemoguciKontrole()
	{
		comboBox.setEditable(false);
		comboBox_1.setEditable(false);
		comboBox_2.setEditable(false);
		comboBox_3.setEditable(false);
		((JSpinner.DefaultEditor)spinner.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor)spinner_1.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor)spinner_2.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor)spinner_3.getEditor()).getTextField().setEditable(false);
		
		comboBox.setEnabled(false);
		comboBox_1.setEnabled(false);
		comboBox_2.setEnabled(false);
		comboBox_3.setEnabled(false);
		spinner.setEnabled(false);
		spinner_3.setEnabled(false);
		spinner_1.setEnabled(false);
		spinner_2.setEnabled(false);
		dateChooser.setEnabled(false);
	}
	
	public void IspisiVrijednosti(Materijal m)
	{
		comboBox.setSelectedItem(m.getSerijskiBroj());
		comboBox_1.setSelectedItem(m.getOpis());
		comboBox_2.setSelectedItem(m.getMjernaJedinica());
		comboBox_3.setSelectedItem(m.getTip());
		spinner.setValue(m.getGranicnaKolicina());
		spinner_3.setValue(m.getKolicina());
		spinner_1.setValue(m.getNabavnaCijena());
		spinner_2.setValue(m.getProdajnaCijena());
		dateChooser.setDate(m.getDatumNabavke());
	}
	public boolean validacija() 
	{
		
		if(!sB.verify(textField)) return false;
		if(!naziv.verify(textField_1)) return false;
		String datum = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		if(textField.getText().equals("") || textField_1.getText().equals("") || datum.equals(""))
			return false;
		
		return true;
	}
	//public void 
	public void setFrame(JFrame parentF, String akcijaA, Materijal mat)
	{
		akcija = akcijaA;
		materijal=mat;
		 materijali = new ArrayList<Materijal>();
		 SkladisteFacade sf = new SkladisteFacade();
		 naziv = new Validator(frame, textField_1, "Molimo unesite naziv.","");
		 sB = new Validator(frame, textField, "Molimo unesite ispravan serijski broj.","adresa");
		
		 //za brisanje i pregleda ne trebaju biti editabilini!
		if(akcija.equals("Brisanje") )
		{
			IspisiVrijednosti(materijal);
			OnemoguciKontrole();
			
			btnUnesi.setText("Obriši");
		
		}
		//tekst button-a
		else if(akcija.equals("Kreiranje"))
		{
			btnUnesi.setText("Unesi");
			comboBox.setVisible(false);
			comboBox_1.setVisible(false);
			textField.setVisible(true);
			textField_1.setVisible(true);
		}
		else if(akcija.equals("Modifikovanje"))
		{
			IspisiVrijednosti(materijal);
			btnUnesi.setText("Modifikuj");
		}
		
		else if(akcija.equals("Pregled"))
		{
			
			IspisiVrijednosti(materijal);
			OnemoguciKontrole();
			btnUnesi.setText("Nazad");
		}
			
		String pom = akcija;
		if(akcija.equals("Kreiranje"))
			pom = "Unos";
		panel.setBorder(BorderFactory.createTitledBorder(pom + " materijala/poluproizvoda"));
		parentFrame = parentF;
		parentFrame.setEnabled(false);
		frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public FMaterijalDMPB() {
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
		materijal= new Materijal();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 512, 407);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(12, 13, 482, 349);
		panel.setBorder(BorderFactory.createTitledBorder("Pregled materijala/poluproizvoda"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSerijskiBroj = new JLabel("Serijski broj:");
		lblSerijskiBroj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSerijskiBroj.setBounds(112, 46, 74, 16);
		panel.add(lblSerijskiBroj);
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNaziv.setBounds(130, 75, 56, 16);
		panel.add(lblNaziv);
		
		JLabel lblKoliina = new JLabel("Koli\u010Dina:");
		lblKoliina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKoliina.setBounds(130, 104, 56, 16);
		panel.add(lblKoliina);
		
		JLabel lblTip = new JLabel("Tip:");
		lblTip.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTip.setBounds(130, 133, 56, 16);
		panel.add(lblTip);
		
		JLabel lblNabavnaCijena = new JLabel("Nabavna cijena:");
		lblNabavnaCijena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNabavnaCijena.setBounds(89, 162, 97, 16);
		panel.add(lblNabavnaCijena);
		
		JLabel lblProdajnaCijena = new JLabel("Prodajna cijena:");
		lblProdajnaCijena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProdajnaCijena.setBounds(83, 191, 103, 16);
		panel.add(lblProdajnaCijena);
		
		listaSerBr = new ArrayList<String>();
		listaNaziv = new ArrayList<String>();
		listaMJ = new ArrayList<String>();
		listaMJ.add("kg");
		listaMJ.add("l");
		listaMJ.add("m");
		listaMJ.add("m^2");
		listaTip = new ArrayList<String>();
		listaTip.add("proizvod");
		listaTip.add("poluproizvod");
	    SkladisteFacade sf = new SkladisteFacade();
		materijali=sf.returnListaMaterijala();
		for(int i=0; i<materijali.size();i++)
		{
			
			listaSerBr.add(materijali.get(i).getSerijskiBroj());
			listaNaziv.add(materijali.get(i).getOpis());
						
		}
		
		comboBox = new Java2sAutoComboBox(listaSerBr);
		comboBox.setEditable(true);
		comboBox.setBounds(198, 43, 216, 22);
		panel.add(comboBox);
		
		comboBox_1 = new Java2sAutoComboBox(listaNaziv);
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(198, 72, 216, 22);
		panel.add(comboBox_1);
		
		comboBox_2 = new Java2sAutoComboBox(listaMJ);
		comboBox_2.setEditable(true);
		comboBox_2.setBounds(326, 101, 88, 22);
		panel.add(comboBox_2);
		
		comboBox_3 = new Java2sAutoComboBox(listaTip);
		comboBox_3.setEditable(true);
		comboBox_3.setBounds(198, 130, 116, 22);
		panel.add(comboBox_3);
		
		JLabel lblKmjedinica = new JLabel("KM/jedinica");
		lblKmjedinica.setBounds(326, 162, 130, 16);
		panel.add(lblKmjedinica);
		
		JLabel lblKmjedinica_1 = new JLabel("KM/jedinica");
		lblKmjedinica_1.setBounds(326, 191, 130, 16);
		panel.add(lblKmjedinica_1);
		
		JLabel lblDatumNabavke = new JLabel("Datum nabavke:");
		lblDatumNabavke.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDatumNabavke.setBounds(77, 220, 109, 16);
		panel.add(lblDatumNabavke);
		
		JLabel lblJedinica = new JLabel("jedinica");
		lblJedinica.setBounds(326, 249, 130, 16);
		panel.add(lblJedinica);
		
		btnUnesi = new JButton("Nazad");
		
		
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//akcija za klik na dugme koje moze imati razlicite f-je
				//brisanje, kreiranje, modifikovanje, pregled
				SkladisteFacade sf= new SkladisteFacade();
				if(akcija.equals("Kreiranje"))
				{
					if(validacija())
					{double kolicina=(Double)spinner_3.getValue();
					double granKolicina=(Double)spinner.getValue();
					double nabCijena = (Double)spinner_1.getValue();
					double prodCijena = (Double)spinner_2.getValue();
					Date datum = (Date)dateChooser.getDate();
					String serBroj= textField.getText();
					String opis= textField_1.getText();
					String mjed=(String)comboBox_2.getSelectedItem();
					Radnik kreirao = (Radnik)trenutniKorisnik;
					Materijal m = new Materijal(serBroj, opis, kolicina, granKolicina, TipMaterijala.proizvod, nabCijena, new Date(),Kategorija.metal,prodCijena,new Date(), kreirao, mjed);
					if(sf.dodajMaterijal(m))
						{
						 MessageBox.infoBox(frame, "Uspješno ste dodali materijal.", "Info");
						 frame.setVisible(false);
						 frame.dispose();
						 parentFrame.setEnabled(true);
					     parentFrame.setVisible(true);
						}
					else MessageBox.infoBox(frame, "Materijal sa unesenim serijskim brojem već postoji!", "Greška");
					}
					else MessageBox.infoBox(frame, "Molimo unesite sve podatke!", "Greška");
				}
				if( akcija.equals("Modifikovanje"))
				{
					materijal.setSerijskiBroj((String)comboBox.getSelectedItem());
					materijal.setOpis((String)comboBox_1.getSelectedItem());
					materijal.setKolicina((Double)spinner_3.getValue());
					materijal.setGranicnaKolicina((Double)spinner.getValue());
					materijal.setNabavnaCijena((Double)spinner_1.getValue());
					materijal.setProdajnaCijena((Double)spinner_2.getValue());
					materijal.setMjernaJedinica((String)comboBox_2.getSelectedItem());
					if(sf.izmijeniMaterijal(materijal))
						{
						//rekalkulacija cijena sastavnica (ako se promjenila cijena materijala onda se
						//treba promjeniti i cijena sastavnica, ali ne i NARUDZBENICA)
						//rekal--
						SkladisteFacade ss = new SkladisteFacade();
						List<Sastavnica> listaSastavnica = ss.returnListaSastavnica();
						for(Sastavnica sas : listaSastavnica)
						{
							sas.setUkupnaCijena(CijenaKalkulator.RekalkulisiCijenuSastavnice(sas));
							ss.izmijeniSastavnicu(sas);
						}
						
						
						
						MessageBox.infoBox(frame, "Uspješno ste modifikovali materijal.", "Info");
						frame.setVisible(false);
						frame.dispose();
						parentFrame.setEnabled(true);
				    	parentFrame.setVisible(true);
						}
				}
				if(akcija.equals("Brisanje"))
				{
					
					SkladisteFacade sf1= new SkladisteFacade();
					boolean obrisana = true;
					try{
						obrisana = sf1.obrišiMaterijal(materijal,(Menadzer)trenutniKorisnik);
					}catch(Exception ee){obrisana = false;}	
					
					if(obrisana)
							{
							MessageBox.infoBox(frame, "Uspješno ste obrisali materijal.", "Info");
							frame.setVisible(false);
							frame.dispose();
							parentFrame.setEnabled(true);
					    	parentFrame.setVisible(true);
							}
							
						else MessageBox.infoBox(frame, "Nije moguće obrisati materijal!Materijal se koristi na postojećoj sastavnici!", "Greška");
				
				}
				if(akcija.equals("Pregled"))
				{
					frame.setVisible(false);
					frame.dispose();
					parentFrame.setEnabled(true);
			    	parentFrame.setVisible(true);
				}
				
			}
		});
		btnUnesi.setBounds(326, 311, 88, 27);
		panel.add(btnUnesi);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(198, 216, 116, 20);
		panel.add(dateChooser);
		
		SpinnerNumberModel m_numberSpinnerModel;
		m_numberSpinnerModel = new SpinnerNumberModel(0.1, 0, 100000, 0.01);
		
		SpinnerNumberModel m_numberSpinnerModel_1;
		m_numberSpinnerModel_1 = new SpinnerNumberModel(0.1, 0, 100000, 0.01);
		
		SpinnerNumberModel m_numberSpinnerModel_2;
		m_numberSpinnerModel_2 = new SpinnerNumberModel(0.1, 0, 100000, 0.5);
		
		SpinnerNumberModel m_numberSpinnerModel_3;
		m_numberSpinnerModel_3 = new SpinnerNumberModel(0.1, 0, 100000, 0.1);
		
		spinner_1 = new JSpinner(m_numberSpinnerModel);
		spinner_1.setBounds(196, 160, 118, 20);
		panel.add(spinner_1);
		
		spinner_2 = new JSpinner(m_numberSpinnerModel_1);
		spinner_2.setBounds(196, 189, 118, 20);
		panel.add(spinner_2);
		spinner_3 = new JSpinner(m_numberSpinnerModel_2);
		spinner_3.setBounds(196, 102, 120, 20);
		panel.add(spinner_3);
		spinner = new JSpinner(m_numberSpinnerModel_3);
		spinner.setBounds(198, 247, 116, 20);
		panel.add(spinner);
		
		JLabel lblGraninaKoliina = new JLabel("Granična količina:");
		lblGraninaKoliina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGraninaKoliina.setBounds(77, 250, 109, 14);
		panel.add(lblGraninaKoliina);
		
		textField = new JTextField();
		textField.setBounds(198, 43, 216, 22);
		panel.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(198, 72, 216, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
	}
	
	public void postaviKorisnika(Osoba os)
	{ 
		trenutniKorisnik=os;
	}
}
