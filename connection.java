import java.sql.*;
import javax.swing.*;

public class connection 
{
	
	public static Connection ConnectDb()
	{   
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Driver Loaded...");
                	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSL=false","root","root");
			//JOptionPane.showMessageDialog(null, "Connection Established");
			return con;
		}		
		catch(ClassNotFoundException | SQLException ex)
		{
			 //JOptionPane.showMessageDialog(null, ex);
		}
	return con;
	}
	public static void main(String[]args)
	{
		ConnectDb();
	}
}	