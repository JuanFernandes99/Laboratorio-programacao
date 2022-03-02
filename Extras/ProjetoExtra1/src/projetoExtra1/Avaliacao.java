package projetoExtra1;

import java.util.List;

import utilizador.Programador;

public class Avaliacao {

	private List<Aplicacao> aplicacoes;
	private List<Programador> programadores;

	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public List<Programador> getProgramadores() {
		return programadores;
	}

	public void setAplicacoes(List<Aplicacao> aAplicacoes) {
		aplicacoes = aAplicacoes;
	}

	public void setProgramadores(List<Programador> aProgramadores) {
		programadores = aProgramadores;
	}

}
