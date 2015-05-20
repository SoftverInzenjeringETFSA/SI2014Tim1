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

public class FSastavnicaPB {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTextField textField_6;
	private String akcija;
	private JFrame parentFrame;
	private JPanel panel;
	private JButton btnObrisiSastavnicu;
	
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
	
	public void setFrame(JFrame parentF, String akcijaA, String klasa)
	{
		//mozda neka provjera da li je akcija validna (moze i enumeracija)
		//ali i ne mora :D
		akcija = akcijaA;
		
		
		//pregled, brisanje
		//tekst button-a
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
		frame.setBounds(100, 100, 800, 470);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Brisanje sastavnice"));
		panel.setBounds(12, 13, 758, 402);
		frame.getContentPane().add(panel);
		
		JLabel lblNazivProizvoda = new JLabel("Naziv proizvoda:");
		lblNazivProizvoda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNazivProizvoda.setBounds(38, 30, 96, 16);
		panel.add(lblNazivProizvoda);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(146, 27, 291, 22);
		panel.add(textField);
		
		JLabel lblOdgovornoLice = new JLabel("Odgovorno lice:");
		lblOdgovornoLice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOdgovornoLice.setBounds(463, 30, 90, 16);
		panel.add(lblOdgovornoLice);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder("Materijali/poluproizvodi (stavke)"));
		panel_1.setBounds(12, 76, 730, 160);
		panel.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 26, 706, 120);
		panel_1.add(scrollPane);
		
		//
		Object rowDataP[][] = { { "", "", "", "", ""},{ "", "", "", "", ""},{ "", "", "", "", ""},
		{ "", "", "", "", ""},{ "", "", "", "", ""},{ "", "", "", "", ""},
		{ "", "", "", "", ""},{ "", "", "", "", ""},{ "", "", "", "", ""}};
		Object columnNamesP[] = { "Serijski broj", "Naziv", "Tip", "Količina", "Cijena"};
		
		table = new JTable(rowDataP, columnNamesP);
		scrollPane.setViewportView(table);
		
		JLabel label_4 = new JLabel("Ukupna cijena:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(56, 323, 96, 16);
		panel.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(164, 320, 130, 22);
		panel.add(textField_1);
		
		JLabel label_5 = new JLabel("Trajanje proizvodnje:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(22, 265, 130, 16);
		panel.add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(164, 262, 130, 22);
		panel.add(textField_2);
		
		JLabel label_6 = new JLabel("h");
		label_6.setBounds(306, 265, 19, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("KM");
		label_7.setBounds(306, 323, 56, 16);
		panel.add(label_7);
		
		btnObrisiSastavnicu = new JButton("Obriši");
		btnObrisiSastavnicu.setBounds(555, 364, 173, 25);
		panel.add(btnObrisiSastavnicu);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(565, 27, 177, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCijenaObavljenogRada = new JLabel("Cijena obavljenog rada:");
		lblCijenaObavljenogRada.setBounds(409, 265, 137, 16);
		panel.add(lblCijenaObavljenogRada);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(558, 262, 130, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblKmh = new JLabel("KM/h");
		lblKmh.setBounds(700, 265, 56, 16);
		panel.add(lblKmh);
		
		JLabel lblDodatniTrokovi = new JLabel("Dodatni tro\u0161kovi:");
		lblDodatniTrokovi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDodatniTrokovi.setBounds(56, 294, 96, 16);
		panel.add(lblDodatniTrokovi);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(164, 291, 130, 22);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblKm = new JLabel("KM");
		lblKm.setBounds(306, 294, 56, 16);
		panel.add(lblKm);
		
		JLabel lblOtpad = new JLabel("Otpad:");
		lblOtpad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOtpad.setBounds(490, 294, 56, 16);
		panel.add(lblOtpad);
		
		JLabel label = new JLabel("%");
		label.setBounds(700, 294, 56, 16);
		panel.add(label);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(558, 291, 130, 22);
		panel.add(textField_6);
	}
}
