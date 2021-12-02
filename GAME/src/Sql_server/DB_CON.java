package Sql_server;
import java.sql.*;
public class DB_CON {
private final String url="jdbc:sqlserver://localhost:1433;databaseName=GAME_QUESTION";
private final String username="sa";
private final String password="1234";
private Connection con;
/**
 * Establishes a connection with the database, initializes and returns
 * the Connection object.
 * 
 * @return Connection, the Connection object
 * @throws Exception
 */
public Connection getConnection() throws Exception{
	/* Step 1 -> Dynamically load the driver's class file into memory  vazo to jar pou mou epitrepi na sindetho*/
	try {
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
	}
	catch (Exception e) {
		
		throw new Exception("SQL Driver error: " + e.getMessage());
	}
	/*
	 * Step 2 -> Establish a connection with the database and initializes
	 * the Connection object (con)
	 */
	try {
	con=DriverManager.getConnection(url,username,password);	
	return con;
	}
	catch(Exception e) {
		throw new Exception("Could not establish connection with the Database Server: " 
				+ e.getMessage());
	}
}
 // End of getConnection

/**
 * Close database connection. It is
 * very important to close the database connection after it is used.
 * 
 * @throws SQLException
 */
public void close() throws SQLException{
	try {
		if (con != null)
			// if connection is (still) open
		con.close();
	}
	catch (Exception e) {
		throw new SQLException("Could not close connection with the Database Server: " 
			+ e.getMessage());
	}
}

}
