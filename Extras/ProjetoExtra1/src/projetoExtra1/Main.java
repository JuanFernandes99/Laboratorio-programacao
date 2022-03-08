package projetoExtra1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import utilizador.Cliente;
import utilizador.Programador;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static AppStore playStore = new AppStore("PlayStore");
	static Aplicacao fruitNinja = new Aplicacao("Fruit Ninja", 50, TipoAplicacao.Games);
	static Aplicacao clashOfClans = new Aplicacao("Clash of clans", 70, TipoAplicacao.Games);
	static Aplicacao callOfDuty = new Aplicacao("Call Of Duty", 60, TipoAplicacao.Games);

	public static void main(String[] args) {
		//playStore.adicionaApp(fruitNinja);
	//	playStore.adicionaApp(clashOfClans);

		// atribuir ao programador apps
		//programador2.atribuirApp(fruitNinja);
		//programador1.atribuirApp(clashOfClans);
		//programador1.atribuirApp(callOfDuty);

		System.out.println("Bem-vindo à appStore!");
		while (true) {
			menu();
			try {
				int opcao = sc.nextInt();
				sc.nextLine();
				switch (opcao) {

				case 1:
					playStore.registarUtilizador();
					System.out.println(playStore.getUtilizadores());
					break;
				case 2:
					System.out.println(playStore.getAplicacoes());
					break;

				case 3:
					System.out.println(playStore.getAplicacoes());
					break;

				case 4:
					// System.out.println("Esfregadelas Acumuladas: " +
					// Lampada.getEsfregadelasAcumuladas());
					break;

				case 5:
					// System.out.println("Vezes recarregada: " + Lampada.getVezesRecarregada());
					break;

				default:
					System.out.println("Só são permitidos números entre 1 a 5 , tente de novo.");
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"Erro fatal (448): Digite um número inteiro de 1 até 2147483647. Os caracteres também não são permitidos. Tente novamente :)");
				sc.nextLine(); // Limpar consola
			}
		}
		/*
		 * 
		 * // Criar Compra
		 * 
		 * Compra compra1 = new Compra(cliente1, Arrays.asList(fruitNinja,
		 * clashOfClans)); Compra compra2 = new Compra(cliente2,
		 * Arrays.asList(fruitNinja));
		 * 
		 * 
		 * 
		 * // adicionar utilizadores a playStore playStore.adicionaUtilizador(cliente1);
		 * playStore.adicionaUtilizador(cliente2);
		 * playStore.adicionaUtilizador(programador1);
		 * playStore.adicionaUtilizador(programador2);
		 * 
		 * // compra do cliente cliente1.adicionaCompra(compra1);
		 * cliente2.adicionaCompra(compra2); playStore.adicionarCompra(compra1);
		 * playStore.adicionarCompra(compra2);
		 * 
		 * // criar avaliaçoes Avaliacao avaliacao1 = new Avaliacao(cliente1.getId(), 9,
		 * "bom jogo"); Avaliacao avaliacao2 = new Avaliacao(4); // construtor para
		 * avaliaçao anonima Avaliacao avaliacao3 = new Avaliacao(cliente1.getId(), 2,
		 * "bom jogo"); Avaliacao avaliacao4 = new Avaliacao(cliente1.getId(), 4,
		 * "bom jogo");
		 * 
		 * // adicionar avaliaçao a aplicaçoes fruitNinja.adicionaAvaliacao(avaliacao1);
		 * fruitNinja.adicionaAvaliacao(avaliacao2);
		 * fruitNinja.adicionaAvaliacao(avaliacao3);
		 * fruitNinja.adicionaAvaliacao(avaliacao4);
		 * clashOfClans.adicionaAvaliacao(avaliacao1);
		 * clashOfClans.adicionaAvaliacao(avaliacao2);
		 * 
		 * // Fazer listagens seletivas das apps por categoria
		 * 
		 * linha(); titulo("Listagens seletivas das apps por categoria (Games)");
		 * System.out.println(playStore.getAplicacoesPorCategoria(TipoAplicacao.Games));
		 * 
		 * // Fazer listagens seletivas por classificação dos utilizadores.
		 * 
		 * linha(); titulo("listagens seletivas por classificação dos utilizadores >3: "
		 * + playStore.getAplicacoesPorClassificacao(3));
		 * 
		 * // Fazer listagens ordenadas das apps por nome.
		 * 
		 * linha(); titulo("Listagens ordenadas das apps por nome : " +
		 * playStore.listarPorNome());
		 * 
		 * // Fazer listagens ordenadas das apps por número de vendas
		 * 
		 * linha(); titulo("Aplicaçoes ordenadas por numero de vendas :" +
		 * playStore.listarPorVendas());
		 * 
		 * // Fazer listagens ordenadas por classificação dos utilizadores.
		 * 
		 * linha(); titulo("listagens ordenadas por classificação dos utilizadores" +
		 * playStore.listarPorClassificacao());
		 * 
		 * // Listar as classificações e comentários (se houver) de uma aplicação em //
		 * concreto.
		 * 
		 * linha();
		 * titulo("Listar as classificações e comentários (se houver) de uma aplicaçãoem concreto (Fruit Ninja)."
		 * + fruitNinja.getAvaliacoes());
		 * 
		 * // Listar as aplicações de um utilizador em concreto (independentemente de
		 * ser // cliente ou programador).
		 * 
		 * linha();
		 * titulo("Listar as aplicações de um utilizador em concreto (cliente)\n" +
		 * cliente1.getAplicacoes() +"\n");
		 * titulo("Listar as aplicações de um utilizador em concreto (programador)\n" +
		 * programador1.getAplicacoes());
		 * 
		 * // Imprimir o valor total que a App Store recebeu do conjunto dos seus //
		 * utilizadores. linha();
		 * titulo("Valor total que a App Store recebeu do conjunto dos seus utilizadores: "
		 * + playStore.getLucro() + "€");
		 * 
		 * // Imprimir o valor total que cada programador recebeu do conjunto das suas
		 * apps linha();
		 * titulo("Valor total que cada programador recebeu do conjunto das suas apps: "
		 * + programador1.getLucro() + "€");
		 */
	}

	public static void linha() {
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------");
	}

	public static void titulo(String titulo) {
		System.out.println(titulo);
	}

	public static void menu() {
		System.out.println("\nEscolha uma das opções disponíveis:");
		System.out.println("1 - Registar Utilizador");
		System.out.println("2 - Registar aplicaçao");
		System.out.println("3 - Comprar App");
		System.out.println("4 - Quantidade de Esfregadelas");
		System.out.println("5 - Quantidade de Recarregamentos");
	}
}
