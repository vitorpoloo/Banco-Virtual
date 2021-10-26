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

public class ClienteController implements Initializable {

	@FXML
	private void btnAbrirContaSimplesPorClienteAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/CriarContaSimplesPorCliente.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/Styles.css");

			Stage stage = new Stage();
			stage.setTitle("Abrir Conta Simples");
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void btnAbrirContaEspecialPorClienteAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/CriarContaEspecialPorCliente.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/Styles.css");

			Stage stage = new Stage();
			stage.setTitle("Abrir Conta Especial");
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void btnAbrirContaPoupancaPorClienteAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/CriarContaPoupancaPorCliente.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/Styles.css");

			Stage stage = new Stage();
			stage.setTitle("Abrir Conta Poupança");
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void btnAbrirAplicacaoAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/AplicacaoCliente.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/Styles.css");

			Stage stage = new Stage();
			stage.setTitle("Fazer Aplicação");
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void btnAbrirSaldoAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Saldo.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/Styles.css");

			Stage stage = new Stage();
			stage.setTitle("Fazer Transferência");
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void btnAbrirRetiradaAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/RetiradaCliente.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/Styles.css");

			Stage stage = new Stage();
			stage.setTitle("Fazer Retirada");
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void btnAbrirMudarSenhaAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/MudarSenhaCliente.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/Styles.css");

			Stage stage = new Stage();
			stage.setTitle("Fazer Retirada");
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
