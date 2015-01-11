

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
/**
 * This form is about displaying the list of the employees.
 * @author george
 *
 */
public class EmployeeInfo extends JFrame {

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
					EmployeeInfo frame = new EmployeeInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public EmployeeInfo() {
		connection=SQLiteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 815, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadEmployeeInformation = new JButton("Load Employee Information");
		btnLoadEmployeeInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "select * from EmployeeInfo";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnLoadEmployeeInformation.setBounds(312, 311, 185, 23);
		contentPane.add(btnLoadEmployeeInformation);
		
		table = new JTable();
		table.setBounds(10, 11, 779, 294);
		contentPane.add(table);
	}
}
