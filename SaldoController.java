package br.com.projeto.banco;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SaldoController implements Initializable {

	private ContaDao contaDao = new ContaDao();

	@FXML
	private TextField txtValor;

	@FXML
	private TextField txtLimite;

	@FXML
	private TextField txtSaldoLimite;

	@FXML
	private Label labelMensagem;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Conta conta = contaDao.getContaLogada();
		txtValor.setText(String.valueOf(conta.getSaldo()));
		double limite = 0;
		if (conta instanceof ContaEspecial) {
			ContaEspecial contaEspecial = (ContaEspecial) conta;
			txtLimite.setText(String.valueOf(contaEspecial.getLimite()));
			limite = contaEspecial.getLimite();
		} else {
			txtLimite.setText(String.valueOf(limite));
		}

		txtSaldoLimite.setText(String.valueOf(conta.getSaldo() + limite));

	}

}
