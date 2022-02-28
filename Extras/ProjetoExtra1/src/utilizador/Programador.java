package utilizador;

import java.util.ArrayList;
import java.util.List;
import projetoExtra1.Aplicacao;

public class Programador extends Utilizador {

	private List<Aplicacao> aplicacoes;

	public Programador(String aNome, int aIdade) {
		super(aNome, aIdade);
		aplicacoes = new ArrayList<Aplicacao>();
	}

	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public void setAplicacoes(List<Aplicacao> aAplicacoes) {
		aplicacoes = aAplicacoes;
	}

}
