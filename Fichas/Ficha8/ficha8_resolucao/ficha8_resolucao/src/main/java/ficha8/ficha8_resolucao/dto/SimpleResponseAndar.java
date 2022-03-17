package ficha8.ficha8_resolucao.dto;

import java.util.ArrayList;
import java.util.List;

import ficha8.ficha8_resolucao.model.Andar;

public class SimpleResponseAndar extends SimpleResponse {
	List<Andar> andares;

	public SimpleResponseAndar() {
		andares = new ArrayList<>();
	}

	public List<Andar> getAndares() {
		return andares;
	}

	public void setAndares(List<Andar> aAndares) {
		andares = aAndares;
	}

}
