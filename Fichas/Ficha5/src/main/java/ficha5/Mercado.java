package ficha5;

import java.util.ArrayList;
import java.util.List;

public class Mercado {

	private List<Pessoa> pessoas;
	private String nome;

	public Mercado(String aNome) {
		nome = aNome;
		pessoas = new ArrayList<Pessoa>();
	}

	public void inserePessoaJson(ArrayList<Pessoa> arrayList) {
		pessoas.addAll(arrayList);
	}
	
	public void inserirPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	public double saldoAcumulado() {
		double valor = 0;
		for (Pessoa pessoa : pessoas) { 
			valor += pessoa.getSaldo();

		}
		return valor;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public String getNome() {
		return nome;
	}

	public void setPessoas(List<Pessoa> aPessoas) {
		pessoas = aPessoas;
	}

	public void setNome(String aNome) {
		nome = aNome;
	}

	@Override
	public String toString() {
		return "Mercado [Nome=" + nome + ", \nPessoa=" + pessoas + "]";
	}

}