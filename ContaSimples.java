package br.com.projeto.banco;

public class ContaSimples extends Conta {

	public ContaSimples() {
		super();
	}

	public ContaSimples(Cliente cliente, String senha, String numeroConta, double saldo) {
		super(cliente, senha, numeroConta, saldo);
	}

	public String printConta() {
		return ("Tipo da conta: Simples\n" + super.printConta());
	}

	@Override
	public void sacar(double valor) throws ValorInsuficiente {
		if (valor <= getSaldo())
			debitar(valor);
		else
			throw new ValorInsuficiente();
	}

	@Override
	protected String getTipoConta() {
		return "Conta Simples";
	}
}