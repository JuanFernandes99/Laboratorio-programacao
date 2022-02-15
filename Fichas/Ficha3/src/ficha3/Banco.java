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

	public void criaConta(ContaBancaria aContaBancaria) {

		contasBancarias.add(aContaBancaria);

	}

	public ContaBancaria getConta(String aNome) {
		for (ContaBancaria contaBancaria : contasBancarias) {
			if (contaBancaria.getTitular().toLowerCase().equals(aNome.toLowerCase())) { // para comparar strings é utilizado sempre o equals
				return contaBancaria;
			}
			
		}
		return null;
	}

	public String getNome() {
		return nome;
	}

	public List<ContaBancaria> getContasBancarias() {
		return contasBancarias;
	}

	public void setNome(String aNome) {
		nome = aNome;
	}

	public void setContasBancarias(List<ContaBancaria> aContasBancarias) {
		contasBancarias = aContasBancarias;
	}

}