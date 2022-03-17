package ficha8.ficha8_resolucao.dto;

import java.util.ArrayList;
import java.util.List;

import ficha8.ficha8_resolucao.model.Loja;

public class SimpleResponseLoja extends SimpleResponse {
	List<Loja> lojas;

	public SimpleResponseLoja() {
		lojas = new ArrayList<>();
	}

	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> aLojas) {
		lojas = aLojas;
	}


}
