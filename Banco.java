package br.com.projeto.banco;

public class Banco {
	public static void main(String[] args) {
		GerenteDao dados = new GerenteDao();
		Gerente gerente = new Gerente();
		gerente.setNome("Alex");
		gerente.setLogin("alex");
		gerente.setSenha("1");
		try {
			dados.salvar(gerente);
		} catch (Exception e) {
			e.printStackTrace();
		}

		EntryPoint.main(args);

	}
}
