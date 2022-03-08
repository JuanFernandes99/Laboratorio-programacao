package projetoExtra1;

import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

	private String nomeApp;
	private double preco;
	private double avaliacaoGeral;
	private TipoAplicacao tipo;
	private int numVendas;
	private List<Avaliacao> avaliacoes;

	public Aplicacao(String aNomeApp, double aPreco, TipoAplicacao aTipo) {
		avaliacaoGeral = 0;
		nomeApp = aNomeApp;
		preco = aPreco;
		tipo = aTipo;
		avaliacoes = new ArrayList<Avaliacao>();
	}

	public void adicionaAvaliacao(Avaliacao aAvaliacao) { // esta mal soma todas as avaliaçoes
		avaliacoes.add(aAvaliacao);
		double sum = 0;
		for (Avaliacao avaliacao : avaliacoes) {
			sum += avaliacao.getClassificacao();
		}
		avaliacaoGeral = sum / avaliacoes.size();
	}

	public void adicionarVenda() {
		numVendas++;
	}

	// Getters e Setters
	public String getNomeApp() {
		return nomeApp;
	}

	public double getPreco() {
		return preco;
	}

	public TipoAplicacao getTipo() {
		return tipo;
	}

	public int getNumVendas() {
		return numVendas;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public double getAvaliacaoGeral() {
		return avaliacaoGeral;
	}

	public void setNomeApp(String aNomeApp) {
		nomeApp = aNomeApp;
	}

	public void setPreco(double aPreco) {
		preco = aPreco;
	}

	public void setTipo(TipoAplicacao aTipo) {
		tipo = aTipo;
	}

	public void setAvaliacaoGeral(double avaliacaoGeral) {
		this.avaliacaoGeral = avaliacaoGeral;
	}

	public void setNumVendas(int numVendas) {
		this.numVendas = numVendas;
	}

	@Override
	public String toString() {
		return "\nnomeApp=" + nomeApp + ", preco=" + preco + ", avaliacaoGeral=" + avaliacaoGeral + ", tipo=" + tipo
				+ "";
	}

}
