package ficha3;

import java.util.Date;

public class Main {

	public static void main(String[] args) {

		System.out.println("\n----- Exercício 1 e 2-----\n");

		// Criação do Banco "Santander"
		Banco santander = new Banco("Santander");

		// Acrescenta duas contas Bancarias na lista de contas bancarias do banco
		// "Santander" , com diferentes construtores
		santander.criaConta(new ContaBancaria("Juan", new Date()));
		santander.criaConta(new ContaBancaria("pedro", 250));

		// Criamos um objeto "conta1" e atribuimos a traves do metodo getConta que
		// recebe o titular por parâmetro e devolve a conta do santander do titular:
		// "juan"
		ContaBancaria conta1 = santander.getConta("juan"); // nao é possivel chamar a funçao getConta se nao fizermos
															// esta linha de codigo
		System.out.println(conta1.getSaldo());

		// Criamos um objeto "conta2" e atribuimos a traves do metodo getConta que
		// recebe o titular por parâmetro e devolve a conta do santander do titular:
		// "pedro"
		ContaBancaria conta2 = santander.getConta("pedro");
		System.out.println(conta2.getSaldo());

		conta1.depositar(500);
		conta1.levantar(200);
		conta2.depositar(900);
		conta2.levantar(400);

		System.out.println(conta1.getInformacaoConta());
		System.out.println(conta2.getInformacaoConta());

		System.out.println("\n----- Exercício 3 -----\n");

		// Criação da casa "casa1" com o construtor vazio
		Casa casa1 = new Casa();
		casa1.setMorada("Caminho do Trapiche");
		casa1.setPrecoCusto(50_000);
		casa1.setPrecoVenda(80_000);
		// Criação da casa "casa2" com o construtor vazio
		Casa casa2 = new Casa("Caminho da Chamorra");
		casa2.setPrecoCusto(180_000);
		casa2.setPrecoVenda(300_400);
		// Criação da casa "casa3" com o construtor vazio
		Casa casa3 = new Casa("Rua dos Alecrins");
		casa3.setPrecoCusto(42_500);
		casa3.setPrecoVenda(76_000);

		System.out.println("Morada: " + casa2.getMorada() + " , Margem de lucro: " + casa2.getMargemLucro()
				+ ", Percentagem do margem de lucro: " + casa2.getPercentMargemLucro() + " %");

		System.out.println("\n----- Exercício 4 -----\n");

		// Acrescenta tres casas na lista de casas do banco "Santander".
		santander.criaCasa(casa1);
		santander.criaCasa(casa2);
		santander.criaCasa(casa3);

		System.out.println(santander.getCasas());
		santander.removeCasa("Caminho da Chamorra");
		System.out.println(santander.getCasas());
		System.out.println(
				"Lucro previsto: " + santander.getLucroPrevisto() + " (" + santander.getCasas().size() + " casas)");

	}
}
