package ficha4;

public class FrutaPeso extends Fruta {

	private double peso;

	public FrutaPeso(String aNome, double aPrecoBase) {
		super(aNome, aPrecoBase);
		peso = 0;
	}

	@Override
	public double pagar() {
		return precoBase * peso;

	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double aPeso) {
		peso = aPeso;
	}

}
