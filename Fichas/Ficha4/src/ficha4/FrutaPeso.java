package ficha4;

public class FrutaPeso extends Fruta implements IDescontavel {

	private float peso;
	private double percentagem;

	public FrutaPeso(String aNome, double aPrecoBase) {
		super(aNome, aPrecoBase);
		peso = 0;
	}

	@Override
	public double pagar() {
		return precoBase * peso;
	}
	
	@Override
	public double descontar() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getPeso() {
		return peso;
	}
	
	public double getPercentagem() {
		return percentagem;
	}

	public void setPeso(float aPeso) {
		peso = aPeso;
	}

	public void setPercentagemDesconto(double aPercentagem) {
		percentagem = aPercentagem;
	}

}
