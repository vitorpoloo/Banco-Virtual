package br.com.projeto.banco;

import java.util.ArrayList;
import java.util.List;

public class ContaDao implements Dao<Conta> {

	private static List<Conta> contas = new ArrayList<Conta>();

	private static Conta contaLogada;

	@Override
	public void excluir(Conta conta) throws Exception {
		contas.remove(conta);
	}

	@Override
	public List<Conta> listar() throws Exception {
		return contas;
	}

	public List<String> listarContasClientes() throws Exception {
		List<String> contasClientes = new ArrayList<>();
		for (Conta conta : contas) {
			contasClientes.add(conta.getCliente().getNome() + " - " + conta.getNumConta());
		}
		return contasClientes;
	}

	public List<Conta> listarContasDoCliente(Cliente cliente) throws Exception {
		List<Conta> contasClientes = new ArrayList<>();
		for (Conta conta : contas) {
			if (conta.getCliente().getCpf().equals(cliente.getCpf())) {
				contasClientes.add(conta);
			}
		}
		return contasClientes;
	}

	public Conta login(String login, String senha) {
		for (Conta conta : contas) {
			if (conta.getNumConta().equals(login) && conta.getSenha().equals(senha)) {
				contaLogada = conta;
				return conta;
			}
		}
		return null;
	}

	@Override
	public void salvar(Conta conta) throws Exception {
		contas.add(conta);
	}

	public List<Conta> pesquisarContasPorCliente(String nomeCliente) {

		List<Conta> contasPesquisa = new ArrayList<>();
		for (Conta conta : contas) {
			if (conta.getCliente().getNome().equals(nomeCliente))
				contasPesquisa.add(conta);
		}

		return contasPesquisa;
	}

	public Conta pesquisarContasPorNumero(String numero) {

		for (Conta conta : contas) {
			if (conta.getNumConta().equals(numero))
				return conta;
		}

		return null;
	}

	public static String gerarNumConta() {
		return ("17040" + Integer.toString(contas.size()));
	}
	
	public Conta getContaLogada() {
		return contaLogada;
	}
}
