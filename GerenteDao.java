package br.com.projeto.banco;

import java.util.ArrayList;
import java.util.List;

public class GerenteDao implements Dao<Gerente> {

	private static List<Gerente> gerentes = new ArrayList<Gerente>();
	
	private static Gerente gerenteLogado;

	@Override
	public void excluir(Gerente gerente) throws Exception {
		gerentes.remove(gerente);
	}

	@Override
	public List<Gerente> listar() throws Exception {
		return gerentes;
	}

	@Override
	public void salvar(Gerente gerente) throws Exception {
		gerentes.add(gerente);
	}
	
	public Gerente login(String login, String senha) {
		for (Gerente gerente : gerentes) {
			if (gerente.getLogin().equals(login) && gerente.getSenha().equals(senha)) {
				gerenteLogado = gerente;
				return gerente;
			}
		}
		return null;
	}

	public Gerente getGerenteLogado() {
		return gerenteLogado;
	}

}
