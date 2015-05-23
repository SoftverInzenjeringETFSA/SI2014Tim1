package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

//import net.miginfocom.swing.MigLayout;






import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;

import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.ComponentOrientation;

import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;

public class Menadzer {

	private JFrame frame;
	
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private DataGrid dataGNarudzbenica;
	private DataGrid dataGMaterijal;
	private DataGrid dataGSastavnica;
	private DataGrid dataGKlijent;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
					Menadzer window = new Menadzer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public void setFrame(JFrame parentF, String akcijaA, String klasa)
	{
		frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public Menadzer() {
		
		initialize();
		
		popuniTabeluKlijent(null,null,null);
		popuniTabeluNarudzbenica(null,null,null);
		popuniTabeluSkladiste(null,null,null);
		popuniTabeluSastavnica(null,null,null);
		
		//postavlanje akcije za izlaz iz frejma
				frame.addWindowListener(new java.awt.event.WindowAdapter() {
				    @Override
				    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				    	
				    	CustomDialog d = new CustomDialog();
				    	d.setFrame(frame, "Odjava", 
				    			"Da li se želite odjaviti sa sistema?");
				    }
				});
				
				frame.addWindowListener(new java.awt.event.WindowAdapter() {
				    @Override
				    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
				    	
				    	//parentFrame.setEnabled(true);
				    	
				    	//parentFrame.setVisible(true);
				    }
				});
				
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Menadžer");
		frame.setResizable(false);
		frame.setBounds(100, 100, 713, 665);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 51, 683, 569);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Narudžbenice", null, panel_3, null);
		panel_3.setLayout(null);	
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(12, 229, 654, 268);
		panel_8.setBorder(BorderFactory.createTitledBorder("Pregled/odabir narudžbenice"));
		panel_3.add(panel_8);
		panel_8.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 28, 630, 227);
		panel_8.add(scrollPane_1);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(BorderFactory.createTitledBorder("Pretraga"));
		panel_9.setBounds(12, 13, 374, 203);
		panel_3.add(panel_9);
		
		JButton button_5 = new JButton("Pretra\u017Ei");
		button_5.setBounds(242, 165, 91, 25);
		panel_9.add(button_5);
		
		JButton button_6 = new JButton("Prika\u017Ei sve");
		button_6.setBounds(133, 165, 97, 25);
		panel_9.add(button_6);
		
		JLabel label_2 = new JLabel("Pretra\u017Ei po:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(12, 72, 109, 16);
		panel_9.add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(133, 34, 200, 22);
		comboBox.addItem("datumu kreiranja");
		comboBox.addItem("odgovornom licu");
		panel_9.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(133, 103, 200, 22);
		panel_9.add(textField_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(133, 69, 200, 22);
		comboBox_1.addItem("datumu kreiranja");
		comboBox_1.addItem("odgovornom licu");
		panel_9.add(comboBox_1);
		
		JLabel label_3 = new JLabel("Sortiraj po:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(12, 37, 109, 16);
		panel_9.add(label_3);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(BorderFactory.createTitledBorder("Nova narudžbenica"));
		panel_10.setBounds(398, 13, 268, 83);
		panel_3.add(panel_10);
		
		JButton button_7 = new JButton("Kreiraj");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				FNarudzbenicaD n = new FNarudzbenicaD();
				//sada akcija moze biti samo kreiranje
				n.setFrame(frame, null, null);
				
			}
		});
		button_7.setBounds(159, 45, 97, 25);
		panel_10.add(button_7);
		
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBorder(BorderFactory.createTitledBorder("Postojeća narudžbenica"));
		panel_15.setBounds(398, 109, 268, 107);
		panel_3.add(panel_15);
		
		JButton button_10 = new JButton("Pregledaj");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FNarudzbenicaP n = new FNarudzbenicaP();
				//sada akcija moze biti samo pregled
				n.setFrame(frame, null, null);
				
			}
		});
		button_10.setBounds(159, 69, 97, 25);
		panel_15.add(button_10);
		
		JLabel lblNisteOdabraliNiti_2 = new JLabel("Niste odabrali niti jednu narud\u017Ebenicu.");
		lblNisteOdabraliNiti_2.setBounds(22, 510, 644, 16);
		panel_3.add(lblNisteOdabraliNiti_2);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Klijenti", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(12, 229, 654, 268);
		panel_4.setBorder(BorderFactory.createTitledBorder("Pregled/odabir klijenta"));
		panel_2.add(panel_4);
		panel_4.setLayout(null);
	    scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 28, 630, 227);
		panel_4.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(12, 13, 374, 203);
		panel_6.setBorder(BorderFactory.createTitledBorder("Pretraga"));
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		//panel_6.add(btnPretrai);
		
		JButton btnPrikaiSve = new JButton("Prika\u017Ei sve");
		btnPrikaiSve.setBounds(133, 165, 97, 25);
		panel_6.add(btnPrikaiSve);
		
		JLabel lblPretraiPo = new JLabel("Pretra\u017Ei po:");
		lblPretraiPo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPretraiPo.setBounds(12, 72, 109, 16);
		panel_6.add(lblPretraiPo);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(133, 34, 200, 22);
		comboBox_8.addItem("nazivu");
		panel_6.add(comboBox_8);
		
		textField = new JTextField();
		textField.setBounds(133, 104, 200, 22);
		panel_6.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(133, 69, 200, 22);
		comboBox_9.addItem("nazivu");
		panel_6.add(comboBox_9);
		
		JLabel lblSortirajPo = new JLabel("Sortiraj po:");
		lblSortirajPo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSortirajPo.setBounds(12, 37, 109, 16);
		panel_6.add(lblSortirajPo);
		
		JButton button_2 = new JButton("Pretra\u017Ei");
		button_2.setBounds(242, 165, 91, 25);
		panel_6.add(button_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(398, 13, 268, 83);
		panel_7.setBorder(BorderFactory.createTitledBorder("Novi klijent"));
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		
		JButton btnKreiraj = new JButton("Kreiraj");
		btnKreiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//kreiranje klijenta
				FKlijentDMPB k = new FKlijentDMPB();
				k.setFrame(frame, "Kreiranje", null);
			}
		});
		btnKreiraj.setBounds(159, 45, 97, 25);
		panel_7.add(btnKreiraj);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(398, 109, 268, 107);
		panel_5.setBorder(BorderFactory.createTitledBorder("Postojeći klijent"));
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnModifikuj = new JButton("Modifikuj");
		btnModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//modifikovanje klijenta
				FKlijentDMPB k = new FKlijentDMPB();
				k.setFrame(frame, "Modifikovanje", null);
				
			}
		});
		btnModifikuj.setBounds(159, 69, 97, 25);
		panel_5.add(btnModifikuj);
		
		JButton btnObrii = new JButton("Obri\u0161i");
		btnObrii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//pregled klijenta
				FKlijentDMPB k = new FKlijentDMPB();
				k.setFrame(frame, "Brisanje", null);//sada null treba biti klasa
				
			}
		});
		btnObrii.setBounds(12, 69, 97, 25);
		panel_5.add(btnObrii);
		
		JButton btnPregledaj_1 = new JButton("Pregledaj");
		btnPregledaj_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//pregled klijenta
				FKlijentDMPB k = new FKlijentDMPB();
				k.setFrame(frame, "Pregled", null);//sada null treba biti klasa
				
			}
		});
		btnPregledaj_1.setBounds(159, 31, 97, 25);
		panel_5.add(btnPregledaj_1);
		
		JLabel lblNisteOdabraliNiti = new JLabel("Niste odabrali niti jednog klijenta.");
		lblNisteOdabraliNiti.setBounds(22, 510, 644, 16);
		panel_2.add(lblNisteOdabraliNiti);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Sastavnice", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setBorder(BorderFactory.createTitledBorder("Pretraga"));
		panel_16.setBounds(12, 13, 374, 203);
		panel.add(panel_16);
		
		JButton button_11 = new JButton("Pretra\u017Ei");
		button_11.setBounds(242, 165, 91, 25);
		panel_16.add(button_11);
		
		JButton button_12 = new JButton("Prika\u017Ei sve");
		button_12.setBounds(133, 165, 97, 25);
		panel_16.add(button_12);
		
		JLabel label_4 = new JLabel("Pretra\u017Ei po:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(12, 72, 109, 16);
		panel_16.add(label_4);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(133, 34, 200, 22);
		comboBox_4.addItem("nazivu");
		comboBox_4.addItem("datumu kreiranja");
		panel_16.add(comboBox_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(133, 104, 200, 22);
		panel_16.add(textField_3);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(133, 69, 200, 22);
		comboBox_5.addItem("nazivu");
		comboBox_5.addItem("datumu kreiranja");
		panel_16.add(comboBox_5);
		
		JLabel label_5 = new JLabel("Sortiraj po:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(12, 37, 109, 16);
		panel_16.add(label_5);
		
		JPanel panel_18 = new JPanel();
		panel_18.setLayout(null);
		panel_18.setBorder(BorderFactory.createTitledBorder("Postojeća sastavnica"));
		panel_18.setBounds(398, 109, 268, 107);
		panel.add(panel_18);
		
		JButton button_15 = new JButton("Obri\u0161i");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FSastavnicaPB s = new FSastavnicaPB();
				s.setFrame(frame, "Brisanje", null);
				
			}
		});
		button_15.setBounds(12, 69, 97, 25);
		panel_18.add(button_15);
		
		JButton button_16 = new JButton("Pregledaj");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FSastavnicaPB s = new FSastavnicaPB();
				s.setFrame(frame, "Pregled", null);
				
			}
		});
		button_16.setBounds(159, 69, 97, 25);
		panel_18.add(button_16);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBounds(12, 229, 654, 268);
		panel_19.setBorder(BorderFactory.createTitledBorder("Pregled/odabir sastavnice"));
		panel.add(panel_19);
		panel_19.setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(12, 26, 630, 229);
		panel_19.add(scrollPane_2);
		
		JLabel lblNisteOdabraliNiti_3 = new JLabel("Niste odabrali niti jednu sastavnicu.");
		lblNisteOdabraliNiti_3.setBounds(22, 510, 644, 16);
		panel.add(lblNisteOdabraliNiti_3);
		JButton btnPretrai = new JButton("Pretra\u017Ei");
		btnPretrai.setBounds(215, 165, 91, 25);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Skladište", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(12, 229, 654, 268);
		panel_11.setBorder(BorderFactory.createTitledBorder("Pregled/odabir materijala/poluproizvoda"));
		panel_1.add(panel_11);
		panel_11.setLayout(null);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(12, 26, 630, 229);
		panel_11.add(scrollPane_3);
		
		JLabel lblNisteOdabraliNiti_1 = new JLabel("Niste odabrali niti jedan materijal/poluproizvod");
		lblNisteOdabraliNiti_1.setBounds(22, 510, 644, 16);
		panel_1.add(lblNisteOdabraliNiti_1);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(BorderFactory.createTitledBorder("Pretraga"));
		panel_12.setBounds(12, 13, 374, 203);
		panel_1.add(panel_12);
		
		JButton button = new JButton("Pretra\u017Ei");
		button.setBounds(242, 165, 91, 25);
		panel_12.add(button);
		
		JButton button_1 = new JButton("Prika\u017Ei sve");
		button_1.setBounds(133, 165, 97, 25);
		panel_12.add(button_1);
		
		JLabel label = new JLabel("Pretra\u017Ei po:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(12, 72, 109, 16);
		panel_12.add(label);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(133, 34, 200, 22);
		comboBox_2.addItem("nazivu");
		comboBox_2.addItem("datumu kreiranja");
		panel_12.add(comboBox_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(133, 104, 200, 22);
		panel_12.add(textField_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(133, 69, 200, 22);
		comboBox_3.addItem("nazivu");
		comboBox_3.addItem("datumu kreiranja");
		panel_12.add(comboBox_3);
		
		JLabel label_1 = new JLabel("Sortiraj po:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(12, 37, 109, 16);
		panel_12.add(label_1);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBorder(BorderFactory.createTitledBorder("Novi materijal/poluproizvod"));
		panel_13.setBounds(398, 13, 268, 83);
		panel_1.add(panel_13);
		
		JButton btnUnesi = new JButton("Unesi");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//otvaranje forme za unos, pregled, modif. i brisnaje korisnika sis.
				FMaterijalDMPB m = new FMaterijalDMPB();
				m.setFrame(frame, "Kreiranje", null);
				
			}
		});
		btnUnesi.setBounds(159, 45, 97, 25);
		panel_13.add(btnUnesi);
		
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBorder(BorderFactory.createTitledBorder("Postojeći materijal/poluproizvod"));
		panel_14.setBounds(398, 109, 268, 107);
		panel_1.add(panel_14);
		
		JButton button_3 = new JButton("Modifikuj");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//otvaranje forme za unos, pregled, modif. i brisnaje korisnika sis.
				FMaterijalDMPB m = new FMaterijalDMPB();
				m.setFrame(frame, "Modifikovanje", null);
				
			}
		});
		button_3.setBounds(159, 69, 97, 25);
		panel_14.add(button_3);
		
		JButton button_4 = new JButton("Obri\u0161i");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//otvaranje forme za unos, pregled, modif. i brisnaje korisnika sis.
				FMaterijalDMPB m = new FMaterijalDMPB();
				m.setFrame(frame, "Brisanje", null);
				
			}
		});
		button_4.setBounds(12, 69, 97, 25);
		panel_14.add(button_4);
		
		JButton btnPregledaj = new JButton("Pregledaj");
		btnPregledaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//otvaranje forme za unos, pregled, modif. i brisnaje korisnika sis.
				FMaterijalDMPB m = new FMaterijalDMPB();
				m.setFrame(frame, "Pregled", null);
				
			}
		});
		btnPregledaj.setBounds(159, 31, 97, 25);
		panel_14.add(btnPregledaj);
		
		JButton btnOdjava = new JButton("Odjava");
		btnOdjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CustomDialog d = new CustomDialog();
		    	d.setFrame(frame, "Odjava", 
		    			"Da li se želite odjaviti sa sistema?");
				
			}
		});
		btnOdjava.setBounds(598, 15, 97, 25);
		frame.getContentPane().add(btnOdjava);
		
		JButton btnKorisnici = new JButton("Korisnici");
		btnKorisnici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//otvaranje forme za unos, pregled, modif. i brisnaje korisnika sis.
				FKorisnik k = new FKorisnik();
				k.setFrame(frame, null, null);
				
			}
		});
		btnKorisnici.setBounds(463, 15, 97, 25);
		frame.getContentPane().add(btnKorisnici);
	}
	
	
	
	public void popuniTabeluKlijent(String name, String value, String sort)
	{
		dataGKlijent=new DataGrid("Klijent");
		table = dataGKlijent.getTable(name, value, sort);
		scrollPane.setViewportView(table);
	}
	public void popuniTabeluNarudzbenica(String name, String value, String sort)
	{
		dataGNarudzbenica=new DataGrid("Narudzbenica");
		table_1 = dataGNarudzbenica.getTable(name, value, sort);
		scrollPane_1.setViewportView(table_1);
	}
	public void popuniTabeluSastavnica(String name, String value, String sort)
	{
		dataGSastavnica=new DataGrid("Sastavnica");
		table_2 = dataGSastavnica.getTable(name, value, sort);
		scrollPane_2.setViewportView(table_2);
	}
	public void popuniTabeluSkladiste(String name, String value, String sort)
	{
		dataGMaterijal=new DataGrid("Materijal");
		table_3 = dataGMaterijal.getTable(name, value, sort);
		scrollPane_3.setViewportView(table_3);
	}
}
