package navio;

import java.util.Date;

public class NavPetroleiro extends Navio {

	private float capCarga; // Em toneladas

	public NavPetroleiro(String aIdentificador, String aNome, Date aAnoConstrucao, float aComprimento,
			float aCapCarga) {
		super(aIdentificador, aNome, aAnoConstrucao, aComprimento);
		capCarga = aCapCarga;
	}

	public float getCapCarga() {
		return capCarga;
	}

}
