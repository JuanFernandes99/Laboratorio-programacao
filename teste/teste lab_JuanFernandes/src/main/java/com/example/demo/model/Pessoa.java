package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Pessoa")
public class Pessoa {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String morada;
	private int idade;

	private String email;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Column
	private String imagem;

	@ManyToOne()

	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	@OneToMany(mappedBy = "pessoa")
	@JsonIgnore
	private List<Salario> listaSalarios;

	public void addSalario(Salario aSalario) {
		listaSalarios.add(aSalario);
	}

	public String getNome() {
		return nome;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String aMorada) {
		morada = aMorada;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Salario> getListaSalarios() {
		return listaSalarios;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setListaSalarios(List<Salario> listaSalarios) {
		this.listaSalarios = listaSalarios;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}
