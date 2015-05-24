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
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.projekt.Klase.Narudzbenica;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FNarudzbenicaP {

	private JFrame frame;
	private JTextField odgLice;
	private JTable table;
	private JTextField tfCijena;
	private JTextField tfTrajanje;
	private JFrame parentFrame;
	public Narudzbenica narudzbenica;
	private JTextField klijentTF;
	private JTextField serijskiBroj;
	private JScrollPane scrollPane;
	public DefaultTableModel model;
	public Double ukupnaCijena = (double) 0;;
	public Double ukupnoTrajanje = (double) 0;

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
					FNarudzbenicaP window = new FNarudzbenicaP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setFrame(JFrame parentF, String akcijaA, Narudzbenica n) {
		parentFrame = parentF;
		parentFrame.setEnabled(false);
		frame.setVisible(true);
		// narudzbenica=new Narudzbenica();
		 narudzbenica=n;
		 popuniPodatke();
		// SkladisteFacade sf=new SkladisteFacade();
		// narudzbenica=sf.pretragaNarudzbenica("xy");
	}

	/**
	 * Create the application.
	 */
	public FNarudzbenicaP() {
		initialize();
		kreirajTabelu();
		

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
		panel.setBorder(BorderFactory
				.createTitledBorder("Pregled narudžbenice"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblOdgovornoLice = new JLabel("Odgovorno lice:");
		lblOdgovornoLice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOdgovornoLice.setBounds(12, 47, 113, 16);
		panel.add(lblOdgovornoLice);

		odgLice = new JTextField();
		odgLice.setEditable(false);
		odgLice.setBounds(128, 44, 158, 22);
		panel.add(odgLice);
		odgLice.setColumns(10);

		JLabel lblKlijent = new JLabel("Klijent:");
		lblKlijent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKlijent.setBounds(311, 47, 73, 16);
		panel.add(lblKlijent);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 99, 762, 160);
		panel_1.setBorder(BorderFactory.createTitledBorder("Proizvodi"));
		panel.add(panel_1);
		panel_1.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 27, 738, 120);
		panel_1.add(scrollPane);

		JLabel lblUkupnaCijena = new JLabel("Ukupna cijena:");
		lblUkupnaCijena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUkupnaCijena.setBounds(12, 283, 144, 16);
		panel.add(lblUkupnaCijena);

		tfCijena = new JTextField();
		tfCijena.setEditable(false);
		tfCijena.setBounds(168, 280, 178, 22);
		panel.add(tfCijena);
		tfCijena.setColumns(10);

		JLabel lblTrajanjeProizvodnje = new JLabel("Trajanje proizvodnje:");
		lblTrajanjeProizvodnje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrajanjeProizvodnje.setBounds(395, 283, 206, 16);
		panel.add(lblTrajanjeProizvodnje);

		tfTrajanje = new JTextField();
		tfTrajanje.setEditable(false);
		tfTrajanje.setBounds(613, 280, 130, 22);
		panel.add(tfTrajanje);
		tfTrajanje.setColumns(10);

		JLabel lblH = new JLabel("h");
		lblH.setBounds(755, 283, 19, 16);
		panel.add(lblH);

		JLabel lblKm = new JLabel("KM");
		lblKm.setBounds(358, 283, 33, 16);
		panel.add(lblKm);

		JButton btnKreirajNarudbenicu = new JButton("Nazad");
		btnKreirajNarudbenicu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				parentFrame.setEnabled(true);
				parentFrame.setVisible(true);
				
			}
		});
		btnKreirajNarudbenicu.setBounds(612, 332, 151, 25);
		panel.add(btnKreirajNarudbenicu);

		klijentTF = new JTextField();
		klijentTF.setEditable(false);
		klijentTF.setBounds(386, 45, 123, 20);
		panel.add(klijentTF);
		klijentTF.setColumns(10);

		JLabel lblNewLabel = new JLabel("Serijski broj:");
		lblNewLabel.setBounds(527, 48, 73, 14);
		panel.add(lblNewLabel);

		serijskiBroj = new JTextField();
		serijskiBroj.setEditable(false);
		serijskiBroj.setText("");
		serijskiBroj.setBounds(602, 45, 102, 20);
		panel.add(serijskiBroj);
		serijskiBroj.setColumns(10);
	}

	public void popuniPodatke() {
	
		SkladisteFacade sf = new SkladisteFacade();
       odgLice.setText(narudzbenica.getOdgovornoLice().getIme() + " "
				+ narudzbenica.getOdgovornoLice().getPrezime());
		klijentTF.setText(narudzbenica.getKlijent().getIme() + " "
				+ narudzbenica.getKlijent().getPrezime());
		serijskiBroj.setText(narudzbenica.getSerijskiBroj());
		for (int i = 0; i < narudzbenica.getStav_nar().size(); i++) {
			model.addRow(new Object[] {
					narudzbenica.getStav_nar().get(i).getProizvod().getNaziv(),
					narudzbenica.getStav_nar().get(i).getProizvod()
							.getSerijskiBroj(),
					narudzbenica.getStav_nar().get(i).getProizvod()
							.getUkupnaCijena(),
					narudzbenica.getStav_nar().get(i).getProizvod()
							.getTrajanjeProizvodnje(),
					narudzbenica.getStav_nar().get(i).getKolicina() });
			Double x = narudzbenica.getStav_nar().get(i).getProizvod()
					.getUkupnaCijena();
			Double y = narudzbenica.getStav_nar().get(i).getProizvod()
					.getTrajanjeProizvodnje();
			Double z = narudzbenica.getStav_nar().get(i).getKolicina();
			ukupnaCijena = ukupnaCijena + x * z;
			ukupnoTrajanje = ukupnoTrajanje + y * z;
		}
		table = new JTable(model);
		scrollPane.setViewportView(table);
		tfCijena.setText(Double.toString(ukupnaCijena));
		tfTrajanje.setText(Double.toString(ukupnoTrajanje));

	}

	public void kreirajTabelu() {
		tfCijena.setText(Double.toString(ukupnaCijena));
		tfTrajanje.setText(Double.toString(ukupnoTrajanje));
		model = new DefaultTableModel();
		model.addColumn("Naziv");
		model.addColumn("Serijski broj");
		model.addColumn("Cijena");
		model.addColumn("Trajanje proizvodnje");
		model.addColumn("Količina");
		table = new JTable(model);
		scrollPane.setViewportView(table);

	}

}
