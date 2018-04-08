package gui;

import java.util.ArrayList;

import controller.TeacherAdministration;
import controller.TestMain;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ListView;

import javafx.scene.control.Label;

import javafx.scene.layout.Pane;



public class TeacherAdminMenuController {
	TestMain main;
	TeacherAdministration teacher;
	
	public void setMainApp(TestMain main) {
        this.main = main;
        } 
	
	
	@FXML
	private Pane teacherAdminPane;
	@FXML
	private ListView<String> studentList;
	@FXML
	private Label studentListLabel;
	@FXML
	private Button addStudentButton;
	@FXML
	private Button viewStudentButton;
	@FXML
	private ListView<Integer> quizList;
	@FXML
	private Label quizListLabel;
	@FXML
	private Button viewQuizButton;
	@FXML
    private void initialize() {
    	 teacher = new TeacherAdministration();
		ArrayList<String> list = new ArrayList<String>();
		list = teacher.getStudentsNames();
    	 studentList.getItems().addAll(list);
    	 
    	 ArrayList<Integer> listQ = new ArrayList<Integer>();    	 
		listQ = teacher.getQuizID();
    	 quizList.getItems().addAll(listQ);
	}
    @FXML
	private void viewStudent() {
		ObservableList<Integer> selectedIndices =
    		    studentList.getSelectionModel().getSelectedIndices();
		System.out.println(selectedIndices);
	}
    @FXML
	private void viewQuiz() {
		ObservableList<Integer> selectedIndices =
    		    quizList.getSelectionModel().getSelectedIndices();
		System.out.println(selectedIndices);
	}
    @FXML
    private void logout() {
    	System.out.println("Logout");
    	main.showLoginPage();
    }
    
    @FXML
    private void addStudent() {
    	System.out.println("Add Stu");
    }
}
