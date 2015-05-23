package ba.unsa.etf.si.projekt.Validacija;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Validator extends AbstractValidator{
	  public Validator(JFrame parent, JTextField c, String message) {
	        super(parent, c, message);
	    }
	  public Validator (JFrame parent, JComponent c, String message)
	  {
		  super(parent, c, message);
	  }
		
	  public Validator(JFrame frame, Component component, String message) {
		// TODO Auto-generated constructor stub
		  super(frame, component, message);
	}		
	  public Validator (JFrame parent, JComponent c, String message,String tip)
	  {
		  super(parent, c, message,tip);
	  }
	  public boolean validationCriteria(JComponent c, String tip) {
			if(tip.equals("email")) return ValidirajEmail( ((JTextField)c).getText());
			else if(tip.equals("JMBG")) return ValidirajJMBG( ((JTextField)c).getText());
			else if(tip.equals("adresa")) return ValidirajAdresu( ((JTextField)c).getText());
			else if(tip.equals("korIme")) return ValidirajKorisnickoIme( ((JTextField)c).getText());
			else if(tip.equals("pass")) return ValidirajSifru( ((JPasswordField)c).getText());
			else if(tip.equals("telefon")) return ValidirajTelefon(((JFormattedTextField)c).getText());
			else if(tip.equals(""))return ValidirajTekst( ((JTextField)c).getText());
			return true;
		    
		}
	public  Boolean ValidirajJeLiPrazno(String kontrolaTekst)
	{
		if(kontrolaTekst.equals(""))
			return false;
		return true;
	}	
	//validirajTelefon
	public  Boolean ValidirajTelefon(String kontrolaTekst)
	{
		if(kontrolaTekst.equals("___-___-___"))
			return false;
		return true;
	}	
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public Boolean ValidirajEmail(String mail)
	{
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(mail);
        return matcher.find();
	}
	
	//validira tekstualna polja
	public static final Pattern VALID_TEKST_REGEX = Pattern.compile("^[a-zA-Z\\s]+$",  Pattern.CASE_INSENSITIVE);
		public  Boolean ValidirajTekst(String kontrolaTekst)
		{
			Matcher matcher = VALID_TEKST_REGEX .matcher(kontrolaTekst);
	        return matcher.find();
		}
		
	//validacija adrese	
		public static final Pattern VALID_ADRESA_REGEX = Pattern.compile("[A-Za-z0-9'\\.\\-\\s\\,]", Pattern.CASE_INSENSITIVE);
		public  Boolean ValidirajAdresu(String kontrolaTekst)
		{
			Matcher matcher = VALID_ADRESA_REGEX .matcher(kontrolaTekst);
	        return matcher.find();
		}
	
	//validacija korisnickog imena i sifre	
		public  Boolean ValidirajKorisnickoIme(String kontrolaTekst)
		{
			if(kontrolaTekst.length()<4)
				return false;
			return true;
		}
		
		public  Boolean ValidirajSifru(String kontrolaTekst)
		{
			if(kontrolaTekst.length()<4)
				return false;
			return true;
		}
		 public static Boolean IsCharDigit(String c)
	        {
	            Boolean da=false;
	            
	            char[] prebaciString=c.toCharArray();
	            for (int i = 0; i < prebaciString.length; i++)
	            {
	                da = false;
	                if (((prebaciString[i] >= '0') && (prebaciString[i] <= '9')))
	                    da = true;
	            }
	            return da;
	        }
    //validacija jmbga
	public Boolean ValidirajJMBG(String JMBG)
	{
		List<Integer> l3 = new ArrayList<Integer>();
		if(IsCharDigit(JMBG))
		{
			for(char ch : JMBG.toCharArray())
			{
			 l3.add( Integer.valueOf(String.valueOf(ch)));
			}
		
			if (l3.size()!= 13)
	            return false;
	
	        else
	        {
	            Double eval = 0.0;
	            for (int i = 0; i < 6; i++)
	            {
	                eval += (7 - i) * (l3.get(i) + l3.get(i + 6));
	            }
	            return l3.get(12) == 11 - eval % 11;
	        }
		}
		else return false;
	}
	
	/*public static Boolean jeLiBroj(String broj)
	{
		if(broj.isEmpty()) return false;
		for (char ch : broj.toCharArray())
		{
		    if (!Character.isDigit(ch))
		    	return false;
		}
		return true;
	}
	
	//<=0
	
	public static Boolean ValidirajBroj(String broj)
	{
		if(jeLiBroj(broj))
		{
			
		}
		return true;
	}
	
	public static boolean JeLiCijeli(String s) {
	    return JeLiCijeli(s,10);
	}
	
	public static boolean JeLiCijeli(String s, int radix) {
	    if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),radix) < 0) return false;
	    }
	    return true;
	}
	
	*/
}
