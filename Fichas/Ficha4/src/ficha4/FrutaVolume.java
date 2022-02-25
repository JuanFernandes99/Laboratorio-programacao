package ficha4;

public class FrutaVolume extends Fruta implements IDescontavel {

	private float volume;
	private double percentagem;

	public FrutaVolume(String aNome, double aPrecoBase) {
		super(aNome, aPrecoBase);
		volume = 0;

	}

	@Override
	public double pagar() {

		return precoBase * volume;
	}
	
	@Override
	public double descontar() {
		       
		return (precoBase * volume) * percentagem / 100;
	}

	public float getVolume() {
		return volume;
	}

	public double getPercentagem() {
		return percentagem;
	}

	public void setVolume(float aVolume) {
		volume = aVolume;
	}

	public void setPercentagemDesconto(double aPercentagem) {
		percentagem = aPercentagem;
	}

}
