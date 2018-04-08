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
 * File Name: QuestionTable.java
 * 
 * This Program: will help with determining the amount of learning 
 * occuring during a course.
 */

public class QuestionTable {
    //name of this specific DataBase Table
    private final String tableName = "QuestionTable";
    //String used to create this specific Table
    private final String tableCreationString = "(questionID varchar(4000) not null PRIMARY KEY, question varchar(4000) not null, "
    		+ "questionDescription varchar(4000) not null, "
    		+ "step1 varchar(4000) not null, step1Answer varchar(4000) not null, "
    		+ "step2 varchar(4000) not null, step2Answer varchar(4000) not null, "
    		+ "step3 varchar(4000) not null, step3Answer varchar(4000) not null, "
    		+ "step4 varchar(4000) not null, step4Answer varchar(4000) not null, finalResult varchar(4000) not null);";
    
    /**
     * Default Constructor for the QuestionTable class
     */
    public QuestionTable() {

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

        String questionID = insertValues.get(0);
        String question = insertValues.get(1);
        String questionDescription = insertValues.get(2);
        String step1 = insertValues.get(3);
        String step1Answer = insertValues.get(4);
        String step2 = insertValues.get(5);
        String step2Answer = insertValues.get(6);
        String step3 = insertValues.get(7);
        String step3Answer = insertValues.get(8);
        String step4 = insertValues.get(9);
        String step4Answer = insertValues.get(10);
        String finalResult = insertValues.get(11);

        String insertString = "INSERT INTO " + tableName + "(questionID, question, questionDescription, step1, step1Answer, step2, step2Answer, step3, step3Answer, step4, step4Answer ,finalResult) VALUES ('" 
        + questionID + "', '" + question + "', '" + questionDescription + "', '" + step1 + "', '" + step1Answer + "', '" + step2 + "', '" + step2Answer + "', '" + step3 + "', '" + step3Answer + "', '" + step4 
        + "', '" + step4Answer + "', '" + finalResult + "');";
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
            "Row_Number() Over (Order By question) As RowNum" +
            ", * " +
           "From " + tableName + 
           ") t2 " +
           "where RowNum = " + rowNumber + ";");

        return retrievedRow;
    }

    /**
     * Deletes a row from the Table
     * @param questionID = the questionID of the row to delete
     */
    public void DeleteRowFromTable(String questionID) {
        String rowToDelete = ("DELETE FROM " + tableName + " WHERE questionID='" + questionID + "';");
        DatabaseOperations.deleteRowFromTable(rowToDelete);
    }
}

