package br.com.projeto.banco;

public class ContaEspecial extends Conta {
	private double limite;

	public ContaEspecial(Cliente cliente, String senha, String numeroConta, double saldo, double limite) {
		super(cliente, senha, numeroConta, saldo);
		this.limite = limite;
	}

	@Override
	public void sacar(double valor) throws ValorInsuficiente {
		if (valor <= (getSaldo() + limite)) {
			debitar(valor);
			System.out.println("Valor sacado: R$ " + valor + "\nSaldo atual: R$ " + getSaldo());
		} else
			throw new ValorInsuficiente();
	}

	public void cobrancaJuros(float quantJuros) {
		double saldoCobranca = getSaldo();
		if (saldoCobranca < 0) {
			saldoCobranca *= -(quantJuros / 100.0);
			debitar(saldoCobranca);
		}
	}

	@Override
	protected String getTipoConta() {
		// TODO Auto-generated method stub
		return "Conta Especial";
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

}