package fruta;

// classe restrita que n�o pode ser usada para criar objetos
public abstract class Fruta {

	// Atributos
	protected String nome;
	protected double precoBase;

	// Construtor

	// Recebe por par�metro o nome da fruta , e o pre�o base
	public Fruta(String aNome, double aPrecoBase) {
		nome = aNome;
		precoBase = aPrecoBase;
	}
	// M�todos

	// M�todo abstrato que indica que todas as classes filhas devem reescrever esse
	// metodo.
	public abstract double pagar();

	// Getter
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Fruta [nome=" + nome + ", precoBase=" + precoBase + "]";
	}

}
