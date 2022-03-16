package Ficha8.Ficha8_resolucao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Centro Comercial")
public class CentroComercial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false) // por default é true
	private Long id;

	private String nome;
	private String morada;
	private int numeroMaxAndar;

	@OneToMany(mappedBy = "centroComercial")
	private List<Andar> andares = new ArrayList<Andar>();

//	Getters e Setters

	public String getNome() {
		return nome;
	}

	public String getMorada() {
		return morada;
	}

	public int getNumeroMaxAndar() {
		return numeroMaxAndar;
	}

	public Long getId() {
		return id;
	}

	public List<Andar> getAndares() {
		return andares;
	}

	public void setNome(String aNome) {
		nome = aNome;
	}

	public void setMorada(String aMorada) {
		morada = aMorada;
	}

	public void setNumeroMaxAndar(int aNumeroMaxAndar) {
		numeroMaxAndar = aNumeroMaxAndar;
	}

	public void setId(Long aId) {
		id = aId;
	}

	public void setAndares(List<Andar> aAndares) {
		andares = aAndares;
	}

}
