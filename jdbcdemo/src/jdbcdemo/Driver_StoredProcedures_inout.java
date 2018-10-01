package jdbcdemo;

import java.sql.*;

public class Driver_StoredProcedures_inout {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "hbstudent" , "hbstudent");
			
			String theDepartment = "Engineering";
			
			// 2. Prepare the stored procedure call
			myStmt = myConn.prepareCall("{call greet_the_department(?)}");
			
			// 3. Set the parameters
			myStmt.registerOutParameter(1, Types.VARCHAR);
			myStmt.setString(1, theDepartment);
			
			// 4. Call stored procedure
			System.out.println("calling stored procedure. greet_the_department('" + theDepartment + "')");
			myStmt.execute();
			System.out.println("finished calling stored procedure");
			
			// 5. Get the value of the INOUT parameter
			String theResult = myStmt.getString(1);
			System.out.println("\nThe result = " + theResult);
		}
		
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}

	}	
}
	