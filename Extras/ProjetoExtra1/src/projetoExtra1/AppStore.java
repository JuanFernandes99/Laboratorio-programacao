package projetoExtra1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import utilizador.Utilizador;

public class AppStore {
	private String nome;
	private double lucro;
	private List<Aplicacao> aplicacoes;
	private List<Utilizador> utilizadores;
	private List<Compra> compras;

	public AppStore(String nome) {
		lucro = 0;
		aplicacoes = new ArrayList<Aplicacao>();
		utilizadores = new ArrayList<Utilizador>();
		compras = new ArrayList<Compra>();
	}

	public void adicionaUtilizador(Utilizador aUtilizador) {
		utilizadores.add(aUtilizador);
	}

	public void adicionarCompra(Compra aCompra) {
		compras.add(aCompra);
	}
	public  void registarCliente() {
		System.out.println("\nDigite o nome:");
		String aNome = Main.sc.nextLine();
		System.out.println("\nDigite a sua idade:");
		int aIdade = Main.sc.nextInt();
		System.out.println("\nDigite o seu saldo:"); //?
		double aSaldo = Main.sc.nextInt();
		Utilizador cliente = new Cliente(aNome, aIdade, aSaldo);
		utilizadores.add(cliente);
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

	public List<Aplicacao> listarPorNome() {

		aplicacoes.sort(Comparator.comparing(Aplicacao::getNomeApp));
		return aplicacoes;
	}

	public List<Aplicacao> listarPorVendas() {

		aplicacoes.sort(Comparator.comparing(Aplicacao::getNumVendas));
		return aplicacoes;
	}

	public List<Aplicacao> listarPorClassificacao() {
		aplicacoes.sort(Comparator.comparing(Aplicacao::getAvaliacaoGeral).reversed());
		return aplicacoes;
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

	public double getLucro() {
		for (Compra compra : compras) {
			lucro += compra.getValor();
		}
		return lucro;
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

}
