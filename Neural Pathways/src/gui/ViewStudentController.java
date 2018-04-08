package gui;

import controller.TeacherAdministration;
import controller.TestMain;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;

public class ViewStudentController {
	@FXML
	private Button okButton;
	@FXML
	private TableColumn mistakes;
	@FXML
	private Label nameLabel;
	@FXML
	private Label scoreLabel;
	
	TeacherAdministration teacher;
	private Stage dialogStage;
	private boolean okClicked = false;
	
	private void initialize() {
		
	}
	
	private void setStudent() {
		
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void closeWindow() {
		dialogStage.close();
	}

}
