package projetoExtra1;

public class Aplicacao {

	private String nomeApp;
	private double preco;
	private double avaliacao;
	private TipoAplicacao tipo;

	public Aplicacao(String aNomeApp, double aPreco, TipoAplicacao aTipo) {
		nomeApp = aNomeApp;
		preco = aPreco;
		tipo = aTipo;
	}

	public String getNomeApp() {
		return nomeApp;
	}

	public double getPreco() {
		return preco;
	}

	public double getAvaliacao() {
		return avaliacao;
	}

	public TipoAplicacao getTipo() {
		return tipo;
	}

	public void setNomeApp(String aNomeApp) {
		nomeApp = aNomeApp;
	}

	public void setPreco(double aPreco) {
		preco = aPreco;
	}

	public void setAvaliacao(double aAvaliacao) {
		avaliacao = aAvaliacao;
	}

	public void setTipo(TipoAplicacao aTipo) {
		tipo = aTipo;
	}

	@Override
	public String toString() {
		return "Aplicacao [nomeApp=" + nomeApp + ", preco=" + preco + "€, avaliacao=" + avaliacao + ", tipo=" + tipo
				+ "]";
	}
	

}
