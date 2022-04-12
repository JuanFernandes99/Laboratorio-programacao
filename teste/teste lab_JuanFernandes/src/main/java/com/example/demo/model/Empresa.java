package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Empresa")
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	private String nome;
	private String morada;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Column
	private String imagem;

	@OneToMany(mappedBy = "empresa")
	@JsonIgnore
	private List<Pessoa> listaPessoas;

	public void setId(Long id) {
		this.id = id;
	}

	public void addPessoa(Pessoa pessoa) {
		listaPessoas.add(pessoa);
	}

	public void removePessoa(Pessoa pessoa) {
		listaPessoas.remove(pessoa);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public int getNumeroFuncionariosAtual() {
		return listaPessoas.size();
	}

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public Long getId() {
		return id;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
