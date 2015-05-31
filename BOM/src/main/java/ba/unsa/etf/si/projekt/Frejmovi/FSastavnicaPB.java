package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
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
	private Sastavnica sastavnica;
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
		
		sastavnica=s;
		
		
		popuniTabelu();
		textField_7.setText(sastavnica.getSerijskiBroj());
		textField.setText(sastavnica.getNaziv());
		textField_3.setText(sastavnica.getIzdao().getIme()+" "+sastavnica.getIzdao().getPrezime());
	    textField_1.setText(String.valueOf(sastavnica.getUkupnaCijena()));
		spinner.setValue(sastavnica.getTrajanjeProizvodnje());
	    spinner_1.setValue(sastavnica.getCijenaObavljenogRada());
	    spinner_2.setValue(sastavnica.getDodatniTroskovi());
	    spinner_3.setValue(sastavnica.getOtpad());
	    
		if(akcija.equals("Pregled"))
		{	
			btnObrisiSastavnicu.setText("Nazad");
		}
		else if(akcija.equals("Brisanje"))
		{
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
		frame.setBounds(100, 100, 916, 512);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Brisanje sastavnice"));
		panel.setBounds(12, 13, 885, 454);
		frame.getContentPane().add(panel);
		
		JLabel lblNazivProizvoda = new JLabel("Naziv proizvoda:");
		lblNazivProizvoda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNazivProizvoda.setBounds(12, 64, 170, 16);
		panel.add(lblNazivProizvoda);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(194, 61, 243, 22);
		panel.add(textField);
		
		JLabel lblOdgovornoLice = new JLabel("Odgovorno lice:");
		lblOdgovornoLice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOdgovornoLice.setBounds(473, 30, 166, 16);
		panel.add(lblOdgovornoLice);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder("Materijali/poluproizvodi (stavke)"));
		panel_1.setBounds(12, 123, 865, 160);
		panel.add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 26, 841, 120);
		panel_1.add(scrollPane);
		
		
		JLabel label_4 = new JLabel("Ukupna cijena:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(12, 378, 215, 16);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Trajanje proizvodnje:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(12, 311, 215, 16);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("h");
		label_6.setBounds(381, 311, 19, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("KM");
		label_7.setBounds(381, 378, 56, 16);
		panel.add(label_7);
		
		btnObrisiSastavnicu = new JButton("Obriši");
		btnObrisiSastavnicu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(akcija.equals("Pregled"))
				{
					frame.dispose();
					parentFrame.setVisible(true);
					parentFrame.setEnabled(true);
				}
				else if(akcija.equals("Brisanje"))
				{
					SkladisteFacade sf = new SkladisteFacade();
					boolean obrisana = true;
					try{
						obrisana = sf.obrišiSastavnicu(sastavnica);
					}catch(Exception ee){obrisana = false;}
					
					if(obrisana)
					{
						MessageBox.infoBox(frame, "Sastavnica je uspješno obrisana.", "Info");
					}else{
						MessageBox.infoBox(frame, "Ova sastavnica se nalazi na nekim narudžbenicama!\n"
								                + "Zbog toga, ne može se brisati.", "Info");
					}
					
					frame.dispose(); 
					parentFrame.setVisible(true);
					parentFrame.setEnabled(true);
				}
			}
		});
		btnObrisiSastavnicu.setBounds(731, 414, 130, 25);
		panel.add(btnObrisiSastavnicu);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(651, 27, 214, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCijenaObavljenogRada = new JLabel("Cijena obavljenog rada:");
		lblCijenaObavljenogRada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCijenaObavljenogRada.setBounds(12, 344, 215, 16);
		panel.add(lblCijenaObavljenogRada);
		
		JLabel lblKmh = new JLabel("KM/h");
		lblKmh.setBounds(381, 344, 56, 16);
		panel.add(lblKmh);
		
		JLabel lblDodatniTrokovi = new JLabel("Dodatni tro\u0161kovi:");
		lblDodatniTrokovi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDodatniTrokovi.setBounds(488, 311, 178, 16);
		panel.add(lblDodatniTrokovi);
		
		JLabel lblKm = new JLabel("KM");
		lblKm.setBounds(826, 311, 45, 16);
		panel.add(lblKm);
		
		JLabel lblOtpad = new JLabel("Otpad:");
		lblOtpad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOtpad.setBounds(557, 344, 109, 16);
		panel.add(lblOtpad);
		
		JLabel label = new JLabel("%");
		label.setBounds(826, 344, 31, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Serijski broj:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(12, 31, 170, 14);
		panel.add(label_1);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(194, 28, 243, 20);
		panel.add(textField_7);
		
		spinner = new JSpinner();
		spinner.setEnabled(false);
		spinner.setBounds(239, 309, 130, 20);
		panel.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setEnabled(false);
		spinner_1.setBounds(239, 342, 130, 20);
		panel.add(spinner_1);
		
		textField_1 = new JTextField();
		label_4.setLabelFor(textField_1);
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(239, 375, 130, 22);
		panel.add(textField_1);
		
		spinner_2 = new JSpinner();
		spinner_2.setEnabled(false);
		spinner_2.setBounds(678, 309, 136, 20);
		panel.add(spinner_2);
		
		spinner_3 = new JSpinner();
		spinner_3.setEnabled(false);
		spinner_3.setBounds(678, 342, 136, 20);
		panel.add(spinner_3);
	}
	
public void popuniTabelu() {
	
	Object columnsName[] = { "Serijski broj", "Naziv", "Količina", "Tip", "Cijena"};
	Object rows[][] = new Object[sastavnica.getStavke_sas().size()][5];
	
	for (int i = 0; i < sastavnica.getStavke_sas().size(); i++)
	{
		rows[i][0] = sastavnica.getStavke_sas().get(i).getMaterijal().getSerijskiBroj();
        rows[i][1] = sastavnica.getStavke_sas().get(i).getMaterijal().getOpis();
	    rows[i][2] = sastavnica.getStavke_sas().get(i).getKolicina();
		rows[i][3] = sastavnica.getStavke_sas().get(i).getMaterijal().getTip();
		rows[i][4] = sastavnica.getStavke_sas().get(i).getMaterijal().getProdajnaCijena();
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
}
