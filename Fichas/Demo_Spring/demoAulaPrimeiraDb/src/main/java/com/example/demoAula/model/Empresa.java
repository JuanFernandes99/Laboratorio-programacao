package com.example.demoAula.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String morada;
	private int numFuncionariosAtual;
	private int numFuncionariosDesdeCriacao;

	@OneToMany(mappedBy = "empresa")

	private List<Pessoa> listaPessoas = new ArrayList<>();

	
	public void adicionarPessoa(Pessoa aPessoa) { // ver

		listaPessoas.add(aPessoa);

	}

	public void removerPessoa(Pessoa aPessoa) { // ver

		listaPessoas.remove(aPessoa);

	}
	public String getNome() {
		return nome;
	}

	public String getMorada() {
		return morada;
	}

	public int getNumFuncionariosAtual() {
		return numFuncionariosAtual;
	}

	public int getNumFuncionariosDesdeCriacao() {
		return numFuncionariosDesdeCriacao;
	}

	public Long getId() {
		return id;
	}

	public List<Pessoa> getPessoas() {
		return listaPessoas;
	}

	public void setNome(String aNome) {
		nome = aNome;
	}

	public void setMorada(String aMorada) {
		morada = aMorada;
	}

	public void setNumFuncionariosAtual(int aNumFuncionariosAtual) {
		numFuncionariosAtual = aNumFuncionariosAtual;
	}

	public void setNumFuncionariosDesdeCriacao(int aNumFuncionariosDesdeCriacao) {
		numFuncionariosDesdeCriacao = aNumFuncionariosDesdeCriacao;
	}

	public void setPessoas(List<Pessoa> aPessoas) {
		listaPessoas = aPessoas;
	}

}
