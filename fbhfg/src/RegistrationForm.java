
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.LayoutStyle.ComponentPlacement;


public class RegistrationForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
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
	public RegistrationForm() {
		connection = SQLiteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name:");
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String input = textField.getText();
				String input1 = textField_1.getText();
				String input2 = textField_2.getText();
				String input3 = textField_3.getText();
				String input4 = textField_4.getText();
				String input5 = textField_5.getText();
				String input6 = textField_6.getText();
				String input7 = textField_7.getText();
				String input8 = textField_8.getText();
				String input9 = textField_9.getText();
				
				 if(input.equals("")||input1.equals("")||input2.equals("")||input3.equals("")||input4.equals("")||input5.equals("")||input6.equals("")||input7.equals("")||input8.equals("")||input9.equals("")){
		             JOptionPane.showMessageDialog(null,"Please fill out all fields","Error",JOptionPane.ERROR_MESSAGE);   
		             
		      } else {
		             
		    	  try{
						
						String query = "insert into EmployeeInfo (FirstName,LastName,DateHired,Salary,JanuarySalary,Transportation,MedicalInsurance,Position,Level,DateStopped) values (?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement pst = connection.prepareStatement(query);
						pst.setString(1, input);
						pst.setString(2, input1);
						pst.setString(3, input2);
						pst.setString(4, input3);
						pst.setString(5, input4);
						pst.setString(6, input5);
						pst.setString(7, input6);
						pst.setString(8, input7);
						pst.setString(9, input8);
						pst.setString(10, input9);
						
		    	  
						
						pst.execute();
						
						
						
						pst.close();
						
		    	  }catch(Exception e){
		    		  e.printStackTrace();
		    	  }
					
					
		    	  
		    	  
		    	  JOptionPane.showMessageDialog(null,"Registration Successfull!","Register",JOptionPane.PLAIN_MESSAGE);
		             textField.setText("");
		             textField_1.setText("");
		             textField_2.setText("");
		             textField_3.setText("");
		             textField_4.setText("");
		             textField_5.setText("");
		             textField_6.setText("");
		             textField_7.setText("");
		             textField_8.setText("");
		             textField_9.setText("");
		             JFrame backbutton;
				        backbutton = new MainForm();
				        backbutton.pack();
				        backbutton.setSize(420, 400);
				        backbutton.setVisible(true);
						RegistrationForm.this.dispose();
				        RegistrationForm.this.setVisible(false);
		      } 
		    
				    
				
				
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		
		JLabel lblDateStarted = new JLabel("Date Started:");
		
		JLabel lblSalary = new JLabel("Salary:");
		
		JLabel lblJanuarySalary = new JLabel("January Salary:");
		
		JLabel lblTransportationExpenses = new JLabel("Transportation Expenses:");
		
		JLabel lblMedicalExpenses = new JLabel("Medical Expenses:");
		
		JLabel lblPosition = new JLabel("Position:");
		
		JLabel lblLevel = new JLabel("Level:");
		
		JLabel lblDateStopped = new JLabel("Date Stopped:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(178)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblJanuarySalary, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTransportationExpenses, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSalary, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDateStarted, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDateStopped, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPosition, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMedicalExpenses, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(205))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(233)
					.addComponent(btnNewButton)
					.addContainerGap(265, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateStarted, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSalary, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblJanuarySalary, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTransportationExpenses, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMedicalExpenses, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPosition, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDateStopped, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addGap(29))))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
