package george.rima;


public class NumberOfSalaries  {
	double SalNo;
    int counter;
    /* This class calculates how many salaries the employee deserves
     * depends on number of years
     */
	public double NumberSalaries(int yearsWorked)
	{
		SalNo = 0;

	
		if (yearsWorked >=1 && yearsWorked <=5) //if he worked 5 years deserves one salary
			
		{
			
			SalNo = 1;
			
		}
		else
		counter= yearsWorked;
		SalNo=1;
		counter = counter -5;
		while (counter >= 5) 
		/*   1 salary for the first 5 years
		 *  then half salary for every 5 years 
		*/
		{
			
			// 0.5 for every 5 years
		if (counter % 5 != 0)
		{
			
			
			SalNo=SalNo+0.5;
			counter = counter -5;
			
			
		}
		else
		
			if(counter %5 == 0)
			
		{
			
			
			counter = counter/5;
			SalNo = counter * 0.5+1;
			
			break;
		}
		

		}
		
		
		return SalNo; //return number of salaries the employee deserves
		
		
	}
	
	
}
