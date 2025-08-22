package ninzaCRM.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic mothods related to java operations like random num , date 
 * @author M Preethi
 */
public class JavaUtility
{
	/**
	 * This method will generate random number and return it to the caller
	 * @param range
	 * @return
	 */
	public int getRandomNumber(int range)
	{
		Random num = new Random();
		int random =num.nextInt(range);
		return random;
	}
	/**
	 * This method will capture the current system date and returns to the caller
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date = s.format(d);
		return date;
	}

}
