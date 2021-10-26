package br.com.projeto.banco;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RetiradaController implements Initializable {

	private ContaDao contaDao = new ContaDao();

	@FXML
	private TextField txtValor;

	@FXML
	private Label labelMensagem;

	@FXML
	private ComboBox<String> cboContasClientes;

	@FXML
	private void btnSalvarAction(ActionEvent event) {

		if (cboContasClientes.getSelectionModel().getSelectedItem() == null) {
			labelMensagem.setText("Informe um cliente para a conta!");
		} else {

			String vetor[] = cboContasClientes.getSelectionModel().getSelectedItem().split(" - ");

			Conta conta = contaDao.pesquisarContasPorNumero(vetor[1]);

			double valor = Double.parseDouble(txtValor.getText());
			if (conta.getSaldo() >= valor) {
				conta.debitar(valor);
				labelMensagem.setText("Retirada feita com sucesso!");
			} else {
				labelMensagem.setText("Saldo Insuficiente!");
			}

			this.carregarCampos();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			ObservableList<String> clientesContas = FXCollections.observableArrayList(contaDao.listarContasClientes());
			cboContasClientes.setItems(clientesContas);

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.carregarCampos();

	}

	private void carregarCampos() {
		txtValor.setText("");
	}

}
