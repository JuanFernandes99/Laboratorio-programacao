package ficha3;

public class Casa {

	private String morada;
	private double precoCusto;
	private double precoVenda;

	// construtor

	// Construtor sem argumentos.
	public Casa() {

	}

	// Construtor que recebe por parâmetro a morada da casa e cria uma casa com essa
	// morada.
	public Casa(String aMorada) {
		morada = aMorada;
	}

	// Retorna a margem de lucro da casa (diferença entre o preço de venda e o preço
	// de custo).
	public double getMargemLucro() {

		double lucroCasa = precoVenda - precoCusto; // Criar variável lucroCasa cá porque não vai ser preciso em mais
													// nenhum lugar;
		return lucroCasa;
	}

	// Retorna a percentagem da margem de lucro (a razão entre o preço de venda e o
	// preço de custo).
	public double getPercentMargemLucro() {

		double PercentMargemLucro = (getMargemLucro() / (precoVenda * 100));

		return PercentMargemLucro;

	}

	// Getters
	public String getMorada() {
		return morada;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	// Setters
	public void setMorada(String aMorada) {
		morada = aMorada;
	}

	public void setPrecoCusto(double aPrecoCusto) {
		precoCusto = aPrecoCusto;
	}

	public void setPrecoVenda(double aPrecoVenda) {
		precoVenda = aPrecoVenda;
	}

}
