package gui;

import controller.TeacherAdministration;
import java.util.ArrayList;
import controller.Student;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.ListView;

public class ViewStudentController {
	@FXML
	private Button okButton;
	@FXML
	private ListView<String> mistakes;
	@FXML
	private Label nameLabel;
	@FXML
	private Label scoreLabel;
	
	TeacherAdministration teacher;
	private Stage dialogStage;
	
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

}
