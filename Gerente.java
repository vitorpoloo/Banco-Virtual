package br.com.projeto.banco;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends Usuario {

	private List<Cliente> clientes = new ArrayList<>();

	private String login;

	private String senha;

	public Gerente() {
		super();
	}

	public Gerente(String nome, String login, String senha) {
		super(nome);
		this.login = login;
		this.senha = senha;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void adicionarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return getNome() + ", " + login;
	}

}
