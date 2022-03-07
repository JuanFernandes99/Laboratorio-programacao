package ficha5;

public class Main {

	public static void main(String[] args) {

		LoadFromFile fileJson = new LoadFromFile();
		Pessoa pessoa = new Pessoa("Juan", "Fernandes", 22, 1500);
		Pessoa pessoa1 = new Pessoa("Pedro", "Fernandes", 22, 1700);
		// System.out.println(pessoa);
		Mercado mercado = new Mercado("Pingo doce");

		mercado.inserirPessoa(pessoa);
		mercado.inserirPessoa(pessoa1);
		mercado.inserePessoaJson(fileJson.obterInformacaoFicheiro("Pessoas.json"));
		System.out.println(mercado);
		System.out.println("Saldo acumulado: " + mercado.saldoAcumulado() + "€");

	}

}