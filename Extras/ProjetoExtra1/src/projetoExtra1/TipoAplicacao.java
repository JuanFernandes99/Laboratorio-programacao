package projetoExtra1;

import java.util.InputMismatchException;

public enum TipoAplicacao {
	GAMES, BUSSINESS, EDUCATION, LIFESTYLE, ENTERTAINMENT, UTILITIES, TRAVEL, HEALTHANDFITNESS;

	public static TipoAplicacao menuTipo() {
menu();
		while (true) {

			try {
				int opcao = Main.sc.nextInt();
				Main.sc.nextLine();
				switch (opcao) {

				case 1:
					return GAMES;

				case 2:

					return BUSSINESS;

				case 3:
					return EDUCATION;

				case 4:

					return LIFESTYLE;

				case 5:

					return ENTERTAINMENT;
				case 6:

					return UTILITIES;

				case 7:

					return TRAVEL;
				case 8:
					
					return HEALTHANDFITNESS;

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
	private static void menu(){
		System.out.println("\nEscolha a categoria que melhor se adeque à sua aplicação");
		System.out.println("1 - GAMES");
		System.out.println("2 - BUSSINESS");
		System.out.println("3 - EDUCATION");
		System.out.println("4 - LIFESTYLE");
		System.out.println("5 - ENTERTAINMENT");
		System.out.println("6 - UTILITIES");
		System.out.println("7 - TRAVEL");
		System.out.println("8 - HEALTHANDFITNESS");
	}
}