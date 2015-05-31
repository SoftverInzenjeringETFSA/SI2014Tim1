package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.EventQueue;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
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

import ba.unsa.etf.si.projekt.Klase.Klijent;
import ba.unsa.etf.si.projekt.Klase.Osoba;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FKorisnik {
	
	private JFrame frame;
	private JFrame parentFrame = null;
	private JTextField textField;
	private JTable table;
	private DataGrid dataGrid;
	private JScrollPane scrollPane;
	private JLabel lblNisteOdabraliNiti;
	private int SelektovanMenadzer;
	private Osoba osoba;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				//ovaj try sluzi za postavljanje izgleda aplikacije prema platformi
				try { 
				    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
				    e.printStackTrace();
				}
				
				try {
					FKorisnik window = new FKorisnik();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public void setFrame(JFrame parentF, String nacinOtvaranja, String podaci)
	{
		parentFrame = parentF;
		parentFrame.setEnabled(false);
		frame.setVisible(true);
		//ovdje nacin otvaranja i podaci nisu potrebni pa se
		//moze proslijediti null
	}

	/**
	 * Create the application.
	 */
	public FKorisnik() {
		initialize();
		popuniTabelu(null, null, null);
		
		
		//postavlanje akcije za izlaz iz frejma
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	
		    	CustomDialog d = new CustomDialog();
		    	d.setFrame(frame, null, null);
		    }
		    
		    @Override
		    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
		    	
		    	parentFrame.setEnabled(true);
		    	parentFrame.setVisible(true);
		    }
		    
		    @Override
		    public void windowActivated(java.awt.event.WindowEvent windowEvent) {
		    	
		    	popuniTabelu(null,null,null);
		    }
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Korisnici");
		frame.setBounds(100, 100, 696, 562);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Pretraga"));
		panel.setBounds(12, 13, 374, 203);
		frame.getContentPane().add(panel);
		
		JButton btnPrikai = new JButton("Prikaži");
		btnPrikai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] niz = ComboItems.getKorisnikCBItems(comboBox_1.getSelectedItem().toString(), textField.getText(), comboBox.getSelectedItem().toString());
				popuniTabelu(niz[0], niz[1], niz[2]);
				textField.setText("");
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
			}
		});
		btnPrikai.setBounds(242, 165, 91, 25);
		panel.add(btnPrikai);
		
		JButton button_1 = new JButton("Prika\u017Ei sve");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				popuniTabelu(null, null, null);
			}
		});
		button_1.setBounds(133, 165, 97, 25);
		panel.add(button_1);
		
		JLabel label = new JLabel("Pretra\u017Ei po:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(12, 72, 109, 16);
		panel.add(label);
		
		comboBox = new JComboBox();
		comboBox.setBounds(133, 34, 200, 22);
		comboBox.addItem("");
		comboBox.addItem("imenu");
		comboBox.addItem("prezimenu");
		comboBox.addItem("kor. imenu");
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(133, 104, 200, 22);
		panel.add(textField);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(133, 69, 200, 22);
		comboBox_1.addItem("");
		comboBox_1.addItem("imenu");
		comboBox_1.addItem("prezimenu");
		comboBox_1.addItem("kor. imenu");
		panel.add(comboBox_1);
		
		JLabel label_1 = new JLabel("Sortiraj po:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(12, 37, 109, 16);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder("Novi korisnik"));
		panel_1.setBounds(398, 13, 268, 83);
		frame.getContentPane().add(panel_1);
		
		JButton button_2 = new JButton("Kreiraj");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//otvaranje forme za kreiranje korisnika sistema
				FKorisnikDMPB k = new FKorisnikDMPB();
				k.setFrame(frame, "Kreiranje", null, -1);
				
			}
		});
		button_2.setBounds(159, 45, 97, 25);
		panel_1.add(button_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder("Postojeći korisnik"));
		panel_2.setBounds(398, 109, 268, 107);
		frame.getContentPane().add(panel_2);
		
		JButton button_3 = new JButton("Modifikuj");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dajSelektovanogKorisnika();
				if(osoba != null)
				{
					FKorisnikDMPB k = new FKorisnikDMPB();
					k.setFrame(frame, "Modifikovanje", osoba, SelektovanMenadzer);
				}
				
			}
		});
		button_3.setBounds(159, 69, 97, 25);
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("Obri\u0161i");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dajSelektovanogKorisnika();
				if(osoba != null)
				{
					//otvaranje forme za pregled korisnika sistema
					FKorisnikDMPB k = new FKorisnikDMPB();
					k.setFrame(frame, "Brisanje", osoba, SelektovanMenadzer);
				}
			}
		});
		button_4.setBounds(12, 69, 97, 25);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("Pregledaj");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dajSelektovanogKorisnika();
				if(osoba != null)
				{
					//otvaranje forme za pregled korisnika sistema
					FKorisnikDMPB k = new FKorisnikDMPB();
					k.setFrame(frame, "Pregled", osoba, SelektovanMenadzer);//sada null treba biti klasa
				}
				
			}
		});
		button_5.setBounds(159, 31, 97, 25);
		panel_2.add(button_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 229, 654, 253);
		panel_3.setBorder(BorderFactory.createTitledBorder("Pregled/odabir korisnika"));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 26, 630, 214);
		panel_3.add(scrollPane);
		
		lblNisteOdabraliNiti = new JLabel("");
		lblNisteOdabraliNiti.setBounds(22, 489, 644, 16);
		frame.getContentPane().add(lblNisteOdabraliNiti);
	}
	public void popuniTabelu(String name, String value, String sort)
	{
		DataGrid g = new DataGrid("Korisnik");
		table = g.getTable(name, value, sort);
		scrollPane.setViewportView(table);
	}
	public void dajSelektovanogKorisnika()
	{
		osoba = null;
		int sel = table.getSelectedRow();
		if(sel < 0)
		{
			lblNisteOdabraliNiti.setText("Niste odabrali niti jednog korisnika.");
		}
		else
		{
			table.getSelectionModel().clearSelection();
			lblNisteOdabraliNiti.setText("");
			if(sel<dataGrid.menadzeri.size())
			{
				osoba = (Osoba)dataGrid.menadzeri.get(sel);
				SelektovanMenadzer = 1;
			}else{
				osoba = (Osoba)dataGrid.radnici.get(sel-dataGrid.menadzeri.size());
				SelektovanMenadzer = 0;
			}
		}
	}
}