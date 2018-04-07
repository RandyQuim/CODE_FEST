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
	
	public void connectToDB() {
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
	
	 public void createTable(String tableName, String tableCreationString) {
		 //String tableName = "TestTable2";
		 //String tableCreationString = "(column1 varchar(4000) not null PRIMARY KEY, column2 varchar(4000) not null, column3 varchar(4000) not null);";
		 //DELETEs the table if it exists
         deleteTable(tableName);
		 
		 //Builds the table creation String 
		 String TSQLSourceCode = "CREATE TABLE " + tableName + tableCreationString;
		 
		//CREATEs the table
	    try {
	    	//Statement statement = null;
	    	Statement statement = connection.createStatement();
	    	statement.executeUpdate(TSQLSourceCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
         System.out.println("Creation of " + tableName + " complete!");
     }
	 
     public void deleteTable(String tableName)
     {
         String TSQLSourceCode = ("DROP TABLE IF EXISTS " + tableName + ";");

         try {
        	 Statement statement = connection.createStatement();
        	 statement.executeUpdate(TSQLSourceCode);
         } catch (SQLException e) {
        	 e.printStackTrace();
         }
         System.out.println("Deletion of " + tableName + " complete!");
     }
     
     public int RetrieveNumberOfRowsInTable(String tableName)
     {
         int numberOfRowsInTable = 0;

         try {
        	 Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT COUNT(*) AS COUNT FROM " + tableName);

             	while(rs.next()) {
             		System.out.println("The count is " + rs.getInt("COUNT"));
                }
         } catch (SQLException e) {
        	 e.printStackTrace();
         }

         return numberOfRowsInTable;
     }
     
     public void InsertIntoTable(String tableName, String insertString)
     {
         String TSQLSourceCode = insertString;
         
    	 String column1 = "column1";
    	 String column2 = "column2";
    	 String column3 = "column3";
    	 
    	 
    	 TSQLSourceCode = "INSERT INTO " + tableName + "(column1, column2, column3) VALUES ('" + column1 + "', '" + column2 + "', '" + column3 + "');";
         try {
        	 Statement statement = connection.createStatement();
        	 statement.executeUpdate(TSQLSourceCode);
         } catch (SQLException e) {
        	 e.printStackTrace();
         }
         System.out.println("Insertion complete!");
     }
     
     public void DeleteRowFromTable(String tableName, String rowToDelete) {
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