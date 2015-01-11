package george.rima;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.joda.time.LocalDate;

public class Calculation extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public String dateStart;
	public String dateStop; // can be date of today
	public double Salary;
	public int level;
	public double JanuarySal;
	public double Transportation;
	public double Medical;
	public double Expenses;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculation frame = new Calculation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculation() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dS = new JLabel("Date Start");
		dS.setBounds(48, 35, 104, 26);
		contentPane.add(dS);
		
		JLabel DStop = new JLabel("Date Stopped");
		DStop.setBounds(38, 72, 94, 26);
		contentPane.add(DStop);
		
		JLabel Sal = new JLabel("Salary");
		Sal.setBounds(38, 97, 94, 26);
		contentPane.add(Sal);
		
		JLabel lvl = new JLabel("Level");
		lvl.setBounds(38, 118, 104, 26);
		contentPane.add(lvl);
		
		JLabel JanSal = new JLabel("January Salary");
		JanSal.setBounds(38, 144, 114, 26);
		contentPane.add(JanSal);
		
		JLabel Trans = new JLabel("Transportation");
		Trans.setBounds(38, 168, 132, 43);
		contentPane.add(Trans);
		
		JLabel med = new JLabel("Medical");
		med.setBounds(38, 209, 94, 26);
		contentPane.add(med);
		
		JLabel exp = new JLabel("Expenses");
		exp.setBounds(38, 226, 132, 50);
		contentPane.add(exp);
		
		textField = new JTextField();
		textField.setBounds(152, 39, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 72, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(152, 100, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dateStart = textField.getText();
				dateStop = textField_1.getText();
				Salary = Double.parseDouble(textField_2.getText());
				level =  Integer.parseInt(textField_3.getText());
				JanuarySal =  Double.parseDouble(textField_4.getText());
				Transportation =  Double.parseDouble(textField_5.getText());
				Medical =  Double.parseDouble(textField_6.getText());
				Expenses =  Double.parseDouble(textField_7.getText());
				
				
				DurationOfEmployment duration= new DurationOfEmployment(); 
				LocalDate dt1 = new LocalDate(duration.dateFormat(dateStart)); 
				LocalDate dt2 = new LocalDate(duration.dateFormat(dateStop));
				int months = duration.NumMonths(dt1,dt2); //get number of working months
				int years = duration.NumYears(dt1,dt2); // get number of working years
				NumberOfSalaries salaries = new NumberOfSalaries();
				double sal = salaries.NumberSalaries(years); // calculate number of salaries deserves
				System.out.print(" Number of slaries " + sal);
				TaxPaid taxpaid = new TaxPaid();
				double SalaryAfterAddtion=taxpaid.salaryAfterAddTax(Salary , level);
				System.out.println(" Salary after addtion "+SalaryAfterAddtion);
				EndMonthsYears End = new EndMonthsYears();
				double end = End.EndBenefit(months,years, sal, SalaryAfterAddtion);
				System.out.print(" End of benefit "+end);
				NetEndOfBenefit endBenefit = new NetEndOfBenefit();
				double TaxE9Percent= endBenefit.Execluding9Percent(JanuarySal, Expenses, Transportation);
				double MedicalTax = endBenefit.InssuranceTax(TaxE9Percent, Medical);
				double NetEnd = endBenefit.NetBenefit(end, MedicalTax);
				System.out.print(" Net End of benefit "+NetEnd);
				
				String months1 = Integer.toString(months);
				String years1 = Integer.toString(years);
				String sal1 = Double.toString(sal);
				String SalaryAfterAddtion1 = Double.toString(SalaryAfterAddtion);
				String end1 = Double.toString(end);
			    String NetEnd1 = Double.toString(NetEnd); 
				
				textField_8.setText(months1);
				textField_9.setText(years1);
				textField_10.setText(sal1);
				textField_11.setText(SalaryAfterAddtion1);
				textField_12.setText(end1);
				textField_13.setText(NetEnd1);
			
				
			}
		});
		btnCalculate.setBounds(152, 322, 89, 23);
		contentPane.add(btnCalculate);
		
		
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(152, 131, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(152, 160, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(152, 191, 86, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(152, 222, 86, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(152, 256, 86, 20);
		contentPane.add(textField_7);
		
		label = new JLabel("Date Start");
		label.setBounds(265, 117, 69, 26);
		contentPane.add(label);
		
		label_1 = new JLabel("Date Start");
		label_1.setBounds(265, 80, 69, 26);
		contentPane.add(label_1);
		
		label_2 = new JLabel("Date Start");
		label_2.setBounds(265, 154, 69, 26);
		contentPane.add(label_2);
		
		label_3 = new JLabel("Date Start");
		label_3.setBounds(265, 185, 69, 26);
		contentPane.add(label_3);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setEditable(false);
		textField_8.setBounds(344, 78, 86, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setEditable(false);
		textField_9.setBounds(344, 121, 86, 20);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setEditable(false);
		textField_10.setBounds(344, 160, 86, 20);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setEditable(false);
		textField_11.setBounds(344, 191, 86, 20);
		contentPane.add(textField_11);
		
		label_4 = new JLabel("Date Start");
		label_4.setBounds(265, 216, 69, 26);
		contentPane.add(label_4);
		
		label_5 = new JLabel("Date Start");
		label_5.setBounds(265, 248, 69, 26);
		contentPane.add(label_5);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setEditable(false);
		textField_12.setBounds(344, 226, 86, 20);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setEditable(false);
		textField_13.setBounds(344, 256, 86, 20);
		contentPane.add(textField_13);
	}
}
