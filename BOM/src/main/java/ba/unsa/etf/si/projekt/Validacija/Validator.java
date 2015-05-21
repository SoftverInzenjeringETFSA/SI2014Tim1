package ba.unsa.etf.si.projekt.Validacija;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	public static Boolean ValidirajJeLiPrazno(String kontrolaTekst)
	{
		return kontrolaTekst.isEmpty();
	}	
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public static Boolean ValidirajEmail(String mail)
	{
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(mail);
        return matcher.find();
	}
	
	public static Boolean ValidirajJMBG(String JMBG)
	{
		if(!JMBG.isEmpty())
		{List<Integer> l3 = new ArrayList<Integer>();
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
