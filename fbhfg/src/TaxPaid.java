
public class TaxPaid {
	double Tax;
	double lastSalary;
	/* This class calculates number of salary/salaries the employee deserve. This is done by
	 *  taking the tax percentage of the  salary
	 *  The tax percentage depends on the employee's job status or level
	 * 
	 */
	public void setTax(int level)
	{
		// set the level or status of the employee
		
		switch(level){
		case 1:  
		Tax = 0.12;  //if the employee is in level 1 he pays 12% taxes
		break;
		case 2: 
			Tax = 0.10; //if the employee is in level 2 he pays 10%taxes
			break;
		case 3:
			Tax = 0.08; //if the employee is in level 3 he pays 8%taxes
			break;
		case 4:
			Tax = 0.06; //if the employee is in level 4 he pays 6%taxes
			break;
		case 5:
			Tax=0; //if the employee is in level 5 he pays 0%taxes
			break;
		}
	}
		// get the tax
		public double getTax()
		{
			return Tax;
		}
		
	public double SalaryTax(double Salary, int level)
	{
		
		
		
		setTax(level);
		double TaxSal = Salary*getTax();
		//  the tax percentage from the salary
		
		return TaxSal;
			
		
	}
		
public double salaryAfterAddTax(double Salary,int level)

{
//	add the salary to the percentage of tax taken
	double TaxSal = SalaryTax(Salary,level);
	lastSalary = Salary + TaxSal;
	return lastSalary;
}
	}


