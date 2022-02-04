package ficha3;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private String nome;
	private List<ContaBancaria> contasBancarias;

	public Banco(String aNome) {
		nome = aNome;
		contasBancarias = new ArrayList<ContaBancaria>(100); // limitar a 100

	}

}