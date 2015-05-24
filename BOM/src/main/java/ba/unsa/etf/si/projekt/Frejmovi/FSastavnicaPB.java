package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;

import javax.swing.SpinnerModel;

public class FSastavnicaPB {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_3;
	private JTable table;
	private String akcija;
	private JFrame parentFrame;
	private JPanel panel;
	private JButton btnObrisiSastavnicu;
	private JScrollPane scrollPane;
	private Sastavnica sast;
	public DefaultTableModel model;
	private JTextField textField_7;
	private JTextField textField_1;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JSpinner spinner_3;
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
					FSastavnicaPB window = new FSastavnicaPB();
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
		
		sast=s;
		//pregled, brisanje
		//tekst button-a
		if(akcija.equals("Pregled"))
		{	popuniPodatke();
			textField_7.setText(sast.getSerijskiBroj());
			textField.setText(sast.getNaziv());
			textField_3.setText(sast.getIzdao().getIme()+" "+sast.getIzdao().getPrezime());
		    //textField.setText((String)sast.getUkupnaCijena());
			spinner.setValue(sast.getTrajanjeProizvodnje());
		    spinner_1.setValue(sast.getCijenaObavljenogRada());
		    spinner_2.setValue(sast.getDodatniTroskovi());
		    spinner_3.setValue(sast.getOtpad());
			
		    
			btnObrisiSastavnicu.setText("Nazad");
		}
		else if(akcija.equals("Brisanje"))
		{
			
			popuniPodatke();
			textField_7.setText(sast.getSerijskiBroj());
			textField.setText(sast.getNaziv());
			textField_3.setText(sast.getIzdao().getIme()+" "+sast.getIzdao().getPrezime());
		    //textField.setText((String)sast.getUkupnaCijena());
			spinner.setValue(sast.getTrajanjeProizvodnje());
		    spinner_1.setValue(sast.getCijenaObavljenogRada());
		    spinner_2.setValue(sast.getDodatniTroskovi());
		    spinner_3.setValue(sast.getOtpad());
			
		    
		    
			btnObrisiSastavnicu.setText("Obriši");
		}
			
			
		panel.setBorder(BorderFactory.createTitledBorder(akcija + " sastavnice"));
		parentFrame = parentF;
		parentFrame.setEnabled(false);
		frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public FSastavnicaPB() {
		initialize();
		kreirajTabelu();
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
		frame.setBounds(100, 100, 919, 457);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Brisanje sastavnice"));
		panel.setBounds(12, 13, 878, 415);
		frame.getContentPane().add(panel);
		
		JLabel lblNazivProizvoda = new JLabel("Naziv proizvoda:");
		lblNazivProizvoda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNazivProizvoda.setBounds(12, 46, 173, 16);
		panel.add(lblNazivProizvoda);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(195, 43, 291, 22);
		panel.add(textField);
		
		JLabel lblOdgovornoLice = new JLabel("Odgovorno lice:");
		lblOdgovornoLice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOdgovornoLice.setBounds(500, 30, 166, 16);
		panel.add(lblOdgovornoLice);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder("Materijali/poluproizvodi (stavke)"));
		panel_1.setBounds(12, 76, 865, 160);
		panel.add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 26, 841, 120);
		panel_1.add(scrollPane);
		
		
		JLabel label_4 = new JLabel("Ukupna cijena:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(12, 357, 215, 16);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Trajanje proizvodnje:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(12, 265, 215, 16);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("h");
		label_6.setBounds(381, 265, 19, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("KM");
		label_7.setBounds(381, 357, 56, 16);
		panel.add(label_7);
		
		btnObrisiSastavnicu = new JButton("Obriši");
		btnObrisiSastavnicu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//SkladisteFacade sf = new SkladisteFacade();
				//sf.obrišiSastavnicu(sast);
			}
		});
		btnObrisiSastavnicu.setBounds(735, 379, 130, 25);
		panel.add(btnObrisiSastavnicu);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(678, 27, 187, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCijenaObavljenogRada = new JLabel("Cijena obavljenog rada:");
		lblCijenaObavljenogRada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCijenaObavljenogRada.setBounds(12, 300, 215, 16);
		panel.add(lblCijenaObavljenogRada);
		
		JLabel lblKmh = new JLabel("KM/h");
		lblKmh.setBounds(381, 300, 56, 16);
		panel.add(lblKmh);
		
		JLabel lblDodatniTrokovi = new JLabel("Dodatni tro\u0161kovi:");
		lblDodatniTrokovi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDodatniTrokovi.setBounds(500, 265, 178, 16);
		panel.add(lblDodatniTrokovi);
		
		JLabel lblKm = new JLabel("KM");
		lblKm.setBounds(832, 265, 45, 16);
		panel.add(lblKm);
		
		JLabel lblOtpad = new JLabel("Otpad:");
		lblOtpad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOtpad.setBounds(569, 300, 109, 16);
		panel.add(lblOtpad);
		
		JLabel label = new JLabel("%");
		label.setBounds(832, 303, 31, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Serijski broj:");
		label_1.setBounds(65, 21, 71, 14);
		panel.add(label_1);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(132, 15, 86, 20);
		panel.add(textField_7);
		
		spinner = new JSpinner();
		spinner.setEnabled(false);
		spinner.setBounds(237, 263, 130, 20);
		panel.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setEnabled(false);
		spinner_1.setBounds(239, 301, 130, 20);
		panel.add(spinner_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(237, 355, 130, 22);
		panel.add(textField_1);
		
		spinner_2 = new JSpinner();
		spinner_2.setEnabled(false);
		spinner_2.setBounds(688, 263, 136, 20);
		panel.add(spinner_2);
		
		spinner_3 = new JSpinner();
		spinner_3.setEnabled(false);
		spinner_3.setBounds(686, 298, 136, 20);
		panel.add(spinner_3);
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
public void popuniPodatke() {
	
	for (int i = 0; i < sast.getStavke_sas().size(); i++)
	{
		model.addRow(new Object[] 
				{
				
				sast.getStavke_sas().get(i).getMaterijal()
						.getSerijskiBroj(),
				sast.getStavke_sas().get(i).getMaterijal().getOpis(),
				sast.getStavke_sas().get(i).getMaterijal().getTip(),
				sast.getStavke_sas().get(i).getMaterijal().getKolicina(),
				sast.getStavke_sas().get(i).getMaterijal().getNabavnaCijena()});
				}
	
	table = new JTable(model);

	scrollPane.setViewportView(table);
	textField.setText(Double.toString(ukupnaCijena));
}
}
