package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private static int numEmpresas = 0;
	private int id;
	private String nome;
	private String morada;
	private int numFuncionariosAtual;
	private int numFuncionariosDesdeCriacao;
	private List<Pessoa> pessoasEmpresa;

	public Empresa(String aNome, String aMorada) {
		nome = aNome;
		morada = aMorada;
		id = numEmpresas;
		numEmpresas++;
		pessoasEmpresa = new ArrayList<Pessoa>();
	}

	public void adicionarPessoa(Pessoa aPessoa) { // ver

		pessoasEmpresa.add(aPessoa);

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

	public List<Pessoa> getPessoas() {
		return pessoasEmpresa;
	}

	public int getId() {
		return id;
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
		pessoasEmpresa = aPessoas;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + ", morada=" + morada + ", numFuncionariosAtual="
				+ numFuncionariosAtual + ", numFuncionariosDesdeCriacao=" + numFuncionariosDesdeCriacao
				+ ", pessoasEmpresa=" + pessoasEmpresa + "]";
	}

}
