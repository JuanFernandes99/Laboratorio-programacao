package utilizador;

import java.util.ArrayList;
import java.util.List;
import projetoExtra1.Aplicacao;
import projetoExtra1.TipoAplicacao;

public class Programador extends Utilizador {
	private double avaliacao;
	private List<Aplicacao> aplicacoes;  // atençao ao apagar as listas 


	public Programador(String aNome, int aIdade) {
		super(aNome, aIdade);
		aplicacoes = new ArrayList<Aplicacao>();
		avaliacao = 0;
	}

	public Aplicacao desenvolverAplicacao(String aNome, double aPreco, TipoAplicacao aTipo) {
		return new Aplicacao(aNome, aPreco, aTipo);
	}
	
	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public void setAplicacoes(List<Aplicacao> aAplicacoes) {
		aplicacoes = aAplicacoes;
	}

	public double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(double aAvaliacao) {
		avaliacao = aAvaliacao;
	}

}
