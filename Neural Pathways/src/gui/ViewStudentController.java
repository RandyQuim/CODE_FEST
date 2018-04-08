package gui;

import controller.TeacherAdministration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import controller.Student;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import database.DatabaseOperations;
import database.QuestionTable;
import database.StudentTable;


import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.ListView;

public class ViewStudentController {
	@FXML
	private Button okButton;
	@FXML
	private Button tocsv;
	@FXML
	private ListView<String> mistakes;
	@FXML
	private Label nameLabel;
	@FXML
	private Label scoreLabel;
	
	TeacherAdministration teacher;
	private Stage dialogStage;
	String[] row;
	QuestionTable questionTable = new QuestionTable();

	public void setStudent(Student student) {
		nameLabel.setText(student.getName());
		scoreLabel.setText(Integer.toString(student.getScore()));
		
		ArrayList<String> list = new ArrayList<String>();
		list = student.getIncorrectSteps();
		mistakes.getItems().addAll(list);
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	@FXML
	public void closeWindow() {
		dialogStage.close();
	}
	
	@FXML
	public void exportCSV() throws FileNotFoundException {
		StudentTable studentTable;
		studentTable = new StudentTable();
		try {
			 PrintWriter pw = new PrintWriter(new File("test.csv"));
		        StringBuilder sb = new StringBuilder();
		        sb.append("Name,Score,Mistakes\n");
			new DatabaseOperations();
			DatabaseOperations.connectToDB();
			int count = 0;
			String grades[] = {};
			String line;
			for(int i = 1; i <= 5; i++) {
				row = studentTable.retrieveTableRow("StudentTable", i).split("\\r?\\n");
				
				for (int j=0;j<row.length;j++) {
		            System.out.println("line " + count++ + " : " + row[j]);
		            if(j == 1 || j == 4) {sb.append(row[j]);
		            sb.append(",");}

		            if(j == 3) {
		            	grades = row[3].split("~");

		            }

		            
	        }
				
            	for( String a:grades)
            	{	sb.append(a);sb.append(",");
            }	sb.append("\n");			
			}
			pw.write(sb.toString());
            pw.close();
			System.out.println("File Written");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
