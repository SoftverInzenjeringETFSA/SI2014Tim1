package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.EventQueue;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class Korisnik {

	private JFrame frame;
	private JFrame parentFrame = null;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				//ovaj try sluzi za postavljanje izgleda aplikacije prema platformi1233
				try { 
				    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
				    e.printStackTrace();
				}
				
				try {
					Korisnik window = new Korisnik();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setParent(JFrame parentF)
	{
		parentFrame = parentF;
	}
	public void setParentEnabled(boolean en)
	{
		parentFrame.setEnabled(en);
	}
	
	public void setVisible(boolean visible)
	{
		frame.setVisible(visible);
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		       
		    	
		    	/*
		    	if (JOptionPane.showConfirmDialog(frame, 
		            "Are you sure to close this window?", "Really Closing?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		            System.exit(0);
		        }
		        */
		    	parentFrame.setEnabled(true);
		        
		        
		        
		    }
		});
	}
	/*
	public void windowClosing(WindowEvent e)//WindowEvent e
	{
		parentFrame.setEnabled(true);
	}
	*/
	

	/**
	 * Create the application.
	 */
	public Korisnik() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Korisnici");
		frame.setBounds(100, 100, 696, 562);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Pretraga"));
		panel.setBounds(12, 13, 374, 203);
		frame.getContentPane().add(panel);
		
		JButton button = new JButton("Pretra\u017Ei");
		button.setBounds(215, 165, 91, 25);
		panel.add(button);
		
		JButton button_1 = new JButton("Prika\u017Ei sve");
		button_1.setBounds(106, 165, 97, 25);
		panel.add(button_1);
		
		JLabel label = new JLabel("Pretra\u017Ei po:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(26, 72, 74, 16);
		panel.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(106, 34, 200, 22);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(106, 104, 200, 22);
		panel.add(textField);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(106, 69, 200, 22);
		panel.add(comboBox_1);
		
		JLabel label_1 = new JLabel("Sortiraj po:");
		label_1.setBounds(34, 37, 66, 16);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder("Novi korisnik"));
		panel_1.setBounds(398, 13, 268, 83);
		frame.getContentPane().add(panel_1);
		
		JButton button_2 = new JButton("Kreiraj");
		button_2.setBounds(159, 45, 97, 25);
		panel_1.add(button_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder("Postojeći korisnik"));
		panel_2.setBounds(398, 109, 268, 107);
		frame.getContentPane().add(panel_2);
		
		JButton button_3 = new JButton("Modifikuj");
		button_3.setBounds(159, 69, 97, 25);
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("Obri\u0161i");
		button_4.setBounds(12, 69, 97, 25);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("Pregledaj");
		button_5.setBounds(159, 31, 97, 25);
		panel_2.add(button_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 229, 654, 253);
		panel_3.setBorder(BorderFactory.createTitledBorder("Pregled/odabir korisnika"));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 26, 630, 214);
		panel_3.add(scrollPane);
		
		Object rowK[][] = { { "", "", "", "", ""},
                { "", "", "", "", ""},{ "", "", "", "", ""},
                { "", "", "", "", ""},{ "", "", "", "", ""},
                { "", "", "", "", ""},{ "", "", "", "", ""},
                { "", "", "", "", ""},{ "", "", "", "", ""},
                { "", "", "", "", ""},{ "", "", "", "", ""},
                { "", "", "", "", ""} };
		Object columnK[] = { "ID", "Ime i prezime", "Telefon", "Korisničko ime", "Kreiran"};
		
		table = new JTable(rowK, columnK);
		scrollPane.setViewportView(table);
		
		JLabel lblNisteOdabraliNiti = new JLabel("Niste odabrali niti jednog korisnika.");
		lblNisteOdabraliNiti.setBounds(22, 489, 644, 16);
		frame.getContentPane().add(lblNisteOdabraliNiti);
	}
}