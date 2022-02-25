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

		return (precoBase * peso) - descontar();
	}
	
	@Override
	public double descontar() {
		       
		return (precoBase * peso) * percentagem / 100;
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
