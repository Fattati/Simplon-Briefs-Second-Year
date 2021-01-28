package application;
	
import Models.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Main extends Application {
	public static User logged;
	
	@Override
	public void start(Stage primaryStage) {
		try{
			Parent root = FXMLLoader.load(getClass().getResource("../View/pageLogin.fxml"));
            Scene scene = new Scene(root,700,600);
            scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void getAlert(String text, String title) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(text);
		alert.showAndWait();
	}
}
