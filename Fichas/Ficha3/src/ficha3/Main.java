package ficha3;


import java.util.Date;

public class Main {

	public static void main(String[] args) {

		ContaBancaria conta1 = new ContaBancaria("Juan", new Date());
		ContaBancaria conta2 = new ContaBancaria("pedro", 250);
		
		conta1.depositar(500);
		conta1.levantar(200);
		conta2.depositar(900);
		conta2.levantar(400);
		System.out.println(conta1.getInformacaoConta());
		System.out.println(conta2.getInformacaoConta());
	}

}