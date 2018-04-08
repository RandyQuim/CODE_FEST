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


public class TriviaPageController {
	@FXML
	private Label question;
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
	
	TestMain main;
	QuestionTable questionTable = new QuestionTable();
	String[] lines;
	String[] answers;
	public void setMainApp(TestMain main) {
		this.main=main;
	}
	
	public void submit() {
	
		if(!a1.isSelected()&&!a2.isSelected()&&!a3.isSelected()&&!a4.isSelected()) {}
		else {	
			if(!a1.isSelected() && Integer.parseInt(lines[5])==1) {
				System.out.println("WRONG");}
			if(!a2.isSelected() && Integer.parseInt(lines[5])==2) {
				System.out.println("Wrong");
			}
			if(!a3.isSelected() && Integer.parseInt(lines[5])==3) {
				System.out.println("WRONG");}
			if(!a4.isSelected() && Integer.parseInt(lines[5])==4) {
				System.out.println("Wrong");
			}			
			next.setDisable(false);
			submit.setDisable(true);
		}
	}

	public void next() {
		System.out.println("Next Question");
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
        question.setText(lines[2]);
        
        

	}
	
}
