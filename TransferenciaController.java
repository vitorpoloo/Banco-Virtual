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

public class TransferenciaController implements Initializable {

	private ContaDao contaDao = new ContaDao();

	@FXML
	private TextField txtValor;

	@FXML
	private Label labelMensagem;

	@FXML
	private ComboBox<String> cboContasClientesRetirada;

	@FXML
	private ComboBox<String> cboContasClientesRecebimento;

	@FXML
	private void btnSalvarAction(ActionEvent event) {

		if (cboContasClientesRetirada.getSelectionModel().getSelectedItem() == null) {
			labelMensagem.setText("Informe a conta de retirada!");
		} else if (cboContasClientesRecebimento.getSelectionModel().getSelectedItem() == null) {
			labelMensagem.setText("Informe a conta de recebimento!");
		} else {

			String vetorContaRetirada[] = cboContasClientesRetirada.getSelectionModel().getSelectedItem().split(" - ");
			String vetorContaRecebimento[] = cboContasClientesRecebimento.getSelectionModel().getSelectedItem()
					.split(" - ");

			Conta contaRetirada = contaDao.pesquisarContasPorNumero(vetorContaRetirada[1]);
			Conta contaRecebimento = contaDao.pesquisarContasPorNumero(vetorContaRecebimento[1]);

			double valor = Double.parseDouble(txtValor.getText());
			if (contaRetirada.getSaldo() >= valor) {
				contaRetirada.debitar(valor);
				contaRecebimento.depositar(valor);
				labelMensagem.setText("Transferência feita com sucesso!");

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
			cboContasClientesRetirada.setItems(clientesContas);
			cboContasClientesRecebimento.setItems(clientesContas);

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.carregarCampos();

	}

	private void carregarCampos() {
		txtValor.setText("");
	}

}
