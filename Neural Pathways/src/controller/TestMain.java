package controller;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import gui.*;

public class TestMain extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Neural Pathways");

        initRootLayout();

        showLoginPage();
        //showTeacherAdminPage();
	}
	
	
	public void initRootLayout() throws Exception{
        try {
        		// Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TestMain.class.getResource("../gui/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            	// Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // end of initRootLayout method
	
	
	
	
	/**
     * Shows the login page
     */
    public void showLoginPage() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TestMain.class.getResource("../gui/LoginPage.fxml"));
            AnchorPane loginPage = (AnchorPane) loader.load();
            LoginPageController controller = loader.getController();
            controller.setMainApp(this);
            rootLayout.setCenter(loginPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showTeacherAdminPage() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TestMain.class.getResource("../gui/TeacherAdminMenu.fxml"));
            AnchorPane teacherPage = (AnchorPane) loader.load();
            rootLayout.setCenter(teacherPage);
            TeacherAdminMenuController  controller = loader.getController();
            controller.setMainApp(this);            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
	public static void main(String[] args) {
		launch(args);
	}
}
