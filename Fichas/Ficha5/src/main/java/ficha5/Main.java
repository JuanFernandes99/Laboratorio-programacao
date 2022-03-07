package ficha5;

public class Main {

	public static void main(String[] args) {

		Pessoa pessoa = new Pessoa("Juan", "Fernandes", 22, 1500);
		Pessoa pessoa1 = new Pessoa("Pedro", "Fernandes", 22, 1700);
		System.out.println(pessoa);
		Mercado mercado = new Mercado("Pingo doce");
		
		mercado.inserePessoa(pessoa);
		mercado.inserePessoa(pessoa1);
		System.out.println(mercado);
		System.out.println("Saldo acumulado: " + mercado.saldoAcumulado() + "€");
	}

}
