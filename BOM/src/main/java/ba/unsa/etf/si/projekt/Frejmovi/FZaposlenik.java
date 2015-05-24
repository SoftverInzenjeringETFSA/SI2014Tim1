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

import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Osoba;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;

public class FZaposlenik {

	private JFrame frame;
	private JTable table_3;
	private JTextField textField_1;
	private JTextField textField_3;	
	private JTable table_2;
	private JScrollPane scrollPane_2;
	private DataGrid dataGSastavnica;
	private JScrollPane scrollPane_3;
	private DataGrid dataGSkladiste;
	private Sastavnica sastavnica;
	private Materijal materijal;
	private JLabel lblNisteOdabraliNiti_3;
	private JLabel lblNisteOdabraliNiti_1;
	private Osoba trenutniKorisnik;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				// ovaj try sluzi za postavljanje izgleda aplikacije slicnijeg
				// platformi
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					FZaposlenik window = new FZaposlenik();
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
	
	public FZaposlenik() {
		initialize();
		popuniTabeluSastavnice(null,null,null);
		popuniTabeluSkladiste(null,null,null);
		//postavlanje akcije za izlaz iz frejma
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	
		    	CustomDialog d = new CustomDialog();
		    	d.setFrame(frame, "Odjava", 
		    			"Da li se želite odjaviti sa sistema?");
		    }
		    @Override
		    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
		    	
		    	//parentFrame.setEnabled(true);
		    	//parentFrame.setVisible(true);
		    }
		    @Override
		    public void windowActivated(java.awt.event.WindowEvent windowEvent) {
		    	

				popuniTabeluSastavnice(null,null,null);
				popuniTabeluSkladiste(null,null,null);
		    }
		});
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Menadžer");
		frame.setTitle("Zaposlenik");
		frame.setResizable(false);
		frame.setBounds(100, 100, 713, 665);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 51, 683, 569);
		frame.getContentPane().add(tabbedPane);

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

		JPanel panel_17 = new JPanel();
		panel_17.setLayout(null);
		panel_17.setBorder(BorderFactory.createTitledBorder("Nova sastavnica"));
		panel_17.setBounds(398, 13, 268, 83);
		panel.add(panel_17);

		JButton button_13 = new JButton("Kreiraj");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FSastavnicaDM s = new FSastavnicaDM();
				s.setFrame(frame, "Kreiranje", null);
				//s.postaviKorisnika(trenutniKorisnik);
			}
		});
		button_13.setBounds(159, 45, 97, 25);
		panel_17.add(button_13);

		JPanel panel_18 = new JPanel();
		panel_18.setLayout(null);
		panel_18.setBorder(BorderFactory
				.createTitledBorder("Postojeća sastavnica"));
		panel_18.setBounds(398, 109, 268, 107);
		panel.add(panel_18);

		JButton button_14 = new JButton("Modifikuj");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dajSelektovanuSastavnicu();
				if(sastavnica != null)
				{
					//otvaranje forme za pregled korisnika sistema
					FSastavnicaDM s = new FSastavnicaDM();
					s.setFrame(frame, "Modifikovanje", sastavnica);
					//s.postaviKorisnika(trenutniKorisnik);
				}
				
			}
		});
		button_14.setBounds(159, 69, 97, 25);
		panel_18.add(button_14);

		JButton button_15 = new JButton("Obri\u0161i");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dajSelektovanuSastavnicu();
				if(sastavnica != null)
				{
					//otvaranje forme za pregled korisnika sistema
					FSastavnicaDM s = new FSastavnicaDM();
					s.setFrame(frame, "Brisanje", sastavnica);
					//s.postaviKorisnika(trenutniKorisnik);
				}
				
			}
		});
		button_15.setBounds(12, 69, 97, 25);
		panel_18.add(button_15);

		JButton button_16 = new JButton("Pregledaj");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dajSelektovanuSastavnicu();
				if(sastavnica != null)
				{
					//otvaranje forme za pregled korisnika sistema
					FSastavnicaPB s = new FSastavnicaPB();
					s.setFrame(frame, "Pregled", sastavnica);
				}
				
			}
		});
		button_16.setBounds(159, 31, 97, 25);
		panel_18.add(button_16);

		JPanel panel_19 = new JPanel();
		panel_19.setBounds(12, 229, 654, 268);
		panel_19.setBorder(BorderFactory
				.createTitledBorder("Pregled/odabir sastavnice"));
		panel.add(panel_19);
		panel_19.setLayout(null);
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(12, 26, 630, 229);
		panel_19.add(scrollPane_2);

		lblNisteOdabraliNiti_3 = new JLabel("Niste odabrali niti jednu sastavnicu.");
		lblNisteOdabraliNiti_3.setBounds(22, 510, 644, 16);
		panel.add(lblNisteOdabraliNiti_3);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Skladište", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_11 = new JPanel();
		panel_11.setBounds(12, 229, 654, 268);
		panel_11.setBorder(BorderFactory
				.createTitledBorder("Pregled/odabir materijala/poluproizvoda"));
		panel_1.add(panel_11);
		panel_11.setLayout(null);

		scrollPane_3 = new JScrollPane();
		scrollPane_3
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_3
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(12, 26, 630, 229);
		panel_11.add(scrollPane_3);
		
		lblNisteOdabraliNiti_1 = new JLabel("");
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
		comboBox_2.addItem("datumu nabavke");
		panel_12.add(comboBox_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(133, 102, 200, 22);
		panel_12.add(textField_1);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(133, 69, 200, 22);
		comboBox_3.addItem("nazivu");
		comboBox_3.addItem("datumu nabavke");
		panel_12.add(comboBox_3);

		JLabel label_1 = new JLabel("Sortiraj po:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(12, 37, 109, 16);
		panel_12.add(label_1);

		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBorder(BorderFactory
				.createTitledBorder("Novi materijal/poluproizvod"));
		panel_13.setBounds(398, 13, 268, 83);
		panel_1.add(panel_13);

		JButton btnUnesi = new JButton("Unesi");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FMaterijalDMPB m = new FMaterijalDMPB();
				m.setFrame(frame, "Kreiranje", null);
				//postaviKorisnika(trenutniKorisnik);
				
			}
		});
		btnUnesi.setBounds(159, 45, 97, 25);
		panel_13.add(btnUnesi);

		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBorder(BorderFactory
				.createTitledBorder("Postojeći materijal/poluproizvod"));
		panel_14.setBounds(398, 109, 268, 107);
		panel_1.add(panel_14);

		JButton button_3 = new JButton("Modifikuj");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dajSelektovaniMaterijal();
				if(materijal != null)
				{
					//otvaranje forme za pregled korisnika sistema
					FMaterijalDMPB s = new FMaterijalDMPB();
					s.setFrame(frame, "Modifikuj", materijal);
					//s.postaviKorisnika(trenutniKorisnik);
				}
				
			}
		});
		button_3.setBounds(159, 69, 97, 25);
		panel_14.add(button_3);

		JButton button_4 = new JButton("Obri\u0161i");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dajSelektovaniMaterijal();
				if(materijal != null)
				{
					//otvaranje forme za pregled korisnika sistema
					FMaterijalDMPB s = new FMaterijalDMPB();
					s.setFrame(frame, "Brisanje", materijal);
				}
				
			}
		});
		button_4.setBounds(12, 69, 97, 25);
		panel_14.add(button_4);

		JButton btnPregledaj = new JButton("Pregledaj");
		btnPregledaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dajSelektovaniMaterijal();
				if(materijal != null)
				{
					//otvaranje forme za pregled korisnika sistema
					FMaterijalDMPB s = new FMaterijalDMPB();
					s.setFrame(frame, "Pregled", materijal);
				}
				
			}
		});
		btnPregledaj.setBounds(159, 31, 97, 25);
		panel_14.add(btnPregledaj);

		JButton btnPretrai = new JButton("Pretra\u017Ei");
		btnPretrai.setBounds(215, 165, 91, 25);

		JButton btnOdjava = new JButton("Odjava");
		btnOdjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CustomDialog d = new CustomDialog();
		    	d.setFrame(frame, "Odjava", 
		    			"Da li se želite odjaviti sa sistema?");
				
			}
		});
		btnOdjava.setBounds(598, 15, 97, 25);
		frame.getContentPane().add(btnOdjava);
	}
	
	public void popuniTabeluSastavnice(String name, String value, String sort)
	{
		dataGSastavnica = new DataGrid("Sastavnica");
		table_2 = dataGSastavnica.getTable(name, value, sort);
		scrollPane_2.setViewportView(table_2);
	}
	public void popuniTabeluSkladiste(String name, String value, String sort)
	{
		dataGSkladiste = new DataGrid("Materijal");
		table_3 = dataGSkladiste.getTable(name, value, sort);
		scrollPane_3.setViewportView(table_3);
	}
	public void dajSelektovanuSastavnicu()
	{
		sastavnica = null;
		int sel = table_2.getSelectedRow();
		if(sel < 0)
		{
			lblNisteOdabraliNiti_3.setText("Niste odabrali niti jednu sastavnicu.");
		}
		else
		{
			table_2.getSelectionModel().clearSelection();
			lblNisteOdabraliNiti_3.setText("");
			if(dataGSastavnica.sastavnice.size()>0)
				sastavnica = dataGSastavnica.sastavnice.get(sel);
		}
	}
	public void dajSelektovaniMaterijal()
	{
		materijal = null;
		int sel = table_3.getSelectedRow();
		if(sel < 0)
		{
			lblNisteOdabraliNiti_1.setText("Niste odabrali niti jedan materijal/poluproizvod.");
		}
		else
		{
			table_3.getSelectionModel().clearSelection();
			lblNisteOdabraliNiti_1.setText("");
			if(dataGSkladiste.materijali.size()>0)
				materijal = dataGSkladiste.materijali.get(sel);
		}
	}
	public void postaviKorisnika(Osoba os)
	{
		trenutniKorisnik = os;
	}
}
