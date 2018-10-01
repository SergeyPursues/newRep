package jdbcdemo;
import java.sql.*;
public class Driver_Insert {

	static Statement myStmt;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker";
		String user = "hbstudent";
		String passwort = "hbstudent";
		try {
			// get a connection
			Connection myConn = DriverManager.getConnection(url, user, passwort);
			// create a statement
			myStmt = myConn.createStatement();
			// insert information to the database
			String sql = "insert into student" 
					+ "(first_name, last_name, email)"
					+ " values ('David', 'Brown', 'david.brown@foo.com')";
			
			myStmt = myConn.createStatement();
			myStmt.executeUpdate(sql);
			
			System.out.println("insert complete");
		}
		
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
}
