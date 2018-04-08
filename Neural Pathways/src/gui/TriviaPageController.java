package gui;

import controller.TestMain;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;

import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;
import controller.TestMain;

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
	
	public void setMainApp(TestMain main) {
		this.main=main;
	}
	
	public void submit() {
		System.out.println("Submitting");
	}

	public void next() {
		System.out.println("Next Question");
	}
	@FXML
    private void initialize() {
	//next.disableProperty().set(false);
	}
	
}
