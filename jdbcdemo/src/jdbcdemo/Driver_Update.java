package jdbcdemo;

import java.sql.*;
public class Driver_Update {

	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker";
		String user = "hbstudent";
		String passwort = "hbstudent";
		Connection myConn = null;
		Statement myStmt = null;
		try {
			// get a connection
			myConn = DriverManager.getConnection(url, user, passwort);
			// create a statement
			myStmt = myConn.createStatement();
			// execute a sql query
			String sql = "update student set email='demo@luv2code.com' where id=2";
			int rowsAffected = myStmt.executeUpdate(sql);
			System.out.println("Rows affected: " + rowsAffected);
			System.out.println("update complete");
		}
		
		catch(Exception exc){
			exc.printStackTrace();
		}

		
  }

}
	