package br.com.projeto.banco;

public class Cliente extends Usuario {

	private String cpf;

	private Gerente gerente;

	public Cliente() {
		super();
	}

	public Cliente(String cpf, String nome, Gerente gerente) {
		super(nome);
		this.cpf = cpf;
		this.gerente = gerente;
	}

	public Cliente(String cpf) {
		super();
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	@Override
	public String toString() {
		return cpf + ", " + getNome();
	}

}
