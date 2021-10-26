package br.com.projeto.banco;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrincipalController implements Initializable {

	@FXML
	private void btnAbrirTelaGerente(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginGerente.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/Styles.css");

			Stage stage = new Stage();
			stage.setTitle("Login Gerente");
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void btnAbrirTelaCliente(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginCliente.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/Styles.css");

			Stage stage = new Stage();
			stage.setTitle("Login Cliente");
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}
}
