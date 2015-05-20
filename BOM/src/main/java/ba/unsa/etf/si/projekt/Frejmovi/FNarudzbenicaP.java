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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FNarudzbenicaP {

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
					FNarudzbenicaP window = new FNarudzbenicaP();
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
	public FNarudzbenicaP() {
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
		frame.setBounds(100, 100, 816, 440);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 786, 382);
		panel.setBorder(BorderFactory.createTitledBorder("Pregled narudžbenice"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblOdgovornoLice = new JLabel("Odgovorno lice:");
		lblOdgovornoLice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOdgovornoLice.setBounds(12, 47, 164, 16);
		panel.add(lblOdgovornoLice);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(188, 44, 195, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblKlijent = new JLabel("Klijent:");
		lblKlijent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKlijent.setBounds(395, 47, 73, 16);
		panel.add(lblKlijent);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(480, 44, 283, 22);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 99, 762, 160);
		panel_1.setBorder(BorderFactory.createTitledBorder("Proizvodi"));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 27, 738, 120);
		panel_1.add(scrollPane);
		
		Object rowDataP[][] = { { "", "", "", ""},{ "", "", "", ""},{ "", "", "", ""},
				{ "", "", "", ""},{ "", "", "", ""},{ "", "", "", ""},
				{ "", "", "", ""},{ "", "", "", ""},{ "", "", "", ""}};
		Object columnNamesP[] = { "ID", "Naziv proizvoda", "Količina", "Cijena"};
		
		table = new JTable(rowDataP, columnNamesP);
		scrollPane.setViewportView(table);
		
		JLabel lblUkupnaCijena = new JLabel("Ukupna cijena:");
		lblUkupnaCijena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUkupnaCijena.setBounds(12, 283, 144, 16);
		panel.add(lblUkupnaCijena);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(168, 280, 178, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTrajanjeProizvodnje = new JLabel("Trajanje proizvodnje:");
		lblTrajanjeProizvodnje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrajanjeProizvodnje.setBounds(395, 283, 206, 16);
		panel.add(lblTrajanjeProizvodnje);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(613, 280, 130, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblH = new JLabel("h");
		lblH.setBounds(755, 283, 19, 16);
		panel.add(lblH);
		
		JLabel lblKm = new JLabel("KM");
		lblKm.setBounds(358, 283, 33, 16);
		panel.add(lblKm);
		
		JButton btnKreirajNarudbenicu = new JButton("Nazad");
		btnKreirajNarudbenicu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//vracanje nazad
			}
		});
		btnKreirajNarudbenicu.setBounds(612, 332, 151, 25);
		panel.add(btnKreirajNarudbenicu);
	}
}
