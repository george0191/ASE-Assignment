package george.rima;

import javax.swing.JFrame;

import org.joda.time.LocalDate;

/**
 * 
 * @author Rima
 *
 */
public class MainClass {
	LocalDate dt1;
	LocalDate dt2;
/**
 * 	
 * @param args
 */
public static void main(String[] args)
	
	{
		
		
		/*
		 * the variables should be taken from the classes George will create
		 */
		
		
		JFrame calc = new Calculation();
		calc.pack();
		calc.setVisible(true);
		
		
		}

}
