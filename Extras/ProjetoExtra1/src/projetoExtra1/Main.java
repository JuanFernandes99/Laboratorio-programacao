package projetoExtra1;

import utilizador.Cliente;
import utilizador.Programador;

public class Main {

	public static void main(String[] args) {

		Programador programador1 = new Programador("Juan", 22);
		Cliente cliente1 = new Cliente("Jessica", 25);
		AppStore appStore1 = new AppStore();
		Aplicacao aplicacao1 = programador1.desenvolverAplicacao("Fruit Ninja", 50, TipoAplicacao.Games);

		appStore1.adicionaUtilizador(cliente1);
		appStore1.adicionaUtilizador(programador1);
		appStore1.adicionaApp(aplicacao1);

		System.out.println(appStore1);
		System.out.println(appStore1.getUtilizadores());
	}

}
