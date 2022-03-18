package ficha8.ficha8_resolucao.dto;

import java.util.ArrayList;
import java.util.List;

import ficha8.ficha8_resolucao.model.CentroComercial;

public class SimpleResponseCentroComercial extends SimpleResponse {
	List<CentroComercial> centroComerciales;

	public SimpleResponseCentroComercial() {
		centroComerciales = new ArrayList<>();
	}

	public List<CentroComercial> getEmpresas() {
		return centroComerciales;
	}

	public void setCentroComerciales(List<CentroComercial> aCentroComercial) {
		centroComerciales = aCentroComercial;
	}
}
