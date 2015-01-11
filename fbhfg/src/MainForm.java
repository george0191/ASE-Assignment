

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.JLabel;
import java.awt.Font;
/**
 * This is the main menu form of the application.
 * @author george
 *
 */

public class MainForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
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
	public MainForm() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 352);
		contentPane = new JPanel();
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegisterEmployee = new JButton("Register Employee");
		btnRegisterEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrationForm reg = new RegistrationForm();
				reg.setVisible(true);
				MainForm.this.dispose();
				MainForm.this.setVisible(false);
			}
		});
		btnRegisterEmployee.setBounds(143, 100, 145, 23);
		contentPane.add(btnRegisterEmployee);
		
		JButton btnEmployee = new JButton("Employees");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmployeeInfo emp = new EmployeeInfo();
				emp.setVisible(true);
				
			}
		});
		btnEmployee.setBounds(143, 134, 145, 23);
		contentPane.add(btnEmployee);
		
		JButton btnCalc = new JButton("Calculation");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calculation calc = new Calculation();
				calc.setVisible(true);
			}
		});
		btnCalc.setBounds(143, 168, 145, 23);
		contentPane.add(btnCalc);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		btnExit.setBounds(143, 202, 145, 23);
		contentPane.add(btnExit);
	}
}
