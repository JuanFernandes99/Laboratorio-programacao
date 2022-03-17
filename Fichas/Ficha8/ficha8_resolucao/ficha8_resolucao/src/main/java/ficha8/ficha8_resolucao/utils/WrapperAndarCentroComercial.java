package ficha8.ficha8_resolucao.utils;

import ficha8.ficha8_resolucao.model.Andar;
import ficha8.ficha8_resolucao.model.CentroComercial;

public class WrapperAndarCentroComercial {
	private CentroComercial centroComercial;
	private Andar andar;

	public WrapperAndarCentroComercial(CentroComercial aCentroComercial, Andar aAndar) {
		centroComercial = aCentroComercial;
		andar = aAndar;
	}

	public CentroComercial getCentroComercial() {
		return centroComercial;
	}

	public Andar getAndar() {
		return andar;
	}

	public void setCentroComercial(CentroComercial aCentroComercial) {
		centroComercial = aCentroComercial;
	}

	public void setAndar(Andar aAndar) {
		andar = aAndar;
	}

}
