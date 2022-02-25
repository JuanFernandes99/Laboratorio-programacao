package fruta;

// classe restrita que não pode ser usada para criar objetos
public abstract class Fruta {

	// Atributos
	protected String nome;
	protected double precoBase;

	// Construtor

	// Recebe por parâmetro o nome da fruta , e o preço base
	public Fruta(String aNome, double aPrecoBase) {
		nome = aNome;
		precoBase = aPrecoBase;
	}
	// Métodos

	// Método abstrato que indica que todas as classes filhas devem reescrever esse
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
