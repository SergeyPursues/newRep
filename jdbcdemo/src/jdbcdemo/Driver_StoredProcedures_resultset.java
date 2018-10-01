package jdbcdemo;

import java.sql.*;

public class Driver_StoredProcedures_resultset {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "hbstudent" , "hbstudent");
			
			// 2. Prepare the stored procedure call
			myStmt = myConn.prepareCall("{call get_employees_for_department(?)}");
			
			// 3. Set the parameter
			String theDepartment = "Engineering";
			myStmt.setString(1, theDepartment);
			
			// 4. Called stored procedure
			System.out.println("Calling stored procedure.  get_employees_for_department('" + theDepartment + "')");
            myStmt.execute();
            System.out.println("Finished calling stored procedure.\n");
            
            // 5. Get the result set
            myRs = myStmt.getResultSet();
            
            // 6. Display the result set
            display(myRs);

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

	private static void display(ResultSet myRs) throws SQLException {
		while (myRs.next()) {
			String lastName = myRs.getString("last_name");
			String firstName = myRs.getString("first_name");
			double salary = myRs.getDouble("salary");
			String department = myRs.getString("department");
			
			System.out.printf("%s, %s, %.2f, %s\n", lastName, firstName, salary, department);
		}
	}
}
