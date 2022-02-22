package ficha4;

public abstract class Fruta {

	protected String nome;
	protected double precoBase;

	public Fruta(String aNome, double aPrecoBase) {
		nome = aNome;
		precoBase = aPrecoBase;
	}

	public abstract double pagar();

	
	public String getNome() {
		return nome;
	}

	public double getPrecoBase() {
		return precoBase;
	}

	public void setNome(String aNome) {
		nome = aNome;
	}

	public void setPrecoBase(double aPrecoBase) {
		precoBase = aPrecoBase;
	}

}
