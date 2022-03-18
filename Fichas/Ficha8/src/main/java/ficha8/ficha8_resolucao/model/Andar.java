package ficha8.ficha8_resolucao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Andar")
public class Andar {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private int numeroAndar;
	private int numeroMaxLojas;

	@ManyToOne
	@JoinColumn(name = "CentroComercial_id")
	@JsonIgnore // com o JsonIgnore n conseguimos ver a empresa da pessoa, mas é importante para
				// evitar o loop infinito

	private CentroComercial centroComercial; // temos de utilizar o nome "centroComercial" para o one to many

	@OneToMany(mappedBy = "andares")
	private List<Loja> lojas = new ArrayList<Loja>();

	public void adicionarLoja(Loja aLoja) {

		lojas.add(aLoja);

	}

	public void removerLoja(Loja aLoja) {

		lojas.remove(aLoja);

	}
//	Getters e Setters

	public int getNumeroAndar() {
		return numeroAndar;
	}

	public int getNumeroMaxLojas() {
		return numeroMaxLojas;
	}

	public Long getId() {
		return id;
	}

	public CentroComercial getCentroComercial() {
		return centroComercial;
	}

	public List<Loja> getLojas() {
		return lojas;
	}

	public void setNumeroAndar(int aNumeroAndar) {
		numeroAndar = aNumeroAndar;
	}

	public void setNumeroMaxLojas(int aNumeroMaxLojas) {
		numeroMaxLojas = aNumeroMaxLojas;
	}

	public void setCentroComercial(CentroComercial aCentroComercial) {
		centroComercial = aCentroComercial;
	}

	public void setLojas(List<Loja> aLojas) {
		lojas = aLojas;
	}

}