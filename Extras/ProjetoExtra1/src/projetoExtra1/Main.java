package projetoExtra1;

import java.util.Arrays;

import utilizador.Cliente;
import utilizador.Programador;

public class Main {

	public static void main(String[] args) {

		Programador programador1 = new Programador("Juan", 22);
		Programador programador2 = new Programador("Ligia", 22);
		Cliente cliente1 = new Cliente("Jessica", 25);
		AppStore playStore = new AppStore("PlayStore");
		Aplicacao fruitNinja = programador1.desenvolverAplicacao("Fruit Ninja", 50, TipoAplicacao.Games);
		Aplicacao clashOfClans = programador2.desenvolverAplicacao("Clash of clans", 70, TipoAplicacao.Games);
		Compra compra1 = new Compra(cliente1.getId(), Arrays.asList(fruitNinja, clashOfClans)); // compra pode ter
																								// varias apps, fazer
																								// verificaçao depois se
																								// o dinheiro d
		programador1.atribuirApp(fruitNinja);
		playStore.adicionaUtilizador(cliente1);
		playStore.adicionaUtilizador(programador1);
		playStore.adicionaUtilizador(programador2);
		playStore.adicionaApp(fruitNinja);
		playStore.adicionaApp(clashOfClans);
		cliente1.adicionaCompra(compra1);
		Avaliacao avaliacao1 = new Avaliacao(cliente1.getId(), 5, "bom jogo");
		Avaliacao avaliacao2 = new Avaliacao(cliente1.getId(), 2, "bom jogo");
		Avaliacao avaliacao3 = new Avaliacao(cliente1.getId(), 4, "bom jogo");
		fruitNinja.adicionaAvaliacao(avaliacao1);
		fruitNinja.adicionaAvaliacao(avaliacao2);
		fruitNinja.adicionaAvaliacao(avaliacao3);
		clashOfClans.adicionaAvaliacao(avaliacao2);
		clashOfClans.adicionaAvaliacao(avaliacao1);
		System.out.println(fruitNinja.getAvaliacaoGeral());
		System.out.println(clashOfClans.getAvaliacaoGeral());
		System.out.println(compra1);
		System.out.println(programador1.getAplicacoes());
		// System.out.println(clashOfClans);
		// System.out.println(playStore.getAplicacoesPorCategoria(TipoAplicacao.Games));
		// System.out.println(playStore.getAplicacoesPorClassificacao(3));

		// System.out.println(fruitNinja);
		// System.out.println(cliente1);
		// System.out.println(playStore);
		// System.out.println(playStore.getUtilizadores());

	}

}
