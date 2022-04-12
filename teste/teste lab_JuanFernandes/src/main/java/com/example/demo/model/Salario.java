package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Salario")
public class Salario {
	private float quantidade;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date data;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	public float getQuantidade() {
		return quantidade;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public Long getId() {
		return id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
