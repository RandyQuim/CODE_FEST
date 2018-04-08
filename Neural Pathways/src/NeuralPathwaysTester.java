import java.util.ArrayList;

import database.DatabaseOperations;
import database.QuestionTable;

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
		ArrayList<String> insertQuestionTableValues = new ArrayList<String>();
   	 	insertQuestionTableValues.add("Q1"); 				// Identifier
   	 	insertQuestionTableValues.add("Find the X value in the following equation? 5x - 11 = 42"); //Question
   	 	insertQuestionTableValues.add("whydoyoudodis.jpg"); // Irrelevant
   	 	insertQuestionTableValues.add("Add 11 to both sides~Subtract 11 to both sides~Multiply 5x by 2~Add 5 to both");		//Step1
   	 	insertQuestionTableValues.add("1");		//Step1Ans [Position 1 starting from 1]
   	 	insertQuestionTableValues.add("wrong~5x-11+11=42+11~wrong~wrong");		//Step2
   	 	insertQuestionTableValues.add("2");		//Step2Ans [pos 2]
   	 	insertQuestionTableValues.add("Divide both sides by 5~Multiply both sides by 5~add 5 to both sides~subtract 11 from both sides");		//Step3
   	 	insertQuestionTableValues.add("1");      //Step3Ans   
   	 	insertQuestionTableValues.add("wrong~wrong~wrong~(5x)/5 = 53/5");     //Step4
   	 	insertQuestionTableValues.add("4");     //Step4Ans   
   	 	insertQuestionTableValues.add("x = 53/5");     //Result
   	 			
   	 	QuestionTable QT = new QuestionTable();
		//QT.insertRowIntoTable(QT.getTableName(), insertQuestionTableValues);
		System.out.println("The number of rows in this table are: " + QT.retrieveNumberOfRowsInTable());
		System.out.println(QT.retrieveTableRow(QT.getTableName(), 1));
		
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
		System.out.println("The number of rows in student table are: " + ST.retrieveNumberOfRowsInTable());
		
		//QuestionTable QT = new QuestionTable();
		System.out.println("The number of rows in question table are: " + QT.retrieveNumberOfRowsInTable());
		
	}
}
