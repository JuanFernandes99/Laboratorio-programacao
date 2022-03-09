package fichaExtra1;

import java.util.Date;

import navio.NavPetroleiro;
import navio.NavPortaContentor;

public class Main {

	public static void main(String[] args) {

		// Cria��o de navios

		// Valide que n�o � poss�vel repetir a matr�cula de navio, num mesmo porto.
		// podemos ver que tem o mesmo identificador, mas quando inserimos o navio no
		// portoHamburgo
		// � feita uma altera��o ao identificador se s�o iguais, com um UUID

		NavPortaContentor pcAltair = new NavPortaContentor("123", "Altair", new Date(), 5000, 50);
		NavPortaContentor pc1Antares = new NavPortaContentor("123", "Antares", new Date(), 8000, 80);
		NavPetroleiro ptFlamingo = new NavPetroleiro("159", "Flamingo", new Date(), 2000, 120);
		// Cria��o do Porto
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
