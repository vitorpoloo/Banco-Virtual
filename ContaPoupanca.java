package br.com.projeto.banco;

public class ContaPoupanca extends Conta {
	private float taxaJuros;

	@Override
	public void sacar(double valor) throws ValorInsuficiente {
		if (valor <= getSaldo()) {
			debitar(valor);
			System.out.println("Valor sacado: R$ " + valor + "\nSaldo atual: R$ " + getSaldo());
		} else
			throw new ValorInsuficiente();
	}

	private void setTaxaJuros(float taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	public float getTaxaJuros() {
		return taxaJuros;
	}

	public String printConta() {
		return ("Tipo da conta: Poupan�a\n" + super.printConta() + "\nTaxa de Juros: +" + getTaxaJuros() + " %\n");
	}

	public void aplicaRendimento() {
		double saldoTemp = getSaldo();
		saldoTemp *= (getTaxaJuros() / 100);
		depositar(saldoTemp);
	}

	@Override
	protected String getTipoConta() {
		// TODO Auto-generated method stub
		return "Conta Poupan�a";
	}
}