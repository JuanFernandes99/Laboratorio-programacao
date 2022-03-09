package navio;

import java.util.Date;

public abstract class Navio {

	protected String identificador;
	protected String nome;
	protected Date anoConstrucao;
	protected float comprimento;

	public Navio(String aIdentificador, String aNome, Date aAnoConstrucao, float aComprimento) {
		identificador = aIdentificador;
		nome = aNome;
		anoConstrucao = aAnoConstrucao;
		comprimento = aComprimento;
	}

	public String getIdentificador() {
		return identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setIdentificador(String aIdentificador) {
		identificador = aIdentificador;
	}


	@Override
	public String toString() {
		return "Navio [identificador=" + identificador + ", nome=" + nome + "]";
	}

}
