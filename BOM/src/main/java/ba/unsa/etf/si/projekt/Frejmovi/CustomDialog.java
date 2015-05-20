package ba.unsa.etf.si.projekt.Frejmovi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class CustomDialog {

	private JFrame frame;
	private JFrame parentFrame;
	JLabel labelaPitanje;

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
					CustomDialog window = new CustomDialog();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setFrame(JFrame parentF, String akcija, String poruka)
	{
		if(akcija == null || poruka == null)
		{
			frame.setTitle("Zatvaranje forme");
			String t = parentF.getTitle();
			labelaPitanje.setText("Da li želite zatvoriti formu " + t + " ?");
		}else{//ukoliko imamo postavljena oba stringa
			
			frame.setTitle(akcija);
			labelaPitanje.setText(poruka);
		}
		parentFrame = parentF;
		parentFrame.setEnabled(false);
		frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public CustomDialog() {
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
		frame.setBounds(100, 100, 409, 180);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		labelaPitanje = new JLabel();
		labelaPitanje.setVerticalAlignment(SwingConstants.TOP);
		labelaPitanje.setBounds(30, 27, 349, 25);
		frame.getContentPane().add(labelaPitanje);
		
		JButton btnNe = new JButton("Ne");
		btnNe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				parentFrame.setEnabled(true);
				parentFrame.setVisible(true);
				frame.setVisible(false);
				frame.dispose();
				
			}
		});
		btnNe.setBounds(282, 97, 97, 25);
		frame.getContentPane().add(btnNe);
		
		JButton btnDa = new JButton("Da");
		btnDa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				parentFrame.setVisible(false);
				parentFrame.dispose();
				frame.setVisible(false);
				frame.dispose();
				
				
			}
		});
		btnDa.setBounds(173, 97, 97, 25);
		frame.getContentPane().add(btnDa);
	}
}
