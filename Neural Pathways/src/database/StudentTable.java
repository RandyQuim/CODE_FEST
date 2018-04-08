package database;
import java.util.ArrayList;

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
 * File Name: StudentTable.java
 * 
 * This Program: will help with determining the amount of learning 
 * occuring during a course.
 */

public class StudentTable {
	//number of columns in the table
	private final int numberOfColumns = 4;
    //name of this specific DataBase Table
    private final String tableName = "StudentTable";
    //String used to create this specific Table
    private final String tableCreationString = "(studentName varchar(4000) not null PRIMARY KEY, password varchar(4000) not null, "
    		+ "mistakes varchar(4000) not null, score varchar(4000) not null);";
    
    /**
     * Default Constructor for the QuestionTable class
     */
    public StudentTable() {

    }

    /**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @return the tableCreationString
	 */
	public String getTableCreationString() {
		return tableCreationString;
	}

	/**
	 * Creates this Table
	 * @param tableName = The name of the table
	 * @param tableCreationString = The SQL string to create the table
	 */
    public void createTable(String tableName, String tableCreationString) {
        DatabaseOperations.createTable(tableName, tableCreationString);
    }

    /**
     * Inserts a row into the Table
     * @param tableName = The name of the table
     * @param insertValues = ArrayList<String> of values, each element holds the value of the rows column
     */
    public void insertRowIntoTable(String tableName, ArrayList<String> insertValues) {

        String studentName = insertValues.get(0);
        String password = insertValues.get(1);
        String mistakes = insertValues.get(2);
        String score = insertValues.get(3);

        String insertString = "INSERT INTO " + tableName + "(studentName, password, mistakes, score) VALUES ('" 
        + studentName + "', '" + password + "', '" + mistakes + "', '" + score + "');";
        DatabaseOperations.insertIntoTable(insertString);
    }

    /**
     * Gets the number of rows a table has
     * @return the number of rows in the table
     */
    public int retrieveNumberOfRowsInTable() {
        return DatabaseOperations.retrieveNumberOfRowsInTable(tableName);
    }

    /**
     * Retrieves the row values from the Table
     * @param tableName = name of the table
     * @param rowNumber = the row number to retrieve
     * @return a string value of the row values separated by the "\n" character
     */
    public String retrieveTableRow(String tableName, int rowNumber) {
        String retrievedRow = DatabaseOperations.retrieveRowFromTable("" +
            "SELECT * FROM" +
           "(" +
            "Select " +
            "Row_Number() Over (Order By studentName) As RowNum" +
            ", * " +
           "From " + tableName + 
           ") t2 " +
           "where RowNum = " + rowNumber + ";", numberOfColumns);

        return retrievedRow;
    }

    /**
     * Deletes a row from the Table
     * @param questionID = the questionID of the row to delete
     */
    public void DeleteRowFromTable(String studentName) {
        String rowToDelete = ("DELETE FROM " + tableName + " WHERE studentName='" + studentName + "';");
        DatabaseOperations.deleteRowFromTable(rowToDelete);
    }
}

