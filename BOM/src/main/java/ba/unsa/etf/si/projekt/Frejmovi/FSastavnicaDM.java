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
import com.toedter.calendar.JCalendar;

public class FSastavnicaDM {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtRdads;
	private JTable table;
	private JFrame parentFrame;
	private String akcija;
	private JButton btnKreirajSastavnicu;
	private JPanel panel;

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
	
	public void setFrame(JFrame parentF, String akcijaA, String klasa)
	{
		//mozda neka provjera da li je akcija validna (moze i enumeracija)
		//ali i ne mora :D
		akcija = akcijaA;
		
		
		//kreiranje, modifikovanje
		//tekst button-a
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
		frame.setBounds(100, 100, 919, 611);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Kreiranje sastavnice"));
		panel.setBounds(12, 13, 889, 553);
		frame.getContentPane().add(panel);
		
		JLabel lblNazivProizvoda = new JLabel("Naziv proizvoda:");
		lblNazivProizvoda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNazivProizvoda.setBounds(12, 47, 156, 16);
		panel.add(lblNazivProizvoda);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(180, 44, 342, 22);
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
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(168, 32, 341, 22);
		panel_1.add(comboBox_1);
		
		JLabel label_3 = new JLabel("Koli\u010Dina:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(557, 35, 111, 16);
		panel_1.add(label_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(680, 32, 173, 22);
		panel_1.add(spinner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 105, 841, 120);
		panel_1.add(scrollPane);
		
		//
		Object rowDataP[][] = { { "", "", "", "", ""},{ "", "", "", "", ""},{ "", "", "", "", ""},
		{ "", "", "", "", ""},{ "", "", "", "", ""},{ "", "", "", "", ""},
		{ "", "", "", "", ""},{ "", "", "", "", ""},{ "", "", "", "", ""}};
		Object columnNamesP[] = { "Serijski broj", "Naziv", "Tip", "Količina", "Cijena"};
		
		table = new JTable(rowDataP, columnNamesP);
		scrollPane.setViewportView(table);
		
		JButton btnDodajStavku = new JButton("Dodaj stavku");
		btnDodajStavku.setBounds(680, 67, 173, 25);
		panel_1.add(btnDodajStavku);
		
		JButton btnIzbaciStavku = new JButton("Izbaci stavku");
		btnIzbaciStavku.setBounds(680, 239, 173, 25);
		panel_1.add(btnIzbaciStavku);
		
		JLabel label_4 = new JLabel("Ukupna cijena:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(137, 511, 96, 16);
		panel.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(245, 508, 130, 22);
		panel.add(textField_1);
		
		JLabel label_5 = new JLabel("Trajanje proizvodnje:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(12, 395, 221, 16);
		panel.add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(245, 392, 130, 22);
		panel.add(textField_2);
		
		JLabel label_6 = new JLabel("h");
		label_6.setBounds(387, 395, 19, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("KM");
		label_7.setBounds(387, 511, 56, 16);
		panel.add(label_7);
		
		btnKreirajSastavnicu = new JButton("Kreiraj");
		btnKreirajSastavnicu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//kreiranje sastavnice....
				
			}
		});
		btnKreirajSastavnicu.setBounds(689, 507, 173, 25);
		panel.add(btnKreirajSastavnicu);
		
		textField_3 = new JTextField();
		textField_3.setBounds(689, 44, 177, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCijenaObavljenogRada = new JLabel("Cijena obavljenog rada:");
		lblCijenaObavljenogRada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCijenaObavljenogRada.setBounds(12, 441, 221, 16);
		panel.add(lblCijenaObavljenogRada);
		
		textField_4 = new JTextField();
		textField_4.setBounds(245, 438, 130, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblKmh = new JLabel("KM/h");
		lblKmh.setBounds(387, 441, 56, 16);
		panel.add(lblKmh);
		
		JLabel lblDodatniTrokovi = new JLabel("Dodatni tro\u0161kovi:");
		lblDodatniTrokovi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDodatniTrokovi.setBounds(493, 395, 184, 16);
		panel.add(lblDodatniTrokovi);
		
		textField_5 = new JTextField();
		textField_5.setBounds(693, 392, 130, 22);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblKm = new JLabel("KM");
		lblKm.setBounds(835, 395, 37, 16);
		panel.add(lblKm);
		
		JLabel lblOtpad = new JLabel("Otpad:");
		lblOtpad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOtpad.setBounds(621, 441, 56, 16);
		panel.add(lblOtpad);
		
		txtRdads = new JTextField();
		txtRdads.setColumns(10);
		txtRdads.setBounds(693, 438, 130, 22);
		panel.add(txtRdads);
		
		JLabel label = new JLabel("%");
		label.setBounds(835, 441, 37, 16);
		panel.add(label);
	}
}
