package jdbcdemo;

import java.sql.*;
public class Driver_Read {

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
			// execute a sql query
			ResultSet MyRs = myStmt.executeQuery("select * from student");
			// process the result set
			System.out.println(MyRs==null? "empty": "non-empty");
			
			while (MyRs.next()){
				System.out.println(MyRs.getString("last_name")+", "+MyRs.getString("first_name"));
			}
		}
		
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
}
