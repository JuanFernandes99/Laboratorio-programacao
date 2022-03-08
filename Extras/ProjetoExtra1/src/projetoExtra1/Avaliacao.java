package projetoExtra1;


public class Avaliacao {
	private float classificacao;
	private String comentario;
	private int clienteId; // ver isto

	// dois construtores porque pode ser anonimo
	public Avaliacao(int aClienteId, float aClassificacao, String aComentario) {
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
		return "Avaliacao [classificacao=" + classificacao + ", comentario=" + comentario + ", clienteId=" + clienteId
				+ "]";
	}

}
