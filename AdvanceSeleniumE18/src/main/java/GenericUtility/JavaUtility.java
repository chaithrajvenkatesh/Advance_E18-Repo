package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber(int limit) {
		Random ran= new Random();
		int randomNumber=ran.nextInt(limit);
		return randomNumber;
	}
	public String generateSystemDate() {
		Date dateobj= new Date();
		SimpleDateFormat sim= new SimpleDateFormat("dd-MM-YYYY");
		String todaysDate = sim.format(dateobj);
		return todaysDate;
	}
	
	public String generateRequiredDate(int days) {
		Date dateobj= new Date();
		SimpleDateFormat sim= new SimpleDateFormat("dd-MM-YYYY");
		String todaysDate = sim.format(dateobj);
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String closeDate = sim.format(cal.getTime());
		return closeDate;
	}
}
