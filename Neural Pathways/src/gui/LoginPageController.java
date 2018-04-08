package gui;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.PasswordField;

import javafx.event.ActionEvent;
import controller.Authentication;
import controller.TeacherAdministration;
import controller.TestMain;
import database.DatabaseOperations;

public class LoginPageController {
	TestMain main;

	public void setMainApp(TestMain main) {
        this.main = main;
        //patientTable.setItems(main.getPatientData());
        }

	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Button loginButton;

	@FXML
	public void login(ActionEvent event) {
		Authentication auth = new Authentication();
		new DatabaseOperations();
		DatabaseOperations.connectToDB();
		System.out.print("Login clicked");
		//main.showTrivia();

		if (auth.authentication(username.getText(), password.getText())){
			main.showTrivia();
		}

		if(username.getText().equals("teacher")) {
			System.out.println("I'm a teacher");
			main.showTeacherAdminPage();
		} else if (username.getText().equals("student")) {
			System.out.println("I'm a student");
		}

	}

}
