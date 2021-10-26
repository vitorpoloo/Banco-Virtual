package br.com.projeto.banco;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GerenteController implements Initializable {

	private ContaDao contaDao = new ContaDao();

	@FXML
	private TextField txtNomeCliente;

	@FXML
	private ListView<Conta> listaContas;

	@FXML
	private void btnAbrirContaSimplesAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/CriarContaSimples.fxml"));

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
	private void btnAbrirContaEspecialAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/CriarContaEspecial.fxml"));

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
	private void btnAbrirContaPoupancaAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/CriarContaPoupanca.fxml"));

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
	private void btnAbrirCadastroClienteAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/CadastroCliente.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/Styles.css");

			Stage stage = new Stage();
			stage.setTitle("Cadastro de Cliente");
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void btnAbrirCadastroGerenteAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/CadastroGerente.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add("/styles/Styles.css");

			Stage stage = new Stage();
			stage.setTitle("Cadastro de Gerente");
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void btnAbrirAplicacaoAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Aplicacao.fxml"));

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
	private void btnAbrirTransferenciaAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Transferencia.fxml"));

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
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Retirada.fxml"));

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
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/MudarSenhaGerente.fxml"));

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
	private void btnPesquisarContaPorCliente(ActionEvent event) {

		ObservableList<Conta> data = FXCollections
				.observableArrayList(contaDao.pesquisarContasPorCliente(txtNomeCliente.getText()));
		listaContas.setItems(data);

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
}
