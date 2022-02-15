package ficha3;

public class Casa {

	private String morada;
	private double precoCusto;
	private double precoVenda;

	// construtor
	public Casa() {

	}

	public Casa(String aMorada) {
		morada = aMorada;
	}

	public double getLucro() {

		double lucroCasa = precoVenda - precoCusto; // meter aqui pq nao vai ser preciso em mais nenhum lugar;

		return lucroCasa;
	}

	public double getPercentMargemLucro() {

		double PercentMargemLucro = (100 * getLucro() / precoCusto);

		return PercentMargemLucro;

	}

	public String getMorada() {
		return morada;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

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
