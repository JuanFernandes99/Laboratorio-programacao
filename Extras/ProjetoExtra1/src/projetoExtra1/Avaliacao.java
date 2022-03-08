package projetoExtra1;


public class Avaliacao {
	private float classificacao;
	private String comentario;
	private int clienteId; 

	// dois construtores porque pode ser anonimo
	public Avaliacao(int aClienteId, float aClassificacao, String aComentario) {
		if (aClassificacao>5 && aClassificacao>0) {
			throw new IllegalArgumentException("Erro no construtor da avaliaçao : a Classificaçao só pode ser de 1 a 5 ");
	    }
		
		clienteId = aClienteId;
		classificacao = aClassificacao;
		comentario = aComentario;
	}
	//anonimo e sem comentario
	public Avaliacao(float aClassificacao) {
		classificacao = aClassificacao;
	}

	// getters and setter
	public float getClassificacao() {
		return classificacao;
	}

	public String getComentario() {
		return comentario;
	}

	public int getClienteId() {
		return clienteId;
	}
	
	@Override
	public String toString() {
		return "\nclassificacao=" + classificacao + ", comentario=" + comentario + ", clienteId=" + clienteId
				+ "]";
	}

}
