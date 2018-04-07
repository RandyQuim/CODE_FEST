package gui;

import controller.TestMain;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ListView;

import javafx.scene.control.Label;

import javafx.scene.layout.Pane;



public class TeacherAdminMenuController {
	TestMain main;

	public void setMainApp(TestMain main) {
        this.main = main;
        //patientTable.setItems(main.getPatientData());
        } 
	
	
	@FXML
	private Pane teacherAdminPane;
	@FXML
	private ListView studentList;
	@FXML
	private Label studentListLabel;
	@FXML
	private Button addStudentButton;
	@FXML
	private Button viewStudentButton;
	@FXML
	private ListView quizList;
	@FXML
	private Label quizListLabel;
	@FXML
	private Button viewQuizButton;

}
