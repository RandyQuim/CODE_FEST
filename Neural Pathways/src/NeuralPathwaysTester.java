import java.util.ArrayList;

import database.DatabaseOperations;
import database.QuestionTable;
import database.StudentTable;

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
		
   	 	// this is for testing QuestionTable Q1
		/**
		ArrayList<String> insertQuestionTableQ1Values = new ArrayList<String>();
   	 	insertQuestionTableQ1Values.add("Q1"); 				// Identifier
   	 	insertQuestionTableQ1Values.add("Find the X value in the following equation? 5x - 11 = 42"); //Question
   	 	insertQuestionTableQ1Values.add("whydoyoudodis.jpg"); // Irrelevant
   	 	insertQuestionTableQ1Values.add("Add 11 to both sides~Subtract 11 to both sides~Multiply 5x by 2~Add 5 to both~What do you do first?");		//Step1 Answers ~ Step1 Question
   	 	insertQuestionTableQ1Values.add("1");		//Step1Ans [Position 1 starting from 1]
   	 	insertQuestionTableQ1Values.add("5x = 53~5x = 42~53x = 5~3x = 42~5x - 11 + 11 = 42 + 11");		//Step2 Answers ~ Step2 Qustion
   	 	insertQuestionTableQ1Values.add("1");		//Step2Ans [pos 2]
   	 	insertQuestionTableQ1Values.add("Divide both sides by 5~Multiply both sides by 5~add 5 to both sides~subtract 11 from both sides~Solve 5x=53");		//Step3 Answers - Step3 question
   	 	insertQuestionTableQ1Values.add("1");      //Step3Ans   
   	 	insertQuestionTableQ1Values.add("x = 5/53~x = 5~x = 53~x = 53/5");     //Step4 ~ question
   	 	insertQuestionTableQ1Values.add("4");     //Step4Ans   
   	 	insertQuestionTableQ1Values.add("x = 53/5");     //Result
   	 	*/
		
		
   	 	// this is for testing QuestionTable Q2
		/**
		ArrayList<String> insertQuestionTableQ2Values = new ArrayList<String>();
		insertQuestionTableQ2Values.add("Q2"); 				// Identifier
		insertQuestionTableQ2Values.add("Find the X value in the following equation? 3x + 9 = 27"); //Question
		insertQuestionTableQ2Values.add("whydoyoudodis.jpg"); // Irrelevant
		insertQuestionTableQ2Values.add("Subtract 9 to both sides~Add 27 to both sides~Multiply 5x by 27~Add 27 to both sides~What do you do first?");		//Step1 Answers ~ Step1 Question
		insertQuestionTableQ2Values.add("1");		//Step1Ans [Position 1 starting from 1]
		insertQuestionTableQ2Values.add("3x = 18~3x = 27~9x = 27~27x = 27 + 9~3x + 9 - 9 = 27 - 9");		//Step2 Answers ~ Step2 Question
		insertQuestionTableQ2Values.add("1");		//Step2Ans [pos 2]
		insertQuestionTableQ2Values.add("Divide both sides by 3~Multiply both sides by 3~add 3 to both sides~subtract 9 from both sides~Solve 3x=18");		//Step3 Answers - Step3 question
		insertQuestionTableQ2Values.add("1");      //Step3Ans   
		insertQuestionTableQ2Values.add("x = 18~x = 27~x = 3~x = 6~3x = 18");     //Step4 ~ question
		insertQuestionTableQ2Values.add("4");     //Step4Ans   
		insertQuestionTableQ2Values.add("x = 6");     //Result
		*/
		
   	 	QuestionTable QT = new QuestionTable();
   	 	//QT.createTable(QT.getTableName(),QT.getTableCreationString());
		//QT.insertRowIntoTable(QT.getTableName(), insertQuestionTableQ1Values);
   	 	//QT.insertRowIntoTable(QT.getTableName(), insertQuestionTableQ2Values);
		System.out.println("The number of rows in this table are: " + QT.retrieveNumberOfRowsInTable());
		System.out.println(QT.retrieveTableRow(QT.getTableName(), 1));
		System.out.println(QT.retrieveTableRow(QT.getTableName(), 2));
		
		// this is for testing StudentTable
		/*ArrayList<String> insertStudentTableValues = new ArrayList<String>();
   	 	insertStudentTableValues.add("Chris");
   	 	insertStudentTableValues.add("sirhc");
   	 	insertStudentTableValues.add("");
   	    insertStudentTableValues.add("100");
   	 	*/
   	 	StudentTable ST = new StudentTable();
   	 	//ST.createTable(ST.getTableName(), ST.getTableCreationString());
		//ST.insertRowIntoTable(ST.getTableName(), insertStudentTableValues);
		//System.out.println("The number of rows in this table are: " + ST.retrieveNumberOfRowsInTable());
		//System.out.println(ST.retrieveTableRow(ST.getTableName(), 1));
		
		
		//StudentTable ST = new StudentTable();
		//System.out.println("The number of rows in student table are: " + ST.retrieveNumberOfRowsInTable());
		
		//QuestionTable QT = new QuestionTable();
		//System.out.println("The number of rows in question table are: " + QT.retrieveNumberOfRowsInTable());
		
	}
}
