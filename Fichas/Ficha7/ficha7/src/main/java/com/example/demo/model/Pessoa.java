package com.example.demo.model;

public class Pessoa {
	private static int numPessoas = 0;
	private int id;
	private String nome;
	private int idade;
	private String email;
	private int empresaId; // Chave estrangeira colocada no lado de muitos.

	public Pessoa(String aNome, int aIdade, int aEmpresaId, String aEmail) {
		email = aEmail;
		nome = aNome;
		empresaId = aEmpresaId;
		idade = aIdade;
		id = numPessoas;
		numPessoas++;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getEmail() {
		return email;
	}

	public int getEmpresaId() {
		return empresaId;
	}

	public void setEmail(String aEmail) {
		email = aEmail;
	}

	public void setNome(String aNome) {
		nome = aNome;
	}

	public void setIdade(int aIdade) {
		idade = aIdade;
	}

	@Override
	public String toString() {
		return "Pessoa [Id=" + id + ", Nome=" + nome + ", Idade=" + idade + ", Email=" + email + ", EmpresaId="
				+ empresaId + "]";
	}

}
