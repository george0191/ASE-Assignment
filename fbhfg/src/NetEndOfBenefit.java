
public class NetEndOfBenefit {
	/*This class calculates the net of end of benefit by taking the  taxes
	 * from EndMonthsYears class
	*/ 
	double Tax = 0.09;
	double JanuarySal;
	double Expenses;
	double Transportation;
	double MedicalInssurance;
	double NetBenefit;
	public double  Execluding9Percent(double JanuarySal,double expenses, double transportation )
	{
		//Tax taken from January salary , expenses and transportation
	    double Total = (JanuarySal + expenses + transportation)*Tax;
		double PercentagePerYear = Total *12; //Taxes per year
		
		return PercentagePerYear;
		
	}
	public double InssuranceTax(double PercentagePerYear, double Medical)
	{
		// the medical Taxes
		double Tax = Execluding9Percent(JanuarySal,Expenses,Transportation);
		double MedicalTax = Tax + Medical;
		
		return MedicalTax;
	}
double NetBenefit(double end , double execlucing9Percent)
{
	//Subtract the taxes from the end of benefit which was calculated in class EndMonthsYears
	execlucing9Percent=
	NetBenefit = end-execlucing9Percent;
	return NetBenefit;
}
}


