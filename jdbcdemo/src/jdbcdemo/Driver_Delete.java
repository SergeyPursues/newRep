package jdbcdemo;

import java.sql.*;
public class Driver_Delete {

	
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
			String sql = "delete from student where last_name='Brown'";
			int rowsAffected = myStmt.executeUpdate(sql);
			System.out.println("Rows affected: " + rowsAffected);
			System.out.println("update complete");
		}
		
		catch(Exception exc){
			exc.printStackTrace();
		}

		
  }

}
	