import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Timothy McWatters
 * @author Randy Quimby
 * @author Chris Ault
 * @author Louis Anthony
 * @author Daniel Amorim
 * @version 1.0
 * 
 * UWF CodeFest 2018 Project
 * Neural Pathways
 * File Name: DatabaseOperations.java
 * 
 * This Program: will help with determining the amount of learning 
 * occuring during a course.
 */

public class DatabaseOperations {
	static Connection connection = null;
	
	/**
	 * Connects the program to the Microsoft Azure SQL Database
	 */
	public static void connectToDB() {
		// Connect to database
		String url = "jdbc:sqlserver://trivianation.database.windows.net:1433;database=NeuralPathways;user=trivianationadmin@trivianation;password={SoftwareEngineering2};encrypt=true;trustServerCertificate=false;hostNameInCertificate=cr2.eastus1-a.control.database.windows.net;loginTimeout=30;";

		try {
            connection = DriverManager.getConnection(url);
            System.out.println("Successful connection");
            }                   
		
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	
	/**
	 * Creates this Table
	 * @param tableName = The name of the table
	 * @param tableCreationString = The SQL string to create the table
	 */
	 public static void createTable(String tableName, String tableCreationString) {
		 //DELETEs the table if it exists
		 deleteTable(tableName);
		 
		 //Builds the table creation String 
		 String TSQLSourceCode = "CREATE TABLE " + tableName + tableCreationString;
		 
		//CREATEs the table
	    try {
	    	Statement statement = connection.createStatement();
	    	statement.executeUpdate(TSQLSourceCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
         System.out.println("Creation of " + tableName + " complete!");
     }
	 
	 /**
	 * Deletes a row from the Table
	 * @param questionID = the questionID of the row to delete
	 */
     public static void deleteTable(String tableName) {
         String TSQLSourceCode = ("DROP TABLE IF EXISTS " + tableName + ";");

         try {
        	 Statement statement = connection.createStatement();
        	 statement.executeUpdate(TSQLSourceCode);
         } catch (SQLException e) {
        	 e.printStackTrace();
         }
         System.out.println("Deletion of " + tableName + " complete!");
     }
     
     /**
      * Gets the number of rows a table has
      * @return the number of rows in the table
      */
     public static int retrieveNumberOfRowsInTable(String tableName) {
         int numberOfRowsInTable = 0;

         try {
        	 Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT COUNT(*) AS COUNT FROM " + tableName);

             	while(rs.next()) {
             		numberOfRowsInTable = rs.getInt("COUNT");
                }
         } catch (SQLException e) {
        	 e.printStackTrace();
         }

         return numberOfRowsInTable;
     }
     
     /**
      * Inserts a row into the Table
      * @param insertString = SQL string to insert a row into the table
      */
     public static void insertIntoTable(String insertString) {
         String TSQLSourceCode = insertString;

         try {
        	 Statement statement = connection.createStatement();
        	 statement.executeUpdate(TSQLSourceCode);
         } catch (SQLException e) {
        	 e.printStackTrace();
         }
         System.out.println("Insertion complete!");
     }
     
     /**
      * Retrieves the row values from the Table
      * @param rowToRetrieve = The SQL string to retrive a row from the database
      * @return a string value of the row values separated by the "\n" character
      */
     public static String retrieveRowFromTable(String rowToRetrieve, int numberOfRows) {
         String retrievedRow = "";
         String TSQLSourceCode = rowToRetrieve;

         try {
        	 Statement statement = connection.createStatement();
        	 ResultSet rs = statement.executeQuery(TSQLSourceCode);
        	 while (rs.next()) {
        		 for (int i = 1; i <= numberOfRows + 1; i++)
                 {
                     retrievedRow += (rs.getString(i) + "\n");
                 }
        	 }
         } catch (SQLException e) {
        	 e.printStackTrace();
         }
         System.out.println("Retrieval complete!");
         return retrievedRow;
     }
     
     /**
      * Deletes a row from the Table
      * @param rowToDelete = the SQL string to delete a row in the database
      */
     public static void deleteRowFromTable(String rowToDelete) {
         String TSQLSourceCode = rowToDelete;

         try {
        	 Statement statement = connection.createStatement();
        	 statement.executeUpdate(TSQLSourceCode);
         } catch (SQLException e) {
        	 e.printStackTrace();
         }
         System.out.println("Deletion complete!");
     }
}