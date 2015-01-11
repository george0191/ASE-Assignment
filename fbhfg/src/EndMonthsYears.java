
public class EndMonthsYears {


	//This class is to calculate the end of benefit for months worked and years
	// Calculate the end of benefit without taking any other taxes
	
	public double benefitMonths(double months, double numberSalaries, double SalaryAfterAddtion)
	{
		
		  
		double lastSalary = months/12;
		
		
		double endMonths =lastSalary*numberSalaries*SalaryAfterAddtion;// end of benefit during the months worked
	
		return 		endMonths;
		//this method calculate end of benefit depending on months worked
		
	}
	
	public double benefitYears(int years, double numberSalaries, double SalaryAfterAddtion)
	{
		//this method calculate end of benefit depending on years worked
		
		double endYears = years*numberSalaries* SalaryAfterAddtion ;
		
		 return 		endYears;
	
	}
	
	public double EndBenefit(double months, int years, double numberSalaries, double SalaryAfterAddtion){
		//this method add the end of benefit of years and months to get the total of the benefit
		double Months = benefitMonths(months, numberSalaries, SalaryAfterAddtion);
		double Years =  benefitYears(years, numberSalaries, SalaryAfterAddtion);
		double end = Months + Years;
		return end;
	}
	
}



