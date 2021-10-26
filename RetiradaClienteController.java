package br.com.projeto.banco;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RetiradaClienteController implements Initializable {

	private ContaDao contaDao = new ContaDao();

	@FXML
	private TextField txtValor;

	@FXML
	private Label labelMensagem;

	@FXML
	private void btnSalvarAction(ActionEvent event) {

		if (campoObrigatorioVazio(txtValor.getText())) {
			labelMensagem.setText("Informe um valor!");
		} else {
			Conta conta = contaDao.getContaLogada();

			if (conta.getSaldo() < Double.parseDouble(txtValor.getText())) {
				labelMensagem.setText("Saldo Insuficiente!");
			} else {
				conta.debitar(Double.parseDouble(txtValor.getText()));
				labelMensagem.setText("Retirada feita com sucesso!");
				txtValor.setText("");
			}
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

		txtValor.setText("");
	}

}
