package fichaExtra1;

import java.util.Date;

import navio.NavPetroleiro;
import navio.NavPortaContentor;

public class Main {

	public static void main(String[] args) {

		// Criação de navios

		// Valide que não é possível repetir a matrícula de navio, num mesmo porto.
		// podemos ver que tem o mesmo identificador, mas quando inserimos o navio no
		// portoHamburgo
		// é feita uma alteração ao identificador se são iguais, com um UUID

		NavPortaContentor pcAltair = new NavPortaContentor("123", "Altair", new Date(), 5000, 50);
		NavPortaContentor pc1Antares = new NavPortaContentor("123", "Antares", new Date(), 8000, 80);
		NavPetroleiro ptFlamingo = new NavPetroleiro("159", "Flamingo", new Date(), 2000, 120);
		// Criação do Porto
		Porto portoHamburgo = new Porto("Porto de Hamburgo", "Alemanha");

		// Inserir navios ao porto de Hamburgo
		portoHamburgo.insereNavio(pcAltair);
		portoHamburgo.insereNavio(pc1Antares);
		portoHamburgo.insereNavio(ptFlamingo);

		System.out.println("Capacidade maxima de contentores: " + portoHamburgo.capacidadeMaximaTotalContentores()
				+ " Contentores");
		System.out.println("Capacidade total de carga: " + portoHamburgo.capacidadeTotalDeCarga() + " Toneladas");
	}

}
