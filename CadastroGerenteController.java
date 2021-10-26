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

public class CadastroGerenteController implements Initializable {

	private GerenteDao gerenteDao = new GerenteDao();

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtLogin;

	@FXML
	private TextField txtSenha;

	@FXML
	private Label labelMensagem;

	@FXML
	private ListView<Gerente> listaGerentes;

	@FXML
	private void btnSalvarAction(ActionEvent event) {

		if (campoObrigatorioVazio(txtNome.getText()) || campoObrigatorioVazio(txtLogin.getText())
				|| campoObrigatorioVazio(txtSenha.getText())) {

			labelMensagem.setText("Preencha todos os campos obrigatórios!");

		} else {

			Gerente gerente = new Gerente(txtNome.getText(), txtLogin.getText(), txtSenha.getText());

			try {
				gerenteDao.salvar(gerente);

				labelMensagem.setText("Gerente salvo com sucesso!");

				ObservableList<Gerente> data = FXCollections.observableArrayList(gerenteDao.listar());
				listaGerentes.setItems(data);

			} catch (Exception e) {
				e.printStackTrace();
			}

			txtNome.setText("");
			txtLogin.setText("");
			txtSenha.setText("");
		}
	}

	@FXML
	private void btnAlterarSenhaAction(ActionEvent event) {

		if (campoObrigatorioVazio(txtNome.getText()) || campoObrigatorioVazio(txtLogin.getText())
				|| campoObrigatorioVazio(txtSenha.getText())) {

			labelMensagem.setText("Preencha todos os campos obrigatórios!");

		} else {

			Gerente gerente = gerenteDao.getGerenteLogado();
			gerente.setSenha(txtSenha.getText());

			labelMensagem.setText("Senha alterada com sucesso!");

			txtNome.setText(gerente.getNome());
			txtLogin.setText(gerente.getLogin());
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
		try {
			if (listaGerentes != null) {
				ObservableList<Gerente> data = FXCollections.observableArrayList(gerenteDao.listar());
				listaGerentes.setItems(data);
			} else {
				Gerente gerente = gerenteDao.getGerenteLogado();
				txtNome.setText(gerente.getNome());
				txtLogin.setText(gerente.getLogin());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
