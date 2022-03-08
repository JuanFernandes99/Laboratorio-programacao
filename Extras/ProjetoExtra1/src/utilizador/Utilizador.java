package utilizador;

public abstract class Utilizador {

	protected static int utilizadorCounter = 1;
	protected String nome;
	protected int idade;
	protected int id;

	public Utilizador(String aNome, int aIdade) {
		nome = aNome;
		idade = aIdade;
		id = utilizadorCounter; // Registar novos utilizadores e atribuir automaticamente números únicos.
		utilizadorCounter++;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public int getId() {
		return id;
	}

	public void setNome(String aNome) {
		nome = aNome;
	}

	public void setIdade(int aIdade) {
		idade = aIdade;
	}

	public void setId(int aId) {
		id = aId;
	}

	@Override
	public String toString() { // Listar todos os utilizadores da App Store. Para cada utilizador é mostrado o
								// nome, idade, e número de utilizador.
		
		return "Utilizador: [Nome=" + nome + ", Idade=" + idade + ", Tipo=" + getClass().getSimpleName() + ", Id=" + id
				+ "]";
	}

}
