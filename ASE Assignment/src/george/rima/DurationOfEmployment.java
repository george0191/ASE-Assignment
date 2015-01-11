package george.rima;
    
import org.joda.time.*;
//This class is used to calculate the duration employment

import java.text.SimpleDateFormat;
import java.util.Date;
public class DurationOfEmployment {
	/*This class calculates the duration of months and years worked
	 * 
	 */
	LocalDate dt1;
	LocalDate dt2;
	private int years;
	private int months;
	
	public int NumMonths(LocalDate dateStart, LocalDate dateStop)
	
	{
		
		// working months
		Period period=new Period(dateStart,dateStop);
		months = period.getMonths();
		System.out.println(" Working months "+ months);
		return months;
		
		
				
	}
	public int NumYears(LocalDate dateStart, LocalDate dateStop)
	{
		// working years
		Period period=new Period(dateStart,dateStop);
		years = period.getYears();
		System.out.println(" Working Years "+ years);
		
		return years;
		
				
	}
	public Date dateFormat(String date)
	{
		        
		// change the string type to a date format
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		Date dt;
		dt=null;
		try {
		
			dt = format.parse(date);
			
			   
		}
	    catch (Exception e) {
		    e.printStackTrace();
	    }
		
		return dt;
	}
	
		
	
}

