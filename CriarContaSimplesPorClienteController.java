package br.com.projeto.banco;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CriarContaSimplesPorClienteController implements Initializable {

	private ContaDao contaDao = new ContaDao();

	@FXML
	private TextField txtNumConta;

	@FXML
	private TextField txtLimite;

	@FXML
	private TextField txtTaxa;

	@FXML
	private TextField txtCliente;

	@FXML
	private Label labelMensagem;

	@FXML
	private void btnSalvarAction(ActionEvent event) {

		ContaSimples contaSimples = new ContaSimples(contaDao.getContaLogada().getCliente(), "0000",
				txtNumConta.getText(), 0);

		try {
			contaDao.salvar(contaSimples);

			labelMensagem.setText("Conta criada com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.carregarCampos();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		this.carregarCampos();

	}

	private void carregarCampos() {
		txtCliente.setText(contaDao.getContaLogada().getCliente().getNome());
		txtNumConta.setText(ContaDao.gerarNumConta());
		txtLimite.setText("Conta não suportada");
		txtTaxa.setText("Conta não suportada");
	}

}
