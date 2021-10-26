package br.com.projeto.banco;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AplicacaoClienteController implements Initializable {

	private ContaDao contaDao = new ContaDao();

	@FXML
	private TextField txtValor;

	@FXML
	private Label labelMensagem;

	@FXML
	private void btnSalvarAction(ActionEvent event) {

		Conta conta = contaDao.getContaLogada();
		conta.depositar(Double.parseDouble(txtValor.getText()));

		labelMensagem.setText("Aplicação feita com sucesso!");

		txtValor.setText("");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		txtValor.setText("");
	}

}
