package george.rima;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;
	

	/**
	 * Create the application.
	 * "connection" connects the class with the db.
	 */
	public Login() {
		initialize();
		connection = SQLiteConnection.dbConnector();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(182, 74, 71, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(182, 103, 71, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(263, 72, 86, 20);
		frame.getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "select * from Credentials where Username=? and Password=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldUN.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next()){
						count = count +1;
					}
					if(count ==1){
						JOptionPane.showMessageDialog(null, "Username and Password is correct");
						frame.dispose();
						MainForm main = new MainForm();
						main.setVisible(true);
					}
					else if(count >1){
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
					}
					else {
						JOptionPane.showMessageDialog(null, "Username and Password is not correct, Try Again..");
					}
					
					rs.close();
					pst.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
					
				}
				
				
			}
		});
		btnLogin.setBounds(238, 148, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(263, 101, 86, 20);
		frame.getContentPane().add(passwordField);
		
		lblNewLabel_2 = new JLabel("");
		Image img = new ImageIcon (this.getClass().getResource("/login.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(92, 39, 80, 132);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
