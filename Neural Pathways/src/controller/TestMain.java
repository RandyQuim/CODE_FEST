package controller;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
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
            // Load login page.
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
    public void showTrivia() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TestMain.class.getResource("../gui/TriviaPage.fxml"));
            AnchorPane triviaPage = (AnchorPane) loader.load();
            rootLayout.setCenter(triviaPage);
            TriviaPageController  controller = loader.getController();
            System.out.println("FKU");
            controller.setMainApp(this);            
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
    }
    
    public void showViewStudentDialog(Student student) {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(TestMain.class.getResource("../gui/ViewStudent.fxml"));
	    	AnchorPane page = (AnchorPane) loader.load();
	    	
	    	//create dialog stage
	    	Stage dialogStage = new Stage();
	    	dialogStage.setTitle("View Student");
	    	dialogStage.initModality(Modality.WINDOW_MODAL);
	    	dialogStage.initOwner(primaryStage);
	    	Scene scene = new Scene(page);
	    	dialogStage.setScene(scene);
	    	
	    	//set the student into the controller
	    	ViewStudentController controller = loader.getController();
	    	controller.setDialogStage(dialogStage);
	    	controller.setStudent(student);
	    	
	    	dialogStage.showAndWait();
	    	
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
