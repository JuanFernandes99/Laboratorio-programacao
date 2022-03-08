package projetoExtra1;

import java.util.ArrayList;
import java.util.List;
import utilizador.Utilizador;

public class AppStore {
	private String nome;
	private List<Aplicacao> aplicacoes; // atençao ao apagar as listas
	private List<Compra> compras;
	private List<Utilizador> utilizadores;

	public AppStore(String nome) {
		aplicacoes = new ArrayList<Aplicacao>();
		compras = new ArrayList<Compra>();
		utilizadores = new ArrayList<Utilizador>();
	}

	public void adicionaCompra(Compra aCompra) {
		compras.add(aCompra);
	}
	
	public void adicionaUtilizador(Utilizador aUtilizador) {
		utilizadores.add(aUtilizador);
	}

	public void adicionaApp(Aplicacao aAplicacoes) { // Incluir novas aplicações com a informação necessária.
		aplicacoes.add(aAplicacoes);
	}
	
	public List<Aplicacao> getAplicacoesPorCategoria(TipoAplicacao tipo) {
        return aplicacoes.stream()
                .filter(aplicacao -> aplicacao.getTipo() == tipo)
                .toList();
    }

    public List<Aplicacao> getAplicacoesPorClassificacao(float classificacaoMinima) {
        return aplicacoes.stream()
                .filter(aplicacao -> aplicacao.getAvaliacaoGeral() >= classificacaoMinima)
                .toList();
    }

	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public List<Compra> getCompras() {
		return compras;
	}
	
	public String getNome() {
		return nome;
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



	public void setNome(String aNome) {
		nome = aNome;
	}

}
