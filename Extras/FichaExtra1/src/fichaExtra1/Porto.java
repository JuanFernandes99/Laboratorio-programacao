package fichaExtra1;

import java.util.ArrayList;
import java.util.List;
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
	
	public void insereNavio(Navio aNavio) {
		for (Navio navio : navios) {
			if (navio.getIdentificador().equals(aNavio.getIdentificador())) {
				navios.add(aNavio);
		}
		else {
			System.out.println("id iguais");
		}
	}
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

	public void setNome(String aNome) {
		nome = aNome;
	}

	public void setLocalizacao(String aLocalizacao) {
		localizacao = aLocalizacao;
	}

	public void setNavios(List<Navio> aNavios) {
		navios = aNavios;
	}

}
