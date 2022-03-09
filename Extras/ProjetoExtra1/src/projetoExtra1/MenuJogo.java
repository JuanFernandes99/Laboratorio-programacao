package projetoExtra1;

import utilizador.Cliente;
import utilizador.Programador;
import utilizador.Utilizador;

public class MenuJogo {
	static AppStore playStore = new AppStore("PlayStore");
	static Aplicacao fruitNinja = new Aplicacao("Fruit Ninja", 50, TipoAplicacao.Games);
	static Aplicacao clashOfClans = new Aplicacao("Clash of clans", 70, TipoAplicacao.Games);
	static Aplicacao callOfDuty = new Aplicacao("Call Of Duty", 60, TipoAplicacao.Games);

	public static void menu() {
		System.out.println("\nEscolha uma das opções disponíveis:");
		System.out.println("1 - Registar Utilizador");
		System.out.println("2 - Registar aplicaçao");
		System.out.println("3 - Comprar App");
		System.out.println("4 - Quantidade de Esfregadelas");
		System.out.println("5 - Quantidade de Recarregamentos");
	}

	public static void registarUtilizador() {
		System.out.println("\nDigite o nome:");
		String aNome = Main.sc.nextLine();
		System.out.println("\nDigite a sua idade:");
		int aIdade = Main.sc.nextInt();
		Main.sc.nextLine();
		System.out.println("Indique o tipo de utilizador: Cliente(1) ou Programador(2) ?");
		int utilizador = Main.sc.nextInt();
		if ((utilizador == 1)) {
			System.out.println("\nDigite o seu saldo:"); // ?
			double aSaldo = Main.sc.nextInt();
			Utilizador cliente = new Cliente(aNome, aIdade, aSaldo);
			playStore.adicionarUtilizador(cliente);
			System.out.println(cliente.getNome() + "cliente criado com sucesso");
		} else if (utilizador == 2) {

			Utilizador programador = new Programador(aNome, aIdade);
			playStore.adicionarUtilizador(programador);
			System.out.println(programador.getNome() + "programador criado com sucesso");
		}

	}
}
