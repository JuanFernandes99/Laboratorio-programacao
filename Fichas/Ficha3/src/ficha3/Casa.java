package ficha3;

public class Casa {

	private String morada;
	private double precoCusto;
	private double precoVenda;

	// construtor


	// Construtor que recebe por par�metro a morada da casa e cria uma casa com essa
	// morada.
	public Casa(String aMorada) {
		morada = aMorada;
	}

	// Retorna a margem de lucro da casa (diferen�a entre o pre�o de venda e o pre�o
	// de custo).
	public double getMargemLucro() {

		return precoVenda - precoCusto;
	}

	// Retorna a percentagem da margem de lucro (a raz�o entre o pre�o de venda e o
	// pre�o de custo).
	public double getPercentMargemLucro() {

		return precoVenda/precoCusto;

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
