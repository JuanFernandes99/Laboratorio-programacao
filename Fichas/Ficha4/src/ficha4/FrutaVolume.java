package ficha4;

public class FrutaVolume extends Fruta {

	private double volume;

	public FrutaVolume(String aNome, double aPrecoBase) {
		super(aNome, aPrecoBase);
		volume = 0;

	}

	@Override
	public double pagar() {

		return precoBase * volume;

	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double aVolume) {
		volume = aVolume;
	}

}
