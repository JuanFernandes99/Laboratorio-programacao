package fruta;

public class FrutaUnidade extends Fruta {

	private int unidade;

	public FrutaUnidade(String aNome, double aPrecoBase) {
		super(aNome, aPrecoBase);
		unidade = 0;
	}

	@Override
	public double pagar() {

		return precoBase * unidade;

	}

	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int aUnidade) {
		unidade = aUnidade;
	}

}
