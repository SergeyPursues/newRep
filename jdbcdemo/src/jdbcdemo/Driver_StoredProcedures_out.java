package jdbcdemo;

import java.sql.*;

public class Driver_StoredProcedures_out {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "hbstudent" , "hbstudent");
			
			String theDepartment = "Engineering";
			
			// 2. Prepare the stored procedure call
			myStmt = myConn.prepareCall("{call get_count_for_department(?, ?)}");
			
			// 3. Set the parameters
			myStmt.setString(1, theDepartment);
			myStmt.registerOutParameter(2, Types.INTEGER);
			
			// 4. Call stored procedure
			System.out.println("calling stored procedure. get_count_of_department('" + theDepartment + "')");
			myStmt.execute();
			System.out.println("finished calling stored procedure");
			
			// 5. Get the value of the OUT parameter
			int theCount = myStmt.getInt(2);
			System.out.println("\nThe result = " + theCount);
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
	