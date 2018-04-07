package gui;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.PasswordField;

import javafx.event.ActionEvent;

public class LoginPageController {
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Button loginButton;
	
	private static String teacherUsername = "teach";
	private static String pass = "password";
	
	@FXML
	public void login(ActionEvent event) {
		
	}

}
