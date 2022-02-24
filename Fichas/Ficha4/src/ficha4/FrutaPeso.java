package ficha4;

public class FrutaPeso extends Fruta {

	private float peso;

	public FrutaPeso(String aNome, double aPrecoBase) {
		super(aNome, aPrecoBase);
		peso = 0;
	}

	@Override
	public double pagar() {
		return precoBase * peso;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float aPeso) {
		peso = aPeso;
	}

}
