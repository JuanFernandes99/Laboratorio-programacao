package utilizador;

public abstract class Utilizador {

	protected static int utilizadorCounter = 1;
	protected String nome;
	protected int idade;
	protected int id;
	protected String userName;
	protected String password;


	public Utilizador(String aNome, int aIdade, String aUserName, String aPassword) {
		super();
		nome = aNome;
		idade = aIdade;
		userName = aUserName;
		password = aPassword;
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
	

	public String getUserName() {
		return userName;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setUserName(String aUserName) {
		userName = aUserName;
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
