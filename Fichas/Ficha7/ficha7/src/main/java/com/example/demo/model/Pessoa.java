package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Pessoa {

	private String nome;
	private int idade;
	private String email;
	private UUID id;
	@JsonIgnore // para evitar o loop infinito
	private Empresa empresa;

	public Pessoa(String aNome, int aIdade, String aEmail) {
		email = aEmail;
		nome = aNome;
		idade = aIdade;
		id = UUID.randomUUID();
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public UUID getId() {
		return id;
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

	public void setEmpresa(Empresa aEmpresa) {
		empresa = aEmpresa;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", email=" + email + ", empresa=" + empresa + "]";
	}

}
