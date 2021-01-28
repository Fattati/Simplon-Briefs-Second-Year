/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Dao.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import Models.Apprenant;
import Models.Formateur;
import application.Main;

/**
 *
 * @author DELL
 */
public class FXMLDocumentController implements Initializable {
	@FXML
	private TextField email;
	@FXML
	private TextField password;
	@FXML
	private Button btnConnexion;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	@FXML
	private void connexion(ActionEvent event) throws IOException {
		DatabaseConnection db_con = new DatabaseConnection();
		Main.logged = db_con.authentification(email.getText(), password.getText());
		if (Main.logged != null) {
			if (Main.logged.getClass() == Apprenant.class) {
				Parent PageApprenant = FXMLLoader.load(getClass().getResource("../View/pageApprenant.fxml"));
				Scene s = new Scene(PageApprenant);
				Stage page = (Stage) ((Node) event.getSource()).getScene().getWindow();
				page.setScene(s);
				page.show();
			}
			if (Main.logged.getClass() == Formateur.class) {
				Parent PageFormateur = FXMLLoader.load(getClass().getResource("../View/pageFormateur.fxml"));
				Scene s = new Scene(PageFormateur);
				Stage page = (Stage) ((Node) event.getSource()).getScene().getWindow();
				page.setScene(s);
				page.show();
			}
		
		} else {
			Main.getAlert("Incorrect Email or Password", "ERROR");
		}
	}

}
