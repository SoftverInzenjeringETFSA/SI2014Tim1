package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.EventQueue;

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

import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class FNarudzbenicaD {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JFrame parentFrame;

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
					FNarudzbenicaD window = new FNarudzbenicaD();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setFrame(JFrame parentF, String akcijaA, String klasa)
	{
		parentFrame = parentF;
		parentFrame.setEnabled(false);
		frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public FNarudzbenicaD() {
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
		frame.setBounds(100, 100, 816, 552);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 786, 494);
		panel.setBorder(BorderFactory.createTitledBorder("Kreiranje narudžbenice"));
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
		
		SkladisteFacade sf = new SkladisteFacade();
		List<Materijal> materijali = sf.returnListaMaterijala();
		JComboBox comboBox = new JComboBox();
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
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(134, 32, 315, 22);
		panel_1.add(comboBox_1);
		
		JLabel lblKoliina = new JLabel("Koli\u010Dina:");
		lblKoliina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKoliina.setBounds(461, 35, 104, 16);
		panel_1.add(lblKoliina);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(577, 32, 173, 22);
		panel_1.add(spinner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 105, 738, 120);
		panel_1.add(scrollPane);
		
		Object rowDataP[][] = { { "", "", "", ""},{ "", "", "", ""},{ "", "", "", ""},
				{ "", "", "", ""},{ "", "", "", ""},{ "", "", "", ""},
				{ "", "", "", ""},{ "", "", "", ""},{ "", "", "", ""}};
		Object columnNamesP[] = { "ID", "Naziv proizvoda", "Količina", "Cijena"};
		
		table = new JTable(rowDataP, columnNamesP);
		scrollPane.setViewportView(table);
		
		JButton btnDodajProizvod = new JButton("Dodaj proizvod");
		btnDodajProizvod.setBounds(599, 67, 151, 25);
		panel_1.add(btnDodajProizvod);
		
		JButton btnIzbaciProizvod = new JButton("Izbaci proizvod");
		btnIzbaciProizvod.setBounds(599, 238, 151, 25);
		panel_1.add(btnIzbaciProizvod);
		
		JLabel lblUkupnaCijena = new JLabel("Ukupna cijena:");
		lblUkupnaCijena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUkupnaCijena.setBounds(12, 401, 137, 16);
		panel.add(lblUkupnaCijena);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(161, 398, 178, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTrajanjeProizvodnje = new JLabel("Trajanje proizvodnje:");
		lblTrajanjeProizvodnje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrajanjeProizvodnje.setBounds(385, 401, 215, 16);
		panel.add(lblTrajanjeProizvodnje);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(612, 398, 130, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblH = new JLabel("h");
		lblH.setBounds(754, 401, 20, 16);
		panel.add(lblH);
		
		JLabel lblKm = new JLabel("KM");
		lblKm.setBounds(351, 401, 32, 16);
		panel.add(lblKm);
		
		JButton button = new JButton("Kreiraj");
		button.setBounds(612, 444, 151, 25);
		panel.add(button);
	}
}