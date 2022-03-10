package projetoExtra1;

import java.util.InputMismatchException;

import utilizador.Cliente;
import utilizador.Programador;
import utilizador.Utilizador;

public class MenuStore {
	// para testes
	private Aplicacao fruitNinja = new Aplicacao("Fruit Ninja", 50, TipoAplicacao.GAMES);
	private Aplicacao clashOfClans = new Aplicacao("Clash of clans", 70, TipoAplicacao.GAMES);
	private Aplicacao callOfDuty = new Aplicacao("Call Of Duty", 60, TipoAplicacao.BUSSINESS);

	private AppStore playStore = new AppStore("PlayStore");

	public void menu() {
		playStore.adicionaApp(callOfDuty);
		playStore.adicionaApp(clashOfClans);
		playStore.adicionaApp(fruitNinja);
		fruitNinja.setAvaliacaoGeral(4);
		clashOfClans.setAvaliacaoGeral(3);
		callOfDuty.setAvaliacaoGeral(2);
		System.out.println("\nEscolha uma das opções disponíveis:");
		System.out.println("1 - Registar Utilizador"); // feito
		System.out.println("2 - Adicionar aplicaçao");
		System.out.println("3 - Listar utilizadores");
		System.out.println("4 - Realizar compras de aplicações");
		System.out.println("5 - Quantidade de Recarregamentos");
	}

	public void registarUtilizador() {
		System.out.println("\nDigite o nome:");
		String aNome = Main.sc.nextLine();
		System.out.println("\nDigite a sua idade:");
		int aIdade = Main.sc.nextInt();
		Main.sc.nextLine();
		String aUserName = verificarUserName();
		System.out.println("\nDigite a sua Password:");
		String aPassword = Main.sc.nextLine();
		System.out.println("Indique o tipo de utilizador: Cliente(1) ou Programador(2) ?");
		int utilizador = Main.sc.nextInt();
		if ((utilizador == 1)) {
			System.out.println("\nDigite o seu saldo:");
			double aSaldo = Main.sc.nextInt();
			Main.sc.nextLine();
			Utilizador cliente = new Cliente(aNome, aIdade, aUserName, aPassword, aSaldo);
			playStore.adicionarUtilizador(cliente);
			System.out.println("Nome: " + cliente.getNome() + ", cliente criado com sucesso");
		} else if (utilizador == 2) {

			Utilizador programador = new Programador(aNome, aIdade, aUserName, aPassword);
			playStore.adicionarUtilizador(programador);
			System.out.println("Nome: " + programador.getNome() + ", programador criado com sucesso");
		}

	}

	public String verificarUserName() {

		System.out.println("\nDigite o seu userName:");
		String aUserName = Main.sc.nextLine();
		for (Utilizador utilizador : playStore.getUtilizadores()) {
			if (utilizador.getUserName().equals(aUserName)) {
				System.out.println("User name em uso , try again");
				verificarUserName();

			} else {
				System.out.println("User name disponivel");

			}
		}

		return aUserName;
	}

	public void listarUtilizador() {
		if (playStore.getUtilizadores().isEmpty()) {
			System.out.println("A lista está vazia :(");
		} else {
			System.out.println(playStore.getUtilizadores());
		}

	}

	public void realizarCompras() {
		filtrosApps();

	}

	public void filtrosApps() {

		while (true) {
			System.out.println("\nEscolha uma das opções de filtros disponíveis:");
			System.out.println("1 - Por categoria ");
			System.out.println("2 - Por classificação dos utilizadores");
			System.out.println("3 - Por nome");
			System.out.println("4 - Por número de vendas");
			System.out.println("5 - Lista de aplicaçoes");
			try {
				int opcao = Main.sc.nextInt();
				Main.sc.nextLine();
				switch (opcao) {

				case 1:

					TipoAplicacao tipoEnum = TipoAplicacao.menuTipo();
					System.out.println(playStore.getAplicacoesPorCategoria(tipoEnum));

					break;

				case 2:
					System.out.println(playStore.getAplicacoesPorClassificacao());
					break;

				case 3:
					System.out.println(playStore.getAplicacoesPorNome());

					break;

				case 4:

					System.out.println(playStore.getAplicacoesPorVendas());

					break;

				case 5:
					System.out.println(playStore.getAplicacoes());
					break;

				default:
					System.out.println("Só são permitidos números entre 1 a 5 , tente de novo.");
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"Erro fatal (448): Digite um número inteiro de 1 até 2147483647. Os caracteres também não são permitidos. Tente novamente :)");
				Main.sc.nextLine(); // Limpar consola
			}
		}

	}

	public void adicionarApp() {
autenticacao();

		System.out.println("\nDigite o nome da App:");
		String aNome = Main.sc.nextLine();
		System.out.println("\nDigite o preço da App:");
		double aPreco = Main.sc.nextDouble();
		Main.sc.nextLine();
		TipoAplicacao tipoEnum = TipoAplicacao.menuTipo();
		Aplicacao aplicacao = new Aplicacao(aNome, aPreco, tipoEnum);
		playStore.adicionaApp(aplicacao);
	}

	public void autenticacaoUserName() {
		System.out.println("\nDigite o seu userName:");
		String aUserName = Main.sc.nextLine();

		for (Utilizador utilizador : playStore.getUtilizadores()) {
			if (utilizador.getUserName().equals(aUserName)) {
				System.out.println("Olá " + utilizador.getUserName() + " Digite a sua Password:");

			} else {
				System.out.println("User name incorreto");
				autenticacaoUserName();
			}
		}
	}

	public void autenticacaoPassword() {
		String aPassword = Main.sc.nextLine();
		for (Utilizador utilizador : playStore.getUtilizadores()) {
			if (utilizador.getPassword().equals(aPassword)) {
				System.out.println("autenticaçao com exito");

			} else {
				System.out.println("Password incorreta");
				autenticacaoPassword();
			}
		}
	}
	public void autenticacao() {
		
		
		autenticacaoUserName();
		autenticacaoPassword();
	}
}