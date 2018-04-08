package gui;

import controller.TestMain;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;

import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;
import controller.TestMain;
import database.DatabaseOperations;
import database.QuestionTable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TriviaPageController {
	@FXML
	private Label question;
	Alert alert = new Alert(AlertType.WARNING);
	
	@FXML
	private Label step;
	@FXML
	private RadioButton a1;
	@FXML
	private ToggleGroup group;
	@FXML
	private RadioButton a2;
	@FXML
	private RadioButton a3;
	@FXML
	private RadioButton a4;
	@FXML
	private Button submit;
	@FXML
	private Button next;
	Boolean second = false;
	TestMain main;
	QuestionTable questionTable = new QuestionTable();
	String[] lines;
	String[] answers;
	int questionStep = 4;
	int answerLine = 5;
	public void setMainApp(TestMain main) {
		this.main=main;
	}
	
	public void submit() {
	
		if(!a1.isSelected()&&!a2.isSelected()&&!a3.isSelected()&&!a4.isSelected()) {}
		else {	
			if(!a1.isSelected() && Integer.parseInt(lines[answerLine])==1) {
				System.out.println("WRONG");}
			if(!a2.isSelected() && Integer.parseInt(lines[answerLine])==2) {
				System.out.println("Wrong");
			}
			if(!a3.isSelected() && Integer.parseInt(lines[answerLine])==3) {
				System.out.println("WRONG");}
			if(!a4.isSelected() && Integer.parseInt(lines[answerLine])==4) {
				System.out.println("Wrong");
			}			
			next.setDisable(false);
			submit.setDisable(true);
		}
	}

	public void next() {
		System.out.println("Next Question");
		if(questionStep!=10) {
			nextStep();
		} else {
			
			question.setText("The final Answer is "+ lines[12]);
			
			alert.setContentText("The final Answer is "+lines[12]);
			alert.showAndWait();

			if(second==true) {
				alert.setContentText("Quiz Complete, You are being logged out");
				alert.showAndWait();				
			main.showLoginPage();
			}
			// Quiz Complete
			second = true;
			lines = questionTable.retrieveTableRow("QuestionTable", 2).split("\\r?\\n");
			questionStep = 4;  
			answerLine = 5;    
			question.setText(lines[2]);
			//submit.setDisable(true);
			// Save mistakes
		}
		System.out.println("I WIN");
		next.setDisable(true);
		submit.setDisable(false);
	}
	
	public void nextStep() {
		questionStep += 2;
		answerLine += 2;
		System.out.println(questionStep+" "+answerLine);
		answers = lines[questionStep].split("~");
	    a1.setText(answers[0]);
	    a2.setText(answers[1]);
	    a3.setText(answers[2]);
	    a4.setText(answers[3]);
	    step.setText(answers[4]);
	}
	
	@FXML
    private void initialize() {
		new DatabaseOperations();
		DatabaseOperations.connectToDB();
		int count = 0;
		lines = questionTable.retrieveTableRow("QuestionTable", 1).split("\\r?\\n");
        for (String line : lines) {
            System.out.println("line " + count++ + " : " + line);
        }
        
       answers = lines[4].split("~");
       //System.out.println(answers[1]);
        a1.setText(answers[0]);
        a2.setText(answers[1]);
        a3.setText(answers[2]);
        a4.setText(answers[3]);
        step.setText(answers[4]);
        question.setText(lines[2]);
	}
	
}
