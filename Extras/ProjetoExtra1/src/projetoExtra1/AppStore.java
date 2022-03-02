package projetoExtra1;

import java.util.ArrayList;
import java.util.List;
import utilizador.Utilizador;

public class AppStore {

	private List<Aplicacao> aplicacoes; // atençao ao apagar as listas
	private List<Compra> compras;
	private List<Utilizador> utilizadores;
	
	public AppStore() {
		aplicacoes = new ArrayList<Aplicacao>();
		compras = new ArrayList<Compra>();
		utilizadores = new ArrayList<Utilizador>();
	}

	public void adicionaUtilizador(Utilizador aUtilizador) {
		utilizadores.add(aUtilizador);
	}
	
	public void adicionaApp(Aplicacao aAplicacoes) {
		aplicacoes.add(aAplicacoes);
	}


	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public List<Compra> getCompras() {
		return compras;
	}


	public void setAplicacoes(List<Aplicacao> aAplicacoes) {
		aplicacoes = aAplicacoes;
	}

	public void setCompras(List<Compra> aCompras) {
		compras = aCompras;
	}

	@Override
	public String toString() {
		return "AppStore [aplicacoes=" + aplicacoes + "$]";
	}

	public List<Utilizador> getUtilizadores() {
		return utilizadores;
	}

	public void setUtilizadores(List<Utilizador> aUtilizadores) {
		this.utilizadores = aUtilizadores;
	}

}
