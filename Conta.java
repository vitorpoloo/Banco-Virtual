package br.com.projeto.banco;

public abstract class Conta {

	private Cliente cliente;

	private String senha;

	protected String numeroConta;

	private double saldo;

	public Conta() {
		saldo = 0d;
		senha = "0000";
	}

	public Conta(Cliente cliente, String senha, String numeroConta, double saldo) {
		super();
		this.cliente = cliente;
		this.senha = senha;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}

	public abstract void sacar(double valor) throws ValorInsuficiente;

	public void debitar(double valor) {
		this.saldo -= valor;
	}

	public void depositar(double valor) {
		this.saldo += valor;
	}

	public void setNumConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNumConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public String printConta() {
		return ("Número conta: " + getNumConta() + "\nSaldo: R$" + String.format("%.2f", getSaldo()));
	}

	public void alteraSenha(String senhaAntiga, String senhaNova) throws NotTheSamePassword {
		if (senhaAntiga.equals(senha))
			senha = senhaNova;
		else
			throw new NotTheSamePassword();
	}

	public int checaSenha(String senhaAtual) {
		if (senhaAtual.equals(senha))
			return 1;
		else
			return 0;
	}

	protected abstract String getTipoConta();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return cliente + ", "+ numeroConta + ", " + saldo;
	}
	
	

}