

import java.sql.*;
import javax.swing.*;

/**
 *  This class connects the database with the application.
 * @author george
 *
 */
public class SQLiteConnection {
	Connection conn = null;
	public static Connection dbConnector()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\George\\workspace\\ASE Assignment\\ASE.sqlite");
			JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
