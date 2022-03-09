package fichaExtra1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import navio.NavPetroleiro;
import navio.NavPortaContentor;
import navio.Navio;

public class Porto {

	private String nome;
	private String localizacao;
	private List<Navio> navios;

	public Porto(String aNome, String aLocalizacao) {
		nome = aNome;
		localizacao = aLocalizacao;
		navios = new ArrayList<Navio>();
	}

	// Adicionar um novo navio sem permitir a duplicação da Identificador do Navio;
	public void insereNavio(Navio aNavio) {

		for (Navio navio : navios) {
			if (navio.getIdentificador().equals(aNavio.getIdentificador())) {
				aNavio.setIdentificador(String.valueOf(UUID.randomUUID()));
			}
		}
		navios.add(aNavio);
	}

	// Devolver a quantidade máxima total de contentores de todos os navios
	// porta-contentoresatracados no porto;
	public int capacidadeMaximaTotalContentores() {
		int capMax = 0;
		for (Navio navio : navios) {

			if (navio instanceof NavPortaContentor) {
				int capNavio = ((NavPortaContentor) navio).getMaxContentores();
				capMax += capNavio;
			}
		}

		return capMax;
	}

	// Devolver a capacidade total de carga de todos os navios porta-contentorese
	// petroleiros atracados no porto, sabendo que um contentor tem capacidade para
	// 10 toneladas;
	public float capacidadeTotalDeCarga() {
		int capCarga = 0;
		int capContentor = capacidadeMaximaTotalContentores() * 10;
		for (Navio navio : navios) {

			if (navio instanceof NavPetroleiro) {
				float capPetroleiro = ((NavPetroleiro) navio).getCapCarga();
				capCarga += capPetroleiro;
			}
		}

		return capCarga + capContentor;
	}

	public String getNome() {
		return nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public List<Navio> getNavios() {
		return navios;
	}

	@Override
	public String toString() {
		return "Porto [nome=" + nome + ", localizacao=" + localizacao + ", navios=" + navios + "]";
	}

}
