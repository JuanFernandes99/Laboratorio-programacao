package utilizador;

import java.util.ArrayList;
import java.util.List;
import projetoExtra1.Aplicacao;
import projetoExtra1.TipoAplicacao;

public class Programador extends Utilizador {
	private double avaliacaoGeral;
	private double lucro;
	private List<Aplicacao> aplicacoes; // atençao ao apagar as listas

	public Programador(String aNome, int aIdade) {
		super(aNome, aIdade);
		lucro = 0;
		aplicacoes = new ArrayList<Aplicacao>();
		avaliacaoGeral = 0;
	}

	public void atribuirApp(Aplicacao aAplicacao) {
		aplicacoes.add(aAplicacao);
	}

/*	public Aplicacao desenvolverAplicacao(String aNome, double aPreco, TipoAplicacao aTipo) {
		return new Aplicacao(aNome, aPreco, aTipo);
	}*/

	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public double getAvaliacaoGeral() {
		return avaliacaoGeral;
	}

	public double getLucro() {
		for (Aplicacao aplicacao : aplicacoes) {
			lucro += aplicacao.getNumVendas() * aplicacao.getPreco();
		}
		return lucro;
	}

	public void setAplicacoes(List<Aplicacao> aAplicacoes) {
		aplicacoes = aAplicacoes;
	}

	public void setAvaliacaoGeral(double avaliacaoGeral) {
		this.avaliacaoGeral = avaliacaoGeral;
	}

}
