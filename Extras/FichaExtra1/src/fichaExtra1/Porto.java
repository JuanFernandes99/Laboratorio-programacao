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

	public void insereNavio(Navio aNavio) throws Exception {

		for (Navio navio : navios) {
			if (navio.getIdentificador().equals(aNavio.getIdentificador())) {
				throw new Exception("Navios com id iguais");
			}
		}
		navios.add(aNavio);
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
