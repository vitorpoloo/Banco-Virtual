package br.com.projeto.banco;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CadastroClienteController implements Initializable {

	private ClienteDao clienteDao = new ClienteDao();

	private GerenteDao gerenteDao = new GerenteDao();

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtCPF;

	@FXML
	private Label labelMensagem;

	@FXML
	private ListView<Cliente> listaClientes;

	@FXML
	private void btnSalvarAction(ActionEvent event) {

		if (campoObrigatorioVazio(txtNome.getText()) || campoObrigatorioVazio(txtCPF.getText())) {

			labelMensagem.setText("Preencha todos os campos obrigatórios!");

		} else {

			Gerente gerenteLogado = gerenteDao.getGerenteLogado();
			Cliente cliente = new Cliente(txtCPF.getText(), txtNome.getText(), gerenteLogado);

			try {
				clienteDao.salvar(cliente);
				gerenteLogado.adicionarCliente(cliente);

				labelMensagem.setText("Cliente salvo com sucesso!");

				ObservableList<Cliente> data = FXCollections.observableArrayList(clienteDao.listar());
				listaClientes.setItems(data);

			} catch (Exception e) {
				e.printStackTrace();
			}

			txtNome.setText("");
			txtCPF.setText("");
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
		try {
			ObservableList<Cliente> data = FXCollections.observableArrayList(clienteDao.listar());
			listaClientes.setItems(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
