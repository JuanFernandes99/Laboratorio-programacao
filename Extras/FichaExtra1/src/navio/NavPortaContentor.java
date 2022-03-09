package navio;

import java.util.Date;

public class NavPortaContentor extends Navio {
	private int maxContentores;

	public NavPortaContentor(String aIdentificador, String aNome, Date aAnoConstrucao, float aComprimento,
			int aMaxContentores) {
		super(aIdentificador, aNome, aAnoConstrucao, aComprimento);
		maxContentores = aMaxContentores;
	}

	public int getMaxContentores() {
		return maxContentores;
	}

}
