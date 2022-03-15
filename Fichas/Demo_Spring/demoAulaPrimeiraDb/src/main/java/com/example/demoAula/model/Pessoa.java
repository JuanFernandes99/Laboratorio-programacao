package com.example.demoAula.model;

import com.fasterxml.jackson.annotation.JsonIgnore; // isto é para empresa

import javax.persistence.*;

@Entity
@Table(name = "Pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int idade;
	private String nome;
	private String email;

	public Long getId() {
		return id;
	}

	public int getIdade() {
		return idade;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public void setIdade(int aIdade) {
		idade = aIdade;
	}

	public void setNome(String aNome) {
		nome = aNome;
	}

	public void setEmail(String aEmail) {
		email = aEmail;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", idade=" + idade + ", nome=" + nome + ", email=" + email + "]";
	}

}
