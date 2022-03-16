package com.example.demoAula.model;

import com.fasterxml.jackson.annotation.JsonIgnore; // isto é para empresa

import javax.persistence.*;

@Entity
@Table(name = "Pessoa")
public class Pessoa {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int idade;
	private String nome;
	private String email;

	@ManyToOne
	@JoinColumn(name = "Empresa_id ")

	@JsonIgnore // com o JsonIgnore n conseguimos ver a empresa da pessoa, mas é importante para
				// evitar o loop infinito
	private Empresa empresa; // temos de utilizar o nome "empresa" para o one to many

	public Long getId() {
		return id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa aEmpresa) {
		empresa = aEmpresa;
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
		return "Pessoa [id=" + id + ", idade=" + idade + ", nome=" + nome + ", email=" + email + ", empresa=" + empresa
				+ "]";
	}

}
