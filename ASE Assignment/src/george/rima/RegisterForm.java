package george.rima;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RegisterForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFName;
	private JTextField textLName;
	private JTextField textSalary;
	private JTextField textHired;
	private JTextField textJanSalary;
	private JTextField textTrans;
	private JTextField textMed;
	private JTextField textPosition;
	private JTextField textLevel;
	private JTextField textStop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;

	/**
	 * Create the frame.
	 */
	public RegisterForm() {
		connection = SQLiteConnection.dbConnector();
		setTitle("Register Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 491, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFirstName.setBounds(94, 70, 170, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLastName.setBounds(94, 98, 170, 14);
		contentPane.add(lblLastName);
		
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
                    System.out.println(textFName);
				try{
					
					String query = "insert into EmployeeInfo (FirstName,LastName,DateHired,Salary,JanuarySalary,Transportation,MedicalInsurance,Position,Level,DateStopped) values (?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFName.getText() );
					pst.setString(2, textLName.getText() );
					pst.setString(3, textSalary.getText() );
					pst.setString(4, textJanSalary.getText() );
					pst.setString(5, textHired.getText() );
					pst.setString(6, textTrans.getText() );
					pst.setString(7, textMed.getText() );
					pst.setString(8, textPosition.getText() );
					pst.setString(9, textLevel.getText() );
					pst.setString(10, textStop.getText() );
					

					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					
					
					pst.close();
					JFrame backbutton;
			        backbutton = new MainForm();
			        backbutton.pack();
			        backbutton.setSize(420, 400);
			        backbutton.setVisible(true);
					RegisterForm.this.dispose();
			        RegisterForm.this.setVisible(false);
					
				}catch(Exception e){
					e.printStackTrace();
				}
			//}
		}});
		
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setBounds(203, 362, 123, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblDateHire = new JLabel("Date Hired:");
		lblDateHire.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateHire.setBounds(94, 122, 182, 14);
		contentPane.add(lblDateHire);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSalary.setBounds(94, 149, 182, 14);
		contentPane.add(lblSalary);
		
		JLabel lblJanuarySalary = new JLabel("January Salary:");
		lblJanuarySalary.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblJanuarySalary.setBounds(94, 174, 170, 14);
		contentPane.add(lblJanuarySalary);
		
		JLabel lblTransportationExpenses = new JLabel("Transportation Expenses:");
		lblTransportationExpenses.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTransportationExpenses.setBounds(94, 199, 170, 14);
		contentPane.add(lblTransportationExpenses);
		
		JLabel lblMedicalExpenses = new JLabel("Medical Expenses:");
		lblMedicalExpenses.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMedicalExpenses.setBounds(94, 224, 182, 14);
		contentPane.add(lblMedicalExpenses);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLevel.setBounds(94, 274, 182, 14);
		contentPane.add(lblLevel);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPosition.setBounds(94, 249, 182, 14);
		contentPane.add(lblPosition);
		
		JLabel lblDateStopped = new JLabel("Date Stopped:");
		lblDateStopped.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateStopped.setBounds(94, 298, 182, 14);
		contentPane.add(lblDateStopped);
		
		textFName = new JTextField();
		textFName.setBounds(274, 68, 86, 20);
		contentPane.add(textFName);
		textFName.setColumns(10);
		
		textLName = new JTextField();
		textLName.setBounds(274, 96, 86, 20);
		contentPane.add(textLName);
		textLName.setColumns(10);
		
		textSalary = new JTextField();
		textSalary.setBounds(274, 147, 86, 20);
		contentPane.add(textSalary);
		textSalary.setColumns(10);
		
		textHired = new JTextField();
		textHired.setBounds(274, 120, 86, 20);
		contentPane.add(textHired);
		textHired.setColumns(10);
		
		textJanSalary = new JTextField();
		textJanSalary.setBounds(274, 172, 86, 20);
		contentPane.add(textJanSalary);
		textJanSalary.setColumns(10);
		
		textTrans = new JTextField();
		textTrans.setBounds(274, 197, 86, 20);
		contentPane.add(textTrans);
		textTrans.setColumns(10);
		
		textMed = new JTextField();
		textMed.setBounds(274, 222, 86, 20);
		contentPane.add(textMed);
		textMed.setColumns(10);
		
		textPosition = new JTextField();
		textPosition.setBounds(274, 247, 86, 20);
		contentPane.add(textPosition);
		textPosition.setColumns(10);
		
		textLevel = new JTextField();
		textLevel.setBounds(274, 272, 86, 20);
		contentPane.add(textLevel);
		textLevel.setColumns(10);
		
		textStop = new JTextField();
		textStop.setBounds(274, 296, 86, 20);
		contentPane.add(textStop);
		textStop.setColumns(10);
	}
}
