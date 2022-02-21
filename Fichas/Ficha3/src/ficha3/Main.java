package ficha3;


import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Banco banco1 = new Banco("Santander");
		
		//ContaBancaria conta1 = new ContaBancaria("Juan", new Date());  
		//ContaBancaria conta2 = new ContaBancaria("pedro", 250);  // para perceber melhor fazer da maneira seguinte
		
		banco1.criaConta(new ContaBancaria("Juan", new Date()));
		banco1.criaConta(new ContaBancaria("pedro", 250));
		
		ContaBancaria conta1 = banco1.getConta("juan"); // nao é possivel chamar a funçao getConta se nao fizermos esta linha de codigo
		System.out.println(conta1.getSaldo());
		
		ContaBancaria conta2 = banco1.getConta("pedro"); 
		System.out.println(conta2.getSaldo());
		
		conta1.depositar(500);
		conta1.levantar(200);
		conta2.depositar(900);
		conta2.levantar(400);
		
		System.out.println(conta1.getInformacaoConta());
		System.out.println(conta2.getInformacaoConta());

		Casa casa1 = new Casa("Caminho da Chamorra");
		Casa casa2 = new Casa("Caminho do Trapiche");
		Casa casa3 = new Casa("Rua dos Alecrins");
		banco1.criaCasa(casa1);
		banco1.criaCasa(casa2);
		banco1.criaCasa(casa3);
		System.out.println(banco1.getCasas());
		banco1.removeCasa("Caminho da Chamorra");
		System.out.println(banco1.getCasas());

		}
	}

