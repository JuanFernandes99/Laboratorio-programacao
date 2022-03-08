package projetoExtra1;

import java.util.ArrayList;
import java.util.List;
import utilizador.Utilizador;

public class AppStore {
	private String nome;
	private List<Aplicacao> aplicacoes;
	private List<Utilizador> utilizadores;

	public AppStore(String nome) {
		aplicacoes = new ArrayList<Aplicacao>();
		utilizadores = new ArrayList<Utilizador>();
	}

	public void adicionaUtilizador(Utilizador aUtilizador) {
		utilizadores.add(aUtilizador);
	}

	public void adicionaApp(Aplicacao aAplicacoes) { // b-) Incluir novas aplicações com a informação necessária.
		aplicacoes.add(aAplicacoes);
	}

	public List<Aplicacao> getAplicacoesPorCategoria(TipoAplicacao tipo) {
		return aplicacoes.stream().filter(aplicacao -> aplicacao.getTipo() == tipo).toList();
	}

	public List<Aplicacao> getAplicacoesPorClassificacao(float classificacaoMinima) {
		return aplicacoes.stream().filter(aplicacao -> aplicacao.getAvaliacaoGeral() >= classificacaoMinima).toList();
	}

	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public String getNome() {
		return nome;
	}

	public List<Utilizador> getUtilizadores() {
		return utilizadores;
	}

	public void setAplicacoes(List<Aplicacao> aAplicacoes) {
		aplicacoes = aAplicacoes;
	}

	public void setUtilizadores(List<Utilizador> aUtilizadores) {
		this.utilizadores = aUtilizadores;
	}

	public void setNome(String aNome) {
		nome = aNome;
	}

	@Override
	public String toString() {
		return "AppStore [aplicacoes=" + aplicacoes + "$]";
	}
}
