package ficha3;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private String nome;
	private List<ContaBancaria> contasBancarias;
	private List<Casa> casas;

	// Construtor

	// Recebe por parâmetro o nome do banco
	public Banco(String aNome) {
		nome = aNome;
		contasBancarias = new ArrayList<ContaBancaria>(100); // limitar a 100
		casas = new ArrayList<Casa>();
	}

	// Métodos

	// Recebe uma contaBancária por parâmetro e acrescenta ao array (lista).
	public void criaConta(ContaBancaria aContaBancaria) {

		contasBancarias.add(aContaBancaria);

	}

	// Recebe o titular por parâmetro e devolve a conta desse titular.
	public ContaBancaria getConta(String aNome) {

		for (ContaBancaria contaBancaria : contasBancarias) {
			if (contaBancaria.getTitular().toLowerCase().equals(aNome)) { // para comparar strings é
																						// utilizado sempre o equals
				// toLowerCase para melhorar a comparaçao
				return contaBancaria;
			}

		}
		return null;
	}

	// Recebe uma casa por parâmetro e acrescenta ao array (lista).
	public void criaCasa(Casa aCasa) {

		casas.add(aCasa);

	}

	// Função que recebe a morada de uma casa e remove essa casa da lista de casas
	// do Banco.
	public void removeCasa(String aMorada) {
        for(Casa casaAux : casas){
            if(casaAux.getMorada().equals(morada)){

                casas.remove(casaAux);
            }
        }
	}

	// Retorna a margem de lucro previsto da venda de todas as casas.
	public double getLucroPrevisto() {
		double lucroPrev = 0;
		for (Casa casa : casas) {
			lucroPrev += casa.getPercentMargemLucro();
		}
		return lucroPrev;
	}
	// Getters

	public List<ContaBancaria> getContasBancarias() {
		return contasBancarias;
	}

	public List<Casa> getCasas() {
		return casas;
	}
	// Setters

	public void setContasBancarias(List<ContaBancaria> aContasBancarias) {
		contasBancarias = aContasBancarias;
	}

}