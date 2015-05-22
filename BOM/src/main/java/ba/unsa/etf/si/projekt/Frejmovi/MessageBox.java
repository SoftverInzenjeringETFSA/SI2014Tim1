package ba.unsa.etf.si.projekt.Frejmovi;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MessageBox {
	public static void infoBox(JFrame f,String infoMessage,String title)
	{
    JOptionPane.showMessageDialog(f, infoMessage, title, JOptionPane.INFORMATION_MESSAGE);
	}
}
