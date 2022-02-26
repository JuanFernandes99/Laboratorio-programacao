package utilizador;

public class Utilizador {

	protected static int utilizadorCounter = 1;
	protected String nome;
	protected int idade;
	protected int id;
	
	public Utilizador(String nome, int idade) {
		nome = nome;
		idade = idade;
		id = utilizadorCounter;
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

	
	
}
