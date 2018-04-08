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
		
		new DatabaseOperations();
		DatabaseOperations.connectToDB();
		
   	 	// this is for testing QuestionTable
   	 	/**
		ArrayList<String> insertQuestionTableValues = new ArrayList<String>();
   	 	insertQuestionTableValues.add("TestElement1");
   	 	insertQuestionTableValues.add("TestElement2");
   	 	insertQuestionTableValues.add("TestElement3");
   	 	insertQuestionTableValues.add("TestElement4");
   	 	insertQuestionTableValues.add("TestElement5");
   	 	insertQuestionTableValues.add("TestElement6");
   	 	insertQuestionTableValues.add("TestElement7");
   	 	insertQuestionTableValues.add("TestElement8");
   	 	insertQuestionTableValues.add("TestElement9");
   	 	insertQuestionTableValues.add("TestElement10");
   	 	insertQuestionTableValues.add("TestElement11");
   	 	insertQuestionTableValues.add("TestElement12");
   	 			
   	 	QuestionTable QT = new QuestionTable();
		//QT.insertRowIntoTable(QT.getTableName(), insertQuestionTableValues);
		System.out.println("The number of rows in this table are: " + QT.retrieveNumberOfRowsInTable());
		System.out.println(QT.retrieveTableRow(QT.getTableName(), 1));
		*/
		
		// this is for testing StudentTable
		/**
		ArrayList<String> insertStudentTableValues = new ArrayList<String>();
   	 	insertStudentTableValues.add("StudentTableTestElement1");
   	 	insertStudentTableValues.add("StudentTableTestElement2");
   	 	insertStudentTableValues.add("StudentTableTestElement3");
   	    insertStudentTableValues.add("StudentTableTestElement4");
   	 	
   	 	StudentTable ST = new StudentTable();
   	 	//ST.createTable(ST.getTableName(), ST.getTableCreationString());
		//ST.insertRowIntoTable(ST.getTableName(), insertStudentTableValues);
		System.out.println("The number of rows in this table are: " + ST.retrieveNumberOfRowsInTable());
		System.out.println(ST.retrieveTableRow(ST.getTableName(), 1));
		*/
		
		StudentTable ST = new StudentTable();
		System.out.println("The number of rows in this table are: " + ST.retrieveNumberOfRowsInTable());
		
		QuestionTable QT = new QuestionTable();
		System.out.println("The number of rows in this table are: " + QT.retrieveNumberOfRowsInTable());
		
	}
}
