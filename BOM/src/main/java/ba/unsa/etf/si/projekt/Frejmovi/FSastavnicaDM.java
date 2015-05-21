package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
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
	private JTextField textField_3;
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
		panel.setBounds(12, 13, 891, 569);
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
		
		spinner = new JSpinner();
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
				
				//kreiranje sastavnice....
				
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
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(245, 393, 130, 20);
		panel.add(spinner_1);
		
		spinner_2 = new JSpinner(m_numberSpinnerModel);
		spinner_2.setBounds(245, 439, 130, 20);
		panel.add(spinner_2);
		
		spinner_3 = new JSpinner(m_numberSpinnerModel_1);
		spinner_3.setBounds(689, 393, 136, 20);
		panel.add(spinner_3);
		
		spinner_4 = new JSpinner(m_numberSpinnerModel_2);
		spinner_4.setBounds(689, 439, 136, 20);
		panel.add(spinner_4);
	}
}
