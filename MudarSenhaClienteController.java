package br.com.projeto.banco;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MudarSenhaClienteController implements Initializable {

	private ContaDao contaDao = new ContaDao();

	@FXML
	private TextField txtConta;

	@FXML
	private TextField txtSenha;

	@FXML
	private Label labelMensagem;

	@FXML
	private ComboBox<Cliente> cboClientes;

	@FXML
	private void btnAlterarSenhaAction(ActionEvent event) {

		Conta conta = contaDao.getContaLogada();

		if (campoObrigatorioVazio(txtSenha.getText())) {
			labelMensagem.setText("Informe sua nova senha!");
		} else {
			conta.setSenha(txtSenha.getText());
			labelMensagem.setText("Senha alterada!");
		}

		txtConta.setText(conta.getNumConta());

	}

	private boolean campoObrigatorioVazio(String campo) {
		if (campo.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Conta conta = contaDao.getContaLogada();
		txtConta.setText(conta.getNumConta());

	}

}
