package br.com.projeto.banco;

import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements Dao<Cliente> {

	private static List<Cliente> clientes = new ArrayList<Cliente>();

	private static Cliente clienteLogado;

	@Override
	public void excluir(Cliente cliente) throws Exception {
		clientes.remove(cliente);
	}

	@Override
	public List<Cliente> listar() throws Exception {
		return clientes;
	}

	@Override
	public void salvar(Cliente cliente) throws Exception {
		clientes.add(cliente);
	}

	public Cliente getClienteLogado() {
		return clienteLogado;
	}

	public Cliente pesquisarClientePorNome(String nome) {
		for (Cliente cliente : clientes) {
			if (cliente.getNome().equals(nome)) 
				return cliente;
		}
		return null;
	}
	
}
