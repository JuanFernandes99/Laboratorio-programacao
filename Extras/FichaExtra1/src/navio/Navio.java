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

	public Date getAnoConstrucao() {
		return anoConstrucao;
	}

	public float getComprimento() {
		return comprimento;
	}

	public void setIdentificador(String aIdentificador) {
		identificador = aIdentificador;
	}

	public void setNome(String aNome) {
		nome = aNome;
	}

	public void setAnoConstrucao(Date aAnoConstrucao) {
		anoConstrucao = aAnoConstrucao;
	}

	public void setComprimento(float aComprimento) {
		comprimento = aComprimento;
	}

}
