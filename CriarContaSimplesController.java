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

public class CriarContaSimplesController implements Initializable {

	private ClienteDao clienteDao = new ClienteDao();
	private GerenteDao gerenteDao = new GerenteDao();
	private ContaDao contaDao = new ContaDao();

	@FXML
	private TextField txtNumConta;

	@FXML
	private TextField txtLimite;

	@FXML
	private TextField txtTaxa;

	@FXML
	private Label labelMensagem;

	@FXML
	private ComboBox<Cliente> cboClientes;

	@FXML
	private void btnSalvarAction(ActionEvent event) {

		if (cboClientes.getSelectionModel().getSelectedItem() == null) {
			labelMensagem.setText("Informe um cliente para a conta!");
		} else {

			Gerente gerenteLogado = gerenteDao.getGerenteLogado();
			ContaSimples contaSimples = new ContaSimples(cboClientes.getSelectionModel().getSelectedItem(), "0000", txtNumConta.getText(), 0);

			try {
				gerenteLogado.adicionarCliente(cboClientes.getSelectionModel().getSelectedItem());
				contaDao.salvar(contaSimples);

				labelMensagem.setText("Conta criada com sucesso!");

			} catch (Exception e) {
				e.printStackTrace();
			}

			this.carregarCampos();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			ObservableList<Cliente> clientes = FXCollections.observableArrayList(clienteDao.listar());
			cboClientes.setItems(clientes);

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.carregarCampos();

	}

	private void carregarCampos() {
		txtNumConta.setText(ContaDao.gerarNumConta());
		txtLimite.setText("Conta não suportada");
		txtTaxa.setText("Conta não suportada");
	}

}
