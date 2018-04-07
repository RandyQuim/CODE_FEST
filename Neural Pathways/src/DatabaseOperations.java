import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
    
	public void connectToDB() {
		// Connect to database
		String hostName = "trivianation.database.windows.net";
		String dbName = "NeuralPathways";
		String user = "trivianationadmin@trivianation";
		String password = "SoftwareEngineering2";
		String url = (String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password));
		Connection connection = null;

		try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);

            System.out.println("Query data example:");
            System.out.println("=========================================");

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT TOP 20 pc.Name as CategoryName, p.name as ProductName " 
                + "FROM [SalesLT].[ProductCategory] pc "  
                + "JOIN [SalesLT].[Product] p ON pc.productcategoryid = p.productcategoryid";

            try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectSql)) {

                    // Print results from select statement
                    System.out.println("Top 20 categories:");
                    while (resultSet.next())
                    {
                        System.out.println(resultSet.getString(1) + " "
                            + resultSet.getString(2));
                    }
             connection.close();
            }                   
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
}

