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
 * File Name: NeuralPathwaysTester.java
 * 
 * This Program: will help with determining the amount of learning 
 * occuring during a course.
 */

public class NeuralPathwaysTester {

	public static void main(String[] args) {
		
		String tableName = "TestTable";
		String tableCreationString = "(column1 varchar(4000) not null PRIMARY KEY, column2 varchar(4000) not null, column3 varchar(4000) not null);";
		String insertionString = "";
		String column = "column1";
   	 	String rowToDelete = ("DELETE FROM " + tableName + " WHERE column1='" + column + "';");
   	 	ArrayList<String> insertValues = new ArrayList<String>();
   	 	
   	 	insertValues.add("TestElement1");
   	 	insertValues.add("TestElement2");
   	 	insertValues.add("TestElement3");
   	 	insertValues.add("TestElement4");
   	 	insertValues.add("TestElement5");
   	 	insertValues.add("TestElement6");
   	 	insertValues.add("TestElement7");
   	 	insertValues.add("TestElement8");
   	 	insertValues.add("TestElement9");
   	 	insertValues.add("TestElement10");
   	 	insertValues.add("TestElement11");
   	 	insertValues.add("TestElement12");
		
		new DatabaseOperations();
		DatabaseOperations.connectToDB();
		QuestionTable QT = new QuestionTable();
		//QT.insertRowIntoTable(QT.getTableName(), insertValues);
		System.out.println("The number of rows in this table are: " + QT.retrieveNumberOfRowsInTable());
		System.out.println(QT.retrieveTableRow(QT.getTableName(), 1));
		
		//DatabaseOperations.DeleteRowFromTable(tableName, rowToDelete);
		//DatabaseOperations.InsertIntoTable(tableName, insertionString);
		//DatabaseOperations.retrieveNumberOfRowsInTable(tableName);
	}
}
