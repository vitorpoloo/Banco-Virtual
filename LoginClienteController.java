package br.com.projeto.banco;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginClienteController implements Initializable {

	private ClienteDao clienteDao = new ClienteDao();
	
	private ContaDao contaDao = new ContaDao();

	@FXML
	private TextField txtLogin;

	@FXML
	private TextField txtSenha;

	@FXML
	private Label labelMensagem;

	@FXML
	private void btnFazerLoginAction(ActionEvent event) {

		if (campoObrigatorioVazio(txtLogin.getText()) || campoObrigatorioVazio(txtSenha.getText())) {

			labelMensagem.setText("Preencha todos os campos obrigatórios!");

		} else {
			
			Conta conta = contaDao.login(txtLogin.getText(), txtSenha.getText());
			
			if (conta != null) {
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/fxml/Cliente.fxml"));

					Scene scene = new Scene(root);
					scene.getStylesheets().add("/styles/Styles.css");

					Stage stage = new Stage();
					stage.setTitle("Cliente");
					stage.setScene(scene);
					stage.show();

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				labelMensagem.setText("Conta não encontrado!");
			}
			
			txtLogin.setText("");
			txtSenha.setText("");
		}
	}

	private boolean campoObrigatorioVazio(String campo) {
		if (campo.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
