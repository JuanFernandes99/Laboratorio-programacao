package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Empresa {
	private String nome;
	private String morada;
	private int numFuncionariosAtual;
	private int numFuncionariosDesdeCriacao;
	private List<Pessoa> listaPessoas;
	private UUID id;

	public Empresa(String aNome, String aMorada) {
		nome = aNome;
		morada = aMorada;
		id = UUID.randomUUID();
		listaPessoas = new ArrayList<Pessoa>();
	}

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

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public UUID getId() {
		return id;
	}

	public void setNome(String aNome) {
		nome = aNome;
	}

	public void setMorada(String aMorada) {
		morada = aMorada;
	}

	public void setListaPessoas(List<Pessoa> aPessoas) {
		listaPessoas = aPessoas;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + ", morada=" + morada + ", numFuncionariosAtual="
				+ numFuncionariosAtual + ", numFuncionariosDesdeCriacao=" + numFuncionariosDesdeCriacao
				+ ", pessoasEmpresa=" + listaPessoas + "]";
	}

}
