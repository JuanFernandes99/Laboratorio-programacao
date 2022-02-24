package ficha4;

public class FrutaVolume extends Fruta {

	private float volume;

	public FrutaVolume(String aNome, double aPrecoBase) {
		super(aNome, aPrecoBase);
		volume = 0;

	}

	@Override
	public double pagar() {

		return precoBase * volume;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float aVolume) {
		volume = aVolume;
	}

}
